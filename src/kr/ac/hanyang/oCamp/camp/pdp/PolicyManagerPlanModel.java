/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Policy Manager Plan Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getOrigin <em>Origin</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getPolicyManagerType <em>Policy Manager Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getActionGroups <em>Action Groups</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel()
 * @model
 * @generated
 */
public interface PolicyManagerPlanModel extends EObject {
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getName <em>Name</em>}' attribute.
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see #setOrigin(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_Origin()
	 * @model
	 * @generated
	 */
	String getOrigin();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

	/**
	 * Returns the value of the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Code</em>' attribute.
	 * @see #setSourceCode(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_SourceCode()
	 * @model
	 * @generated
	 */
	String getSourceCode();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

	/**
	 * Returns the value of the '<em><b>Policy Manager Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Manager Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Manager Type</em>' attribute.
	 * @see #setPolicyManagerType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_PolicyManagerType()
	 * @model
	 * @generated
	 */
	String getPolicyManagerType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getPolicyManagerType <em>Policy Manager Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Manager Type</em>' attribute.
	 * @see #getPolicyManagerType()
	 * @generated
	 */
	void setPolicyManagerType(String value);

	/**
	 * Returns the value of the '<em><b>Action Groups</b></em>' containment reference list.
	 * The list contents are of type {@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Groups</em>' containment reference list.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_ActionGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActionGroupModel> getActionGroups();

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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyManagerPlanModel_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

} // PolicyManagerPlanModel
