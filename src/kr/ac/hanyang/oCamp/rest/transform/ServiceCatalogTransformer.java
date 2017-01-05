package kr.ac.hanyang.oCamp.rest.transform;

import static org.apache.brooklyn.rest.util.WebResourceUtils.serviceUriBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.core.UriBuilder;

import org.apache.brooklyn.api.catalog.CatalogItem;
import org.apache.brooklyn.api.catalog.CatalogItem.CatalogItemType;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityType;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.location.LocationSpec;
import org.apache.brooklyn.api.objs.SpecParameter;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.policy.PolicySpec;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.EntityDynamicType;
import org.apache.brooklyn.core.mgmt.BrooklynTags;
import org.apache.brooklyn.core.objs.BrooklynTypes;
import org.apache.brooklyn.rest.api.CatalogApi;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.apache.brooklyn.rest.domain.CatalogItemSummary;
import org.apache.brooklyn.rest.domain.CatalogLocationSummary;
import org.apache.brooklyn.rest.domain.CatalogPolicySummary;
import org.apache.brooklyn.rest.domain.EffectorSummary;
import org.apache.brooklyn.rest.domain.EntityConfigSummary;
import org.apache.brooklyn.rest.domain.LocationConfigSummary;
import org.apache.brooklyn.rest.domain.PolicyConfigSummary;
import org.apache.brooklyn.rest.domain.SensorSummary;
import org.apache.brooklyn.rest.domain.SummaryComparators;
import org.apache.brooklyn.rest.transform.CatalogTransformer;
import org.apache.brooklyn.rest.transform.EffectorTransformer;
import org.apache.brooklyn.rest.transform.EntityTransformer;
import org.apache.brooklyn.rest.transform.SensorTransformer;
import org.apache.brooklyn.rest.util.BrooklynRestResourceUtils;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.collections.MutableSet;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.javalang.Reflections;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


public class ServiceCatalogTransformer {
private static final org.slf4j.Logger log = LoggerFactory.getLogger(ServiceCatalogTransformer.class);
    
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Entity> CatalogEntitySummary catalogEntitySummary(EntitySpec<?> spec, UriBuilder ub) {
        Set<EntityConfigSummary> config = Sets.newLinkedHashSet();
        Set<SensorSummary> sensors = Sets.newTreeSet(SummaryComparators.nameComparator());
        Set<EffectorSummary> effectors = Sets.newTreeSet(SummaryComparators.nameComparator());

        try {
            //spec = (EntitySpec<?>) b.getCatalog().createSpec((CatalogItem) item);
            EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
            EntityType type = typeMap.getSnapshot();

            for (SpecParameter<?> input: spec.getParameters())
                config.add(EntityTransformer.entityConfigSummary(input));
            for (Sensor<?> x: type.getSensors())
                sensors.add(SensorTransformer.sensorSummaryForCatalog(x));
            for (Effector<?> x: type.getEffectors())
                effectors.add(EffectorTransformer.effectorSummaryForCatalog(x));
            
            return new CatalogEntitySummary(spec.getDisplayName(), "","Catalog Name",
            spec.getType().getName(), "",
            "Catalog Description", null,
            null, config, sensors, effectors,
            false, null);

        } catch (Exception e) {
            Exceptions.propagateIfFatal(e);

        }
		return null;
        
    }
    
    public static List<CatalogEntitySummary> listEntities(List<EntitySpec<?>> entities){
    	ArrayList<CatalogEntitySummary> toReturn = new ArrayList<CatalogEntitySummary>();
    	for(EntitySpec<?> spec: entities){
    		toReturn.add(catalogEntitySummary(spec,null));
    	}
    	return toReturn;
    }
    
    public static List<EntityConfigSummary> catalogEntityConfigsSummary(EntitySpec<?> spec, UriBuilder ub){
    	Set<EntityConfigSummary> config = Sets.newLinkedHashSet();
    	try {
    		EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
    		EntityType type = typeMap.getSnapshot();

    		for (SpecParameter<?> input: spec.getParameters())
                config.add(EntityTransformer.entityConfigSummary(input));

    	 } catch (Exception e) {
             Exceptions.propagateIfFatal(e);

         }
    	ArrayList<EntityConfigSummary> toReturn = new ArrayList<EntityConfigSummary>();
    	toReturn.addAll(config);
 		return toReturn;
    }
    
