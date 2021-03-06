package kr.ac.hanyang.oCamp.core.objs.proxy;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntityInitializer;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityTypeRegistry;
import org.apache.brooklyn.api.entity.Group;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.core.config.ConfigConstraints;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.AbstractApplication;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.EntityInternal;
import org.apache.brooklyn.core.mgmt.BrooklynTaskTags;
import org.apache.brooklyn.core.mgmt.internal.ManagementContextInternal;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;
import org.apache.brooklyn.core.objs.proxy.InternalPolicyFactory;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.flags.FlagUtils;
import org.apache.brooklyn.util.core.task.Tasks;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.PolicyManager;
import kr.ac.hanyang.oCamp.entities.policies.objs.Action;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.ConstraintProperties;
import kr.ac.hanyang.oCamp.entities.policies.objs.PolicyImpl;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.transitions.Transition;

import static com.google.common.base.Preconditions.checkNotNull;

public class InternalOCampEntityFactory extends InternalEntityFactory {

	private static final Logger log = LoggerFactory.getLogger(InternalOCampEntityFactory.class);
	private Map<String, String> planId2serviceId;
	private final EntityTypeRegistry entityTypeRegistry;
	
	public InternalOCampEntityFactory(ManagementContextInternal managementContext,
			EntityTypeRegistry entityTypeRegistry, InternalPolicyFactory policyFactory) {
		super(managementContext, entityTypeRegistry, policyFactory);
		this.entityTypeRegistry = checkNotNull(entityTypeRegistry, "entityTypeRegistry");
		planId2serviceId = MutableMap.of();
	}
	
		
	@Override
	protected <T extends Entity> T createEntityAndDescendantsUninitialized(EntitySpec<T> spec, Map<String,Entity> entitiesByEntityId, Map<String,EntitySpec<?>> specsByEntityId) {
		try {
            Class<? extends T> clazz = getImplementedBy(spec);
            T entity = constructEntityBySpec(clazz, spec);
            loadUnitializedEntity(entity, spec);
            
            for(EntitySpec<?> childSpec: spec.getChildren()){
            	entity.addChild(createEntitiesRec(childSpec,entitiesByEntityId,specsByEntityId));
            }
            //setup parent to application
            for (Entity child: entity.getChildren()){
            	child.setParent(entity);
            }
            
//            for (Entity member: spec.getMembers()) {
//                if (!(entity instanceof Group)) {
//                    throw new IllegalStateException("Entity "+entity+" must be a group to add members "+spec.getMembers());
//                }
//                ((Group)entity).addMember(member);
//            }
            
            entitiesByEntityId.put(entity.getId(), entity);
            specsByEntityId.put(entity.getId(), spec);

            return entity;
		}catch(Exception e){
			throw Exceptions.propagate(e);
		}
	}
	
