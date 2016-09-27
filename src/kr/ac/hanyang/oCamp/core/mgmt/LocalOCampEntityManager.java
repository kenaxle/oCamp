package kr.ac.hanyang.oCamp.core.mgmt;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.core.BrooklynLogging;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.EntityInternal;
import org.apache.brooklyn.core.internal.storage.BrooklynStorage;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.mgmt.internal.LocalEntityManager;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.mgmt.internal.ManagementTransitionInfo;
import org.apache.brooklyn.core.mgmt.internal.ManagementTransitionMode;
import org.apache.brooklyn.core.objs.BasicEntityTypeRegistry;
import org.apache.brooklyn.core.objs.proxy.EntityProxy;
import org.apache.brooklyn.core.objs.proxy.EntityProxyImpl;
import org.apache.brooklyn.core.objs.proxy.InternalPolicyFactory;
import org.apache.brooklyn.util.collections.MutableSet;
import org.apache.brooklyn.util.collections.SetFromLiveMap;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;



import kr.ac.hanyang.oCamp.camp.platform.oCampComponentTemplateResolver;
import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerTemplate;
import kr.ac.hanyang.oCamp.core.objs.proxy.InternalOCampEntityFactory;
import kr.ac.hanyang.oCamp.entities.policies.PolicyManager;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;

public class LocalOCampEntityManager extends LocalEntityManager {

	private static final Logger log = LoggerFactory.getLogger(LocalOCampEntityManager.class);
	private final InternalOCampEntityFactory entityFactory;
	private final LocalManagementContext managementContext;
	
	private final BrooklynStorage storage;
	private final Map<String,String> entityTypes;
	private final Set<String> applicationIds;
	private final Set<String> policyManagerIds;
	
	/** Proxies of the managed entities that are applications */
    protected final Set<PolicyManager> policyManagers = Sets.newConcurrentHashSet();
	
	public LocalOCampEntityManager(LocalManagementContext managementContext) {
		super(managementContext);
		BasicEntityTypeRegistry entityTypeRegistry = new BasicEntityTypeRegistry();
		InternalPolicyFactory policyFactory = new InternalPolicyFactory(managementContext);
        this.entityFactory = new InternalOCampEntityFactory(managementContext, entityTypeRegistry, policyFactory);
        this.managementContext = managementContext;
        this.storage = managementContext.getStorage();
        
        entityTypes = storage.getMap("entities");
        applicationIds = SetFromLiveMap.create(storage.<String,Boolean>getMap("applications"));
        policyManagerIds = SetFromLiveMap.create(storage.<String,Boolean>getMap("policyManagers"));
	}
	
	
	 boolean isPreRegistered(Entity e) {
	     return preRegisteredEntitiesById.containsKey(e.getId());
	 }
	
	@Override
	public InternalOCampEntityFactory getEntityFactory() {
        if (!managementContext.isRunning()) throw new IllegalStateException("Management context no longer running");
        return entityFactory;
    }
	
	@Override
    public <T extends Entity> T createEntity(EntitySpec<T> spec) {
		try {
            T entity = this.entityFactory.createEntity(spec);
            Entity proxy = ((AbstractEntity)entity).getProxy();
            checkNotNull(proxy, "proxy for entity %s, spec %s", entity, spec);
            
            manage(entity);

            return (T) proxy;
        } catch (Throwable e) {
            log.warn("Failed to create entity using spec "+spec+" (rethrowing)", e);
            throw Exceptions.propagate(e);
        }
	}
	
