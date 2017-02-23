package kr.ac.hanyang.oCamp.camp.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.eclipse.emf.ecore.EFactory;

import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionModel;
import kr.ac.hanyang.oCamp.camp.pdp.Artifact;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyModel;
//import kr.ac.hanyang.oCamp.camp.pdp.Service;
//import kr.ac.hanyang.tosca2camp.rest.model.ModelPackage;
//import kr.ac.hanyang.tosca2camp.rest.model.ServiceTemplateModel;
import kr.ac.hanyang.oCamp.camp.pdp.Service;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceModel;
import kr.ac.hanyang.oCamp.camp.pdp.TransitionModel;
import kr.ac.hanyang.oCamp.camp.pdp.bk.Action;
import kr.ac.hanyang.oCamp.camp.pdp.bk.Transition;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel;


public class DeploymentPlanTransformer {
	
	String name;
	String origin;
	String description;
	String sourceCode;
	String type;
	List<Artifact> artifacts;
	List<Service> services;
	List<Policy> policies;
	List<ActionGroup> actionGroups;
	Map<String,Object> customAttributes;
		   
	   
    @SuppressWarnings("unchecked")
    public static DeploymentPlanModel getDeploymentPlan(Map<String,Object> root, String optionalSourceCode) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
		DeploymentPlanModel deploymentPlan = (DeploymentPlanModel) factory.create(PdpPackage.Literals.DEPLOYMENT_PLAN_MODEL);
		
