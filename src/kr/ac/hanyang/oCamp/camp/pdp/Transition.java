package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EObject;

/**
 * @model 
 */
public interface Transition extends EObject {
//	
//	String name;
//	String description;
//	String transitionType;
//	Object value;
//	Map<String,Object> customAttributes;
//		   
//	   
//    @SuppressWarnings("unchecked")
//    public static Transition of(Map<String,Object> root) {
//        Map<String,Object> attrs = MutableMap.copyOf(root);
//        
//        Transition result = new Transition();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.transitionType = (String) Yamls.removeMultinameAttribute(attrs, "transition_type", "transitionType", "type");
//        // TODO version
//        
//        result.value = attrs.remove("value");
//        result.customAttributes = attrs;
//        
//        return result;
//    }

    /**
     * @model 
     */
    public String getName();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getDescription <em>Description</em>}' attribute.
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
    public String getTransitionType();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getTransitionType <em>Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Type</em>' attribute.
	 * @see #getTransitionType()
	 * @generated
	 */
	void setTransitionType(String value);

				/**
     * @model 
     */
    public Object getValue();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	
    @Override
    public String toString() ;

 
}
