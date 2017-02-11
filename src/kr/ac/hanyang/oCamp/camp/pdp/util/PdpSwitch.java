/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.util;

import java.util.Map;
import kr.ac.hanyang.oCamp.camp.pdp.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage
 * @generated
 */
public class PdpSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PdpPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpSwitch() {
		if (modelPackage == null) {
			modelPackage = PdpPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL: {
				AbstractOCampPlanModel abstractOCampPlanModel = (AbstractOCampPlanModel)theEObject;
				T result = caseAbstractOCampPlanModel(abstractOCampPlanModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.ACTION_MODEL: {
				ActionModel actionModel = (ActionModel)theEObject;
				T result = caseActionModel(actionModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.ACTION_GROUP_MODEL: {
				ActionGroupModel actionGroupModel = (ActionGroupModel)theEObject;
				T result = caseActionGroupModel(actionGroupModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.ARTIFACT_MODEL: {
				ArtifactModel artifactModel = (ArtifactModel)theEObject;
				T result = caseArtifactModel(artifactModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.ARTIFACT_CONTENT_MODEL: {
				ArtifactContentModel artifactContentModel = (ArtifactContentModel)theEObject;
				T result = caseArtifactContentModel(artifactContentModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.ARTIFACT_REQUIREMENT_MODEL: {
				ArtifactRequirementModel artifactRequirementModel = (ArtifactRequirementModel)theEObject;
				T result = caseArtifactRequirementModel(artifactRequirementModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.DEPLOYMENT_PLAN_MODEL: {
				DeploymentPlanModel deploymentPlanModel = (DeploymentPlanModel)theEObject;
				T result = caseDeploymentPlanModel(deploymentPlanModel);
				if (result == null) result = caseAbstractOCampPlanModel(deploymentPlanModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.POLICY_MODEL: {
				PolicyModel policyModel = (PolicyModel)theEObject;
				T result = casePolicyModel(policyModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.POLICY_CONSTRAINT_MODEL: {
				PolicyConstraintModel policyConstraintModel = (PolicyConstraintModel)theEObject;
				T result = casePolicyConstraintModel(policyConstraintModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.POLICY_MANAGER_PLAN_MODEL: {
				PolicyManagerPlanModel policyManagerPlanModel = (PolicyManagerPlanModel)theEObject;
				T result = casePolicyManagerPlanModel(policyManagerPlanModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.SERVICE_MODEL: {
				ServiceModel serviceModel = (ServiceModel)theEObject;
				T result = caseServiceModel(serviceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.SERVICE_CHARACTERISTIC_MODEL: {
				ServiceCharacteristicModel serviceCharacteristicModel = (ServiceCharacteristicModel)theEObject;
				T result = caseServiceCharacteristicModel(serviceCharacteristicModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.TRANSITION_MODEL: {
				TransitionModel transitionModel = (TransitionModel)theEObject;
				T result = caseTransitionModel(transitionModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PdpPackage.STRING_TO_EOBJECT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Object> stringToEObjectMap = (Map.Entry<String, Object>)theEObject;
				T result = caseStringToEObjectMap(stringToEObjectMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract OCamp Plan Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract OCamp Plan Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractOCampPlanModel(AbstractOCampPlanModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionModel(ActionModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Group Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Group Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionGroupModel(ActionGroupModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArtifactModel(ArtifactModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Content Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Content Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArtifactContentModel(ArtifactContentModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Requirement Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Requirement Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArtifactRequirementModel(ArtifactRequirementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Plan Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Plan Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentPlanModel(DeploymentPlanModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolicyModel(PolicyModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy Constraint Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy Constraint Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolicyConstraintModel(PolicyConstraintModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy Manager Plan Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy Manager Plan Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolicyManagerPlanModel(PolicyManagerPlanModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceModel(ServiceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Characteristic Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Characteristic Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceCharacteristicModel(ServiceCharacteristicModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionModel(TransitionModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To EObject Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To EObject Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToEObjectMap(Map.Entry<String, Object> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PdpSwitch
