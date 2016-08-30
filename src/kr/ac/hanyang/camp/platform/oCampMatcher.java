package kr.ac.hanyang.camp.platform;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.location.LocationDefinition;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampConstants;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampReservedKeys;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynEntityMatcher;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate.Builder;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.ArtifactContent;
import org.apache.brooklyn.camp.spi.pdp.ArtifactRequirement;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.camp.spi.resolve.PdpMatcher;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.catalog.internal.BasicBrooklynCatalog;
import org.apache.brooklyn.core.location.BasicLocationDefinition;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.text.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.ac.hanyang.camp.platform.oCampPlatformComponentTemplate;
import kr.ac.hanyang.camp.platform.oCampReserved;
import kr.ac.hanyang.entities.IService;

public class oCampMatcher extends BrooklynEntityMatcher implements PdpMatcher,oCampReserved {
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
	
	
	
	// matches the best service to the requirement type and takes 
	// into consideration the characteristics 
	protected List<String> matchService(String typeName, Collection<String> charTypes){
		String[] services = {"web.tomcat.Tomcat8","software.SoftwareProcess"};
		List<String> matches = new MutableList<String>();
		for(String servType: services){
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
	        if (loader == null) 
	        	loader = JavaBrooklynClassLoadingContext.create(mgmt);
	        IService service;
			try {
				service = (IService) loader.loadClass(SERVICE_PREFIX+servType).newInstance();
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
		
		//Object instantiator = atc.getInstantiator();
		// use my own instantiator so I can instantiate Services and Artifact
		atc.instantiator(oCampAssemblyTemplateInstantiator.class);
		Object result = applyPlanItem(deploymentPlanItem);
		if (result != null){
			atc.add((PlatformComponentTemplate) result);
			return true; //change null to the application
		}else
			return false;
		// add to the ATC here *******
	}
	
	
	//recursve method
	public Object applyPlanItem(Object deploymentPlanItem) {
		if (!(deploymentPlanItem instanceof Service) && !(deploymentPlanItem instanceof Artifact) && !(deploymentPlanItem instanceof ArtifactRequirement))	return false;
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
		
		//now to instantiate the AssemblyTemplate
		//Object instantiator = atc.getInstantiator();
		// remove the restrictions for only brooklyn types
		
		//**** build an oCampPlatformComponentTemplate instead
		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
        builder.type( type.indexOf(':')==-1 ? /*"brooklyn:"+*/type : type ); //reform the type string: this forces the types to only be brooklyn types
        
        // use my own instantiator so I can instantiate Services and Artifacts
        //atc.instantiator(oCampAssemblyTemplateInstantiator.class);
        
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
           // builder.customAttribute("parent", parent);
        	

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
	        
	        //add custom tags
	        Collection<String> keys = getTagIDs();
	        for(String key: keys){
	        	addCustomMapAttributeIfNonNull(builder, attrs, key);
	        }
	        
	        //get non-depricated config tags 
	        // for each tag determine if it is in the PDP
	        // if the tag is in the pdp then add the custom attribute.
	        
	        //must remove these TODO
//	        addCustomMapAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CONFIG);
//	        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_POLICIES);
//	        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_ENRICHERS);
//	        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_INITIALIZERS);
//	        addCustomListAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CHILDREN);
//	        addCustomMapAttributeIfNonNull(builder, attrs, BrooklynCampReservedKeys.BROOKLYN_CATALOG);
	
	        brooklynFlags.putAll(attrs);
	        if (!brooklynFlags.isEmpty()) {
	            builder.customAttribute(BrooklynCampReservedKeys.BROOKLYN_FLAGS, brooklynFlags);
	        }
	        return builder.build(); 
        }
        else if (deploymentPlanItem instanceof Artifact){ 
        	name = ((Artifact)deploymentPlanItem).getName();
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	ArtifactContent content = (ArtifactContent)((Artifact)deploymentPlanItem).getContent();
        	if (content != null){
        		builder.customAttribute("content",content.getHref());
        	}
        	Map<String, Object> attrs = MutableMap.copyOf( ((Artifact)deploymentPlanItem).getCustomAttributes() ); 
       
        	// may need this if deciding to add attributes to artifacts
        	//addCustomMapAttributeIfNonNull(builder,attrs,);
        	
        	
        	
        	List<Object> reqs = MutableList.copyOf( ((Artifact)deploymentPlanItem).getRequirements() ); 
        	       	
        	if (reqs != null ){
        	
        		for(Object requirement: reqs){
        			//builder.customAttribute("child", requirement.toString());
                	
        			
        			builder.add((oCampPlatformComponentTemplate)applyPlanItem(requirement));
        			//atc.add(builder.build());
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
        	return builder.build();
        }
        else if (deploymentPlanItem instanceof ArtifactRequirement){
        	
        	
        	Map<String, Object> attrs = MutableMap.copyOf( ((ArtifactRequirement)deploymentPlanItem).getCustomAttributes() );
	        		if (attrs.containsKey("fulfillment")){
	        			// need to recursively find the service
	        			
	        			Map<String, Object> fulfillment = (Map<String, Object>) attrs.remove("fulfillment");
	        			//builder.customAttribute("fulfillment", fulfillment);
	        			// may have to edit the map to add a name and type
	        			// lookup the service type required based in the requirement type. 
	        			// each service should have a capability lookup therefore  
	        			// go through each service of the catalog and find a service that 
	        			// matches the requirement.
	        			//then need to match the characteristics to narrow down the best service.
	        			
	        			// this lookup information will be added to the interface of each service type.
	        			String reqType = extractTypeName(((ArtifactRequirement)deploymentPlanItem).getRequirementType());
	        			List charTypes = new ArrayList();
	        			List characteristics = (ArrayList) fulfillment.get("characteristics");
	        			for (Object obj: characteristics){
	        				charTypes.add(((Map<String,Object>)obj).get("type"));
	        			}
	        			List<String> services =  matchService(reqType,charTypes);
	        			for(String matchedService: services){
	        				//System.out.println(matchedService);
	        				//builder.customAttribute("child", matchedService);
	        				fulfillment.put("type",matchedService);
	        			}
	        			//List<Service> services = new MutableList<Service>();
	        			//search only the oCamp namespace
	        			
	        			//fulfillment.add("type", )
	        			Service service = Service.of(fulfillment); //create a service object 
	        			builder.add((oCampPlatformComponentTemplate)applyPlanItem(service)); //recursive call
	        			
	        		}
	        		return builder.build();
        }
        
        //atc.add(builder.build());

        return true;
		//return false; // TODO need to remove this. but i dont want to actually deploy as yet.
	}
	
	
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

	private String extractTypeName(String type){
		int index = type.lastIndexOf(".");
		return type.substring(index+1);
	}
	
	private Collection<String> getTagIDs(){
		ArrayList<String> result = new ArrayList<String>();
		BrooklynClassLoadingContext bclc = JavaBrooklynClassLoadingContext.create(mgmt);
		//load the configKeys class
		Maybe<Class<?>> mby = bclc.tryLoadClass("org.apache.brooklyn.core.entity.BrooklynConfigKeys");
		if (mby.isPresentAndNonNull()){
			Class<?> clazz = mby.get();
			try {
				Field[] fields = clazz.getDeclaredFields();
				for(int i = 0; i<fields.length-1; i++){
	
					Field field = fields[i];
					field.setAccessible(true);
					if(! field.isAnnotationPresent(Deprecated.class)){
					if (field.get(null) instanceof ConfigKey)
						result.add(((ConfigKey<?>) field.get(null)).getName());
					else if (field.get(null) instanceof AttributeSensorAndConfigKey)
						result.add(((AttributeSensorAndConfigKey<?, ?>) field.get(null)).getConfigKey().getName());
					else
						result.add(((String) field.get(null)).toString());
					}
				}			
			} catch (ClassCastException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				log.error("***Exception***"+e);
				//e.printStackTrace();
			}
		}
		return result;
	}
	
}
