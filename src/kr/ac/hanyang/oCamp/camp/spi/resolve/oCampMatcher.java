package kr.ac.hanyang.oCamp.camp.spi.resolve;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampReservedKeys;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynEntityMatcher;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate.Builder;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.ArtifactContent;
import org.apache.brooklyn.camp.spi.pdp.ArtifactRequirement;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.camp.spi.pdp.ServiceCharacteristic;
import org.apache.brooklyn.camp.spi.resolve.PdpMatcher;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.catalog.internal.BasicBrooklynCatalog;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.text.Strings;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.ac.hanyang.oCamp.camp.pdp.Action;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;
import kr.ac.hanyang.oCamp.camp.pdp.Transition;
import kr.ac.hanyang.oCamp.camp.pdp.oCampAssemblyTemplateConstructor;
import kr.ac.hanyang.oCamp.camp.platform.oCampAssemblyTemplateInstantiator;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatformComponentTemplate;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;
import kr.ac.hanyang.oCamp.entities.requirements.IService;

public class oCampMatcher extends BrooklynEntityMatcher implements PdpMatcher,oCampReserved {
	private static final Logger log = LoggerFactory.getLogger(oCampMatcher.class);
	
	
	public oCampMatcher(ManagementContext mgmt){
		super(mgmt);
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
		
		if (deploymentItem instanceof ActionGroup){
			ActionGroup actionGroup = (ActionGroup) deploymentItem;
			String actionGroupType = actionGroup.getActionGroupType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, actionGroupType) != null)
                return actionGroupType;
		}
		
		
		log.debug( "Not an oCamp Matchable type. unable to match "+deploymentItem);
		return null;
	}
	
	
	
	// matches the best service to the requirement type and takes 
	// into consideration the characteristics 
	@Deprecated
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
		    !(deploymentPlanItem instanceof Policy) &&
		    !(deploymentPlanItem instanceof ActionGroup))	return false;
		
		atc.instantiator(oCampAssemblyTemplateInstantiator.class);
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
        
        String name;

        if (deploymentPlanItem instanceof Service){
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type( type ); 
        	name = ((Service)deploymentPlanItem).getName();
        	Collection<String> keys = getTagIDs();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            List<Object> characteristics = MutableList.copyOf(((Service)deploymentPlanItem).getCharacteristics());
            for(Object servChar: characteristics){
            	Map<String, Object> attrs = MutableMap.copyOf( ((ServiceCharacteristic)servChar).getCustomAttributes() );           	
	            if (attrs.containsKey("member")){ // this is a cluster of group. parse the spec of the member
	            	Service memberService = Service.of((Map<String, Object>) attrs.remove("member"));
	            	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> memberBuilder = oCampPlatformComponentTemplate.builder();
	            	memberBuilder.type(lookupType(memberService));
	            	Map<String, Object> memberAttrs = MutableMap.copyOf( memberService.getCustomAttributes() ); 
	            	for(String key: keys){
	     	        	addCustomMapAttributeIfNonNull(memberBuilder, memberAttrs, key);
	     	        }
	            	builder.customAttribute("member", memberBuilder.build());
	            }
           	
            }
            if (((Service)deploymentPlanItem).getCustomAttributes().containsKey("id"))
            builder.customAttribute("planId", ((Service)deploymentPlanItem).getCustomAttributes().get("id"));
  
	        //******************************************************************
            //builder.customAttribute("location", "AWS Tokyo (ap-northeast-1)");
            //******************************************************************
            //add custom tags
            Map<String, Object> attrs = MutableMap.copyOf( ((Service)deploymentPlanItem).getCustomAttributes() ); 
	        for(String key: keys){
	        	addCustomMapAttributeIfNonNull(builder, attrs, key);
	        }
	        
	        atc.add(builder.build()); // Add the service to the AssemblyTemplate
        }
        else if (deploymentPlanItem instanceof Artifact){ 
        	//all services were already added except those specified in fulfillment
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(type); //reform the type string: this forces the types to only be brooklyn types
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
        	        reqBuilder.customAttribute("planId", attrs.remove("id"));
        	        
        	        //add custom tags
        	        Collection<String> keys = getTagIDs();
        	        for(String key: keys){
        	        	addCustomMapAttributeIfNonNull(reqBuilder, attrs, key);
        	        }
        	  
        	        reqBuilder.add(builder.build());

                	if (reqAttrs.containsKey("fulfillment")){

		        		Object fulfillmentObj = reqAttrs.remove("fulfillment");
		        		if (fulfillmentObj instanceof Map){ // we have a definition
		        			Map<String, Object> fulfillment = (Map<String, Object>) fulfillmentObj;
		        			Service service = Service.of(fulfillment);	        				

		        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> servBuilder = oCampPlatformComponentTemplate.builder(); 
		        			servBuilder.type( service.getServiceType()); 
		                	name = service.getName();
		                    if (!Strings.isBlank(name)) 
		                    	servBuilder.name(name);
		                    List<Object> characteristics = MutableList.copyOf(((Service)deploymentPlanItem).getCharacteristics());
		                    for(Object servChar: characteristics){
		                    	Map<String, Object> fulfillAttrs = MutableMap.copyOf( ((ServiceCharacteristic)servChar).getCustomAttributes() );           	
		        	            if (fulfillAttrs.containsKey("member")){ // this is a cluster of group. parse the spec of the member
		        	            	Service memberService = Service.of((Map<String, Object>) fulfillAttrs.remove("member"));
		        	            	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> memberBuilder = oCampPlatformComponentTemplate.builder();
		        	            	memberBuilder.type(lookupType(memberService));
		        	            	Map<String, Object> memberAttrs = MutableMap.copyOf( memberService.getCustomAttributes() ); 
		        	            	for(String key: keys){
		        	     	        	addCustomMapAttributeIfNonNull(memberBuilder, memberAttrs, key);
		        	     	        }
		        	            	builder.customAttribute("member", memberBuilder.build());
		        	            }
		                   	
		                    }
		                    if (service.getCustomAttributes().containsKey("id"))
		                    	builder.customAttribute("planId", service.getCustomAttributes().get("id"));
		        	        
		        	        //add custom tags
		                    Map<String, Object> servAttrs = MutableMap.copyOf( ((Service)deploymentPlanItem).getCustomAttributes() ); 
		        	        for(String key: keys){
		        	        	addCustomMapAttributeIfNonNull(servBuilder, servAttrs, key);
		        	        }
		        	        servBuilder.add(reqBuilder.build());
		        	        atc.add(servBuilder.build()); // Add the service to the AssemblyTemplate
		        		}else{
		        			log.info("The artifact is referencing a service by ID");

		        			String id = extractSubValue((String)fulfillmentObj,":");
		        			((oCampAssemblyTemplateConstructor)atc).addRequirement(reqBuilder.build(),id);
		        		}
	
		        	}
        			
        		}
        		
        	}
        	MutableMap<Object, Object> customFlags = MutableMap.of();
        	Object origBrooklynFlags = reqs.remove(BrooklynCampReservedKeys.BROOKLYN_FLAGS);
        	
        }else if(deploymentPlanItem instanceof Policy){

        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(POLICY_PREFIX+"Policy"); //Policy class. there are no other policy types
        	name = ((Policy)deploymentPlanItem).getName();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            
            Map<String, Object> attrs = MutableMap.copyOf( ((Policy)deploymentPlanItem).getCustomAttributes() ); 
            if (attrs.containsKey("id"))
            builder.customAttribute("planId", attrs.remove("id"));
            
            builder.customAttribute("policymanager.type", type); //need to keep track of the policy manager to process this policy
           
            List<String> targets = MutableList.copyOf( ((Policy)deploymentPlanItem).getTargets() ); 

            builder.customAttribute("targets", targets);
            List<Object> constraints = MutableList.copyOf( ((Policy)deploymentPlanItem).getPolicyConstraints() ); 
	        for (Object constraintObject: constraints){
	        	PolicyConstraint polConstraint = (PolicyConstraint) constraintObject;
	        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> constBuilder = oCampPlatformComponentTemplate.builder(); 
    	        constBuilder.type( polConstraint.getPolicyConstraintType());
    	        Map<String, Object> constAttrs = MutableMap.copyOf( polConstraint.getCustomAttributes()); 
    	        constBuilder.customAttribute("property", constAttrs.remove("property"));
    	        constBuilder.customAttribute("value", polConstraint.getValue());
    	        builder.add(constBuilder.build());
	        }
	        Collection<String> keys = getTagIDs();

	        
	        atc.add(builder.build()); // add the policytemplate
        }else if(deploymentPlanItem instanceof ActionGroup){
        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(type); //reform the type string: this forces the types to only be brooklyn types
        	name = ((ActionGroup)deploymentPlanItem).getName(); // this is not needed FIXME
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	
        	builder.customAttribute("actionId", ((ActionGroup)deploymentPlanItem).getActionId());
        	Map<String, Object> attrs = MutableMap.copyOf( ((ActionGroup)deploymentPlanItem).getCustomAttributes() ); 
        	List<Action> actions = MutableList.copyOf( ((ActionGroup)deploymentPlanItem).getActions());
        	if (actions != null ){
        		for(Action action: actions){
        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> actionBuilder = oCampPlatformComponentTemplate.builder(); 
        			actionBuilder.type( action.getActionType());
        			actionBuilder.customAttribute("property", action.getProperty());
        			
        			List<Transition> transitions = MutableList.copyOf(action.getTransitions());
        			if (transitions != null ){
                		for(Transition transition: transitions){
                			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> transBuilder = oCampPlatformComponentTemplate.builder(); 
                			transBuilder.type( oCampReserved.TRANSITION_PREFIX+transition.getTransitionType());
                			transBuilder.customAttribute("value", transition.getValue());
                			
                			actionBuilder.add(transBuilder.build());
                		}
        			}        	     
        	  
        			builder.add(actionBuilder.build());
        		}
        	}
        	atc.addCustomAttributes(MutableMap.of("policyMgr",true));
        	atc.add(builder.build());
        }

        return true;
		
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
		Maybe<Class<?>> mby = bclc.tryLoadClass("kr.ac.hanyang.oCamp.core.mgmt.oCampConfigKeys"/*"org.apache.brooklyn.core.entity.BrooklynConfigKeys"*/);
		if (mby.isPresentAndNonNull()){
			Class<?> clazz = mby.get();
			try {
				Field[] fields = clazz.getDeclaredFields();
				Field[] fields_super = clazz.getSuperclass().getDeclaredFields();
				Field[] all_fields = (Field[]) ArrayUtils.addAll(fields, fields_super);
				for(int i = 0; i<all_fields.length-1; i++){
	
					Field field = all_fields[i];
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
