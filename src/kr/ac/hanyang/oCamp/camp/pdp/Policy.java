package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

// This class actually represents the policy manager that is responsible for 
// processing the policy in case of a violation. The type of the policy object
// refers to the type of the policy manager entity. 
/**
 * @model 
 */
public interface Policy extends EObject{

//    String name;
//    String description;
//    String policyType;
//    
//    List<PolicyConstraint> policyConstraints;
//    List<String> targets;
//    
//    Map<String,Object> customAttributes;
//    
//    @SuppressWarnings("unchecked")
//    public static Policy of(Map<String, Object> policy) {
//        Map<String,Object> fields = MutableMap.copyOf(policy);
//        
//        Policy result = new Policy();
//        result.name = (String) fields.remove("name");
//        result.description = (String) fields.remove("description");
//        // FIXME _type needed in lots of places
//        result.policyType = (String) Yamls.removeMultinameAttribute(fields, "policy_type", "policyType", "type");
//        
//        result.policyConstraints = new ArrayList<PolicyConstraint>();
//        
//        Object constraints = fields.remove("constraints");
//        if (constraints instanceof Iterable) {
//            for (Object constr: (Iterable<Object>)constraints) {
//                if (constr instanceof Map) {
//                    result.policyConstraints.add(PolicyConstraint.of((Map<String,Object>) constr));
//                } else {
//                    throw new IllegalArgumentException("characteristics should be a map, not "+constr.getClass());
//                }
//            }
//        } else if (constraints!=null) {
//            // TODO "map" short form
//            throw new IllegalArgumentException("services body should be iterable, not "+constraints.getClass());
//        }
//        
//        result.targets = new ArrayList<String>();
//        
//        Object targets = fields.remove("targets");
//        if (targets instanceof Iterable) {
//            for (Object target: (Iterable<Object>)targets) {
//                if (target instanceof String) {
//                    result.targets.add((String)target);
//                } else {
//                    throw new IllegalArgumentException("targets should be a String, not "+target.getClass());
//                }
//            }
//        } else if (targets!=null) {
//            // TODO "map" short form
//            throw new IllegalArgumentException("targets body should be iterable, not "+targets.getClass());
//        }
//        result.customAttributes = fields;
//        
//        return result;
//    }
    
    /**
     * @model 
     */
    public String getName();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getDescription <em>Description</em>}' attribute.
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
    public String getPolicyType() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getPolicyType <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Type</em>' attribute.
	 * @see #getPolicyType()
	 * @generated
	 */
	void setPolicyType(String value);

				/**
     * @model 
     */
    public EList<PolicyConstraint> getPolicyConstraints() ;
    
    /**
     * @model 
     */
    public EList<String> getTargets() ;
    
   
    
    @Override
    public String toString() ;
    	
}

