package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;

/**
 * @model kind="class"
 */
public interface Action extends EObject {
	
//	String name;
//	String description;
//	String actionType;
//	String property;
//	List<Transition> transitions;
//	Map<String,Object> customAttributes;
//		   
//	   
//    @SuppressWarnings("unchecked")
//    public static Action of(Map<String,Object> root) {
//        Map<String,Object> attrs = MutableMap.copyOf(root);
//        
//        Action result = new Action();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.actionType = oCampReserved.POLICY_PREFIX+"Action";
//        result.property = (String) attrs.remove("property");
//        // TODO version
//        
//        result.transitions = new ArrayList<Transition>();
//        Object transitions = attrs.remove("transitions");
//        if (transitions instanceof Iterable) {
//            for (Object transition: (Iterable<Object>)transitions) {
//                if (transition instanceof Map) {
//                    result.transitions.add(Transition.of((Map<String,Object>) transition));
//                } else {
//                    throw new UserFacingException("Transitions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(transition));
//                }
//            }
//        } else if (transitions!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("Transitions block should be a list, not "+JavaClassNames.superSimpleClassName(transitions));
//        }
//        
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getDescription <em>Description</em>}' attribute.
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
    public String getProperty();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

				/**
     * @model 
     */
    public String getActionType() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(String value);

				/**
     * @model 
     */
    public EList<Transition> getTransitions();

    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getCustomAttributes <em>Custom Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Attributes</em>' attribute.
	 * @see #getCustomAttributes()
	 * @generated
	 */
	void setCustomAttributes(Map<String, Object> value);

				/**
     * Returns a present {@link Maybe} of the custom attribute with the given name if the attribute is
     * non-null and is an instance of the given type. Otherwise returns absent.
     * <p/>
     * Does not remove the attribute from the custom attribute map.
     */
    /**
     * @model 
     */
    @SuppressWarnings("unchecked")
    public <T> Maybe<T> getCustomAttribute(String attributeName, Class<T> type, boolean throwIfTypeMismatch) ;

    @Override
    public String toString();

 
}
