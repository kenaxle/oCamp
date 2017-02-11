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
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
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
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpFactory;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceModel;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel;
import kr.ac.hanyang.oCamp.camp.pdp.TransitionModel;
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
		
		if (deploymentItem instanceof ArtifactModel){
			ArtifactModel artifact = (ArtifactModel) deploymentItem;
			String artifactType = artifact.getArtifactType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
			if (loader == null) 
				loader = JavaBrooklynClassLoadingContext.create(mgmt);
			if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, artifactType) != null)         
				return artifactType; //just for testing
		}
		
		if (deploymentItem instanceof ArtifactRequirementModel){
			ArtifactRequirementModel artifactReq = (ArtifactRequirementModel) deploymentItem;
			String artReqType = artifactReq.getRequirementType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
			if (loader == null) 
				loader = JavaBrooklynClassLoadingContext.create(mgmt);
			if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, artReqType) != null)         
				return artReqType; //just for testing
		}
		
		if (deploymentItem instanceof ServiceModel){
			ServiceModel service = (ServiceModel) deploymentItem;
			String serviceType = service.getCharacteristics().iterator().next().getCharacteristicType();// get the 1st characteristic type. we assume that only one characteristic is added
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, serviceType) != null)
                return serviceType;
		}
		
		if (deploymentItem instanceof PolicyModel){
			PolicyModel policy = (PolicyModel) deploymentItem;
			String policyType = policy.getPolicyType();
			// now can we load the class 
			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
            if (loader == null) 
            	loader = JavaBrooklynClassLoadingContext.create(mgmt);
            if (BrooklynComponentTemplateResolver.Factory.newInstance(loader, policyType) != null)
                return policyType;
		}
		
		if (deploymentItem instanceof ActionGroupModel){
			ActionGroupModel actionGroup = (ActionGroupModel) deploymentItem;
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
	
	
	
//	// matches the best service to the requirement type and takes 
//	// into consideration the characteristics 
//	@Deprecated
//	protected List<String> matchService(String typeName, Collection<String> charTypes){
//		String[] services = {"web.tomcat.Tomcat8","software.SoftwareProcess"};
//		List<String> matches = new MutableList<String>();
//		for(String servType: services){
//			BrooklynClassLoadingContext loader = BasicBrooklynCatalog.BrooklynLoaderTracker.getLoader();
//	        if (loader == null) 
//	        	loader = JavaBrooklynClassLoadingContext.create(mgmt);
//	        IService service;
//			try {
//				service = (IService) loader.loadClass(SERVICE_PREFIX+servType).newInstance();
//				for(String capType: service.getCapabilities()){
//					if (capType.equals(typeName))
//						matches.add(service.getClass().getCanonicalName()) ;
//				}
//			} catch (InstantiationException e) {
//				log.error("cannot instantiate "+servType+" "+e );
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				log.error("no access to "+servType);
//				e.printStackTrace();
//			}
//		}
//		return matches;
//	}

	@Override
	public boolean accepts(Object deploymentPlanItem) {
		return lookupType(deploymentPlanItem) != null;		
	}
	

	
	public boolean apply(Object deploymentPlanItem, AssemblyTemplateConstructor atc) {
		if (!(deploymentPlanItem instanceof ServiceModel) && 
		    !(deploymentPlanItem instanceof ArtifactModel) && 
		    !(deploymentPlanItem instanceof PolicyModel) &&
		    !(deploymentPlanItem instanceof ActionGroupModel))	return false;
		
		atc.instantiator(oCampAssemblyTemplateInstantiator.class);
		String type = lookupType(deploymentPlanItem);
		if (type == null) return false;
		
		log.debug("Item "+deploymentPlanItem+" being instantiated with "+type);
        
        String name;

        if (deploymentPlanItem instanceof ServiceModel){
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type( type ); 
        	name = ((ServiceModel)deploymentPlanItem).getName();
        	Collection<String> keys = getTagIDs();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            List<Object> characteristics = MutableList.copyOf(((ServiceModel)deploymentPlanItem).getCharacteristics());
            for(Object servChar: characteristics){
            	//Map<String, Object> attrs =  ((ServiceCharacteristic)servChar).getCustomAttributes().map() ;           	
	            if (((ServiceCharacteristicModel)servChar).eGet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__MEMBER) != null){ // this is a cluster of group. parse the spec of the member
	            	ServiceModel memberService = (ServiceModel) ((ServiceCharacteristicModel)servChar).eGet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__MEMBER);
	            	
	            	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> memberBuilder = oCampPlatformComponentTemplate.builder();
	            	memberBuilder.type(lookupType(memberService));
	            	Map<String, Object> memberAttrs =  memberService.getCustomAttributes().map(); 
	            	for(String key: keys){
	     	        	addCustomMapAttributeIfNonNull(memberBuilder, memberAttrs, key);
	     	        }
	            	builder.customAttribute("member", memberBuilder.build());
	            }
           	
            }
            if (((ServiceModel)deploymentPlanItem).getCustomAttributes().containsKey("id"))
            builder.customAttribute("planId", ((ServiceModel)deploymentPlanItem).getCustomAttributes().get("id"));
  
	        //******************************************************************
            //builder.customAttribute("location", "AWS Tokyo (ap-northeast-1)");
            //******************************************************************
            //add custom tags
            Map<String, Object> attrs = ((ServiceModel)deploymentPlanItem).getCustomAttributes().map() ; 
	        for(String key: keys){
	        	addCustomMapAttributeIfNonNull(builder, attrs, key);
	        }
	        
	        atc.add(builder.build()); // Add the service to the AssemblyTemplate
        }
        else if (deploymentPlanItem instanceof ArtifactModel){ 
        	//all services were already added except those specified in fulfillment
        	//**** build an oCampPlatformComponentTemplate instead
    		oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(type); //reform the type string: this forces the types to only be brooklyn types
        	name = ((ArtifactModel)deploymentPlanItem).getName();
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	ArtifactContent content = (ArtifactContent)((ArtifactModel)deploymentPlanItem).getContent();
        	if (content != null){
        		builder.customAttribute("content",content.getHref());
        	}
        	Map<String, Object> attrs =  ((ArtifactModel)deploymentPlanItem).getCustomAttributes().map() ; 
       
        	List<Object> reqs = MutableList.copyOf( ((ArtifactModel)deploymentPlanItem).getRequirements() ); 
        	
        	oCampPlatformComponentTemplate artifact = builder.build();
        	
        	if (reqs != null ){
        	
        		for(Object requirement: reqs){
        			ArtifactRequirementModel artRequirement = (ArtifactRequirementModel) requirement;
        			String reqType = extractSubValue(artRequirement.getRequirementType(),".");
        			Map<String, Object> reqAttrs = artRequirement.getCustomAttributes().map() ;
        			
        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> reqBuilder = oCampPlatformComponentTemplate.builder(); 
        	        reqBuilder.type( reqType);
        	        reqBuilder.customAttribute("planId", reqAttrs.remove("id"));
        	        
        	        //add custom tags
        	        Collection<String> keys = getTagIDs();
        	        for(String key: keys){
        	        	addCustomMapAttributeIfNonNull(reqBuilder, reqAttrs, key);
        	        }
        	  
        	        reqBuilder.add(artifact);
        	        String fulfillment = (String) artRequirement.eGet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__FULFILLMENT);
                	if (fulfillment != null ){
                		
		        			log.info("The artifact is referencing a service by ID");

		        			String id = extractSubValue((String)fulfillment,":");
		        			
		        			((oCampAssemblyTemplateConstructor)atc).addRequirement(reqBuilder.build(),id);
		        			
		        		}
	
		        	}
        			
        		//}
        		
        	}
        	//MutableMap<Object, Object> customFlags = MutableMap.of();
        	//Object origBrooklynFlags = reqs.remove(BrooklynCampReservedKeys.BROOKLYN_FLAGS);
        	
        }else if(deploymentPlanItem instanceof PolicyModel){

        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(POLICY_PREFIX+"Policy"); //Policy class. there are no other policy types
        	name = ((PolicyModel)deploymentPlanItem).getName();
            if (!Strings.isBlank(name)) 
            	builder.name(name);
            
            Map<String, Object> attrs = ((PolicyModel)deploymentPlanItem).getCustomAttributes().map() ; 
            if (attrs.containsKey("id"))
            builder.customAttribute("planId", attrs.remove("id"));
            
            builder.customAttribute("policymanager.type", type); //need to keep track of the policy manager to process this policy
           
            List<String> targets = MutableList.copyOf( ((PolicyModel)deploymentPlanItem).getTargets() ); 

            builder.customAttribute("targets", targets);
            List<Object> constraints = MutableList.copyOf( ((PolicyModel)deploymentPlanItem).getPolicyConstraints() ); 
	        for (Object constraintObject: constraints){
	        	PolicyConstraintModel polConstraint = (PolicyConstraintModel) constraintObject;
	        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> constBuilder = oCampPlatformComponentTemplate.builder(); 
    	        constBuilder.type( polConstraint.getPolicyConstraintType());
    	        Map<String, Object> constAttrs = polConstraint.getCustomAttributes().map(); 
    	        constBuilder.customAttribute("property", constAttrs.remove("property"));
    	        constBuilder.customAttribute("value", polConstraint.getValue());
    	        builder.add(constBuilder.build());
	        }
	        Collection<String> keys = getTagIDs();

	        
	        atc.add(builder.build()); // add the policytemplate
        }else if(deploymentPlanItem instanceof ActionGroupModel){
        	oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> builder = oCampPlatformComponentTemplate.builder(); 
            builder.type(type); //reform the type string: this forces the types to only be brooklyn types
        	name = ((ActionGroupModel)deploymentPlanItem).getName(); // this is not needed FIXME
        	if (!Strings.isBlank(name)) 
        		builder.name(name);
        	
        	builder.customAttribute("actionId", ((ActionGroupModel)deploymentPlanItem).getActionId());
        	Map<String, Object> attrs =  (Map<String, Object>) ((ActionGroupModel)deploymentPlanItem).getCustomAttributes() ; 
        	List<ActionModel> actions = MutableList.copyOf( ((ActionGroupModel)deploymentPlanItem).getActions());
        	if (actions != null ){
        		for(ActionModel action: actions){
        			oCampPlatformComponentTemplate.Builder<? extends oCampPlatformComponentTemplate> actionBuilder = oCampPlatformComponentTemplate.builder(); 
        			actionBuilder.type( action.getActionType());
        			actionBuilder.customAttribute("property", action.getProperty());
        			
        			List<TransitionModel> transitions = MutableList.copyOf(action.getTransitions());
        			if (transitions != null ){
                		for(TransitionModel transition: transitions){
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
