package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model 
 */
public interface DeploymentPlan extends EObject {
//	
//	String name;
//	String origin;
//	String description;
//	String sourceCode;
//	String type;
//	List<Artifact> artifacts;
//	List<Service> services;
//	List<Policy> policies;
//	List<ActionGroup> actionGroups;
//	Map<String,Object> customAttributes;
//		   
//	   
//    @SuppressWarnings("unchecked")
//    public static DeploymentPlan of(Map<String,Object> root, String optionalSourceCode) {
//        Map<String,Object> attrs = MutableMap.copyOf(root);
//        
//        DeploymentPlan result = new DeploymentPlan();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.origin = (String) attrs.remove("origin");
//        result. type = (String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type");
//        result.sourceCode = optionalSourceCode;
//        // TODO version
//        
//        result.services = new ArrayList<Service>();
//        Object services = attrs.remove("services");
//        if (services instanceof Iterable) {
//            for (Object service: (Iterable<Object>)services) {
//                if (service instanceof Map) {
//                    result.services.add(Service.of((Map<String,Object>) service));
//                } else {
//                    throw new UserFacingException("Services list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(service));
//                }
//            }
//        } else if (services!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("Services block should be a list, not "+JavaClassNames.superSimpleClassName(services));
//        }
//        
//        result.artifacts = new ArrayList<Artifact>();
//        Object artifacts = attrs.remove("artifacts");
//        if (artifacts instanceof Iterable) {
//            for (Object artifact: (Iterable<Object>)artifacts) {
//                if (artifact instanceof Map) {
//                    result.artifacts.add(Artifact.of((Map<String,Object>) artifact));
//                } else {
//                    throw new UserFacingException("Artifacts list should contain map items, not "+JavaClassNames.superSimpleClassName(artifact));
//                }
//            }
//        } else if (artifacts!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("Artifacts block should contain a list, not "+JavaClassNames.superSimpleClassName(artifacts));
//        }
//        
//        result.policies = new ArrayList<Policy>();
//        Object policies = attrs.remove("policies");
//        if (policies instanceof Iterable) {
//            for (Object policy: (Iterable<Object>)policies) {
//                if (policy instanceof Map) {
//                    result.policies.add(Policy.of((Map<String,Object>) policy));
//                } else {
//                    throw new UserFacingException("Policies list should contain map items, not "+JavaClassNames.superSimpleClassName(policy));
//                }
//            }
//        } else if (policies!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("Policies block should contain a list, not "+JavaClassNames.superSimpleClassName(policies));
//        }
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

    /**
     * @model 
     */
    public String getName();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

				/**
     * @model 
     */
    public String getDescription();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

				/**
     * @model 
     */
    public String getOrigin();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

				/**
     * @model 
     */
    public String getSourceCode();
   
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

				/**
     * @model 
     */
    public String getType();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

				/**
     * @model 
     */
    public EList<Artifact> getArtifacts();

    /**
     * @model 
     */
    public EList<Service> getServices() ;
    
    /**
     * @model 
     */
    public EList<Policy> getPolicies() ;
    
    /**
     * @model 
     */
    public EList<ActionGroup> getActionGroups() ;

    
    @Override
    public String toString() ;
 
}
