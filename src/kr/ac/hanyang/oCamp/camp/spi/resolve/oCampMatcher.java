package kr.ac.hanyang.oCamp.camp.spi.resolve;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.EntitySpec;
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
import org.apache.brooklyn.camp.spi.collection.ResolvableLink;
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
import org.apache.brooklyn.util.collections.MutableSet;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.text.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.ac.hanyang.oCamp.api.policyManager.PolicyManager;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.oCampAssemblyTemplateConstructor;
import kr.ac.hanyang.oCamp.camp.platform.oCampAssemblyTemplateInstantiator;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform.oCampPlatformTransaction;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatformComponentTemplate;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;
import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerComponentTemplate;
import kr.ac.hanyang.oCamp.entities.requirements.IService;

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
			String serviceType = service.getCharacteristics().iterator().next().getCharacteristicType();// get the 1st characteristic type. we assume that only one characteristic is added
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, serviceType) != null)
                return serviceType;
			
			
		}
		
		if (deploymentItem instanceof Policy){
			Policy policy = (Policy) deploymentItem;
			String policyType = policy.getPolicyType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, policyType) != null)
                return policyType;
			

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
	

	
	public boolean apply(Object deploymentPlanItem, AssemblyTemplateConstructor atc) {
		if (!(deploymentPlanItem instanceof Service) && 
		    !(deploymentPlanItem instanceof Artifact) && 
		    !(deploymentPlanItem instanceof Policy))	return false;
		
		atc.instantiator(oCampAssemblyTemplateInstantiator.class);
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
        
        String name;

        if (deploymentPlanItem instanceof Service){
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type( type.indexOf(':')==-1 ? /*"brooklyn:"+*/type : type ); //reform the type string: this forces the types to only be brooklyn types
        	name = ((Service)deploymentPlanItem).getName();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            Map<String, Object> attrs = MutableMap.copyOf( ((Service)deploymentPlanItem).getCustomAttributes() ); 
            if (attrs.containsKey("id"))
            builder.customAttribute("serviceID", attrs.remove("id"));
	        builder.customAttribute("location", "AWS Tokyo (ap-northeast-1)");
	        //add custom tags
	        Collection<String> keys = getTagIDs();
	        for(String key: keys){
	        	addCustomMapAttributeIfNonNull(builder, attrs, key);
	        }
	        
	        atc.add(builder.build()); // Add the service to the AssemblyTemplate
        }
        else if (deploymentPlanItem instanceof Artifact){ 
        	//all services were already added except those specified in fulfillment
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type( type.indexOf(':')==-1 ? /*"brooklyn:"+*/type : type ); //reform the type string: this forces the types to only be brooklyn types
        	name = ((Artifact)deploymentPlanItem).getName();
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	ArtifactContent content = (ArtifactContent)((Artifact)deploymentPlanItem).getContent();
        	if (content != null){
        		builder.customAttribute("content",content.getHref());
        	}
        	Map<String, Object> attrs = MutableMap.copyOf( ((Artifact)deploymentPlanItem).getCustomAttributes() ); 
       
        	List<Object> reqs = MutableList.copyOf( ((Artifact)deploymentPlanItem).getRequirements() ); 
        	       	
        	if (reqs != null ){
        	
        		for(Object requirement: reqs){
        			ArtifactRequirement artRequirement = (ArtifactRequirement) requirement;
        			String reqType = extractSubValue(artRequirement.getRequirementType(),".");
        			Map<String, Object> reqAttrs = MutableMap.copyOf(artRequirement.getCustomAttributes() );
        			
        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> reqBuilder = oCampPlatformComponentTemplate.builder(); 
        	        reqBuilder.type( artRequirement.getRequirementType());
        	        reqBuilder.customAttribute("requirementID", attrs.remove("id"));
        	        
        	        //add custom tags
        	        Collection<String> keys = getTagIDs();
        	        for(String key: keys){
        	        	addCustomMapAttributeIfNonNull(reqBuilder, attrs, key);
        	        }
        	        
        	        //builder.add(reqBuilder.build()); // Add the requirement to the Artifact Template
        	        //inverting
        	        reqBuilder.add(builder.build());
        			
        		
                	if (reqAttrs.containsKey("fulfillment")){

		        		Object fulfillmentObj = reqAttrs.remove("fulfillment");
		        		if (fulfillmentObj instanceof Map){ // we have a definition
		        			Map<String, Object> fulfillment = (Map<String, Object>) fulfillmentObj;
		        			Service service = Service.of(fulfillment);	        				
		        		
		        			//apply(service,atc); // recursively call apply to add the service
		        			//service specified in fulfillment
		        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> servBuilder = oCampPlatformComponentTemplate.builder(); 
		                    builder.type( service.getServiceType()); 
		                	name = service.getName();
		                    if (!Strings.isBlank(name)) 
		                    	builder.name(name);
		                    Map<String, Object> servAttrs = MutableMap.copyOf( service.getCustomAttributes() ); 
		                    if (attrs.containsKey("id"))
		                    builder.customAttribute("serviceID", attrs.remove("id"));
		        	        
		        	        //add custom tags
		        	        Collection<String> servKeys = getTagIDs();
		        	        for(String key: servKeys){
		        	        	addCustomMapAttributeIfNonNull(servBuilder, attrs, key);
		        	        }
		        	        servBuilder.add(reqBuilder.build());
		        	        atc.add(servBuilder.build()); // Add the service to the AssemblyTemplate
		        		}else{
		        			log.info("The artifact is referencing a service by ID");
		        			// I need to verify that the service is specified with an ID
		        			//extract the service id. id:serviceID
		        			//atc.getService(string id);
		        			String id = extractSubValue((String)fulfillmentObj,":");
		        			((oCampAssemblyTemplateConstructor)atc).addRequirement(reqBuilder.build(),id);
		        		}
	
		        	}
        			
        		}
        		
        	}
        	MutableMap<Object, Object> customFlags = MutableMap.of();
        	Object origBrooklynFlags = reqs.remove(BrooklynCampReservedKeys.BROOKLYN_FLAGS);
        	
        	//atc.add(builder.build());// Add the Artifact to the AssemblyTemplate
        	
        }else if(deploymentPlanItem instanceof Policy){
        	
        	//find the policy manager in the platform
        	//if is does not exit then create it.
        	for(ResolvableLink<PolicyManagerComponentTemplate> rlink:((oCampAssemblyTemplateConstructor)atc).getPlatform().policyManagerComponentTemplates().links() ){
        		PolicyManagerComponentTemplate pmct = rlink.resolve();
        		if (!pmct.getType().equals(((Policy)deploymentPlanItem).getPolicyType())){
        			//no policy manager lets try to create it and add it.
        			// then create the policy and add it to the application.
        			
        			PolicyManagerComponentTemplate polMCT = PolicyManagerComponentTemplate.builder().description("Policy Manager for "+type+" policies.")
			                .name(type+" PolicyManager")
			                .type(type)
			                .build();
        			
					BrooklynClassLoadingContext loader = JavaBrooklynClassLoadingContext.create(mgmt);
					BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, polMCT);
					
					EntitySpec<? extends PolicyManager> polMgrSpec = entityResolver.resolveSpec(MutableSet.<String>of());
					PolicyManager polMgr = mgmt.getEntityManager().createEntity(polMgrSpec);
					((oCampPlatformTransaction) ((oCampAssemblyTemplateConstructor)atc).getPlatform().transaction()).add(polMCT).commit();
        		}// else means that a policy may be unmanagable
        	}
        	
        	
        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type( type.indexOf(':')==-1 ? /*"brooklyn:"+*/type : type ); //reform the type string: this forces the types to only be brooklyn types
        	name = ((Policy)deploymentPlanItem).getName();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            
            Map<String, Object> attrs = MutableMap.copyOf( ((Policy)deploymentPlanItem).getCustomAttributes() ); 
            if (attrs.containsKey("id"))
            builder.customAttribute("planId", attrs.remove("id"));
            
            List<Object> constraints = MutableList.copyOf( ((Policy)deploymentPlanItem).getPolicyConstraints() ); 
            List<String> targets = MutableList.copyOf( ((Policy)deploymentPlanItem).getTargets() ); 
            builder.customAttribute("constraint", constraints);
            builder.customAttribute("targets", targets);
            
	        
	        Collection<String> keys = getTagIDs();

	        
	        atc.add(builder.build()); // add the policytemplate
        }

        return true;
		
	}
	
	public void invertApp(oCampAssemblyTemplateConstructor atc){
		
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

	private String extractSubValue(String str, String del){
		int index = str.lastIndexOf(del);
		return str.substring(index+1);
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
