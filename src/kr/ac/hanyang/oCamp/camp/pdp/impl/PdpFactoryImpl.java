/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PdpFactoryImpl extends EFactoryImpl implements PdpFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PdpFactory init() {
		try {
			PdpFactory thePdpFactory = (PdpFactory)EPackage.Registry.INSTANCE.getEFactory(PdpPackage.eNS_URI);
			if (thePdpFactory != null) {
				return thePdpFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PdpFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PdpPackage.ACTION_MODEL: return createActionModel();
			case PdpPackage.ACTION_GROUP_MODEL: return createActionGroupModel();
			case PdpPackage.ARTIFACT_MODEL: return createArtifactModel();
			case PdpPackage.ARTIFACT_CONTENT_MODEL: return createArtifactContentModel();
			case PdpPackage.ARTIFACT_REQUIREMENT_MODEL: return createArtifactRequirementModel();
			case PdpPackage.DEPLOYMENT_PLAN_MODEL: return createDeploymentPlanModel();
			case PdpPackage.POLICY_MODEL: return createPolicyModel();
			case PdpPackage.POLICY_CONSTRAINT_MODEL: return createPolicyConstraintModel();
			case PdpPackage.POLICY_MANAGER_PLAN_MODEL: return createPolicyManagerPlanModel();
			case PdpPackage.SERVICE_MODEL: return createServiceModel();
			case PdpPackage.SERVICE_CHARACTERISTIC_MODEL: return createServiceCharacteristicModel();
			case PdpPackage.TRANSITION_MODEL: return createTransitionModel();
			case PdpPackage.STRING_TO_EOBJECT_MAP: return (EObject)createStringToEObjectMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionModel createActionModel() {
		ActionModelImpl actionModel = new ActionModelImpl();
		return actionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionGroupModel createActionGroupModel() {
		ActionGroupModelImpl actionGroupModel = new ActionGroupModelImpl();
		return actionGroupModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactModel createArtifactModel() {
		ArtifactModelImpl artifactModel = new ArtifactModelImpl();
		return artifactModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactContentModel createArtifactContentModel() {
		ArtifactContentModelImpl artifactContentModel = new ArtifactContentModelImpl();
		return artifactContentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactRequirementModel createArtifactRequirementModel() {
		ArtifactRequirementModelImpl artifactRequirementModel = new ArtifactRequirementModelImpl();
		return artifactRequirementModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlanModel createDeploymentPlanModel() {
		DeploymentPlanModelImpl deploymentPlanModel = new DeploymentPlanModelImpl();
		return deploymentPlanModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyModel createPolicyModel() {
		PolicyModelImpl policyModel = new PolicyModelImpl();
		return policyModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyConstraintModel createPolicyConstraintModel() {
		PolicyConstraintModelImpl policyConstraintModel = new PolicyConstraintModelImpl();
		return policyConstraintModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyManagerPlanModel createPolicyManagerPlanModel() {
		PolicyManagerPlanModelImpl policyManagerPlanModel = new PolicyManagerPlanModelImpl();
		return policyManagerPlanModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceModel createServiceModel() {
		ServiceModelImpl serviceModel = new ServiceModelImpl();
		return serviceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceCharacteristicModel createServiceCharacteristicModel() {
		ServiceCharacteristicModelImpl serviceCharacteristicModel = new ServiceCharacteristicModelImpl();
		return serviceCharacteristicModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionModel createTransitionModel() {
		TransitionModelImpl transitionModel = new TransitionModelImpl();
		return transitionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createStringToEObjectMap() {
		StringToEObjectMapImpl stringToEObjectMap = new StringToEObjectMapImpl();
		return stringToEObjectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpPackage getPdpPackage() {
		return (PdpPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PdpPackage getPackage() {
		return PdpPackage.eINSTANCE;
	}

} //PdpFactoryImpl
