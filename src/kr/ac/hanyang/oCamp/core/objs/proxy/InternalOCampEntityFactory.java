package kr.ac.hanyang.oCamp.core.objs.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntityInitializer;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityTypeRegistry;
import org.apache.brooklyn.api.location.LocationSpec;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.policy.PolicySpec;
import org.apache.brooklyn.api.sensor.Enricher;
import org.apache.brooklyn.api.sensor.EnricherSpec;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.core.config.ConfigConstraints;
import org.apache.brooklyn.core.entity.AbstractApplication;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.EntityInternal;
import org.apache.brooklyn.core.mgmt.BrooklynTaskTags;
import org.apache.brooklyn.core.mgmt.internal.ManagementContextInternal;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;
import org.apache.brooklyn.core.objs.proxy.InternalPolicyFactory;
import org.apache.brooklyn.core.policy.AbstractPolicy;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.flags.FlagUtils;
import org.apache.brooklyn.util.core.task.Tasks;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import static com.google.common.base.Preconditions.checkNotNull;

public class InternalOCampEntityFactory extends InternalEntityFactory {

	private static final Logger log = LoggerFactory.getLogger(InternalOCampEntityFactory.class);
	private List<Entity> artifactsList;
	private final EntityTypeRegistry entityTypeRegistry;
	
	public InternalOCampEntityFactory(ManagementContextInternal managementContext,
			EntityTypeRegistry entityTypeRegistry, InternalPolicyFactory policyFactory) {
		super(managementContext, entityTypeRegistry, policyFactory);
		this.entityTypeRegistry = checkNotNull(entityTypeRegistry, "entityTypeRegistry");
		artifactsList = new ArrayList<Entity>();
	}
	
//	@Override
//    public <T extends Entity> T createEntity(EntitySpec<T> spec) {
//		
//	
//		Map<String,Entity> entitiesByEntityId = MutableMap.of();
//      Map<String,EntitySpec<?>> specsByEntityId = MutableMap.of();
//        
//		T entity = 
//		return null; //fill this method
//	}
	
	
		
	@Override
	protected <T extends Entity> T createEntityAndDescendantsUninitialized(EntitySpec<T> spec, Map<String,Entity> entitiesByEntityId, Map<String,EntitySpec<?>> specsByEntityId) {
		try {
            Class<? extends T> clazz = getImplementedBy(spec);
            T entity = constructEntityBySpec(clazz, spec);
            loadUnitializedEntity(entity, spec);
            
            for(EntitySpec<?> childSpec: spec.getChildren()){
            	entity.addChild(createEntitiesRec(childSpec,entitiesByEntityId,specsByEntityId));
            }
            
            entitiesByEntityId.put(entity.getId(), entity);
            specsByEntityId.put(entity.getId(), spec);

            return entity;
		}catch(Exception e){
			throw Exceptions.propagate(e);
		}
	}
	
	protected <T extends Entity> T createEntitiesRec(EntitySpec<T> spec, Map<String,Entity> entitiesByEntityId, Map<String,EntitySpec<?>> specsByEntityId) {
		//List<Entity> result = Lists.newArrayList();
		Class<? extends T> clazz = getImplementedBy(spec);
		T entity = constructEntityBySpec(clazz, spec);
        loadUnitializedEntity(entity, spec);
        List<EntitySpec<?>> childList = spec.getChildren();
		if (childList.isEmpty()){
        	
			if(entitiesByEntityId.containsKey(entity.getId())){
					return (T) entitiesByEntityId.get(entity.getId());
			}else{
	        	entitiesByEntityId.put(entity.getId(), entity);
	            specsByEntityId.put(entity.getId(), spec);
	            
	        	return (T) entity;
			}
        }
        for (EntitySpec<?> childSpec : childList) {
			entity.addChild(createEntitiesRec(childSpec, entitiesByEntityId, specsByEntityId));
			
			entitiesByEntityId.put(entity.getId(), entity);
            specsByEntityId.put(entity.getId(), childSpec);
            
            return (T) entity ;
        }
		return null;
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
//
                for (EntityInitializer initializer: spec.getInitializers()) {
                    initializer.apply((EntityInternal)entity);
                }

//                for (Enricher enricher : spec.getEnrichers()) {
//                    entity.enrichers().add(enricher);
//                }

//                for (EnricherSpec<?> enricherSpec : spec.getEnricherSpecs()) {
//                    entity.enrichers().add(policyFactory.createEnricher(enricherSpec));
//                }
//
//                for (Policy policy : spec.getPolicies()) {
//                    entity.policies().add((AbstractPolicy)policy);
//                }
//
//                for (PolicySpec<?> policySpec : spec.getPolicySpecs()) {
//                    entity.policies().add(policyFactory.createPolicy(policySpec));
//                }

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