    public static List<EntityConfigSummary> catalogEntityConfigsSummary(EntityType entity){
    	Set<EntityConfigSummary> config = Sets.newLinkedHashSet();
    	try {
    		
    		for (ConfigKey<?> key: entity.getConfigKeys())
                config.add(EntityTransformer.entityConfigSummary(key, key.getName(), 1.0,null));

    	 } catch (Exception e) {
             Exceptions.propagateIfFatal(e);

         }
    	ArrayList<EntityConfigSummary> toReturn = new ArrayList<EntityConfigSummary>();
    	toReturn.addAll(config);
 		return toReturn;
    }
    
    
    public static List<SensorSummary> catalogEntitySensorsSummary(EntitySpec<?> spec, UriBuilder ub){
    	Set<SensorSummary> sensors = Sets.newTreeSet(SummaryComparators.nameComparator());
    	try {
    		EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
    		EntityType type = typeMap.getSnapshot();

            for (Sensor<?> x: type.getSensors())
                sensors.add(SensorTransformer.sensorSummaryForCatalog(x));
            
           
            
    	 } catch (Exception e) {
             Exceptions.propagateIfFatal(e);

         }
    	ArrayList<SensorSummary> toReturn = new ArrayList<SensorSummary>();
    	toReturn.addAll(sensors);
 		return toReturn;
    }
    
    public static List<EffectorSummary> catalogEntityEffectorsSummary(EntitySpec<?> spec, UriBuilder ub){
    	Set<EffectorSummary> effectors = Sets.newTreeSet(SummaryComparators.nameComparator());
    	try {
    		EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
    		EntityType type = typeMap.getSnapshot();

    		for (Effector<?> x: type.getEffectors())
                effectors.add(EffectorTransformer.effectorSummaryForCatalog(x));
            
    	 } catch (Exception e) {
             Exceptions.propagateIfFatal(e);

         }
    	ArrayList<EffectorSummary> toReturn = new ArrayList<EffectorSummary>();
    	toReturn.addAll(effectors);
 		return toReturn;
    }
    
    public static List<CatalogEntitySummary> listEntitiesbyConfig(String config, List<EntitySpec<?>> entities){
    	ArrayList<CatalogEntitySummary> toReturn = new ArrayList<CatalogEntitySummary>();
    	for(EntitySpec<?> spec: entities){
    		List<String> configs = new ArrayList<String>();
    		
    		try {
               
                EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
                EntityType type = typeMap.getSnapshot();

                for (ConfigKey x: type.getConfigKeys()){
                    configs.add(x.getName());
                }
                
                if (configs.contains(config))
                	toReturn.add(catalogEntitySummary(spec,null));
    		}catch (Exception e) {
                Exceptions.propagateIfFatal(e);
            }	
    	}
    	return toReturn;
    }
    
    
    public static List<CatalogEntitySummary> listEntitiesbySensor(String sensorName, List<EntitySpec<?>> entities){
    	ArrayList<CatalogEntitySummary> toReturn = new ArrayList<CatalogEntitySummary>();
    	for(EntitySpec<?> spec: entities){
    		List<String> sensors = new ArrayList<String>();
    		
    		try {
               
                EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
                EntityType type = typeMap.getSnapshot();

                for (Sensor<?> x: type.getSensors()){
                    sensors.add(x.getName());
                }
                
                if (sensors.contains(sensorName))
                	toReturn.add(catalogEntitySummary(spec,null));
    		}catch (Exception e) {
                Exceptions.propagateIfFatal(e);

            }	
    	}
    	return toReturn;
    }
    
    public static List<CatalogEntitySummary> listEntitiesbyEffector(String effectorName, List<EntitySpec<?>> entities){
    	ArrayList<CatalogEntitySummary> toReturn = new ArrayList<CatalogEntitySummary>();
    	for(EntitySpec<?> spec: entities){
    		List<String> effectors = new ArrayList<String>();
    		
    		try {
               
                EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
                EntityType type = typeMap.getSnapshot();

                for (Effector<?> x: type.getEffectors()){
                    effectors.add(x.getName());
                }
                
                if (effectors.contains(effectorName))
                	toReturn.add(catalogEntitySummary(spec,null));
    		}catch (Exception e) {
                Exceptions.propagateIfFatal(e);
            }	
    	}
    	return toReturn;
    }
 
}
