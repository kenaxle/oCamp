/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Map;
import kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpFactory;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyModel;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceModel;
import kr.ac.hanyang.oCamp.camp.pdp.TransitionModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PdpPackageImpl extends EPackageImpl implements PdpPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractOCampPlanModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionGroupModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactContentModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactRequirementModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentPlanModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyConstraintModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyManagerPlanModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceCharacteristicModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToEObjectMapEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PdpPackageImpl() {
		super(eNS_URI, PdpFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PdpPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PdpPackage init() {
		if (isInited) return (PdpPackage)EPackage.Registry.INSTANCE.getEPackage(PdpPackage.eNS_URI);

		// Obtain or create and register package
		PdpPackageImpl thePdpPackage = (PdpPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PdpPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PdpPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePdpPackage.createPackageContents();

		// Initialize created meta-data
		thePdpPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePdpPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PdpPackage.eNS_URI, thePdpPackage);
		return thePdpPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractOCampPlanModel() {
		return abstractOCampPlanModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOCampPlanModel_Name() {
		return (EAttribute)abstractOCampPlanModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOCampPlanModel_Description() {
		return (EAttribute)abstractOCampPlanModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOCampPlanModel_Origin() {
		return (EAttribute)abstractOCampPlanModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOCampPlanModel_SourceCode() {
		return (EAttribute)abstractOCampPlanModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOCampPlanModel_Artifacts() {
		return (EReference)abstractOCampPlanModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOCampPlanModel_Services() {
		return (EReference)abstractOCampPlanModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOCampPlanModel_Policies() {
		return (EReference)abstractOCampPlanModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOCampPlanModel_CustomAttributes() {
		return (EReference)abstractOCampPlanModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionModel() {
		return actionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionModel_Name() {
		return (EAttribute)actionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionModel_Description() {
		return (EAttribute)actionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionModel_Property() {
		return (EAttribute)actionModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionModel_ActionType() {
		return (EAttribute)actionModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionModel_Transitions() {
		return (EReference)actionModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionModel_CustomAttributes() {
		return (EReference)actionModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionGroupModel() {
		return actionGroupModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionGroupModel_Name() {
		return (EAttribute)actionGroupModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionGroupModel_Description() {
		return (EAttribute)actionGroupModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionGroupModel_ActionId() {
		return (EAttribute)actionGroupModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionGroupModel_ActionGroupType() {
		return (EAttribute)actionGroupModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionGroupModel_Actions() {
		return (EReference)actionGroupModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionGroupModel_CustomAttributes() {
		return (EReference)actionGroupModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifactModel() {
		return artifactModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactModel_Name() {
		return (EAttribute)artifactModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactModel_Description() {
		return (EAttribute)artifactModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactModel_ArtifactType() {
		return (EAttribute)artifactModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactModel_Content() {
		return (EReference)artifactModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactModel_Requirements() {
		return (EReference)artifactModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactModel_CustomAttributes() {
		return (EReference)artifactModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifactContentModel() {
		return artifactContentModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactContentModel_Href() {
		return (EAttribute)artifactContentModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactContentModel_CustomAttributes() {
		return (EReference)artifactContentModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifactRequirementModel() {
		return artifactRequirementModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactRequirementModel_Name() {
		return (EAttribute)artifactRequirementModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactRequirementModel_Description() {
		return (EAttribute)artifactRequirementModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactRequirementModel_RequirementType() {
		return (EAttribute)artifactRequirementModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactRequirementModel_CustomAttributes() {
		return (EReference)artifactRequirementModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtifactRequirementModel_Fulfillment() {
		return (EAttribute)artifactRequirementModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentPlanModel() {
		return deploymentPlanModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeploymentPlanModel_Type() {
		return (EAttribute)deploymentPlanModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentPlanModel_ActionGroups() {
		return (EReference)deploymentPlanModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicyModel() {
		return policyModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyModel_Name() {
		return (EAttribute)policyModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyModel_Description() {
		return (EAttribute)policyModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyModel_PolicyType() {
		return (EAttribute)policyModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicyModel_PolicyConstraints() {
		return (EReference)policyModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyModel_Targets() {
		return (EAttribute)policyModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicyModel_CustomAttributes() {
		return (EReference)policyModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicyConstraintModel() {
		return policyConstraintModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyConstraintModel_Name() {
		return (EAttribute)policyConstraintModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyConstraintModel_Description() {
		return (EAttribute)policyConstraintModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyConstraintModel_PolicyConstraintType() {
		return (EAttribute)policyConstraintModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyConstraintModel_Value() {
		return (EAttribute)policyConstraintModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicyConstraintModel_CustomAttributes() {
		return (EReference)policyConstraintModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicyManagerPlanModel() {
		return policyManagerPlanModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyManagerPlanModel_Name() {
		return (EAttribute)policyManagerPlanModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyManagerPlanModel_Description() {
		return (EAttribute)policyManagerPlanModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyManagerPlanModel_Origin() {
		return (EAttribute)policyManagerPlanModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyManagerPlanModel_SourceCode() {
		return (EAttribute)policyManagerPlanModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicyManagerPlanModel_PolicyManagerType() {
		return (EAttribute)policyManagerPlanModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicyManagerPlanModel_ActionGroups() {
		return (EReference)policyManagerPlanModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolicyManagerPlanModel_CustomAttributes() {
		return (EReference)policyManagerPlanModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceModel() {
		return serviceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceModel_Name() {
		return (EAttribute)serviceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceModel_Description() {
		return (EAttribute)serviceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceModel_ServiceType() {
		return (EAttribute)serviceModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceModel_Characteristics() {
		return (EReference)serviceModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceModel_CustomAttributes() {
		return (EReference)serviceModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceCharacteristicModel() {
		return serviceCharacteristicModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceCharacteristicModel_Name() {
		return (EAttribute)serviceCharacteristicModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceCharacteristicModel_Description() {
		return (EAttribute)serviceCharacteristicModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceCharacteristicModel_CharacteristicType() {
		return (EAttribute)serviceCharacteristicModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceCharacteristicModel_CustomAttributes() {
		return (EReference)serviceCharacteristicModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceCharacteristicModel_Member() {
		return (EReference)serviceCharacteristicModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionModel() {
		return transitionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionModel_Name() {
		return (EAttribute)transitionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionModel_Description() {
		return (EAttribute)transitionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionModel_TransitionType() {
		return (EAttribute)transitionModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionModel_Value() {
		return (EAttribute)transitionModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToEObjectMap() {
		return stringToEObjectMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToEObjectMap_Key() {
		return (EAttribute)stringToEObjectMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToEObjectMap_Value() {
		return (EAttribute)stringToEObjectMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdpFactory getPdpFactory() {
		return (PdpFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractOCampPlanModelEClass = createEClass(ABSTRACT_OCAMP_PLAN_MODEL);
		createEAttribute(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__NAME);
		createEAttribute(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION);
		createEAttribute(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN);
		createEAttribute(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE);
		createEReference(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS);
		createEReference(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__SERVICES);
		createEReference(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__POLICIES);
		createEReference(abstractOCampPlanModelEClass, ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES);

		actionModelEClass = createEClass(ACTION_MODEL);
		createEAttribute(actionModelEClass, ACTION_MODEL__NAME);
		createEAttribute(actionModelEClass, ACTION_MODEL__DESCRIPTION);
		createEAttribute(actionModelEClass, ACTION_MODEL__PROPERTY);
		createEAttribute(actionModelEClass, ACTION_MODEL__ACTION_TYPE);
		createEReference(actionModelEClass, ACTION_MODEL__TRANSITIONS);
		createEReference(actionModelEClass, ACTION_MODEL__CUSTOM_ATTRIBUTES);

		actionGroupModelEClass = createEClass(ACTION_GROUP_MODEL);
		createEAttribute(actionGroupModelEClass, ACTION_GROUP_MODEL__NAME);
		createEAttribute(actionGroupModelEClass, ACTION_GROUP_MODEL__DESCRIPTION);
		createEAttribute(actionGroupModelEClass, ACTION_GROUP_MODEL__ACTION_ID);
		createEAttribute(actionGroupModelEClass, ACTION_GROUP_MODEL__ACTION_GROUP_TYPE);
		createEReference(actionGroupModelEClass, ACTION_GROUP_MODEL__ACTIONS);
		createEReference(actionGroupModelEClass, ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES);

		artifactModelEClass = createEClass(ARTIFACT_MODEL);
		createEAttribute(artifactModelEClass, ARTIFACT_MODEL__NAME);
		createEAttribute(artifactModelEClass, ARTIFACT_MODEL__DESCRIPTION);
		createEAttribute(artifactModelEClass, ARTIFACT_MODEL__ARTIFACT_TYPE);
		createEReference(artifactModelEClass, ARTIFACT_MODEL__CONTENT);
		createEReference(artifactModelEClass, ARTIFACT_MODEL__REQUIREMENTS);
		createEReference(artifactModelEClass, ARTIFACT_MODEL__CUSTOM_ATTRIBUTES);

		artifactContentModelEClass = createEClass(ARTIFACT_CONTENT_MODEL);
		createEAttribute(artifactContentModelEClass, ARTIFACT_CONTENT_MODEL__HREF);
		createEReference(artifactContentModelEClass, ARTIFACT_CONTENT_MODEL__CUSTOM_ATTRIBUTES);

		artifactRequirementModelEClass = createEClass(ARTIFACT_REQUIREMENT_MODEL);
		createEAttribute(artifactRequirementModelEClass, ARTIFACT_REQUIREMENT_MODEL__NAME);
		createEAttribute(artifactRequirementModelEClass, ARTIFACT_REQUIREMENT_MODEL__DESCRIPTION);
		createEAttribute(artifactRequirementModelEClass, ARTIFACT_REQUIREMENT_MODEL__REQUIREMENT_TYPE);
		createEReference(artifactRequirementModelEClass, ARTIFACT_REQUIREMENT_MODEL__CUSTOM_ATTRIBUTES);
		createEAttribute(artifactRequirementModelEClass, ARTIFACT_REQUIREMENT_MODEL__FULFILLMENT);

		deploymentPlanModelEClass = createEClass(DEPLOYMENT_PLAN_MODEL);
		createEAttribute(deploymentPlanModelEClass, DEPLOYMENT_PLAN_MODEL__TYPE);
		createEReference(deploymentPlanModelEClass, DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS);

		policyModelEClass = createEClass(POLICY_MODEL);
		createEAttribute(policyModelEClass, POLICY_MODEL__NAME);
		createEAttribute(policyModelEClass, POLICY_MODEL__DESCRIPTION);
		createEAttribute(policyModelEClass, POLICY_MODEL__POLICY_TYPE);
		createEReference(policyModelEClass, POLICY_MODEL__POLICY_CONSTRAINTS);
		createEAttribute(policyModelEClass, POLICY_MODEL__TARGETS);
		createEReference(policyModelEClass, POLICY_MODEL__CUSTOM_ATTRIBUTES);

		policyConstraintModelEClass = createEClass(POLICY_CONSTRAINT_MODEL);
		createEAttribute(policyConstraintModelEClass, POLICY_CONSTRAINT_MODEL__NAME);
		createEAttribute(policyConstraintModelEClass, POLICY_CONSTRAINT_MODEL__DESCRIPTION);
		createEAttribute(policyConstraintModelEClass, POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE);
		createEAttribute(policyConstraintModelEClass, POLICY_CONSTRAINT_MODEL__VALUE);
		createEReference(policyConstraintModelEClass, POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES);

		policyManagerPlanModelEClass = createEClass(POLICY_MANAGER_PLAN_MODEL);
		createEAttribute(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__NAME);
		createEAttribute(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__DESCRIPTION);
		createEAttribute(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__ORIGIN);
		createEAttribute(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__SOURCE_CODE);
		createEAttribute(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__POLICY_MANAGER_TYPE);
		createEReference(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__ACTION_GROUPS);
		createEReference(policyManagerPlanModelEClass, POLICY_MANAGER_PLAN_MODEL__CUSTOM_ATTRIBUTES);

		serviceModelEClass = createEClass(SERVICE_MODEL);
		createEAttribute(serviceModelEClass, SERVICE_MODEL__NAME);
		createEAttribute(serviceModelEClass, SERVICE_MODEL__DESCRIPTION);
		createEAttribute(serviceModelEClass, SERVICE_MODEL__SERVICE_TYPE);
		createEReference(serviceModelEClass, SERVICE_MODEL__CHARACTERISTICS);
		createEReference(serviceModelEClass, SERVICE_MODEL__CUSTOM_ATTRIBUTES);

		serviceCharacteristicModelEClass = createEClass(SERVICE_CHARACTERISTIC_MODEL);
		createEAttribute(serviceCharacteristicModelEClass, SERVICE_CHARACTERISTIC_MODEL__NAME);
		createEAttribute(serviceCharacteristicModelEClass, SERVICE_CHARACTERISTIC_MODEL__DESCRIPTION);
		createEAttribute(serviceCharacteristicModelEClass, SERVICE_CHARACTERISTIC_MODEL__CHARACTERISTIC_TYPE);
		createEReference(serviceCharacteristicModelEClass, SERVICE_CHARACTERISTIC_MODEL__CUSTOM_ATTRIBUTES);
		createEReference(serviceCharacteristicModelEClass, SERVICE_CHARACTERISTIC_MODEL__MEMBER);

		transitionModelEClass = createEClass(TRANSITION_MODEL);
		createEAttribute(transitionModelEClass, TRANSITION_MODEL__NAME);
		createEAttribute(transitionModelEClass, TRANSITION_MODEL__DESCRIPTION);
		createEAttribute(transitionModelEClass, TRANSITION_MODEL__TRANSITION_TYPE);
		createEAttribute(transitionModelEClass, TRANSITION_MODEL__VALUE);

		stringToEObjectMapEClass = createEClass(STRING_TO_EOBJECT_MAP);
		createEAttribute(stringToEObjectMapEClass, STRING_TO_EOBJECT_MAP__KEY);
		createEAttribute(stringToEObjectMapEClass, STRING_TO_EOBJECT_MAP__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deploymentPlanModelEClass.getESuperTypes().add(this.getAbstractOCampPlanModel());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractOCampPlanModelEClass, AbstractOCampPlanModel.class, "AbstractOCampPlanModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractOCampPlanModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOCampPlanModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOCampPlanModel_Origin(), ecorePackage.getEString(), "origin", null, 0, 1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOCampPlanModel_SourceCode(), ecorePackage.getEString(), "sourceCode", null, 0, 1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractOCampPlanModel_Artifacts(), this.getArtifactModel(), null, "artifacts", null, 0, -1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractOCampPlanModel_Services(), this.getServiceModel(), null, "services", null, 0, -1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractOCampPlanModel_Policies(), this.getPolicyModel(), null, "policies", null, 0, -1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractOCampPlanModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, AbstractOCampPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionModelEClass, ActionModel.class, "ActionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionModel_Property(), ecorePackage.getEString(), "property", null, 0, 1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionModel_ActionType(), ecorePackage.getEString(), "actionType", null, 0, 1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionModel_Transitions(), this.getTransitionModel(), null, "transitions", null, 0, -1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ActionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionGroupModelEClass, ActionGroupModel.class, "ActionGroupModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionGroupModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionGroupModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionGroupModel_ActionId(), ecorePackage.getEString(), "actionId", null, 0, 1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionGroupModel_ActionGroupType(), ecorePackage.getEString(), "actionGroupType", null, 0, 1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionGroupModel_Actions(), this.getActionModel(), null, "actions", null, 0, -1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionGroupModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ActionGroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(artifactModelEClass, ArtifactModel.class, "ArtifactModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArtifactModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtifactModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtifactModel_ArtifactType(), ecorePackage.getEString(), "artifactType", null, 0, 1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifactModel_Content(), this.getArtifactContentModel(), null, "content", null, 0, 1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifactModel_Requirements(), this.getArtifactRequirementModel(), null, "requirements", null, 0, -1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifactModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ArtifactModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(artifactContentModelEClass, ArtifactContentModel.class, "ArtifactContentModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArtifactContentModel_Href(), ecorePackage.getEString(), "href", null, 0, 1, ArtifactContentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifactContentModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ArtifactContentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(artifactRequirementModelEClass, ArtifactRequirementModel.class, "ArtifactRequirementModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArtifactRequirementModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArtifactRequirementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtifactRequirementModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ArtifactRequirementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtifactRequirementModel_RequirementType(), ecorePackage.getEString(), "requirementType", null, 0, 1, ArtifactRequirementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifactRequirementModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ArtifactRequirementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtifactRequirementModel_Fulfillment(), ecorePackage.getEString(), "fulfillment", null, 0, 1, ArtifactRequirementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deploymentPlanModelEClass, DeploymentPlanModel.class, "DeploymentPlanModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeploymentPlanModel_Type(), ecorePackage.getEString(), "type", null, 0, 1, DeploymentPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeploymentPlanModel_ActionGroups(), this.getActionGroupModel(), null, "actionGroups", null, 0, -1, DeploymentPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyModelEClass, PolicyModel.class, "PolicyModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicyModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyModel_PolicyType(), ecorePackage.getEString(), "policyType", null, 0, 1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicyModel_PolicyConstraints(), this.getPolicyConstraintModel(), null, "policyConstraints", null, 0, -1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyModel_Targets(), ecorePackage.getEString(), "targets", null, 0, -1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicyModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, PolicyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyConstraintModelEClass, PolicyConstraintModel.class, "PolicyConstraintModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicyConstraintModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, PolicyConstraintModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyConstraintModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, PolicyConstraintModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyConstraintModel_PolicyConstraintType(), ecorePackage.getEString(), "policyConstraintType", null, 0, 1, PolicyConstraintModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyConstraintModel_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, PolicyConstraintModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicyConstraintModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, PolicyConstraintModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policyManagerPlanModelEClass, PolicyManagerPlanModel.class, "PolicyManagerPlanModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicyManagerPlanModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyManagerPlanModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyManagerPlanModel_Origin(), ecorePackage.getEString(), "origin", null, 0, 1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyManagerPlanModel_SourceCode(), ecorePackage.getEString(), "sourceCode", null, 0, 1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolicyManagerPlanModel_PolicyManagerType(), ecorePackage.getEString(), "policyManagerType", null, 0, 1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicyManagerPlanModel_ActionGroups(), this.getActionGroupModel(), null, "actionGroups", null, 0, -1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolicyManagerPlanModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, PolicyManagerPlanModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceModelEClass, ServiceModel.class, "ServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceModel_ServiceType(), ecorePackage.getEString(), "serviceType", null, 0, 1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceModel_Characteristics(), this.getServiceCharacteristicModel(), null, "characteristics", null, 0, -1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceCharacteristicModelEClass, ServiceCharacteristicModel.class, "ServiceCharacteristicModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceCharacteristicModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ServiceCharacteristicModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceCharacteristicModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, ServiceCharacteristicModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceCharacteristicModel_CharacteristicType(), ecorePackage.getEString(), "characteristicType", null, 0, 1, ServiceCharacteristicModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCharacteristicModel_CustomAttributes(), this.getStringToEObjectMap(), null, "customAttributes", null, 0, -1, ServiceCharacteristicModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCharacteristicModel_Member(), this.getServiceModel(), null, "member", null, 0, 1, ServiceCharacteristicModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionModelEClass, TransitionModel.class, "TransitionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransitionModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransitionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, TransitionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionModel_TransitionType(), ecorePackage.getEString(), "transitionType", null, 0, 1, TransitionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionModel_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, TransitionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToEObjectMapEClass, Map.Entry.class, "StringToEObjectMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToEObjectMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToEObjectMap_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PdpPackageImpl