	protected <T extends Entity> T createEntitiesRec(EntitySpec<T> spec, Map<String,Entity> entitiesByEntityId, Map<String,EntitySpec<?>> specsByEntityId) {
	
		Class<? extends T> clazz = getImplementedBy(spec);
		T entity = constructEntityBySpec(clazz, spec);
        loadUnitializedEntity(entity, spec);
		if ((entity instanceof BasicOCampArtifact) || (entity instanceof Constraint)){

			if ( (entity instanceof BasicOCampArtifact)){
				
				if(entitiesByEntityId.containsKey(entity.getId())){
						return (T) entitiesByEntityId.get(entity.getId());
				}else{
		        	entitiesByEntityId.put(entity.getId(), entity);
		            specsByEntityId.put(entity.getId(), spec);
				} 
			}else{
				entity.config().set(Constraint.PROPERTY,(Sensor) ConstraintProperties.getProperty((String) spec.getConfig().get(Constraint.PROPERTY)));
				entity.config().set(Constraint.VALUE, spec.getConfig().get(Constraint.VALUE));
			}
			entitiesByEntityId.put(entity.getId(), entity);
            specsByEntityId.put(entity.getId(), spec);
	        return (T) entity;
			
        }else if(entity instanceof ActionGroup || entity instanceof Action || entity instanceof Transition){
        	if(entity instanceof ActionGroup){
        		entity.config().set(ActionGroup.ACTION_ID, (Effector) ConstraintProperties.getProperty((String) spec.getConfig().get(ActionGroup.ACTION_ID)));
        		List<EntitySpec<?>> childList = spec.getChildren();
        		for (EntitySpec<?> childSpec : childList) {
        			entity.addChild(createEntitiesRec(childSpec, entitiesByEntityId, specsByEntityId));	
        		}
        		entitiesByEntityId.put(entity.getId(), entity);
	            specsByEntityId.put(entity.getId(), spec);
        		return (T) entity;
        	}
        	if(entity instanceof Action){
        		entity.config().set(Action.PROPERTY, (Sensor) ConstraintProperties.getProperty((String) spec.getConfig().get(Action.PROPERTY)));
        		List<EntitySpec<?>> childList = spec.getChildren();
        		for (EntitySpec<?> childSpec : childList) {
        			entity.addChild(createEntitiesRec(childSpec, entitiesByEntityId, specsByEntityId));	
        		}
        		entitiesByEntityId.put(entity.getId(), entity);
	            specsByEntityId.put(entity.getId(), spec);
        		return (T) entity;
        	}
        		//need to add a config key to keep the order of the transitions
        		entity.config().set(Transition.VALUE, spec.getConfig().get(Transition.VALUE));
        		entitiesByEntityId.put(entity.getId(), entity);
	            specsByEntityId.put(entity.getId(), spec);
        		return (T) entity;

        }else{	        
	        	List<EntitySpec<?>> childList = spec.getChildren();
	        	for (EntitySpec<?> childSpec : childList) {
					entity.addChild(createEntitiesRec(childSpec, entitiesByEntityId, specsByEntityId));
					if (entity instanceof PolicyImpl){
						//set the targets and constraints
						entity.config().set(PolicyManager.POLMGRTYPE,(String) spec.getConfig().get(PolicyManager.POLMGRTYPE));
						List<Entity> targetList = Lists.newArrayList();
						for (String id: (List<String>) spec.getConfig().get(PolicyImpl.TARGETS)){
							targetList.add(entitiesByEntityId.get(planId2serviceId.get(id)));
						}
						((PolicyImpl) entity).setTargets(targetList);	
					}					
	        	}
	        	for(Entity child: entity.getChildren()){
	        		child.setParent(entity);
	        	}
				entitiesByEntityId.put(entity.getId(), entity);
	            specsByEntityId.put(entity.getId(), spec);
	            planId2serviceId.put((String) spec.getConfig().get(new BasicConfigKey(String.class, "planId")), entity.getId());
	            return (T) entity ;
	        }
	}
	
	
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	    protected <T extends Entity> T loadUnitializedEntity(final T entity, final EntitySpec<T> spec) {
	        try {
	            if (spec.getDisplayName()!=null)
	                ((AbstractEntity)entity).setDisplayName(spec.getDisplayName());
	            
	            if (spec.getCatalogItemId()!=null) {
	                ((AbstractEntity)entity).setCatalogItemId(spec.getCatalogItemId());
	            }
	            
	            if (!(entity instanceof ActionGroup || entity instanceof Action || entity instanceof Transition)){
		            for (Map.Entry<ConfigKey<?>, Object> entry : spec.getConfig().entrySet()) {
		                entity.config().set((ConfigKey)entry.getKey(), entry.getValue());
		            }
	            }
	            
	            Entity parent = spec.getParent();
	            if (parent != null) {
	                parent = (parent instanceof AbstractEntity) ? ((AbstractEntity)parent).getProxyIfAvailable() : parent;
	                entity.setParent(parent);
	            }
	            
	            return entity;
	            
	        } catch (Exception e) {
	            throw Exceptions.propagate(e);
	        }
	    }
		
	public <T extends Entity> T constructEntityBySpec(Class<? extends T> clazz, EntitySpec<T> spec) {
        T entity = constructEntityImpl(clazz, spec, null, null);
        if (((AbstractEntity)entity).getProxy() == null) ((AbstractEntity)entity).setProxy(createEntityProxy(spec, entity));
        return entity;
    }
	
