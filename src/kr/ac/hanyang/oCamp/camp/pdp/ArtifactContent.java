package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.eclipse.emf.ecore.EObject;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class"
 */
public interface ArtifactContent extends EObject {
//	String href;
//    Map<String,Object> customAttributes;
//    
//    public static ArtifactContent of(Object spec) {
//        if (spec==null) return null;
//        
//        ArtifactContent result = new ArtifactContent();
//        if (spec instanceof String) {
//            result.href = (String)spec;
//        } else if (spec instanceof Map) {
//            @SuppressWarnings("unchecked")
//            Map<String,Object> attrs = MutableMap.copyOf( (Map<String,Object>) spec );
//            result.href = (String) attrs.remove("href");
//            result.customAttributes = attrs;            
//        } else {
//            throw new IllegalArgumentException("artifact content should be map or string, not "+spec.getClass());
//        }
//        
//        return result;
//    }

    /**
     * @model
     */
    public String getHref();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(String value);

				/**
     * @model
     */
    public Map<String, Object> getCustomAttributes();

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getCustomAttributes <em>Custom Attributes</em>}' attribute.
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