        //DeploymentPlanTransformer result = new DeploymentPlanTransformer();
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__NAME,(String) attrs.remove("name"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION,(String) attrs.remove("description"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN,(String) attrs.remove("origin"));
		deploymentPlan.eSet(PdpPackage.Literals.DEPLOYMENT_PLAN_MODEL__TYPE,(String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE,optionalSourceCode);
        
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS, getArtifacts(attrs.remove("artifacts")));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES, getServices(attrs.remove("services")));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES, getPolicies(attrs.remove("policies")));
		deploymentPlan.eSet(PdpPackage.Literals.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS,getActionGroups(attrs.remove("actiongroups")));
		//actiongroups
		//custom attributes
		// TODO version
		return deploymentPlan;
        
    }
    
    public static ServiceModel getService(Map<String, Object> svc){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
		ServiceModel service = (ServiceModel) factory.create(PdpPackage.Literals.SERVICE_MODEL);
    	
		Map<String,Object> fields = MutableMap.copyOf(svc);
    	
		service.eSet(PdpPackage.Literals.SERVICE_MODEL__NAME, (String) fields.remove("name"));
		service.eSet(PdpPackage.Literals.SERVICE_MODEL__DESCRIPTION, (String) fields.remove("description"));
		service.eSet(PdpPackage.Literals.SERVICE_MODEL__SERVICE_TYPE, (String) Yamls.removeMultinameAttribute(fields, "service_type", "serviceType", "type"));
		
		service.eSet(PdpPackage.Literals.SERVICE_MODEL__CHARACTERISTICS, getServiceCharacteristics(fields.remove("characteristics")));
        service.eSet(PdpPackage.Literals.SERVICE_MODEL__CUSTOM_ATTRIBUTES, fields);
        return service;
    }
       
    
    public static ServiceCharacteristicModel getServiceCharacteristic(Map<String,Object> svc){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ServiceCharacteristicModel serviceCharacteristic = (ServiceCharacteristicModel) factory.create(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(svc);
    	
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__NAME, (String) fields.remove("name"));
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__DESCRIPTION, (String) fields.remove("description"));
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__CHARACTERISTIC_TYPE, (String) Yamls.removeMultinameAttribute(fields, "characteristicType", "type"));
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__MEMBER, getService((Map<String, Object>)fields.remove("member")));
        serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC_MODEL__CUSTOM_ATTRIBUTES, fields);
        
        return serviceCharacteristic;
    }
    
    public static ArtifactModel getArtifact(Map<String,Object> art){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ArtifactModel artifact = (ArtifactModel) factory.create(PdpPackage.Literals.ARTIFACT_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(art);
    	
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__NAME, (String) fields.remove("name"));
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__DESCRIPTION, (String) fields.remove("description"));
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__ARTIFACT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type"));	
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__CONTENT, getContent(fields.remove("content")));
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__REQUIREMENTS, getRequirements(fields.remove("requirements")));
		
		artifact.eSet(PdpPackage.Literals.ARTIFACT_MODEL__CUSTOM_ATTRIBUTES, fields);
		
        return artifact;
    }
    
    public static ArtifactContentModel getContent(Object spec){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ArtifactContentModel artCont = (ArtifactContentModel) factory.create(PdpPackage.Literals.ARTIFACT_CONTENT_MODEL);
    	if (spec instanceof String) {
    		artCont.eSet(PdpPackage.Literals.ARTIFACT_CONTENT_MODEL__HREF, (String)spec);
        } else if (spec instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String,Object> fields = MutableMap.copyOf( (Map<String,Object>) spec );
            artCont.eSet(PdpPackage.Literals.ARTIFACT_CONTENT_MODEL__HREF, (String) fields.remove("href"));
            artCont.eSet(PdpPackage.Literals.ARTIFACT_CONTENT_MODEL__CUSTOM_ATTRIBUTES, fields);            
        } else {
            throw new IllegalArgumentException("artifact content should be map or string, not "+spec.getClass());
        }	
        return artCont;
    }
    
    public static ArtifactRequirementModel getRequirement(Map<String,Object> requirement){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ArtifactRequirementModel req = (ArtifactRequirementModel) factory.create(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(requirement);
    	
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__NAME, (String) fields.remove("name"));
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__DESCRIPTION, (String) fields.remove("description"));
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__REQUIREMENT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type"));	
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__FULFILLMENT, fields.remove("fulfillment"));
		
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT_MODEL__CUSTOM_ATTRIBUTES, fields);
		
        return req;
    }
    
    public static PolicyModel getPolicy(Map<String,Object> pols){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	PolicyModel pol = (PolicyModel) factory.create(PdpPackage.Literals.POLICY_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(pols);
    	
		pol.eSet(PdpPackage.Literals.POLICY_MODEL__NAME, (String) fields.remove("name"));
		pol.eSet(PdpPackage.Literals.POLICY_MODEL__DESCRIPTION, (String) fields.remove("description"));
		pol.eSet(PdpPackage.Literals.POLICY_MODEL__POLICY_TYPE, (String) Yamls.removeMultinameAttribute(fields, "policyType", "type"));	
		pol.eSet(PdpPackage.Literals.POLICY_MODEL__POLICY_CONSTRAINTS, getConstraints( fields.remove("constraints")));
		pol.eSet(PdpPackage.Literals.POLICY_MODEL__TARGETS, getTargets( fields.remove("targets")));	
        pol.eSet(PdpPackage.Literals.POLICY_MODEL__CUSTOM_ATTRIBUTES, fields);
        
        return pol;
    }
    
    
    public static PolicyConstraintModel getPolicyConstraint(Map<String,Object> polConsts){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	PolicyConstraintModel polConst = (PolicyConstraintModel) factory.create(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(polConsts);
    	
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL__NAME, (String) fields.remove("name"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL__DESCRIPTION, (String) fields.remove("description"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "policyConstraintType", "type"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL__VALUE, fields.remove("value"));	
        polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES, fields);
        
        return polConst;
    }
    
    
    public static ActionGroupModel getActionGroup(Map<String, Object> actionGroups){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ActionGroupModel actionGroup = (ActionGroupModel) factory.create(PdpPackage.Literals.ACTION_GROUP_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(actionGroups);
		
		actionGroup.eSet(PdpPackage.Literals.ACTION_GROUP_MODEL__NAME, (String) fields.remove("name"));
		actionGroup.eSet(PdpPackage.Literals.ACTION_GROUP_MODEL__DESCRIPTION, (String) fields.remove("description"));
		actionGroup.eSet(PdpPackage.Literals.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE, oCampReserved.POLICY_PREFIX+"ActionGroup");
		actionGroup.eSet(PdpPackage.Literals.ACTION_GROUP_MODEL__ACTION_ID, (String) Yamls.removeMultinameAttribute(fields, "actiong_id", "actionId", "id"));
		actionGroup.eSet(PdpPackage.Literals.ACTION_GROUP_MODEL__ACTIONS, getActions(fields.remove("actions")));
		
		return actionGroup;
    }
    
    public static ActionModel getAction(Map<String, Object> actions){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ActionModel action = (ActionModel) factory.create(PdpPackage.Literals.ACTION_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(actions);
		
		action.eSet(PdpPackage.Literals.ACTION_MODEL__NAME, (String) fields.remove("name"));
		action.eSet(PdpPackage.Literals.ACTION_MODEL__DESCRIPTION, (String) fields.remove("description"));
		action.eSet(PdpPackage.Literals.ACTION_MODEL__ACTION_TYPE, oCampReserved.POLICY_PREFIX+"Action");
		action.eSet(PdpPackage.Literals.ACTION_MODEL__PROPERTY, (String) fields.remove("property"));
		action.eSet(PdpPackage.Literals.ACTION_MODEL__TRANSITIONS, getTransitions(fields.remove("transitions")));
		
		return action;
    }
    
    public static TransitionModel getTransition(Map<String, Object> transitions){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	TransitionModel transition = (TransitionModel) factory.create(PdpPackage.Literals.TRANSITION_MODEL);
		Map<String,Object> fields = MutableMap.copyOf(transitions);
		
		transition.eSet(PdpPackage.Literals.TRANSITION_MODEL__NAME, (String) fields.remove("name"));
		transition.eSet(PdpPackage.Literals.TRANSITION_MODEL__DESCRIPTION, (String) fields.remove("description"));
		transition.eSet(PdpPackage.Literals.TRANSITION_MODEL__TRANSITION_TYPE, (String) Yamls.removeMultinameAttribute(fields, "transition_type", "transitionType", "type"));
		transition.eSet(PdpPackage.Literals.TRANSITION_MODEL__VALUE, fields.remove("value"));
		
		return transition;
		
    }
    
    
    
    public static List<ServiceCharacteristicModel> getServiceCharacteristics(Object chars){
        List<ServiceCharacteristicModel> toReturn = new ArrayList<ServiceCharacteristicModel>();
        
        if (chars instanceof Iterable) {
            for (Object req: (Iterable<Object>)chars) {
                if (req instanceof Map) {
                    toReturn.add(getServiceCharacteristic((Map<String,Object>) req));
                } else {
                    throw new IllegalArgumentException("characteristics should be a map, not "+req.getClass());
                }
            }
        } else if (chars!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("services body should be iterable, not "+chars.getClass());
        }
     
		return toReturn;
    }
    
    
    public static List<ServiceModel> getServices(Object services){

    	List<ServiceModel> toReturn = new ArrayList<ServiceModel>();
   
        if (services instanceof Iterable) {
            for (Object svc: (Iterable<Object>)services) {
                if (svc instanceof Map) {
                    toReturn.add(getService((Map<String,Object>) svc));
                } else {
                    throw new UserFacingException("Services list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(svc));
                }
            }
        } else if (services!=null) {
            // TODO "map" short form
            throw new UserFacingException("Services block should be a list, not "+JavaClassNames.superSimpleClassName(services));
        }
        return toReturn;
    }
    
    
    public static List<ArtifactModel> getArtifacts(Object artifacts){
        List<ArtifactModel> toReturn = new ArrayList<ArtifactModel>();
        
        
        if (artifacts instanceof Iterable) {
            for (Object artifact: (Iterable<Object>)artifacts) {
                if (artifact instanceof Map) {
                    toReturn.add(getArtifact((Map<String,Object>) artifact));
                } else {
                    throw new UserFacingException("Artifacts list should contain map items, not "+JavaClassNames.superSimpleClassName(artifact));
                }
            }
        } else if (artifacts!=null) {
            // TODO "map" short form
            throw new UserFacingException("Artifacts block should contain a list, not "+JavaClassNames.superSimpleClassName(artifacts));
        }
        
        return toReturn;
    }
        
        
    public static List<ArtifactRequirementModel> getRequirements(Object reqs){
    	List<ArtifactRequirementModel> toReturn = new ArrayList<ArtifactRequirementModel>();
    	
    	if (reqs instanceof Iterable) {
            for (Object req: (Iterable<Object>)reqs) {
                if (req instanceof Map) {
                    toReturn.add(getRequirement((Map<String,Object>) req));
                } else {
                    throw new IllegalArgumentException("requirement should be a map, not "+req.getClass());
                }
            }
        } else if (reqs!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("artifacts body should be iterable, not "+reqs.getClass());
        }
    	
    	return toReturn;
    
    }
    
    
    public static List<PolicyModel> getPolicies(Object policies){
    	List<PolicyModel> toReturn = new ArrayList<PolicyModel>();
    
       
        if (policies instanceof Iterable) {
            for (Object policy: (Iterable<Object>)policies) {
                if (policy instanceof Map) {
                    toReturn.add(getPolicy((Map<String,Object>) policy));
                } else {
                    throw new UserFacingException("Policies list should contain map items, not "+JavaClassNames.superSimpleClassName(policy));
                }
            }
        } else if (policies!=null) {
            // TODO "map" short form
            throw new UserFacingException("Policies block should contain a list, not "+JavaClassNames.superSimpleClassName(policies));
        }
        return toReturn;
    }
    
    
    public static List<ActionGroupModel> getActionGroups(Object actionGroups){
    	List<ActionGroupModel> toReturn = new ArrayList<ActionGroupModel>();
    	
      if (actionGroups instanceof Iterable) {
          for (Object actionGroup: (Iterable<Object>)actionGroups) {
              if (actionGroup instanceof Map) {
                  toReturn.add(getActionGroup((Map<String,Object>) actionGroup));
              } else {
                  throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
              }
          }
      } else if (actionGroups!=null) {
          // TODO "map" short form
          throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
      }     
      return toReturn;

    }
    
    public static List<ActionModel> getActions(Object actions){
    	List<ActionModel> toReturn = new ArrayList<ActionModel>();
    	
    	if (actions instanceof Iterable) {
            for (Object action: (Iterable<Object>)actions) {
                if (action instanceof Map) {
                    toReturn.add(getAction((Map<String,Object>) action));
                } else {
                    throw new UserFacingException("Actions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(action));
                }
            }
        } else if (actions!=null) {
            // TODO "map" short form
            throw new UserFacingException("Actions block should be a list, not "+JavaClassNames.superSimpleClassName(actions));
        }
    	return toReturn;
    }
    
    
    public static List<TransitionModel> getTransitions(Object transitions){
    	List<TransitionModel> toReturn = new ArrayList<TransitionModel>();
    	
    	 if (transitions instanceof Iterable) {
             for (Object transition: (Iterable<Object>)transitions) {
                 if (transition instanceof Map) {
                     toReturn.add(getTransition((Map<String,Object>) transition));
                 } else {
                     throw new UserFacingException("Transitions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(transition));
                 }
             }
         } else if (transitions!=null) {
             // TODO "map" short form
             throw new UserFacingException("Transitions block should be a list, not "+JavaClassNames.superSimpleClassName(transitions));
         }
    	 
    	 return toReturn;
    }
    
    public static List<PolicyConstraintModel> getConstraints(Object polConsts){
    	List<PolicyConstraintModel> toReturn = new ArrayList<PolicyConstraintModel>();
        
        
        if (polConsts instanceof Iterable) {
            for (Object polConst: (Iterable<Object>)polConsts) {
                if (polConst instanceof Map) {
                    toReturn.add(getPolicyConstraint((Map<String,Object>) polConst));
                } else {
                    throw new UserFacingException("Policies list should contain map items, not "+JavaClassNames.superSimpleClassName(polConst));
                }
            }
        } else if (polConsts!=null) {
            // TODO "map" short form
            throw new UserFacingException("PoliciesConstraints block should contain a list, not "+JavaClassNames.superSimpleClassName(polConsts));
        }
        return toReturn;
    }
    
    public static List<String> getTargets(Object targets){
    	List<String> toReturn = new ArrayList<String>();
        
        if (targets instanceof Iterable) {
            for (Object target: (Iterable<Object>)targets) {
                if (target instanceof String) {
                    toReturn.add((String)target);
                } else {
                    throw new IllegalArgumentException("targets should be a String, not "+target.getClass());
                }
            }
        } else if (targets!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("targets body should be iterable, not "+targets.getClass());
        }
        return toReturn;
    }
//        
//        result.actionGroups = new ArrayList<ActionGroup>();
//        Object actionGroups = attrs.remove("actiongroups");
//        if (actionGroups instanceof Iterable) {
//            for (Object actionGroup: (Iterable<Object>)actionGroups) {
//                if (actionGroup instanceof Map) {
//                    result.actionGroups.add(ActionGroup.of((Map<String,Object>) actionGroup));
//                } else {
//                    throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
//                }
//            }
//        } else if (actionGroups!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
//        }
//        
//        result.customAttributes = attrs;
//        
//        return result;
//    }
//
// 
//    @SuppressWarnings("unchecked")
//    public <T> Maybe<T> getCustomAttribute(String attributeName, Class<T> type, boolean throwIfTypeMismatch) {
//        Object attribute = customAttributes.get(attributeName);
//        if (attribute == null) {
//            return Maybe.absent("Custom attributes does not contain " + attributeName);
//        } else if (!type.isAssignableFrom(attribute.getClass())) {
//            String message = "Custom attribute " + attributeName + " is not of expected type: " +
//                    "expected=" + type.getName() + " actual=" + attribute.getClass().getName();
//            if (throwIfTypeMismatch) {
//                throw new IllegalArgumentException(message);
//            }
//            return Maybe.absent(message);
//        } else {
//            return Maybe.of((T) attribute);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

 
}
