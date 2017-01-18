package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
/**
 * @model 
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

    
    @Override
    public String toString() ;

 
}
