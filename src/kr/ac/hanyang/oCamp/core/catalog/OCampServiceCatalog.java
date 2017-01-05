package kr.ac.hanyang.oCamp.core.catalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.brooklyn.api.catalog.CatalogItem;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityType;
import org.apache.brooklyn.api.objs.SpecParameter;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.EntityDynamicType;
import org.apache.brooklyn.core.objs.BrooklynTypes;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.apache.brooklyn.rest.domain.EffectorSummary;
import org.apache.brooklyn.rest.domain.EntityConfigSummary;
import org.apache.brooklyn.rest.domain.SensorSummary;
import org.apache.brooklyn.rest.domain.SummaryComparators;
import org.apache.brooklyn.rest.transform.EffectorTransformer;
import org.apache.brooklyn.rest.transform.EntityTransformer;
import org.apache.brooklyn.rest.transform.SensorTransformer;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

import kr.ac.hanyang.oCamp.core.mgmt.OCampEntityType;
import kr.ac.hanyang.oCamp.core.mgmt.OCampEntityTypeSnapshot;

public class OCampServiceCatalog {

	    public static final String POLICIES_KEY = "brooklyn.policies";
	    public static final String LOCATIONS_KEY = "brooklyn.locations";
	    public static final String NO_VERSION = "0.0.0.SNAPSHOT";

	    private static final Logger log = LoggerFactory.getLogger(OCampServiceCatalog.class);
	    
	    private Map<String, EntitySpec<?>> entitySpecs;
	    private Map<String, OCampEntityType> entityTypes;
	    
	    public OCampServiceCatalog() {
	        entitySpecs = new LinkedHashMap<String, EntitySpec<?>>();
	        entityTypes = new LinkedHashMap<String, OCampEntityType>();
	    }
	    
	    public void addItem(EntitySpec<?> spec){
	    	
	    	
	    	Set<EntityConfigSummary> config = Sets.newLinkedHashSet();
	        Set<SensorSummary> sensors = Sets.newTreeSet(SummaryComparators.nameComparator());
	        Set<EffectorSummary> effectors = Sets.newTreeSet(SummaryComparators.nameComparator());

	        try {
	            
	            EntityDynamicType typeMap = BrooklynTypes.getDefinedEntityType(spec.getType());
	            EntityType type = typeMap.getSnapshot();

	            entityTypes.put(spec.getDisplayName(), convertType(type));
	            entitySpecs.put(spec.getDisplayName(), spec);
	            
	        } catch (Exception e) {
	            Exceptions.propagateIfFatal(e);

	        }
	    	
	    }
	    
	    public EntitySpec<?> getCatalogItemSpec(String uri){
	    	return entitySpecs.get(uri);
	    }
	    
	    public OCampEntityType getCatalogItemEntity(String uri){
	    	return entityTypes.get(uri);
	    }

		public List<OCampEntityType> getServices(){
			ArrayList<OCampEntityType> entities = new ArrayList<OCampEntityType>();
			for(OCampEntityType entity: entityTypes.values()){
				entities.add(entity);
			}
			return entities;
		}
		
		public List<EntitySpec<?>> getServiceSpecs(){
			ArrayList<EntitySpec<?>> specs = new ArrayList<EntitySpec<?>>();
			for(EntitySpec<?> spec: entitySpecs.values()){
				specs.add(spec);
			}
			return specs;
		}
		
		private OCampEntityType convertType(EntityType entity){
			return new OCampEntityTypeSnapshot(entity);
		}
	    
}
