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

/**
 * @model kind="class" 
 */
public interface PolicyManagerPlan extends EObject {
	
//	String name;
//	String origin;
//	String description;
//	String sourceCode;
//	String policyManagerType;
//	List<ActionGroup> actionGroups;
//	Map<String,Object> customAttributes;
//		   
//	   
//    @SuppressWarnings("unchecked")
//    public static PolicyManagerPlan of(Map<String,Object> root, String optionalSourceCode) {
//        Map<String,Object> attrs = MutableMap.copyOf(root);
//        
//        PolicyManagerPlan result = new PolicyManagerPlan();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.origin = (String) attrs.remove("origin");
//        result.sourceCode = optionalSourceCode;
//        result.policyManagerType = (String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type");
//        // TODO version
//        
//        result.actionGroups = new ArrayList<ActionGroup>();
//        Object actionGroups = attrs.remove("actiongroups");
//        if (actionGroups instanceof Iterable) {
//            for (Object actionGroup: (Iterable<Object>)actionGroups) {
//                if (actionGroup instanceof Map) {
//                    result.actionGroups.add(ActionGroup.of((Map<String,Object>) actionGroup));
//                } else {
//                    throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
//                }
//            }
//        } else if (actionGroups!=null) {
//            // TODO "map" short form
//            throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
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
    public String getName() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getDescription <em>Description</em>}' attribute.
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
    public String getOrigin() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

				/**
     * @model 
     */
    public String getSourceCode() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

				/**
     * @model 
     */
    public EList<ActionGroup> getActionGroups() ;

    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes() ;

    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getCustomAttributes <em>Custom Attributes</em>}' attribute.
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