	@Override
	protected <T extends Entity> void initEntityAndDescendants(String entityId, final Map<String,Entity> entitiesByEntityId, final Map<String,EntitySpec<?>> specsByEntityId) {
        final Entity entity = entitiesByEntityId.get(entityId);
        final EntitySpec<?> spec = specsByEntityId.get(entityId);
        
        if (entity==null || spec==null) {
            log.debug("Skipping initialization of "+entityId+" found as child of entity being initialized, "
                + "but this child is not one we created; likely it was created by an initializer, "
                + "and thus it should be already fully initialized.");
            return;
        }
        
        // Validate all config before attempting to manage any entity. Do this here rather
        // than in manageRecursive so that rebind is unaffected.
        validateDescendantConfig(entity);

        /* Marked transient so that the task is not needlessly kept around at the highest level.
         * Note that the task is not normally visible in the GUI, because 
         * (a) while it is running, the entity is often parentless (and so not in the tree);
         * and (b) when it is completed it is GC'd, as it is transient.
         * However task info is available via the API if you know its ID,
         * and if better subtask querying is available it will be picked up as a background task 
         * of the parent entity creating this child entity
         * (note however such subtasks are currently filtered based on parent entity so is excluded).
         * <p>
         * Some of these (initializers and enrichers) submit background scheduled tasks,
         * which currently show up at the top level once the initializer task completes.
         * TODO It would be nice if these schedule tasks were grouped in a bucket! 
         */
        ((EntityInternal)entity).getExecutionContext().submit(Tasks.builder().dynamic(false).displayName("Entity initialization")
                .tag(BrooklynTaskTags.tagForContextEntity(entity))
                .tag(BrooklynTaskTags.TRANSIENT_TASK_TAG)
                .body(new Runnable() {
            @Override
            public void run() {
                ((AbstractEntity)entity).init();

//                for (LocationSpec<?> locationSpec : spec.getLocationSpecs()) {
//                    ((AbstractEntity)entity).addLocations(MutableList.of(
//                        managementContext.getLocationManager().createLocation(locationSpec)));
//                }
//                ((AbstractEntity)entity).addLocations(spec.getLocations());

                for (EntityInitializer initializer: spec.getInitializers()) {
                    initializer.apply((EntityInternal)entity);
                }


                for (Entity child: entity.getChildren()) {
                    // right now descendants are initialized depth-first (see the getUnchecked() call below)
                    // they could be done in parallel, but OTOH initializers should be very quick
                    initEntityAndDescendants(child.getId(), entitiesByEntityId, specsByEntityId);
                }
            }
        }).build()).getUnchecked();
    }
	
	/**
     * Calls {@link ConfigConstraints#assertValid(Entity)} on the given entity and all of
     * its descendants.
     */
    private void validateDescendantConfig(Entity e) {
        Queue<Entity> queue = Lists.newLinkedList();
        queue.add(e);
        while (!queue.isEmpty()) {
            Entity e1 = queue.poll();
            ConfigConstraints.assertValid(e1);
            queue.addAll(e1.getChildren());
        }
    }
	
	private <T extends Entity> T constructEntityImpl(Class<? extends T> clazz, EntitySpec<?> optionalSpec, Map<String, ?> optionalConstructorFlags, String optionalEntityId) {
        T entity = construct(clazz, optionalSpec, optionalConstructorFlags);
        
        if (optionalEntityId != null) {
            FlagUtils.setFieldsFromFlags(ImmutableMap.of("id", optionalEntityId), entity);
        }
        if (entity instanceof AbstractApplication) {
            FlagUtils.setFieldsFromFlags(ImmutableMap.of("mgmt", managementContext), entity);
        }
        managementContext.prePreManage(entity);
        ((AbstractEntity)entity).setManagementContext(managementContext);

        return entity;
    }
	
	private <T extends Entity> Class<? extends T> getImplementedBy(EntitySpec<T> spec) {
        if (spec.getImplementation() != null) {
            return spec.getImplementation();
        } else {
            return entityTypeRegistry.getImplementedBy(spec.getType());
        }
    }
	

}

