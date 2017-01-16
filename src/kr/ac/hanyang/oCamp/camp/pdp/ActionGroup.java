package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;
/**
 * @model kind="class"
 */
public interface ActionGroup extends EObject {
	
//	String name;
//	String description;
//	String actionGroupType;
//	String actionId;
//	List<Action> actions;
//	Map<String,Object> customAttributes;
//		   
//	   
//    @SuppressWarnings("unchecked")
//    public static ActionGroup of(Map<String,Object> root) {
//        Map<String,Object> attrs = MutableMap.copyOf(root);
//        
//        ActionGroup result = new ActionGroup();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.actionGroupType = oCampReserved.POLICY_PREFIX+"ActionGroup";
//        result.actionId = (String) Yamls.removeMultinameAttribute(attrs, "actiong_id", "actionId", "id");
//        // TODO version
//        
//        result.actions = new ArrayList<Action>();
//        Object actions = attrs.remove("actions");
//        if (actions instanceof Iterable) {
//            for (Object action: (Iterable<Object>)actions) {
//                if (action instanceof Map) {
//                    result.actions.add(Action.of((Map<String,Object>) action));
//                } else {
//                    throw new UserFacingException("Actions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(action));
//                }
//            }
//        } else if (actions!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("Actions block should be a list, not "+JavaClassNames.superSimpleClassName(actions));
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getName <em>Name</em>}' attribute.
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
    public String getDescription() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getDescription <em>Description</em>}' attribute.
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
    public String getActionId();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

				/**
     * @model 
     */
    public String getActionGroupType() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionGroupType <em>Action Group Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Group Type</em>' attribute.
	 * @see #getActionGroupType()
	 * @generated
	 */
	void setActionGroupType(String value);

				/**
     * @model 
     */
    public EList<Action> getActions() ;

    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getCustomAttributes <em>Custom Attributes</em>}' attribute.
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
    public <T> Maybe<T> getCustomAttribute(String attributeName, Class<T> type, boolean throwIfTypeMismatch);
    
    @Override
    public String toString() ;

 
}