	@Override
	protected void manageRecursive(Entity e, final ManagementTransitionMode initialMode) {
		checkManagementAllowed(e);

        final List<EntityInternal> allEntities = Lists.newArrayList();
        Predicate<EntityInternal> manageEntity = new Predicate<EntityInternal>() { public boolean apply(EntityInternal it) {
            ManagementTransitionMode mode = getLastManagementTransitionMode(it.getId());
            if (mode==null) {
                setManagementTransitionMode(it, mode = initialMode);
            }
            
            Boolean isReadOnlyFromEntity = it.getManagementSupport().isReadOnlyRaw();
            if (isReadOnlyFromEntity==null) {
                if (mode.isReadOnly()) {
                    // should have been marked by rebinder
                    log.warn("Read-only entity "+it+" not marked as such on call to manage; marking and continuing");
                }
                it.getManagementSupport().setReadOnly(mode.isReadOnly());
            } else {
                if (!isReadOnlyFromEntity.equals(mode.isReadOnly())) {
                    log.warn("Read-only status at entity "+it+" ("+isReadOnlyFromEntity+") not consistent with management mode "+mode);
                }
            }
            
            if (it.getManagementSupport().isDeployed()) {
                if (mode.wasNotLoaded()) {
                    // silently bail out
                    return false;
                } else {
                    if (mode.wasPrimary() && mode.isPrimary()) {
                        // active partial rebind; continue
                    } else if (mode.wasReadOnly() && mode.isReadOnly()) {
                        // reload in RO mode
                    } else {
                        // on initial non-RO rebind, should not have any deployed instances
                        log.warn("Already deployed "+it+" when managing "+mode+"/"+initialMode+"; ignoring this and all descendants");
                        return false;
                    }
                }
            }
            
            // check RO status is consistent
            boolean isNowReadOnly = Boolean.TRUE.equals( ((EntityInternal)it).getManagementSupport().isReadOnly() );
            if (mode.isReadOnly()!=isNowReadOnly) {
                throw new IllegalStateException("Read-only status mismatch for "+it+": "+mode+" / RO="+isNowReadOnly);
            }

            allEntities.add(it);
            preManageNonRecursive(it, mode);
            it.getManagementSupport().onManagementStarting( new ManagementTransitionInfo(managementContext, mode) ); 
            return manageNonRecursive(it, mode);
        } };
        boolean isRecursive = true;
        if (initialMode.wasPrimary() && initialMode.isPrimary()) {
            // already managed, so this shouldn't be recursive 
            // (in ActivePartialRebind we cheat, calling in to this method then skipping recursion).
            // it also falls through to here when doing a redundant promotion,
            // in that case we *should* be recursive; determine by checking whether a child exists and is preregistered.
            // the TODO above removing manageRebindRoot in favour of explicit mgmt list would clean this up a lot!
            Entity aChild = Iterables.getFirst(e.getChildren(), null);
            if (aChild!=null && isPreRegistered(aChild)) {
                log.debug("Managing "+e+" in mode "+initialMode+", doing this recursively because a child is preregistered");
            } else {
                log.debug("Managing "+e+" but skipping recursion, as mode is "+initialMode);
                isRecursive = false;
            }
        }
        if (!isRecursive) {
            manageEntity.apply( (EntityInternal)e );
        } else {
            recursively(e, manageEntity);
        }
        
        for (EntityInternal it : allEntities) {
            if (!it.getManagementSupport().isFullyManaged()) {
                ManagementTransitionMode mode = getLastManagementTransitionMode(it.getId());
                ManagementTransitionInfo info = new ManagementTransitionInfo(managementContext, mode);
                
                it.getManagementSupport().onManagementStarted(info);
                managementContext.getRebindManager().getChangeListener().onManaged(it);
            }
        }
	}
	
	/**
     * Should ensure that the entity is now managed somewhere, and known about in all the lists.
     * Returns true if the entity has now become managed; false if it was already managed (anything else throws exception)
     */
    private synchronized boolean manageNonRecursive(Entity e, ManagementTransitionMode mode) {
    	
    	Entity old = entitiesById.get(e.getId());
        
        if (old!=null && mode.wasNotLoaded()) {
            if (old.equals(e)) {
                log.warn("{} redundant call to start management of entity {}; ignoring", this, e);
            } else {
                throw new IllegalStateException("call to manage entity "+e+" ("+mode+") but different entity "+old+" already known under that id at "+this);
            }
            return false;
        }

        BrooklynLogging.log(log, BrooklynLogging.levelDebugOrTraceIfReadOnly(e),
            "{} starting management of entity {}", this, e);
        Entity realE = toRealEntity(e);
        
        Entity oldProxy = entityProxiesById.get(e.getId());
        Entity proxyE;
        if (oldProxy!=null) {
            if (mode.wasNotLoaded()) {
                throw new IllegalStateException("call to manage entity "+e+" from unloaded state ("+mode+") but already had proxy "+oldProxy+" already known under that id at "+this);
            }
            // make the old proxy point at this new delegate
            // (some other tricks done in the call below)
            ((EntityProxyImpl)(Proxy.getInvocationHandler(oldProxy))).resetDelegate(oldProxy, oldProxy, realE);
            proxyE = oldProxy;
        } else {
            proxyE = toProxyEntityIfAvailable(e);
        }
        entityProxiesById.put(e.getId(), proxyE);
        entityTypes.put(e.getId(), realE.getClass().getName());
        entitiesById.put(e.getId(), realE);

        preManagedEntitiesById.remove(e.getId());
        if ((e instanceof Application) && (e.getParent()==null)) {
            applications.add((Application)proxyE);
            applicationIds.add(e.getId());
        }
        if ((e instanceof PolicyManager)) {
        	policyManagers.add((PolicyManager)proxyE);
        	policyManagerIds.add(e.getId());
        }
        if ((e instanceof Policy)){
        	log.info("Policy");
        	// find the appropriate policy manager 
        	// add the policy
        	String policyManagerType = e.config().get(ConfigKeys.newConfigKey(String.class, "policymanager.type"));
        	PolicyManager policyManager = (PolicyManager) getPolicyManagerByType(policyManagerType);
        	if (policyManager != null){
        		policyManager.addOCampPolicy((Policy)e); // I think I should add the proxy and not the actual entity.}
        	}else{
        		// create the policy manager and add to the platform
        		PolicyManagerTemplate polMCT = (PolicyManagerTemplate) PolicyManagerTemplate.builder().description("Base Policy Manager")
						.id("PolicyManager")
		                .name("PolicyManager")
		                .type(policyManagerType)
		                .build();
        		BrooklynClassLoadingContext loader = JavaBrooklynClassLoadingContext.create(managementContext);
        		oCampComponentTemplateResolver entityResolver = oCampComponentTemplateResolver.Factory.newInstance(loader, polMCT);       		
        		EntitySpec<? extends PolicyManager> polMgrSpec = entityResolver.resolveSpec(MutableSet.<String>of());
        		policyManager = createEntity(polMgrSpec); // create the policy Manager
        		policyManager.addOCampPolicy((Policy)e); 
        		//Entities.invokeEffector(this, policyManager, STARTUP);
        	}
        }
        if (!entities.contains(proxyE)) 
            entities.add(proxyE);
        
        if (old!=null && old!=e) {
            // passing the transition info will ensure the right shutdown steps invoked for old instance
          //  unmanage(old, mode, true); FIXME
        }
        
        return true;
    }
    
    
    
