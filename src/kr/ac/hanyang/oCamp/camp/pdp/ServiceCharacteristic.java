package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EMap;
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

	
    
    /**
	 * Returns the value of the '<em><b>Custom Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Attributes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Attributes</em>' map.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristic_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

				@Override
    public String toString() ;

}
