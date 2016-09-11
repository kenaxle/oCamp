package kr.ac.hanyang.oCamp.core.objs.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityTypeRegistry;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.core.entity.AbstractApplication;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.mgmt.internal.ManagementContextInternal;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;
import org.apache.brooklyn.core.objs.proxy.InternalPolicyFactory;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.flags.FlagUtils;
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
//        Map<String,EntitySpec<?>> specsByEntityId = MutableMap.of();
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
            //return null;
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
		if (childList == null){
        	//this entity is an artifact
        	for(Entity artEntity:artifactsList){
				if(artEntity.getConfig(new BasicConfigKey<String>(String.class,"camp.template.id"))
						.equals(entity.getConfig(new BasicConfigKey<String>(String.class,"camp.template.id")))){
					//found the artifact in the list
					return (T) artEntity;
				}
			}
        	artifactsList.add(entity);
        	return entity;
        }
        for (EntitySpec<?> childSpec : childList) {
			entity.addChild(createEntitiesRec(childSpec, entitiesByEntityId, specsByEntityId));
            return (T) entity ;
        }
		return null;
	}
		
	public <T extends Entity> T constructEntityBySpec(Class<? extends T> clazz, EntitySpec<T> spec) {
        T entity = constructEntityImpl(clazz, spec, null, null);
        if (((AbstractEntity)entity).getProxy() == null) ((AbstractEntity)entity).setProxy(createEntityProxy(spec, entity));
        return entity;
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
