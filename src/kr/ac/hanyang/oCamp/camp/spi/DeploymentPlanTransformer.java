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
import kr.ac.hanyang.oCamp.camp.pdp.Artifact;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;
//import kr.ac.hanyang.oCamp.camp.pdp.Service;
//import kr.ac.hanyang.tosca2camp.rest.model.ModelPackage;
//import kr.ac.hanyang.tosca2camp.rest.model.ServiceTemplateModel;
import kr.ac.hanyang.oCamp.camp.pdp.Service;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement;


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
    public static DeploymentPlan getDeploymentPlan(Map<String,Object> root, String optionalSourceCode) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
		DeploymentPlan deploymentPlan = (DeploymentPlan) factory.create(PdpPackage.Literals.DEPLOYMENT_PLAN);
		
        //DeploymentPlanTransformer result = new DeploymentPlanTransformer();
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__NAME,(String) attrs.remove("name"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__DESCRIPTION,(String) attrs.remove("description"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__ORIGIN,(String) attrs.remove("origin"));
		deploymentPlan.eSet(PdpPackage.Literals.DEPLOYMENT_PLAN__TYPE,(String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type"));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__SOURCE_CODE,optionalSourceCode);
        
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__ARTIFACTS, getArtifacts(attrs.remove("artifacts")));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__SERVICES, getServices(attrs.remove("services")));
		deploymentPlan.eSet(PdpPackage.Literals.ABSTRACT_OCAMP_PLAN__POLICIES, getPolicies(attrs.remove("policies")));
		// TODO version
		return deploymentPlan;
        
    }
    
    public static Service getService(Map<String, Object> svc){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
		Service service = (Service) factory.create(PdpPackage.Literals.SERVICE);
    	
		Map<String,Object> fields = MutableMap.copyOf(svc);
    	
		service.eSet(PdpPackage.Literals.SERVICE__NAME, (String) fields.remove("name"));
		service.eSet(PdpPackage.Literals.SERVICE__DESCRIPTION, (String) fields.remove("description"));
		service.eSet(PdpPackage.Literals.SERVICE__SERVICE_TYPE, (String) Yamls.removeMultinameAttribute(fields, "service_type", "serviceType", "type"));
		
		service.eSet(PdpPackage.Literals.SERVICE__CHARACTERISTICS, getServiceCharacteristics(fields.remove("characteristics")));
        service.eSet(PdpPackage.Literals.SERVICE__CUSTOM_ATTRIBUTES, fields);
        return service;
    }
       
    
    public static ServiceCharacteristic getServiceCharacteristic(Map<String,Object> svc){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ServiceCharacteristic serviceCharacteristic = (ServiceCharacteristic) factory.create(PdpPackage.Literals.SERVICE_CHARACTERISTIC);
		Map<String,Object> fields = MutableMap.copyOf(svc);
    	
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC__NAME, (String) fields.remove("name"));
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC__DESCRIPTION, (String) fields.remove("description"));
		serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE, (String) Yamls.removeMultinameAttribute(fields, "characteristicType", "type"));	
        serviceCharacteristic.eSet(PdpPackage.Literals.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES, fields);
        
        return serviceCharacteristic;
    }
    
    public static Artifact getArtifact(Map<String,Object> art){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	Artifact artifact = (Artifact) factory.create(PdpPackage.Literals.SERVICE_CHARACTERISTIC);
		Map<String,Object> fields = MutableMap.copyOf(art);
    	
		artifact.eSet(PdpPackage.Literals.ARTIFACT__NAME, (String) fields.remove("name"));
		artifact.eSet(PdpPackage.Literals.ARTIFACT__DESCRIPTION, (String) fields.remove("description"));
		artifact.eSet(PdpPackage.Literals.ARTIFACT__ARTIFACT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type"));	
		artifact.eSet(PdpPackage.Literals.ARTIFACT__CONTENT, fields.remove("content"));
		artifact.eSet(PdpPackage.Literals.ARTIFACT__REQUIREMENTS, getRequirements(fields.remove("requirements")));
		
		artifact.eSet(PdpPackage.Literals.ARTIFACT__CUSTOM_ATTRIBUTES, fields);
		
        return artifact;
    }
    
    public static ArtifactRequirement getRequirement(Map<String,Object> requirement){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	ArtifactRequirement req = (ArtifactRequirement) factory.create(PdpPackage.Literals.ARTIFACT_REQUIREMENT);
		Map<String,Object> fields = MutableMap.copyOf(requirement);
    	
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT__NAME, (String) fields.remove("name"));
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT__DESCRIPTION, (String) fields.remove("description"));
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT__REQUIREMENT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type"));	
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT__FULFILLMENT, fields.remove("fulfillment"));
		
		req.eSet(PdpPackage.Literals.ARTIFACT_REQUIREMENT__CUSTOM_ATTRIBUTES, fields);
		
        return req;
    }
    
    public static Policy getPolicy(Map<String,Object> pols){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	Policy pol = (Policy) factory.create(PdpPackage.Literals.POLICY);
		Map<String,Object> fields = MutableMap.copyOf(pols);
    	
		pol.eSet(PdpPackage.Literals.POLICY__NAME, (String) fields.remove("name"));
		pol.eSet(PdpPackage.Literals.POLICY__DESCRIPTION, (String) fields.remove("description"));
		pol.eSet(PdpPackage.Literals.POLICY__POLICY_TYPE, (String) Yamls.removeMultinameAttribute(fields, "policyType", "type"));	
		pol.eSet(PdpPackage.Literals.POLICY__POLICY_CONSTRAINTS, getConstraints( fields.remove("constraints")));
		pol.eSet(PdpPackage.Literals.POLICY__TARGETS, getTargets( fields.remove("constraints")));	
        pol.eSet(PdpPackage.Literals.POLICY__CUSTOM_ATTRIBUTES, fields);
        
        return pol;
    }
    
    
    public static PolicyConstraint getPolicyConstraint(Map<String,Object> polConsts){
    	EFactory factory = PdpPackage.eINSTANCE.getEFactoryInstance();
    	PolicyConstraint polConst = (PolicyConstraint) factory.create(PdpPackage.Literals.POLICY_CONSTRAINT);
		Map<String,Object> fields = MutableMap.copyOf(polConsts);
    	
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT__NAME, (String) fields.remove("name"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT__DESCRIPTION, (String) fields.remove("description"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "policyConstraintType", "type"));
		polConst.eSet(PdpPackage.Literals.POLICY_CONSTRAINT__VALUE, fields.remove("value"));	
        polConst.eSet(PdpPackage.Literals.POLICY__CUSTOM_ATTRIBUTES, fields);
        
        return polConst;
    }
    
    
    
    public static List<ServiceCharacteristic> getServiceCharacteristics(Object chars){
        List<ServiceCharacteristic> toReturn = new ArrayList<ServiceCharacteristic>();
        
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
    
    
    public static List<Service> getServices(Object services){

    	List<Service> toReturn = new ArrayList<Service>();
   
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
    
    
    public static List<Artifact> getArtifacts(Object artifacts){
        List<Artifact> toReturn = new ArrayList<Artifact>();
        
        
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
        
        
    public static List<ArtifactRequirement> getRequirements(Object reqs){
    	List<ArtifactRequirement> toReturn = new ArrayList<ArtifactRequirement>();
    	
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
    
    
    public static List<Policy> getPolicies(Object policies){
    	List<Policy> toReturn = new ArrayList<Policy>();
    
       
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
    
    public static List<PolicyConstraint> getConstraints(Object polConsts){
    	List<PolicyConstraint> toReturn = new ArrayList<PolicyConstraint>();
        
        
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
