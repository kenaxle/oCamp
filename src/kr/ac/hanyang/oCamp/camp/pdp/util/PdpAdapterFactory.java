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
			public Adapter caseAbstractOCampPlanModel(AbstractOCampPlanModel object) {
				return createAbstractOCampPlanModelAdapter();
			}
			@Override
			public Adapter caseActionModel(ActionModel object) {
				return createActionModelAdapter();
			}
			@Override
			public Adapter caseActionGroupModel(ActionGroupModel object) {
				return createActionGroupModelAdapter();
			}
			@Override
			public Adapter caseArtifactModel(ArtifactModel object) {
				return createArtifactModelAdapter();
			}
			@Override
			public Adapter caseArtifactContentModel(ArtifactContentModel object) {
				return createArtifactContentModelAdapter();
			}
			@Override
			public Adapter caseArtifactRequirementModel(ArtifactRequirementModel object) {
				return createArtifactRequirementModelAdapter();
			}
			@Override
			public Adapter caseDeploymentPlanModel(DeploymentPlanModel object) {
				return createDeploymentPlanModelAdapter();
			}
			@Override
			public Adapter casePolicyModel(PolicyModel object) {
				return createPolicyModelAdapter();
			}
			@Override
			public Adapter casePolicyConstraintModel(PolicyConstraintModel object) {
				return createPolicyConstraintModelAdapter();
			}
			@Override
			public Adapter casePolicyManagerPlanModel(PolicyManagerPlanModel object) {
				return createPolicyManagerPlanModelAdapter();
			}
			@Override
			public Adapter caseServiceModel(ServiceModel object) {
				return createServiceModelAdapter();
			}
			@Override
			public Adapter caseServiceCharacteristicModel(ServiceCharacteristicModel object) {
				return createServiceCharacteristicModelAdapter();
			}
			@Override
			public Adapter caseTransitionModel(TransitionModel object) {
				return createTransitionModelAdapter();
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
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel <em>Abstract OCamp Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel
	 * @generated
	 */
	public Adapter createAbstractOCampPlanModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel <em>Action Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel
	 * @generated
	 */
	public Adapter createActionModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel <em>Action Group Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel
	 * @generated
	 */
	public Adapter createActionGroupModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel <em>Artifact Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel
	 * @generated
	 */
	public Adapter createArtifactModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel <em>Artifact Content Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel
	 * @generated
	 */
	public Adapter createArtifactContentModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel <em>Artifact Requirement Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel
	 * @generated
	 */
	public Adapter createArtifactRequirementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel <em>Deployment Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel
	 * @generated
	 */
	public Adapter createDeploymentPlanModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel <em>Policy Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel
	 * @generated
	 */
	public Adapter createPolicyModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel <em>Policy Constraint Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel
	 * @generated
	 */
	public Adapter createPolicyConstraintModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel <em>Policy Manager Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel
	 * @generated
	 */
	public Adapter createPolicyManagerPlanModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel
	 * @generated
	 */
	public Adapter createServiceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel <em>Service Characteristic Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel
	 * @generated
	 */
	public Adapter createServiceCharacteristicModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel <em>Transition Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel
	 * @generated
	 */
	public Adapter createTransitionModelAdapter() {
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
