package kr.ac.hanyang.platform;

import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.location.LocationDefinition;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampConstants;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampReservedKeys;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynEntityMatcher;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate.Builder;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.camp.spi.resolve.PdpMatcher;
import org.apache.brooklyn.core.catalog.internal.BasicBrooklynCatalog;
import org.apache.brooklyn.core.location.BasicLocationDefinition;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.text.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class oCampMatcher extends BrooklynEntityMatcher implements PdpMatcher {
	private static final Logger log = LoggerFactory.getLogger(oCampMatcher.class);
	//private ManagementContext mgmt;
	
	
	public oCampMatcher(ManagementContext mgmt){
		super(mgmt);
		//this.mgmt = mgmt;
	}
	
	@Override
	protected String lookupType(Object deploymentItem){
		
		if (deploymentItem instanceof Artifact){
			Artifact artifact = (Artifact) deploymentItem;
			String artifactType = artifact.getArtifactType();
			return artifactType; //just for testing
		}
		
		if (deploymentItem instanceof Service){
			Service service = (Service) deploymentItem;
			String serviceType = service.getServiceType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, serviceType) != null)
                return serviceType;
			
			//return serviceType; //just for testing
		}
		log.debug( "Not an artifact or Service. unable to match "+deploymentItem);
		return null;
	}

	@Override
	public boolean accepts(Object deploymentPlanItem) {
		return lookupType(deploymentPlanItem) != null;
		
	}

	@Override
	public boolean apply(Object deploymentPlanItem, AssemblyTemplateConstructor atc) {
		if (!(deploymentPlanItem instanceof Service) && !(deploymentPlanItem instanceof Artifact))	return false;
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
		
		//now to instantiate the AssemblyTemplate
		Object instantiator = atc.getInstantiator();
		// remove the restrictions for only brooklyn types
		Builder<? extends PlatformComponentTemplate> builder = PlatformComponentTemplate.builder();
        builder.type( type.indexOf(':')==-1 ? "brooklyn:"+type : type ); //reform the type string 
        
        // use my own instantiator so I can instantiate Services and Artifacts
        atc.instantiator(oCampAssemblyTemplateInstantiator.class);
        
        //cleaning up the map by removing items not needed
        // leaving this for now since I'm testing with prooklyn blueprints
        // will remove this soon as they dont form part of camp plans
        String name = ((Service)deploymentPlanItem).getName();
        if (!Strings.isBlank(name)) builder.name(name);
        
        // configuration
        Map<String, Object> attrs = MutableMap.copyOf( ((Service)deploymentPlanItem).getCustomAttributes() );

        if (attrs.containsKey("id"))
            builder.customAttribute("planId", attrs.remove("id"));
       // mgmt.getLocationRegistry().getDefinedLocationByName(arg0)
        Map locations = mgmt.getLocationRegistry().getDefinedLocations();		
		LocationDefinition defLocations = (BasicLocationDefinition) locations.get(locations.keySet().iterator().next());
        builder.customAttribute("location", defLocations.getName());
        
        // TODO need to obtain the location from another source 
//        Object location = attrs.remove("location");
//        if (location!=null)
//            builder.customAttribute("location", location);
//        Object locations = attrs.remove("locations");
//        if (locations!=null)
//            builder.customAttribute("locations", locations);
        //------------------------------------------------------------------
        
        // brooklyn flags are added here but I am not using the brooklyn entity matcher so I cannot perform then tasks
        
        MutableMap<Object, Object> brooklynFlags = MutableMap.of();
        Object origBrooklynFlags = attrs.remove(BrooklynCampReservedKeys.BROOKLYN_FLAGS);
        if (origBrooklynFlags!=null) {
            if (!(origBrooklynFlags instanceof Map))
                throw new IllegalArgumentException("brooklyn.flags must be a map of brooklyn flags");
            brooklynFlags.putAll((Map<?,?>)origBrooklynFlags);
        }

        addCustomMapAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CONFIG);
        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_POLICIES);
        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_ENRICHERS);
        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_INITIALIZERS);
        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CHILDREN);
        addCustomMapAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CATALOG);

        brooklynFlags.putAll(attrs);
        if (!brooklynFlags.isEmpty()) {
            builder.customAttribute(BrooklynCampReservedKeys.BROOKLYN_FLAGS, brooklynFlags);
        }

        atc.add(builder.build());

        return true;
		//return false; // TODO need to remove this. but i dont want to actually deploy as yet.
	}
	
	// copying these methods howver I may have to remove them 
	// only keeping them to not break compatibility as yet
	
	 /**
     * Looks for the given key in the map of attributes and adds it to the given builder
     * as a custom attribute with type List.
     * @throws java.lang.IllegalArgumentException if map[key] is not an instance of List
     */
    private void addCustomListAttributeIfNonNull(Builder<? extends PlatformComponentTemplate> builder, Map<?,?> attrs, String key) {
        Object items = attrs.remove(key);
        if (items != null) {
            if (items instanceof List) {
                List<?> itemList = (List<?>) items;
                if (!itemList.isEmpty()) {
                    builder.customAttribute(key, Lists.newArrayList(itemList));
                }
            } else {
                throw new IllegalArgumentException(key + " must be a list, is: " + items.getClass().getName());
            }
        }
    }

    /**
     * Looks for the given key in the map of attributes and adds it to the given builder
     * as a custom attribute with type Map.
     * @throws java.lang.IllegalArgumentException if map[key] is not an instance of Map
     */
    private void addCustomMapAttributeIfNonNull(Builder<? extends PlatformComponentTemplate> builder, Map<?,?> attrs, String key) {
        Object items = attrs.remove(key);
        if (items != null) {
            if (items instanceof Map) {
                Map<?, ?> itemMap = (Map<?, ?>) items;
                if (!itemMap.isEmpty()) {
                    builder.customAttribute(key, Maps.newHashMap(itemMap));
                }
            } else {
                throw new IllegalArgumentException(key + " must be a map, is: " + items.getClass().getName());
            }
        }
    }

	

}
