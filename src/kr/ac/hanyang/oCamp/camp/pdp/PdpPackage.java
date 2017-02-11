/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpFactory
 * @model kind="package"
 * @generated
 */
public interface PdpPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pdp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///kr/ac/hanyang/oCamp/camp/pdp.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kr.ac.hanyang.oCamp.camp.pdp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PdpPackage eINSTANCE = kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl.init();

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl <em>Abstract OCamp Plan Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAbstractOCampPlanModel()
	 * @generated
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS = 4;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__SERVICES = 5;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__POLICIES = 6;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES = 7;

	/**
	 * The number of structural features of the '<em>Abstract OCamp Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Abstract OCamp Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionModelImpl <em>Action Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionModel()
	 * @generated
	 */
	int ACTION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__ACTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__TRANSITIONS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Action Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Action Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl <em>Action Group Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionGroupModel()
	 * @generated
	 */
	int ACTION_GROUP_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__ACTION_ID = 2;

	/**
	 * The feature id for the '<em><b>Action Group Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__ACTION_GROUP_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__ACTIONS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Action Group Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Action Group Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactModelImpl <em>Artifact Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactModel()
	 * @generated
	 */
	int ARTIFACT_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Artifact Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__ARTIFACT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__CONTENT = 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__REQUIREMENTS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Artifact Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Artifact Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentModelImpl <em>Artifact Content Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactContentModel()
	 * @generated
	 */
	int ARTIFACT_CONTENT_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_MODEL__HREF = 0;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_MODEL__CUSTOM_ATTRIBUTES = 1;

	/**
	 * The number of structural features of the '<em>Artifact Content Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Artifact Content Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementModelImpl <em>Artifact Requirement Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactRequirementModel()
	 * @generated
	 */
	int ARTIFACT_REQUIREMENT_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL__REQUIREMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL__CUSTOM_ATTRIBUTES = 3;

	/**
	 * The feature id for the '<em><b>Fulfillment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL__FULFILLMENT = 4;

	/**
	 * The number of structural features of the '<em>Artifact Requirement Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Artifact Requirement Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl <em>Deployment Plan Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getDeploymentPlanModel()
	 * @generated
	 */
	int DEPLOYMENT_PLAN_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__NAME = ABSTRACT_OCAMP_PLAN_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__DESCRIPTION = ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__ORIGIN = ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__SOURCE_CODE = ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__ARTIFACTS = ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__SERVICES = ABSTRACT_OCAMP_PLAN_MODEL__SERVICES;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__POLICIES = ABSTRACT_OCAMP_PLAN_MODEL__POLICIES;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__CUSTOM_ATTRIBUTES = ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__TYPE = ABSTRACT_OCAMP_PLAN_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS = ABSTRACT_OCAMP_PLAN_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deployment Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL_FEATURE_COUNT = ABSTRACT_OCAMP_PLAN_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Deployment Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_MODEL_OPERATION_COUNT = ABSTRACT_OCAMP_PLAN_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl <em>Policy Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyModel()
	 * @generated
	 */
	int POLICY_MODEL = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Policy Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__POLICY_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Policy Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__POLICY_CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__TARGETS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Policy Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Policy Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl <em>Policy Constraint Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyConstraintModel()
	 * @generated
	 */
	int POLICY_CONSTRAINT_MODEL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Policy Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Policy Constraint Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Policy Constraint Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanModelImpl <em>Policy Manager Plan Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyManagerPlanModel()
	 * @generated
	 */
	int POLICY_MANAGER_PLAN_MODEL = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__SOURCE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Policy Manager Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__POLICY_MANAGER_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Action Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__ACTION_GROUPS = 5;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL__CUSTOM_ATTRIBUTES = 6;

	/**
	 * The number of structural features of the '<em>Policy Manager Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Policy Manager Plan Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceModelImpl <em>Service Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceModel()
	 * @generated
	 */
	int SERVICE_MODEL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__SERVICE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__CHARACTERISTICS = 3;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__CUSTOM_ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Service Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Service Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicModelImpl <em>Service Characteristic Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceCharacteristicModel()
	 * @generated
	 */
	int SERVICE_CHARACTERISTIC_MODEL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Characteristic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL__CHARACTERISTIC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL__CUSTOM_ATTRIBUTES = 3;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL__MEMBER = 4;

	/**
	 * The number of structural features of the '<em>Service Characteristic Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Service Characteristic Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionModelImpl <em>Transition Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionModelImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getTransitionModel()
	 * @generated
	 */
	int TRANSITION_MODEL = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Transition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL__TRANSITION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Transition Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Transition Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.StringToEObjectMapImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getStringToEObjectMap()
	 * @generated
	 */
	int STRING_TO_EOBJECT_MAP = 13;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel <em>Abstract OCamp Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract OCamp Plan Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel
	 * @generated
	 */
	EClass getAbstractOCampPlanModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getName()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EAttribute getAbstractOCampPlanModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getDescription()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EAttribute getAbstractOCampPlanModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getOrigin()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EAttribute getAbstractOCampPlanModel_Origin();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getSourceCode()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EAttribute getAbstractOCampPlanModel_SourceCode();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Artifacts</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getArtifacts()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EReference getAbstractOCampPlanModel_Artifacts();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getServices()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EReference getAbstractOCampPlanModel_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policies</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getPolicies()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EReference getAbstractOCampPlanModel_Policies();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel#getCustomAttributes()
	 * @see #getAbstractOCampPlanModel()
	 * @generated
	 */
	EReference getAbstractOCampPlanModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel <em>Action Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel
	 * @generated
	 */
	EClass getActionModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getName()
	 * @see #getActionModel()
	 * @generated
	 */
	EAttribute getActionModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getDescription()
	 * @see #getActionModel()
	 * @generated
	 */
	EAttribute getActionModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getProperty()
	 * @see #getActionModel()
	 * @generated
	 */
	EAttribute getActionModel_Property();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getActionType()
	 * @see #getActionModel()
	 * @generated
	 */
	EAttribute getActionModel_ActionType();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getTransitions()
	 * @see #getActionModel()
	 * @generated
	 */
	EReference getActionModel_Transitions();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionModel#getCustomAttributes()
	 * @see #getActionModel()
	 * @generated
	 */
	EReference getActionModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel <em>Action Group Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Group Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel
	 * @generated
	 */
	EClass getActionGroupModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getName()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EAttribute getActionGroupModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getDescription()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EAttribute getActionGroupModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionId <em>Action Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Id</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionId()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EAttribute getActionGroupModel_ActionId();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionGroupType <em>Action Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Group Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActionGroupType()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EAttribute getActionGroupModel_ActionGroupType();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getActions()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EReference getActionGroupModel_Actions();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel#getCustomAttributes()
	 * @see #getActionGroupModel()
	 * @generated
	 */
	EReference getActionGroupModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel <em>Artifact Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel
	 * @generated
	 */
	EClass getArtifactModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getName()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EAttribute getArtifactModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getDescription()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EAttribute getArtifactModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getArtifactType <em>Artifact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getArtifactType()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EAttribute getArtifactModel_ArtifactType();

	/**
	 * Returns the meta object for the containment reference '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getContent()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EReference getArtifactModel_Content();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getRequirements()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EReference getArtifactModel_Requirements();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel#getCustomAttributes()
	 * @see #getArtifactModel()
	 * @generated
	 */
	EReference getArtifactModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel <em>Artifact Content Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Content Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel
	 * @generated
	 */
	EClass getArtifactContentModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel#getHref()
	 * @see #getArtifactContentModel()
	 * @generated
	 */
	EAttribute getArtifactContentModel_Href();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContentModel#getCustomAttributes()
	 * @see #getArtifactContentModel()
	 * @generated
	 */
	EReference getArtifactContentModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel <em>Artifact Requirement Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Requirement Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel
	 * @generated
	 */
	EClass getArtifactRequirementModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getName()
	 * @see #getArtifactRequirementModel()
	 * @generated
	 */
	EAttribute getArtifactRequirementModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getDescription()
	 * @see #getArtifactRequirementModel()
	 * @generated
	 */
	EAttribute getArtifactRequirementModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getRequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getRequirementType()
	 * @see #getArtifactRequirementModel()
	 * @generated
	 */
	EAttribute getArtifactRequirementModel_RequirementType();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getCustomAttributes()
	 * @see #getArtifactRequirementModel()
	 * @generated
	 */
	EReference getArtifactRequirementModel_CustomAttributes();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getFulfillment <em>Fulfillment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fulfillment</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getFulfillment()
	 * @see #getArtifactRequirementModel()
	 * @generated
	 */
	EAttribute getArtifactRequirementModel_Fulfillment();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel <em>Deployment Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Plan Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel
	 * @generated
	 */
	EClass getDeploymentPlanModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getType()
	 * @see #getDeploymentPlanModel()
	 * @generated
	 */
	EAttribute getDeploymentPlanModel_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getActionGroups <em>Action Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action Groups</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel#getActionGroups()
	 * @see #getDeploymentPlanModel()
	 * @generated
	 */
	EReference getDeploymentPlanModel_ActionGroups();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel <em>Policy Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel
	 * @generated
	 */
	EClass getPolicyModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getName()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EAttribute getPolicyModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getDescription()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EAttribute getPolicyModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getPolicyType <em>Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getPolicyType()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EAttribute getPolicyModel_PolicyType();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getPolicyConstraints <em>Policy Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policy Constraints</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getPolicyConstraints()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EReference getPolicyModel_PolicyConstraints();

	/**
	 * Returns the meta object for the attribute list '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Targets</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getTargets()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EAttribute getPolicyModel_Targets();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyModel#getCustomAttributes()
	 * @see #getPolicyModel()
	 * @generated
	 */
	EReference getPolicyModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel <em>Policy Constraint Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy Constraint Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel
	 * @generated
	 */
	EClass getPolicyConstraintModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getName()
	 * @see #getPolicyConstraintModel()
	 * @generated
	 */
	EAttribute getPolicyConstraintModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getDescription()
	 * @see #getPolicyConstraintModel()
	 * @generated
	 */
	EAttribute getPolicyConstraintModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getPolicyConstraintType <em>Policy Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Constraint Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getPolicyConstraintType()
	 * @see #getPolicyConstraintModel()
	 * @generated
	 */
	EAttribute getPolicyConstraintModel_PolicyConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getValue()
	 * @see #getPolicyConstraintModel()
	 * @generated
	 */
	EAttribute getPolicyConstraintModel_Value();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getCustomAttributes()
	 * @see #getPolicyConstraintModel()
	 * @generated
	 */
	EReference getPolicyConstraintModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel <em>Policy Manager Plan Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy Manager Plan Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel
	 * @generated
	 */
	EClass getPolicyManagerPlanModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getName()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EAttribute getPolicyManagerPlanModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getDescription()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EAttribute getPolicyManagerPlanModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getOrigin()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EAttribute getPolicyManagerPlanModel_Origin();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getSourceCode()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EAttribute getPolicyManagerPlanModel_SourceCode();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getPolicyManagerType <em>Policy Manager Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Manager Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getPolicyManagerType()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EAttribute getPolicyManagerPlanModel_PolicyManagerType();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getActionGroups <em>Action Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action Groups</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getActionGroups()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EReference getPolicyManagerPlanModel_ActionGroups();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlanModel#getCustomAttributes()
	 * @see #getPolicyManagerPlanModel()
	 * @generated
	 */
	EReference getPolicyManagerPlanModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel
	 * @generated
	 */
	EClass getServiceModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getName()
	 * @see #getServiceModel()
	 * @generated
	 */
	EAttribute getServiceModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getDescription()
	 * @see #getServiceModel()
	 * @generated
	 */
	EAttribute getServiceModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getServiceType()
	 * @see #getServiceModel()
	 * @generated
	 */
	EAttribute getServiceModel_ServiceType();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getCharacteristics <em>Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristics</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getCharacteristics()
	 * @see #getServiceModel()
	 * @generated
	 */
	EReference getServiceModel_Characteristics();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceModel#getCustomAttributes()
	 * @see #getServiceModel()
	 * @generated
	 */
	EReference getServiceModel_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel <em>Service Characteristic Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Characteristic Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel
	 * @generated
	 */
	EClass getServiceCharacteristicModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getName()
	 * @see #getServiceCharacteristicModel()
	 * @generated
	 */
	EAttribute getServiceCharacteristicModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getDescription()
	 * @see #getServiceCharacteristicModel()
	 * @generated
	 */
	EAttribute getServiceCharacteristicModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCharacteristicType <em>Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Characteristic Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCharacteristicType()
	 * @see #getServiceCharacteristicModel()
	 * @generated
	 */
	EAttribute getServiceCharacteristicModel_CharacteristicType();

	/**
	 * Returns the meta object for the map '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCustomAttributes()
	 * @see #getServiceCharacteristicModel()
	 * @generated
	 */
	EReference getServiceCharacteristicModel_CustomAttributes();

	/**
	 * Returns the meta object for the containment reference '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Member</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getMember()
	 * @see #getServiceCharacteristicModel()
	 * @generated
	 */
	EReference getServiceCharacteristicModel_Member();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel <em>Transition Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Model</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel
	 * @generated
	 */
	EClass getTransitionModel();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getName()
	 * @see #getTransitionModel()
	 * @generated
	 */
	EAttribute getTransitionModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getDescription()
	 * @see #getTransitionModel()
	 * @generated
	 */
	EAttribute getTransitionModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getTransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getTransitionType()
	 * @see #getTransitionModel()
	 * @generated
	 */
	EAttribute getTransitionModel_TransitionType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.TransitionModel#getValue()
	 * @see #getTransitionModel()
	 * @generated
	 */
	EAttribute getTransitionModel_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To EObject Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To EObject Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EJavaObject"
	 * @generated
	 */
	EClass getStringToEObjectMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EAttribute getStringToEObjectMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EAttribute getStringToEObjectMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PdpFactory getPdpFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl <em>Abstract OCamp Plan Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAbstractOCampPlanModel()
		 * @generated
		 */
		EClass ABSTRACT_OCAMP_PLAN_MODEL = eINSTANCE.getAbstractOCampPlanModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN_MODEL__NAME = eINSTANCE.getAbstractOCampPlanModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION = eINSTANCE.getAbstractOCampPlanModel_Description();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN = eINSTANCE.getAbstractOCampPlanModel_Origin();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE = eINSTANCE.getAbstractOCampPlanModel_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS = eINSTANCE.getAbstractOCampPlanModel_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN_MODEL__SERVICES = eINSTANCE.getAbstractOCampPlanModel_Services();

		/**
		 * The meta object literal for the '<em><b>Policies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN_MODEL__POLICIES = eINSTANCE.getAbstractOCampPlanModel_Policies();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getAbstractOCampPlanModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionModelImpl <em>Action Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionModel()
		 * @generated
		 */
		EClass ACTION_MODEL = eINSTANCE.getActionModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MODEL__NAME = eINSTANCE.getActionModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MODEL__DESCRIPTION = eINSTANCE.getActionModel_Description();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MODEL__PROPERTY = eINSTANCE.getActionModel_Property();

		/**
		 * The meta object literal for the '<em><b>Action Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MODEL__ACTION_TYPE = eINSTANCE.getActionModel_ActionType();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_MODEL__TRANSITIONS = eINSTANCE.getActionModel_Transitions();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getActionModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl <em>Action Group Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionGroupModel()
		 * @generated
		 */
		EClass ACTION_GROUP_MODEL = eINSTANCE.getActionGroupModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP_MODEL__NAME = eINSTANCE.getActionGroupModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP_MODEL__DESCRIPTION = eINSTANCE.getActionGroupModel_Description();

		/**
		 * The meta object literal for the '<em><b>Action Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP_MODEL__ACTION_ID = eINSTANCE.getActionGroupModel_ActionId();

		/**
		 * The meta object literal for the '<em><b>Action Group Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP_MODEL__ACTION_GROUP_TYPE = eINSTANCE.getActionGroupModel_ActionGroupType();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_GROUP_MODEL__ACTIONS = eINSTANCE.getActionGroupModel_Actions();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getActionGroupModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactModelImpl <em>Artifact Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactModel()
		 * @generated
		 */
		EClass ARTIFACT_MODEL = eINSTANCE.getArtifactModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_MODEL__NAME = eINSTANCE.getArtifactModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_MODEL__DESCRIPTION = eINSTANCE.getArtifactModel_Description();

		/**
		 * The meta object literal for the '<em><b>Artifact Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_MODEL__ARTIFACT_TYPE = eINSTANCE.getArtifactModel_ArtifactType();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_MODEL__CONTENT = eINSTANCE.getArtifactModel_Content();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_MODEL__REQUIREMENTS = eINSTANCE.getArtifactModel_Requirements();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifactModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentModelImpl <em>Artifact Content Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactContentModel()
		 * @generated
		 */
		EClass ARTIFACT_CONTENT_MODEL = eINSTANCE.getArtifactContentModel();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_CONTENT_MODEL__HREF = eINSTANCE.getArtifactContentModel_Href();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_CONTENT_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifactContentModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementModelImpl <em>Artifact Requirement Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactRequirementModel()
		 * @generated
		 */
		EClass ARTIFACT_REQUIREMENT_MODEL = eINSTANCE.getArtifactRequirementModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT_MODEL__NAME = eINSTANCE.getArtifactRequirementModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT_MODEL__DESCRIPTION = eINSTANCE.getArtifactRequirementModel_Description();

		/**
		 * The meta object literal for the '<em><b>Requirement Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT_MODEL__REQUIREMENT_TYPE = eINSTANCE.getArtifactRequirementModel_RequirementType();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_REQUIREMENT_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifactRequirementModel_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Fulfillment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT_MODEL__FULFILLMENT = eINSTANCE.getArtifactRequirementModel_Fulfillment();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl <em>Deployment Plan Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getDeploymentPlanModel()
		 * @generated
		 */
		EClass DEPLOYMENT_PLAN_MODEL = eINSTANCE.getDeploymentPlanModel();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN_MODEL__TYPE = eINSTANCE.getDeploymentPlanModel_Type();

		/**
		 * The meta object literal for the '<em><b>Action Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS = eINSTANCE.getDeploymentPlanModel_ActionGroups();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl <em>Policy Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyModel()
		 * @generated
		 */
		EClass POLICY_MODEL = eINSTANCE.getPolicyModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MODEL__NAME = eINSTANCE.getPolicyModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MODEL__DESCRIPTION = eINSTANCE.getPolicyModel_Description();

		/**
		 * The meta object literal for the '<em><b>Policy Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MODEL__POLICY_TYPE = eINSTANCE.getPolicyModel_PolicyType();

		/**
		 * The meta object literal for the '<em><b>Policy Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_MODEL__POLICY_CONSTRAINTS = eINSTANCE.getPolicyModel_PolicyConstraints();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MODEL__TARGETS = eINSTANCE.getPolicyModel_Targets();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicyModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl <em>Policy Constraint Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyConstraintModel()
		 * @generated
		 */
		EClass POLICY_CONSTRAINT_MODEL = eINSTANCE.getPolicyConstraintModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT_MODEL__NAME = eINSTANCE.getPolicyConstraintModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT_MODEL__DESCRIPTION = eINSTANCE.getPolicyConstraintModel_Description();

		/**
		 * The meta object literal for the '<em><b>Policy Constraint Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE = eINSTANCE.getPolicyConstraintModel_PolicyConstraintType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT_MODEL__VALUE = eINSTANCE.getPolicyConstraintModel_Value();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicyConstraintModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanModelImpl <em>Policy Manager Plan Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyManagerPlanModel()
		 * @generated
		 */
		EClass POLICY_MANAGER_PLAN_MODEL = eINSTANCE.getPolicyManagerPlanModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN_MODEL__NAME = eINSTANCE.getPolicyManagerPlanModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN_MODEL__DESCRIPTION = eINSTANCE.getPolicyManagerPlanModel_Description();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN_MODEL__ORIGIN = eINSTANCE.getPolicyManagerPlanModel_Origin();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN_MODEL__SOURCE_CODE = eINSTANCE.getPolicyManagerPlanModel_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Policy Manager Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN_MODEL__POLICY_MANAGER_TYPE = eINSTANCE.getPolicyManagerPlanModel_PolicyManagerType();

		/**
		 * The meta object literal for the '<em><b>Action Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_MANAGER_PLAN_MODEL__ACTION_GROUPS = eINSTANCE.getPolicyManagerPlanModel_ActionGroups();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_MANAGER_PLAN_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicyManagerPlanModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceModelImpl <em>Service Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceModel()
		 * @generated
		 */
		EClass SERVICE_MODEL = eINSTANCE.getServiceModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MODEL__NAME = eINSTANCE.getServiceModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MODEL__DESCRIPTION = eINSTANCE.getServiceModel_Description();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MODEL__SERVICE_TYPE = eINSTANCE.getServiceModel_ServiceType();

		/**
		 * The meta object literal for the '<em><b>Characteristics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MODEL__CHARACTERISTICS = eINSTANCE.getServiceModel_Characteristics();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getServiceModel_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicModelImpl <em>Service Characteristic Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceCharacteristicModel()
		 * @generated
		 */
		EClass SERVICE_CHARACTERISTIC_MODEL = eINSTANCE.getServiceCharacteristicModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC_MODEL__NAME = eINSTANCE.getServiceCharacteristicModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC_MODEL__DESCRIPTION = eINSTANCE.getServiceCharacteristicModel_Description();

		/**
		 * The meta object literal for the '<em><b>Characteristic Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC_MODEL__CHARACTERISTIC_TYPE = eINSTANCE.getServiceCharacteristicModel_CharacteristicType();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_CHARACTERISTIC_MODEL__CUSTOM_ATTRIBUTES = eINSTANCE.getServiceCharacteristicModel_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_CHARACTERISTIC_MODEL__MEMBER = eINSTANCE.getServiceCharacteristicModel_Member();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionModelImpl <em>Transition Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionModelImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getTransitionModel()
		 * @generated
		 */
		EClass TRANSITION_MODEL = eINSTANCE.getTransitionModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_MODEL__NAME = eINSTANCE.getTransitionModel_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_MODEL__DESCRIPTION = eINSTANCE.getTransitionModel_Description();

		/**
		 * The meta object literal for the '<em><b>Transition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_MODEL__TRANSITION_TYPE = eINSTANCE.getTransitionModel_TransitionType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_MODEL__VALUE = eINSTANCE.getTransitionModel_Value();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.StringToEObjectMapImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getStringToEObjectMap()
		 * @generated
		 */
		EClass STRING_TO_EOBJECT_MAP = eINSTANCE.getStringToEObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_EOBJECT_MAP__KEY = eINSTANCE.getStringToEObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_EOBJECT_MAP__VALUE = eINSTANCE.getStringToEObjectMap_Value();

	}

} //PdpPackage
