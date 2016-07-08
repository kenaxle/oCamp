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
import org.apache.brooklyn.camp.spi.pdp.ArtifactRequirement;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.camp.spi.resolve.PdpMatcher;
import org.apache.brooklyn.core.catalog.internal.BasicBrooklynCatalog;
import org.apache.brooklyn.core.location.BasicLocationDefinition;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.text.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.ac.hanyang.entities.IService;

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
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
			if (loader == null) 
				loader = JavaBrooklynClassLoadingContext.create(mgmt);
			if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, artifactType) != null)         
				return artifactType; //just for testing
		}
		
		if (deploymentItem instanceof ArtifactRequirement){
			ArtifactRequirement artifactReq = (ArtifactRequirement) deploymentItem;
			String artReqType = artifactReq.getRequirementType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
			if (loader == null) 
				loader = JavaBrooklynClassLoadingContext.create(mgmt);
			if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, artReqType) != null)         
				return artReqType; //just for testing
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
	
	private String extractTypeName(String type){
		int index = type.lastIndexOf(".");
		return type.substring(index+1);
	}
	
	// matches the best service to the requirement type and takes 
	// into consideration the characteristics 
	protected List<String> matchService(String typeName){
		String[] services = {"kr.ac.hanyang.entities.services.machine.Machine"};
		List<String> matches = new MutableList<String>();
		for(String servType: services){
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
	        if (loader == null) 
	        	loader = JavaBrooklynClassLoadingContext.create(mgmt);
	        IService service;
			try {
				service = (IService) loader.loadClass(servType).newInstance();
				for(String capType: service.getCapabilities()){
					if (capType.equals(typeName))
						matches.add(service.getClass().getCanonicalName()) ;
				}
			} catch (InstantiationException e) {
				log.error("cannot instantiate "+servType+" "+e );
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				log.error("no access to "+servType);
				e.printStackTrace();
			}
		}
		return matches;
	}

	@Override
	public boolean accepts(Object deploymentPlanItem) {
		return lookupType(deploymentPlanItem) != null;		
	}
	
	@Override
	public boolean apply(Object deploymentPlanItem, AssemblyTemplateConstructor atc){
		return apply(deploymentPlanItem,atc,null); //change null to the application
	}
	
	public boolean apply(Object deploymentPlanItem, AssemblyTemplateConstructor atc, Object parent) {
		if (!(deploymentPlanItem instanceof Service) && !(deploymentPlanItem instanceof Artifact) && !(deploymentPlanItem instanceof ArtifactRequirement))	return false;
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
		
		//now to instantiate the AssemblyTemplate
		Object instantiator = atc.getInstantiator();
		// remove the restrictions for only brooklyn types
		Builder<? extends PlatformComponentTemplate> builder = PlatformComponentTemplate.builder();
        builder.type( type.indexOf(':')==-1 ? "brooklyn:"+type : type ); //reform the type string: this forces the types to only be brooklyn types
        
        // use my own instantiator so I can instantiate Services and Artifacts
        atc.instantiator(oCampAssemblyTemplateInstantiator.class);
        
        //cleaning up the map by removing items not needed
        // leaving this for now since I'm testing with prooklyn blueprints
        // will remove this soon as they dont form part of camp plans
        String name;

        if (deploymentPlanItem instanceof Service){
            name = ((Service)deploymentPlanItem).getName();
            if (!Strings.isBlank(name)) builder.name(name);
            	Map<String, Object> attrs = MutableMap.copyOf( ((Service)deploymentPlanItem).getCustomAttributes() ); 
            if (attrs.containsKey("id"))
            builder.customAttribute("planId", attrs.remove("id"));
            builder.customAttribute("parent", parent);
        	

            //simply gets the first location.	
            Map locations = mgmt.getLocationRegistry().getDefinedLocations();		
            LocationDefinition defLocations = (BasicLocationDefinition) locations.get(locations.keySet().iterator().next());
            builder.customAttribute("location", defLocations.getName());
        

        
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
        }
        else if (deploymentPlanItem instanceof Artifact){ 
        	name = ((Artifact)deploymentPlanItem).getName();
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	
        	builder.customAttribute("parent", parent);
        	
        	List<Object> reqs = MutableList.copyOf( ((Artifact)deploymentPlanItem).getRequirements() ); 
        	       	
        	if (reqs != null ){
        	
        		for(Object requirement: reqs){
        			builder.customAttribute("child", requirement.toString());
                	
        			apply(requirement, atc, deploymentPlanItem);        			
        			atc.add(builder.build());
        		}
        		// perform the parsing of the requirements
        		// add the requirements to the builder
        	}else{
        		// the artifact does not have a requirement listed. 
        		// each artifact should know its requirements and can look up the information 
        		// this lookup information will be added to the interface for each artifact type.
        	}
//        	MutableMap<Object, Object> customFlags = MutableMap.of();
//        	Object origBrooklynFlags = reqs.remove(BrooklynCampReservedKeys.BROOKLYN_FLAGS);
        	 
        	//TODO complete attribute
        	//added to test building
        	// here I need to formalize the artifact
        }
        else if (deploymentPlanItem instanceof ArtifactRequirement){
        	builder.customAttribute("parent", parent);
        	
        	Map<String, Object> attrs = MutableMap.copyOf( ((ArtifactRequirement)deploymentPlanItem).getCustomAttributes() );
	        		if (attrs.containsKey("fulfillment")){
	        			// need to convert this into a service here by a recursive call
	        			
	        			Map<String, Object> fulfillment = (Map<String, Object>) attrs.remove("fulfillment");
	        			//builder.customAttribute("fulfillment", fulfillment);
	        			// may have to edit the map to add a name and type
	        			// lookup the service type required based in the requirement type. 
	        			// each service should have a capability lookup therefore  
	        			// go through each service of the catalog and find a service that 
	        			// matches the requirement.
	        			//then need to match the characteristics to narrow down the best service.
	        			
	        			// this lookup information will be added to the interface of each service type.
	        			String typeName = extractTypeName(((ArtifactRequirement)deploymentPlanItem).getRequirementType());
	        			
	        			List<String> services =  matchService(typeName);
	        			for(String matchedService: services){
	        				//System.out.println(matchedService);
	        				builder.customAttribute("child", matchedService);
	        				fulfillment.put("type",matchedService);
	        			}
	        			//List<Service> services = new MutableList<Service>();
	        			//search only the oCamp namespace
	        			
	        			//fulfillment.add("type", )
	        			Service service = Service.of(fulfillment); //create a service object 
	        			apply(service, atc, deploymentPlanItem); //recursive call
	        			
	        		}
        }
        
        //atc.add(builder.build());

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
