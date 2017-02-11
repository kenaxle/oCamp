/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage
 * @generated
 */
public interface PdpFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PdpFactory eINSTANCE = kr.ac.hanyang.oCamp.camp.pdp.impl.PdpFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Model</em>'.
	 * @generated
	 */
	ActionModel createActionModel();

	/**
	 * Returns a new object of class '<em>Action Group Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Group Model</em>'.
	 * @generated
	 */
	ActionGroupModel createActionGroupModel();

	/**
	 * Returns a new object of class '<em>Artifact Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Artifact Model</em>'.
	 * @generated
	 */
	ArtifactModel createArtifactModel();

	/**
	 * Returns a new object of class '<em>Artifact Content Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Artifact Content Model</em>'.
	 * @generated
	 */
	ArtifactContentModel createArtifactContentModel();

	/**
	 * Returns a new object of class '<em>Artifact Requirement Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Artifact Requirement Model</em>'.
	 * @generated
	 */
	ArtifactRequirementModel createArtifactRequirementModel();

	/**
	 * Returns a new object of class '<em>Deployment Plan Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Plan Model</em>'.
	 * @generated
	 */
	DeploymentPlanModel createDeploymentPlanModel();

	/**
	 * Returns a new object of class '<em>Policy Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Policy Model</em>'.
	 * @generated
	 */
	PolicyModel createPolicyModel();

	/**
	 * Returns a new object of class '<em>Policy Constraint Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Policy Constraint Model</em>'.
	 * @generated
	 */
	PolicyConstraintModel createPolicyConstraintModel();

	/**
	 * Returns a new object of class '<em>Policy Manager Plan Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Policy Manager Plan Model</em>'.
	 * @generated
	 */
	PolicyManagerPlanModel createPolicyManagerPlanModel();

	/**
	 * Returns a new object of class '<em>Service Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Model</em>'.
	 * @generated
	 */
	ServiceModel createServiceModel();

	/**
	 * Returns a new object of class '<em>Service Characteristic Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Characteristic Model</em>'.
	 * @generated
	 */
	ServiceCharacteristicModel createServiceCharacteristicModel();

	/**
	 * Returns a new object of class '<em>Transition Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Model</em>'.
	 * @generated
	 */
	TransitionModel createTransitionModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PdpPackage getPdpPackage();

} //PdpFactory
