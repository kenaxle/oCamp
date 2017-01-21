/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.*;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan;
import kr.ac.hanyang.oCamp.camp.pdp.Service;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic;
import kr.ac.hanyang.oCamp.camp.pdp.Transition;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.brooklyn.util.yaml.Yamls;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PdpFactoryImpl extends EFactoryImpl implements PdpFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PdpFactory init() {
		try {
			PdpFactory thePdpFactory = (PdpFactory)EPackage.Registry.INSTANCE.getEFactory(PdpPackage.eNS_URI);
			if (thePdpFactory != null) {
				return thePdpFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PdpFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PdpPackage.ABSTRACT_OCAMP_PLAN: return createAbstractOCampPlan();
			case PdpPackage.ACTION: return createAction();
			case PdpPackage.ACTION_GROUP: return createActionGroup();
			case PdpPackage.ARTIFACT: return createArtifact();
			case PdpPackage.ARTIFACT_CONTENT: return createArtifactContent();
			case PdpPackage.ARTIFACT_REQUIREMENT: return createArtifactRequirement();
			case PdpPackage.DEPLOYMENT_PLAN: return createDeploymentPlan();
			case PdpPackage.POLICY: return createPolicy();
			case PdpPackage.POLICY_CONSTRAINT: return createPolicyConstraint();
			case PdpPackage.POLICY_MANAGER_PLAN: return createPolicyManagerPlan();
			case PdpPackage.SERVICE: return createService();
			case PdpPackage.SERVICE_CHARACTERISTIC: return createServiceCharacteristic();
			case PdpPackage.TRANSITION: return createTransition();
			case PdpPackage.STRING_TO_EOBJECT_MAP: return (EObject)createStringToEObjectMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PdpPackage.MAYBE:
				return createMaybeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PdpPackage.MAYBE:
				return convertMaybeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractOCampPlan createAbstractOCampPlan() {
		AbstractOCampPlanImpl abstractOCampPlan = new AbstractOCampPlanImpl();
		return abstractOCampPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public Action createAction(Map<String,Object> root){
	
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        ActionImpl result = new ActionImpl();
        result.eSet(PdpPackage.ACTION__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.ACTION__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.ACTION__ACTION_TYPE, oCampReserved.POLICY_PREFIX+"Action");
        result.eSet(PdpPackage.ACTION__PROPERTY, (String) attrs.remove("property"));
        
        // TODO version
        
        List<Transition> temp = new ArrayList<Transition>();
        Object transitions = attrs.remove("transitions");
        if (transitions instanceof Iterable) {
            for (Object transition: (Iterable<Object>)transitions) {
                if (transition instanceof Map) {
                	temp.add(createTransition((Map<String,Object>) transition));
                } else {
                    throw new UserFacingException("Transitions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(transition));
                }
            }
        } else if (transitions!=null) {
            // TODO "map" short form
            throw new UserFacingException("Transitions block should be a list, not "+JavaClassNames.superSimpleClassName(transitions));
        }
        result.eSet(PdpPackage.ACTION__TRANSITIONS, temp);
        //result.eSet(PdpPackage.ACTION__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
   
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionGroup createActionGroup() {
		ActionGroupImpl actionGroup = new ActionGroupImpl();
		return actionGroup;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	
	public ActionGroup createActionGroup(Map<String,Object> root){
		Map<String,Object> attrs = MutableMap.copyOf(root);
		
        ActionGroupImpl result = new ActionGroupImpl();
        result.eSet(PdpPackage.ACTION_GROUP__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.ACTION_GROUP__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE, oCampReserved.POLICY_PREFIX+"ActionGroup");
        result.eSet(PdpPackage.ACTION_GROUP__ACTION_ID, (String) Yamls.removeMultinameAttribute(attrs, "actiong_id", "actionId", "id"));
        // TODO version
        
        List<Action> temp = new ArrayList<Action>();
        Object actions = attrs.remove("actions");
        if (actions instanceof Iterable) {
            for (Object action: (Iterable<Object>)actions) {
                if (action instanceof Map) {
                    temp.add(createAction((Map<String,Object>) action));
                } else {
                    throw new UserFacingException("Actions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(action));
                }
            }
        } else if (actions!=null) {
            // TODO "map" short form
            throw new UserFacingException("Actions block should be a list, not "+JavaClassNames.superSimpleClassName(actions));
        }
        
        result.eSet(PdpPackage.ACTION_GROUP__ACTIONS, temp);
       // result.eSet(PdpPackage.ACTION__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Artifact createArtifact() {
		ArtifactImpl artifact = new ArtifactImpl();
		return artifact;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public Artifact createArtifact(Map<String, Object> artifact) {
        Map<String,Object> fields = MutableMap.copyOf(artifact);
        
        ArtifactImpl result = new ArtifactImpl();
        result.eSet(PdpPackage.ARTIFACT__NAME, (String) fields.remove("name"));
        result.eSet(PdpPackage.ARTIFACT__DESCRIPTION, (String) fields.remove("description"));
        result.eSet(PdpPackage.ARTIFACT__ARTIFACT_TYPE, (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type"));
        result.eSet(PdpPackage.ACTION_GROUP__ACTION_ID, (String) Yamls.removeMultinameAttribute(fields, "actiong_id", "actionId", "id"));
        result.eSet(PdpPackage.ARTIFACT__CONTENT, createArtifactContent( fields.remove("content")));

        
        List<ArtifactRequirement> temp = new ArrayList<ArtifactRequirement>();
        Object reqs = fields.remove("requirements");
        if (reqs instanceof Iterable) {
            for (Object req: (Iterable<Object>)reqs) {
                if (req instanceof Map) {
                    temp.add(createArtifactRequirement((Map<String,Object>) req));
                } else {
                    throw new IllegalArgumentException("requirement should be a map, not "+req.getClass());
                }
            }
        } else if (reqs!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("artifacts body should be iterable, not "+reqs.getClass());
        }
        
        result.eSet(PdpPackage.ARTIFACT__REQUIREMENTS, temp);
        //result.eSet(PdpPackage.ARTIFACT__CUSTOM_ATTRIBUTES, fields);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactContent createArtifactContent() {
		ArtifactContentImpl artifactContent = new ArtifactContentImpl();
		return artifactContent;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public ArtifactContent createArtifactContent(Object spec) {
        if (spec==null) return null;
        
        ArtifactContentImpl result = new ArtifactContentImpl();
        if (spec instanceof String) {
            result.eSet(PdpPackage.ARTIFACT_CONTENT__HREF, (String)spec);
        } else if (spec instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String,Object> attrs = MutableMap.copyOf( (Map<String,Object>) spec );
            result.eSet(PdpPackage.ARTIFACT_CONTENT__HREF, (String) attrs.remove("href"));
            //result.eSet(PdpPackage.ARTIFACT_CONTENT__CUSTOM_ATTRIBUTES, attrs);            
        } else {
            throw new IllegalArgumentException("artifact content should be map or string, not "+spec.getClass());
        }
        
        return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactRequirement createArtifactRequirement() {
		ArtifactRequirementImpl artifactRequirement = new ArtifactRequirementImpl();
		return artifactRequirement;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public ArtifactRequirement createArtifactRequirement(Map<String, Object> req) {
        Map<String,Object> attrs = MutableMap.copyOf(req);
        
        ArtifactRequirementImpl result = new ArtifactRequirementImpl();
        result.eSet(PdpPackage.ARTIFACT_REQUIREMENT__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.ARTIFACT_REQUIREMENT__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.ARTIFACT_REQUIREMENT__REQUIREMENT_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "requirementType", "type"));
        
        // TODO fulfillment
        //result.eSet(PdpPackage.ARTIFACT_REQUIREMENT__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public DeploymentPlan createDeploymentPlan(Map<String,Object> root, String optionalSourceCode) {
		Map<String,Object> attrs = MutableMap.copyOf(root);
        
        DeploymentPlanImpl result = new DeploymentPlanImpl();
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__ORIGIN, (String) attrs.remove("origin"));
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__TYPE, (String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type"));
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__SOURCE_CODE, optionalSourceCode);
        // TODO version
        
        List<Service> dpServices = new ArrayList<Service>();
        Object services = attrs.remove("services");
        if (services instanceof Iterable) {
            for (Object service: (Iterable<Object>)services) {
                if (service instanceof Map) {
                	dpServices.add(createService((Map<String,Object>) service));
                } else {
                    throw new UserFacingException("Services list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(service));
                }
            }
        } else if (services!=null) {
            // TODO "map" short form
            throw new UserFacingException("Services block should be a list, not "+JavaClassNames.superSimpleClassName(services));
        }
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__SERVICES, dpServices);
        
        List<Artifact> dpArtifacts = new ArrayList<Artifact>();
        Object artifacts = attrs.remove("artifacts");
        if (artifacts instanceof Iterable) {
            for (Object artifact: (Iterable<Object>)artifacts) {
                if (artifact instanceof Map) {
                    dpArtifacts.add(createArtifact((Map<String,Object>) artifact));
                } else {
                    throw new UserFacingException("Artifacts list should contain map items, not "+JavaClassNames.superSimpleClassName(artifact));
                }
            }
        } else if (artifacts!=null) {
            // TODO "map" short form
            throw new UserFacingException("Artifacts block should contain a list, not "+JavaClassNames.superSimpleClassName(artifacts));
        }
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__ARTIFACTS, dpArtifacts);
        
        List<Policy> dpPolicies = new ArrayList<Policy>();
        Object policies = attrs.remove("policies");
        if (policies instanceof Iterable) {
            for (Object policy: (Iterable<Object>)policies) {
                if (policy instanceof Map) {
                    dpPolicies.add(createPolicy((Map<String,Object>) policy));
                } else {
                    throw new UserFacingException("Policies list should contain map items, not "+JavaClassNames.superSimpleClassName(policy));
                }
            }
        } else if (policies!=null) {
            // TODO "map" short form
            throw new UserFacingException("Policies block should contain a list, not "+JavaClassNames.superSimpleClassName(policies));
        }
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__POLICIES, dpPolicies);
        
        
        List<ActionGroup> dpActionGroups = new ArrayList<ActionGroup>();
        Object actionGroups = attrs.remove("actiongroups");
        if (actionGroups instanceof Iterable) {
            for (Object actionGroup: (Iterable<Object>)actionGroups) {
                if (actionGroup instanceof Map) {
                	dpActionGroups.add(createActionGroup((Map<String,Object>) actionGroup));
                } else {
                    throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
                }
            }
        } else if (actionGroups!=null) {
            // TODO "map" short form
            throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
        }
        result.eSet(PdpPackage.DEPLOYMENT_PLAN__ACTION_GROUPS, dpActionGroups);
        //result.eSet(PdpPackage.DEPLOYMENT_PLAN__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Policy createPolicy() {
		PolicyImpl policy = new PolicyImpl();
		return policy;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public Policy createPolicy(Map<String, Object> policy) {
        Map<String,Object> attrs = MutableMap.copyOf(policy);
        
        PolicyImpl result = new PolicyImpl();
        
        result.eSet(PdpPackage.POLICY__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.POLICY__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.POLICY__POLICY_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "policy_type", "policyType", "type"));
       
        
        List<PolicyConstraint> polConstr = new ArrayList<PolicyConstraint>();
        
        Object constraints = attrs.remove("constraints");
        if (constraints instanceof Iterable) {
            for (Object constr: (Iterable<Object>)constraints) {
                if (constr instanceof Map) {
                    polConstr.add(createPolicyConstraint((Map<String,Object>) constr));
                } else {
                    throw new IllegalArgumentException("characteristics should be a map, not "+constr.getClass());
                }
            }
        } else if (constraints!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("services body should be iterable, not "+constraints.getClass());
        }
        result.eSet(PdpPackage.POLICY__POLICY_CONSTRAINTS, polConstr);
        
        
        List<String> polTargets = new ArrayList<String>();
        
        Object targets = attrs.remove("targets");
        if (targets instanceof Iterable) {
            for (Object target: (Iterable<Object>)targets) {
                if (target instanceof String) {
                    polTargets.add((String)target);
                } else {
                    throw new IllegalArgumentException("targets should be a String, not "+target.getClass());
                }
            }
        } else if (targets!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("targets body should be iterable, not "+targets.getClass());
        }
        result.eSet(PdpPackage.POLICY__TARGETS, polTargets);
      //  result.eSet(PdpPackage.POLICY__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyConstraint createPolicyConstraint() {
		PolicyConstraintImpl policyConstraint = new PolicyConstraintImpl();
		return policyConstraint;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public PolicyConstraint createPolicyConstraint(Map<String, Object> policyConstraint) {
        Map<String,Object> attrs = MutableMap.copyOf(policyConstraint);
        
        PolicyConstraintImpl result = new PolicyConstraintImpl();
        
        result.eSet(PdpPackage.POLICY_CONSTRAINT__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.POLICY_CONSTRAINT__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "constraint_type", "constraintType", "type"));
        result.eSet(PdpPackage.POLICY_CONSTRAINT__VALUE, attrs.remove("value"));
        //result.eSet(PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyManagerPlan createPolicyManagerPlan() {
		PolicyManagerPlanImpl policyManagerPlan = new PolicyManagerPlanImpl();
		return policyManagerPlan;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public PolicyManagerPlan createPolicyManagerPlan(Map<String,Object> root, String optionalSourceCode) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        PolicyManagerPlanImpl result = new PolicyManagerPlanImpl();
        
        
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__ORIGIN, (String) attrs.remove("origin"));
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE, optionalSourceCode);
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type"));
        // TODO version
        
        List<ActionGroup> temp = new ArrayList<ActionGroup>();
        Object actionGroups = attrs.remove("actiongroups");
        if (actionGroups instanceof Iterable) {
            for (Object actionGroup: (Iterable<Object>)actionGroups) {
                if (actionGroup instanceof Map) {
                    temp.add(createActionGroup((Map<String,Object>) actionGroup));
                } else {
                    throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
                }
            }
        } else if (actionGroups!=null) {
            // TODO "map" short form
            throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
        }
        result.eSet(PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS, temp);
        //result.eSet(PdpPackage.POLICY_MANAGER_PLAN__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public Service createService(Map<String, Object> service) {
        Map<String,Object> attrs = MutableMap.copyOf(service);
        
        ServiceImpl result = new ServiceImpl();
        result.eSet(PdpPackage.SERVICE__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.SERVICE__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.SERVICE__SERVICE_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "service_type", "serviceType", "type"));
        
        List<ServiceCharacteristic> temp = new ArrayList<ServiceCharacteristic>();
        Object chars = attrs.remove("characteristics");
        if (chars instanceof Iterable) {
            for (Object req: (Iterable<Object>)chars) {
                if (req instanceof Map) {
                    temp.add(createServiceCharacteristic((Map<String,Object>) req));
                } else {
                    throw new IllegalArgumentException("characteristics should be a map, not "+req.getClass());
                }
            }
        } else if (chars!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("services body should be iterable, not "+chars.getClass());
        }
        
        result.eSet(PdpPackage.SERVICE__CHARACTERISTICS, temp);
       // result.eSet(PdpPackage.SERVICE__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceCharacteristic createServiceCharacteristic() {
		ServiceCharacteristicImpl serviceCharacteristic = new ServiceCharacteristicImpl();
		return serviceCharacteristic;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public ServiceCharacteristic createServiceCharacteristic(Map<String, Object> req) {
        Map<String,Object> attrs = MutableMap.copyOf(req);
        
        ServiceCharacteristicImpl result = new ServiceCharacteristicImpl();
        result.eSet(PdpPackage.SERVICE_CHARACTERISTIC__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "characteristicType", "type"));
        
        // TODO fulfillment
        //result.eSet(PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createStringToEObjectMap() {
		StringToEObjectMapImpl stringToEObjectMap = new StringToEObjectMapImpl();
		return stringToEObjectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public Transition createTransition(Map<String,Object> root) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        TransitionImpl result = new TransitionImpl();
        result.eSet(PdpPackage.TRANSITION__NAME, (String) attrs.remove("name"));
        result.eSet(PdpPackage.TRANSITION__DESCRIPTION, (String) attrs.remove("description"));
        result.eSet(PdpPackage.TRANSITION__TRANSITION_TYPE, (String) Yamls.removeMultinameAttribute(attrs, "transition_type", "transitionType", "type"));
        
        // TODO version
        result.eSet(PdpPackage.TRANSITION__VALUE, attrs.remove("value"));
        //result.eSet(PdpPackage.TRANSITION__CUSTOM_ATTRIBUTES, attrs);
        
        return result;
    }
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maybe<?> createMaybeFromString(EDataType eDataType, String initialValue) {
		return (Maybe<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMaybeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpPackage getPdpPackage() {
		return (PdpPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PdpPackage getPackage() {
		return PdpPackage.eINSTANCE;
	}

} //PdpFactoryImpl
