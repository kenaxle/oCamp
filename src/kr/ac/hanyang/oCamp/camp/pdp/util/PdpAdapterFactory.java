/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.util;

import java.util.Map;
import kr.ac.hanyang.oCamp.camp.pdp.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage
 * @generated
 */
public class PdpAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PdpPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PdpPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PdpSwitch<Adapter> modelSwitch =
		new PdpSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractOCampPlan(AbstractOCampPlan object) {
				return createAbstractOCampPlanAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseActionGroup(ActionGroup object) {
				return createActionGroupAdapter();
			}
			@Override
			public Adapter caseArtifact(Artifact object) {
				return createArtifactAdapter();
			}
			@Override
			public Adapter caseArtifactContent(ArtifactContent object) {
				return createArtifactContentAdapter();
			}
			@Override
			public Adapter caseArtifactRequirement(ArtifactRequirement object) {
				return createArtifactRequirementAdapter();
			}
			@Override
			public Adapter caseDeploymentPlan(DeploymentPlan object) {
				return createDeploymentPlanAdapter();
			}
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter casePolicyConstraint(PolicyConstraint object) {
				return createPolicyConstraintAdapter();
			}
			@Override
			public Adapter casePolicyManagerPlan(PolicyManagerPlan object) {
				return createPolicyManagerPlanAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseServiceCharacteristic(ServiceCharacteristic object) {
				return createServiceCharacteristicAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseStringToEObjectMap(Map.Entry<String, Object> object) {
				return createStringToEObjectMapAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan <em>Abstract OCamp Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan
	 * @generated
	 */
	public Adapter createAbstractOCampPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup <em>Action Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup
	 * @generated
	 */
	public Adapter createActionGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact
	 * @generated
	 */
	public Adapter createArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent <em>Artifact Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent
	 * @generated
	 */
	public Adapter createArtifactContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement <em>Artifact Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement
	 * @generated
	 */
	public Adapter createArtifactRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan
	 * @generated
	 */
	public Adapter createDeploymentPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint <em>Policy Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint
	 * @generated
	 */
	public Adapter createPolicyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan <em>Policy Manager Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan
	 * @generated
	 */
	public Adapter createPolicyManagerPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic <em>Service Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic
	 * @generated
	 */
	public Adapter createServiceCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To EObject Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToEObjectMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PdpAdapterFactory
