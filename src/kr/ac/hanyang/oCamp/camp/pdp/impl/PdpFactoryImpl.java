/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.*;

import org.apache.brooklyn.util.guava.Maybe;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN: return createAbstractOCampPlan();
			case PdpPackage.ACTION: return createAction();
			case PdpPackage.ACTION_GROUP: return createActionGroup();
			case PdpPackage.ARTIFACT: return createArtifact();
			case PdpPackage.ARTIFACT_CONTENT: return createArtifactContent();
			case PdpPackage.ARTIFACT_REQUIREMENT: return createArtifactRequirement();
			case PdpPackage.DEPLOYMENT_PLAN: return createDeploymentPlan();
			case PdpPackage.POLICY: return createPolicy();
			case PdpPackage.POLICY_CONSTRAINT: return createPolicyConstraint();
			case PdpPackage.POLICY_MANAGER_PLAN: return createPolicyManagerPlan();
			case PdpPackage.SERVICE: return createService();
			case PdpPackage.SERVICE_CHARACTERISTIC: return createServiceCharacteristic();
			case PdpPackage.TRANSITION: return createTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PdpPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			case PdpPackage.MAYBE:
				return createMaybeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PdpPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			case PdpPackage.MAYBE:
				return convertMaybeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractOCampPlan createAbstractOCampPlan() {
		AbstractOCampPlanImpl abstractOCampPlan = new AbstractOCampPlanImpl();
		return abstractOCampPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionGroup createActionGroup() {
		ActionGroupImpl actionGroup = new ActionGroupImpl();
		return actionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Artifact createArtifact() {
		ArtifactImpl artifact = new ArtifactImpl();
		return artifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactContent createArtifactContent() {
		ArtifactContentImpl artifactContent = new ArtifactContentImpl();
		return artifactContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactRequirement createArtifactRequirement() {
		ArtifactRequirementImpl artifactRequirement = new ArtifactRequirementImpl();
		return artifactRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Policy createPolicy() {
		PolicyImpl policy = new PolicyImpl();
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyConstraint createPolicyConstraint() {
		PolicyConstraintImpl policyConstraint = new PolicyConstraintImpl();
		return policyConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyManagerPlan createPolicyManagerPlan() {
		PolicyManagerPlanImpl policyManagerPlan = new PolicyManagerPlanImpl();
		return policyManagerPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceCharacteristic createServiceCharacteristic() {
		ServiceCharacteristicImpl serviceCharacteristic = new ServiceCharacteristicImpl();
		return serviceCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maybe<?> createMaybeFromString(EDataType eDataType, String initialValue) {
		return (Maybe<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMaybeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
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
