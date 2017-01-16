package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class" 
 */
public interface Service extends EObject {
//	String name;
//    String description;
//    String serviceType;
//    
//    List<ServiceCharacteristic> characteristics;
//    
//    Map<String,Object> customAttributes;
//    
//    @SuppressWarnings("unchecked")
//    public static Service of(Map<String, Object> service) {
//        Map<String,Object> fields = MutableMap.copyOf(service);
//        
//        Service result = new Service();
//        result.name = (String) fields.remove("name");
//        result.description = (String) fields.remove("description");
//        // FIXME _type needed in lots of places
//        result.serviceType = (String) Yamls.removeMultinameAttribute(fields, "service_type", "serviceType", "type");
//        
//        result.characteristics = new ArrayList<ServiceCharacteristic>();
//        Object chars = fields.remove("characteristics");
//        if (chars instanceof Iterable) {
//            for (Object req: (Iterable<Object>)chars) {
//                if (req instanceof Map) {
//                    result.characteristics.add(ServiceCharacteristic.of((Map<String,Object>) req));
//                } else {
//                    throw new IllegalArgumentException("characteristics should be a map, not "+req.getClass());
//                }
//            }
//        } else if (chars!=null) {
//            // TODO "map" short form
//            throw new IllegalArgumentException("services body should be iterable, not "+chars.getClass());
//        }
//        
//        result.customAttributes = fields;
//        
//        return result;
//    }
    
    /**
     * @model 
     */
    public String getName() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getDescription <em>Description</em>}' attribute.
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
    public String getServiceType();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getServiceType <em>Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Type</em>' attribute.
	 * @see #getServiceType()
	 * @generated
	 */
	void setServiceType(String value);

				/**
     * @model 
     */
    public EList<ServiceCharacteristic> getCharacteristics();
    
    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getCustomAttributes <em>Custom Attributes</em>}' attribute.
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
