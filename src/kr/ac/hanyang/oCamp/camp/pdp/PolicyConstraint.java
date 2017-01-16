package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import org.eclipse.emf.ecore.EObject;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class"
 */
public interface PolicyConstraint extends EObject{
//	String name;
//    String description;
//    String policyConstraintType;
//    
//    String property;
//    Object value;
//    
//    Map<String,Object> customAttributes;
//    
//    public static PolicyConstraint of(Map<String, Object> policyConstraint) {
//        Map<String,Object> fields = MutableMap.copyOf(policyConstraint);
//        
//        PolicyConstraint result = new PolicyConstraint();
//        result.name = (String) fields.remove("name");
//        result.description = (String) fields.remove("description");
//        // FIXME _type needed in lots of places
//        result.policyConstraintType = (String) Yamls.removeMultinameAttribute(fields, "constraint_type", "constraintType", "type");
//     
//        result.value = fields.remove("value");    
//        
//        result.customAttributes = fields;
//        
//        return result;
//    }
    
    /**
     * @model 
     */
    public String getName();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getDescription <em>Description</em>}' attribute.
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
    public String getPolicyConstraintType() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getPolicyConstraintType <em>Policy Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Constraint Type</em>' attribute.
	 * @see #getPolicyConstraintType()
	 * @generated
	 */
	void setPolicyConstraintType(String value);

				/**
     * @model 
     */
    public Object getValue() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

				/**
     * @model 
     */
    public Map<String, Object> getCustomAttributes() ;
    
 

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getCustomAttributes <em>Custom Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Attributes</em>' attribute.
	 * @see #getCustomAttributes()
	 * @generated
	 */
	void setCustomAttributes(Map<String, Object> value);

	@Override
    public String toString() ;
	
}