    private <T extends Entity> T getPolicyManagerByType(String type){
    	for(PolicyManager policyManager: policyManagers){
    		if (policyManager.config().get(ConfigKeys.newConfigKey(String.class, "policymanager.type")) != null){
    			return (T) policyManager; // this is a proxy
    		}
    	}
    	return null; // bad programming; I should not be returnig null FIXME
    }
    
    
    private void recursively(Entity e, Predicate<EntityInternal> action) {
        Entity otherPreregistered = preRegisteredEntitiesById.get(e.getId());
        if (otherPreregistered!=null) {
            // if something has been pre-registered, prefer it
            // (e.g. if we recursing through children, we might have a proxy from previous iteration;
            // the most recent will have been pre-registered)
            e = otherPreregistered;
        }
            
        boolean success = action.apply( (EntityInternal)e );
        if (!success) {
            return; // Don't manage children if action false/unnecessary for parent
        }
        for (Entity child : e.getChildren()) {
            recursively(child, action);
        }
    }
    
    
    
    /**
     * Should ensure that the entity is now known about, but should not be accessible from other entities yet.
     * 
     * Records that the given entity is about to be managed (used for answering {@link #isPreManaged(Entity)}.
     * Note that refs to the given entity are stored in a a weak hashmap so if the subsequent management
     * attempt fails then this reference to the entity will eventually be discarded (if no-one else holds 
     * a reference).
     */
    private synchronized boolean preManageNonRecursive(Entity e, ManagementTransitionMode mode) {
        Entity realE = toRealEntity(e);
        
        Object old = preManagedEntitiesById.put(e.getId(), realE);
        preRegisteredEntitiesById.remove(e.getId());
        
        if (old!=null && mode.wasNotLoaded()) {
            if (old.equals(e)) {
                log.warn("{} redundant call to pre-start management of entity {}, mode {}; ignoring", new Object[] { this, e, mode });
            } else {
                throw new IllegalStateException("call to pre-manage entity "+e+" ("+mode+") but different entity "+old+" already known under that id at "+this);
            }
            return false;
        } else {
            if (log.isTraceEnabled()) log.trace("{} pre-start management of entity {}, mode {}", 
                new Object[] { this, e, mode });
            return true;
        }
    }
    
    
    
    
    private Entity toRealEntity(Entity e) {
        checkNotNull(e, "entity");
        
        if (e instanceof AbstractEntity) {
            return e;
        } else {
            Entity result = toRealEntityOrNull(e.getId());
            if (result == null) {
                throw new IllegalStateException("No concrete entity known for entity "+e+" ("+e.getId()+", "+e.getEntityType().getName()+")");
            }
            return result;
        }
    }
    
    private Entity toRealEntityOrNull(String id) {
        Entity result;
        // prefer the preRegistered and preManaged entities, during hot proxying, they should be newer
        result = preRegisteredEntitiesById.get(id);
        if (result==null)
            result = preManagedEntitiesById.get(id);
        if (result==null)
            entitiesById.get(id);
        return result;
    }
    
    private Entity toProxyEntityIfAvailable(Entity e) {
        checkNotNull(e, "entity");
        
        if (e instanceof EntityProxy) {
            return e;
        } else if (e instanceof AbstractEntity) {
            Entity result = ((AbstractEntity)e).getProxy();
            return (result == null) ? e : result;
        } else {
            // If we don't already know about the proxy, then use the real thing; presumably it's 
            // the legacy way of creating the entity so didn't get a preManage() call

            return e;
        }
    }


}
