package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.eclipse.emf.ecore.EObject;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class" 
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
     * @model 
     */
    public Map<String, Object> getCustomAttributes();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCustomAttributes <em>Custom Attributes</em>}' attribute.
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
