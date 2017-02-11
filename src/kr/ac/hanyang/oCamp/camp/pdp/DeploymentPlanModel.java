/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Plan Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getType <em>Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getActionGroups <em>Action Groups</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getDeploymentPlanModel()
 * @model
 * @generated
 */
public interface DeploymentPlanModel extends AbstractOCampPlanModel {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getDeploymentPlanModel_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getDeploymentPlanModel_ActionGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActionGroupModel> getActionGroups();

} // DeploymentPlanModel
