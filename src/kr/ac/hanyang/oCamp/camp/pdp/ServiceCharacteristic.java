package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EObject;

/**
 * @model 
 * 
 */
public interface ServiceCharacteristic extends EObject {
//	String name;
//    String description;
//    String characteristicType;
//    
//    Map<String,Object> customAttributes;
//    
//    public static ServiceCharacteristic of(Map<String, Object> req) {
//        Map<String,Object> attrs = MutableMap.copyOf(req);
//        
//        ServiceCharacteristic result = new ServiceCharacteristic();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.characteristicType = (String) Yamls.removeMultinameAttribute(attrs, "characteristicType", "type");
//        
//        // TODO fulfillment
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getDescription <em>Description</em>}' attribute.
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
    public String getCharacteristicType() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCharacteristicType <em>Characteristic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characteristic Type</em>' attribute.
	 * @see #getCharacteristicType()
	 * @generated
	 */
	void setCharacteristicType(String value);

	
    
    @Override
    public String toString() ;

}
