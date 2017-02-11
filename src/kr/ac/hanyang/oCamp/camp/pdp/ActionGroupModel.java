/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Group Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionId <em>Action Id</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionGroupType <em>Action Group Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActions <em>Actions</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel()
 * @model
 * @generated
 */
public interface ActionGroupModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Id</em>' attribute.
	 * @see #setActionId(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_ActionId()
	 * @model
	 * @generated
	 */
	String getActionId();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

	/**
	 * Returns the value of the '<em><b>Action Group Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Group Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Group Type</em>' attribute.
	 * @see #setActionGroupType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_ActionGroupType()
	 * @model
	 * @generated
	 */
	String getActionGroupType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionGroupType <em>Action Group Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Group Type</em>' attribute.
	 * @see #getActionGroupType()
	 * @generated
	 */
	void setActionGroupType(String value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActionModel> getActions();

	/**
	 * Returns the value of the '<em><b>Custom Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Attributes</em>' map.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getActionGroupModel_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

} // ActionGroupModel
