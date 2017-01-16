/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
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
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl <em>Abstract OCamp Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAbstractOCampPlan()
	 * @generated
	 */
	int ABSTRACT_OCAMP_PLAN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__SOURCE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__ARTIFACTS = 4;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__SERVICES = 5;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__POLICIES = 6;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES = 7;

	/**
	 * The number of structural features of the '<em>Abstract OCamp Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Abstract OCamp Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OCAMP_PLAN_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TRANSITIONS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl <em>Action Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionGroup()
	 * @generated
	 */
	int ACTION_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__ACTION_ID = 2;

	/**
	 * The feature id for the '<em><b>Action Group Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__ACTION_GROUP_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__ACTIONS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Action Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Action Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_GROUP_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl <em>Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifact()
	 * @generated
	 */
	int ARTIFACT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Artifact Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ARTIFACT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__CONTENT = 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__REQUIREMENTS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentImpl <em>Artifact Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactContent()
	 * @generated
	 */
	int ARTIFACT_CONTENT = 4;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT__HREF = 0;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT__CUSTOM_ATTRIBUTES = 1;

	/**
	 * The number of structural features of the '<em>Artifact Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Artifact Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_CONTENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementImpl <em>Artifact Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactRequirement()
	 * @generated
	 */
	int ARTIFACT_REQUIREMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT__REQUIREMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT__CUSTOM_ATTRIBUTES = 3;

	/**
	 * The number of structural features of the '<em>Artifact Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Artifact Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getDeploymentPlan()
	 * @generated
	 */
	int DEPLOYMENT_PLAN = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__SOURCE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__ARTIFACTS = 5;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__SERVICES = 6;

	/**
	 * The feature id for the '<em><b>Policies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__POLICIES = 7;

	/**
	 * The feature id for the '<em><b>Action Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__ACTION_GROUPS = 8;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__CUSTOM_ATTRIBUTES = 9;

	/**
	 * The number of structural features of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_FEATURE_COUNT = 10;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl <em>Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicy()
	 * @generated
	 */
	int POLICY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Policy Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__POLICY_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Policy Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__POLICY_CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__TARGETS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl <em>Policy Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyConstraint()
	 * @generated
	 */
	int POLICY_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Policy Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Policy Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Policy Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl <em>Policy Manager Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyManagerPlan()
	 * @generated
	 */
	int POLICY_MANAGER_PLAN = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__SOURCE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Action Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__ACTION_GROUPS = 4;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN__CUSTOM_ATTRIBUTES = 5;

	/**
	 * The number of structural features of the '<em>Policy Manager Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Policy Manager Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_MANAGER_PLAN_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CHARACTERISTICS = 3;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CUSTOM_ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl <em>Service Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceCharacteristic()
	 * @generated
	 */
	int SERVICE_CHARACTERISTIC = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Characteristic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES = 3;

	/**
	 * The number of structural features of the '<em>Service Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Service Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHARACTERISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Transition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRANSITION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Custom Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__CUSTOM_ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Custom Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = 0;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 13;

	/**
	 * The meta object id for the '<em>Maybe</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.brooklyn.util.guava.Maybe
	 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getMaybe()
	 * @generated
	 */
	int MAYBE = 14;


	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan <em>Abstract OCamp Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract OCamp Plan</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan
	 * @generated
	 */
	EClass getAbstractOCampPlan();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getName()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EAttribute getAbstractOCampPlan_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getDescription()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EAttribute getAbstractOCampPlan_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getOrigin()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EAttribute getAbstractOCampPlan_Origin();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getSourceCode()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EAttribute getAbstractOCampPlan_SourceCode();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Artifacts</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getArtifacts()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EReference getAbstractOCampPlan_Artifacts();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getServices()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EReference getAbstractOCampPlan_Services();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Policies</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getPolicies()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EReference getAbstractOCampPlan_Policies();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getCustomAttributes()
	 * @see #getAbstractOCampPlan()
	 * @generated
	 */
	EAttribute getAbstractOCampPlan_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getAbstractOCampPlan__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getDescription()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getProperty()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Property();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getActionType()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ActionType();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transitions</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getTransitions()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Transitions();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getCustomAttributes()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.Action#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Action#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getAction__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup <em>Action Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Group</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup
	 * @generated
	 */
	EClass getActionGroup();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getName()
	 * @see #getActionGroup()
	 * @generated
	 */
	EAttribute getActionGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getDescription()
	 * @see #getActionGroup()
	 * @generated
	 */
	EAttribute getActionGroup_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionId <em>Action Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Id</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionId()
	 * @see #getActionGroup()
	 * @generated
	 */
	EAttribute getActionGroup_ActionId();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionGroupType <em>Action Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Group Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActionGroupType()
	 * @see #getActionGroup()
	 * @generated
	 */
	EAttribute getActionGroup_ActionGroupType();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getActions()
	 * @see #getActionGroup()
	 * @generated
	 */
	EReference getActionGroup_Actions();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getCustomAttributes()
	 * @see #getActionGroup()
	 * @generated
	 */
	EAttribute getActionGroup_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ActionGroup#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getActionGroup__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact
	 * @generated
	 */
	EClass getArtifact();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getName()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getDescription()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getArtifactType <em>Artifact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getArtifactType()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_ArtifactType();

	/**
	 * Returns the meta object for the reference '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getContent()
	 * @see #getArtifact()
	 * @generated
	 */
	EReference getArtifact_Content();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getRequirements()
	 * @see #getArtifact()
	 * @generated
	 */
	EReference getArtifact_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Artifact#getCustomAttributes()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent <em>Artifact Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Content</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent
	 * @generated
	 */
	EClass getArtifactContent();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getHref()
	 * @see #getArtifactContent()
	 * @generated
	 */
	EAttribute getArtifactContent_Href();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent#getCustomAttributes()
	 * @see #getArtifactContent()
	 * @generated
	 */
	EAttribute getArtifactContent_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement <em>Artifact Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Requirement</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement
	 * @generated
	 */
	EClass getArtifactRequirement();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getName()
	 * @see #getArtifactRequirement()
	 * @generated
	 */
	EAttribute getArtifactRequirement_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getDescription()
	 * @see #getArtifactRequirement()
	 * @generated
	 */
	EAttribute getArtifactRequirement_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getRequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getRequirementType()
	 * @see #getArtifactRequirement()
	 * @generated
	 */
	EAttribute getArtifactRequirement_RequirementType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getCustomAttributes()
	 * @see #getArtifactRequirement()
	 * @generated
	 */
	EAttribute getArtifactRequirement_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Plan</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan
	 * @generated
	 */
	EClass getDeploymentPlan();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getName()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getDescription()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getOrigin()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_Origin();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getSourceCode()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_SourceCode();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getType()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_Type();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Artifacts</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getArtifacts()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_Artifacts();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getServices()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_Services();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getPolicies <em>Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Policies</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getPolicies()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_Policies();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getActionGroups <em>Action Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Action Groups</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getActionGroups()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_ActionGroups();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getCustomAttributes()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getDeploymentPlan__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy
	 * @generated
	 */
	EClass getPolicy();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getName()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getDescription()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getPolicyType <em>Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getPolicyType()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_PolicyType();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getPolicyConstraints <em>Policy Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Policy Constraints</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getPolicyConstraints()
	 * @see #getPolicy()
	 * @generated
	 */
	EReference getPolicy_PolicyConstraints();

	/**
	 * Returns the meta object for the attribute list '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Targets</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getTargets()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_Targets();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Policy#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Policy#getCustomAttributes()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint <em>Policy Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy Constraint</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint
	 * @generated
	 */
	EClass getPolicyConstraint();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getName()
	 * @see #getPolicyConstraint()
	 * @generated
	 */
	EAttribute getPolicyConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getDescription()
	 * @see #getPolicyConstraint()
	 * @generated
	 */
	EAttribute getPolicyConstraint_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getPolicyConstraintType <em>Policy Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Constraint Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getPolicyConstraintType()
	 * @see #getPolicyConstraint()
	 * @generated
	 */
	EAttribute getPolicyConstraint_PolicyConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getValue()
	 * @see #getPolicyConstraint()
	 * @generated
	 */
	EAttribute getPolicyConstraint_Value();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint#getCustomAttributes()
	 * @see #getPolicyConstraint()
	 * @generated
	 */
	EAttribute getPolicyConstraint_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan <em>Policy Manager Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy Manager Plan</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan
	 * @generated
	 */
	EClass getPolicyManagerPlan();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getName()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EAttribute getPolicyManagerPlan_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getDescription()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EAttribute getPolicyManagerPlan_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getOrigin()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EAttribute getPolicyManagerPlan_Origin();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getSourceCode()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EAttribute getPolicyManagerPlan_SourceCode();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getActionGroups <em>Action Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Action Groups</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getActionGroups()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EReference getPolicyManagerPlan_ActionGroups();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getCustomAttributes()
	 * @see #getPolicyManagerPlan()
	 * @generated
	 */
	EAttribute getPolicyManagerPlan_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getPolicyManagerPlan__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service#getServiceType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceType();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getCharacteristics <em>Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Characteristics</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service#getCharacteristics()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Characteristics();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Service#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Service#getCustomAttributes()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic <em>Service Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Characteristic</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic
	 * @generated
	 */
	EClass getServiceCharacteristic();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getName()
	 * @see #getServiceCharacteristic()
	 * @generated
	 */
	EAttribute getServiceCharacteristic_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getDescription()
	 * @see #getServiceCharacteristic()
	 * @generated
	 */
	EAttribute getServiceCharacteristic_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCharacteristicType <em>Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Characteristic Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCharacteristicType()
	 * @see #getServiceCharacteristic()
	 * @generated
	 */
	EAttribute getServiceCharacteristic_CharacteristicType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic#getCustomAttributes()
	 * @see #getServiceCharacteristic()
	 * @generated
	 */
	EAttribute getServiceCharacteristic_CustomAttributes();

	/**
	 * Returns the meta object for class '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getDescription()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Description();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getTransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Type</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getTransitionType()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_TransitionType();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getValue()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Value();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getCustomAttributes <em>Custom Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Attributes</em>'.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getCustomAttributes()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_CustomAttributes();

	/**
	 * Returns the meta object for the '{@link kr.ac.hanyang.oCamp.camp.pdp.Transition#getCustomAttribute(java.lang.String, java.lang.Class, boolean) <em>Get Custom Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Custom Attribute</em>' operation.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.Transition#getCustomAttribute(java.lang.String, java.lang.Class, boolean)
	 * @generated
	 */
	EOperation getTransition__GetCustomAttribute__String_Class_boolean();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" typeParameters="T T1"
	 * @generated
	 */
	EDataType getMap();

	/**
	 * Returns the meta object for data type '{@link org.apache.brooklyn.util.guava.Maybe <em>Maybe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Maybe</em>'.
	 * @see org.apache.brooklyn.util.guava.Maybe
	 * @model instanceClass="org.apache.brooklyn.util.guava.Maybe" typeParameters="T"
	 * @generated
	 */
	EDataType getMaybe();

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
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl <em>Abstract OCamp Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAbstractOCampPlan()
		 * @generated
		 */
		EClass ABSTRACT_OCAMP_PLAN = eINSTANCE.getAbstractOCampPlan();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN__NAME = eINSTANCE.getAbstractOCampPlan_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN__DESCRIPTION = eINSTANCE.getAbstractOCampPlan_Description();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN__ORIGIN = eINSTANCE.getAbstractOCampPlan_Origin();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN__SOURCE_CODE = eINSTANCE.getAbstractOCampPlan_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN__ARTIFACTS = eINSTANCE.getAbstractOCampPlan_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN__SERVICES = eINSTANCE.getAbstractOCampPlan_Services();

		/**
		 * The meta object literal for the '<em><b>Policies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_OCAMP_PLAN__POLICIES = eINSTANCE.getAbstractOCampPlan_Policies();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES = eINSTANCE.getAbstractOCampPlan_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_OCAMP_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getAbstractOCampPlan__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DESCRIPTION = eINSTANCE.getAction_Description();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__PROPERTY = eINSTANCE.getAction_Property();

		/**
		 * The meta object literal for the '<em><b>Action Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__ACTION_TYPE = eINSTANCE.getAction_ActionType();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__TRANSITIONS = eINSTANCE.getAction_Transitions();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__CUSTOM_ATTRIBUTES = eINSTANCE.getAction_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getAction__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl <em>Action Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getActionGroup()
		 * @generated
		 */
		EClass ACTION_GROUP = eINSTANCE.getActionGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP__NAME = eINSTANCE.getActionGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP__DESCRIPTION = eINSTANCE.getActionGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Action Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP__ACTION_ID = eINSTANCE.getActionGroup_ActionId();

		/**
		 * The meta object literal for the '<em><b>Action Group Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP__ACTION_GROUP_TYPE = eINSTANCE.getActionGroup_ActionGroupType();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_GROUP__ACTIONS = eINSTANCE.getActionGroup_Actions();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_GROUP__CUSTOM_ATTRIBUTES = eINSTANCE.getActionGroup_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_GROUP___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getActionGroup__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl <em>Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifact()
		 * @generated
		 */
		EClass ARTIFACT = eINSTANCE.getArtifact();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__NAME = eINSTANCE.getArtifact_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__DESCRIPTION = eINSTANCE.getArtifact_Description();

		/**
		 * The meta object literal for the '<em><b>Artifact Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__ARTIFACT_TYPE = eINSTANCE.getArtifact_ArtifactType();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT__CONTENT = eINSTANCE.getArtifact_Content();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT__REQUIREMENTS = eINSTANCE.getArtifact_Requirements();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifact_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentImpl <em>Artifact Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactContentImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactContent()
		 * @generated
		 */
		EClass ARTIFACT_CONTENT = eINSTANCE.getArtifactContent();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_CONTENT__HREF = eINSTANCE.getArtifactContent_Href();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_CONTENT__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifactContent_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementImpl <em>Artifact Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactRequirementImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getArtifactRequirement()
		 * @generated
		 */
		EClass ARTIFACT_REQUIREMENT = eINSTANCE.getArtifactRequirement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT__NAME = eINSTANCE.getArtifactRequirement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT__DESCRIPTION = eINSTANCE.getArtifactRequirement_Description();

		/**
		 * The meta object literal for the '<em><b>Requirement Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT__REQUIREMENT_TYPE = eINSTANCE.getArtifactRequirement_RequirementType();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT_REQUIREMENT__CUSTOM_ATTRIBUTES = eINSTANCE.getArtifactRequirement_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getDeploymentPlan()
		 * @generated
		 */
		EClass DEPLOYMENT_PLAN = eINSTANCE.getDeploymentPlan();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__NAME = eINSTANCE.getDeploymentPlan_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__DESCRIPTION = eINSTANCE.getDeploymentPlan_Description();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__ORIGIN = eINSTANCE.getDeploymentPlan_Origin();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__SOURCE_CODE = eINSTANCE.getDeploymentPlan_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__TYPE = eINSTANCE.getDeploymentPlan_Type();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__ARTIFACTS = eINSTANCE.getDeploymentPlan_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__SERVICES = eINSTANCE.getDeploymentPlan_Services();

		/**
		 * The meta object literal for the '<em><b>Policies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__POLICIES = eINSTANCE.getDeploymentPlan_Policies();

		/**
		 * The meta object literal for the '<em><b>Action Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__ACTION_GROUPS = eINSTANCE.getDeploymentPlan_ActionGroups();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_PLAN__CUSTOM_ATTRIBUTES = eINSTANCE.getDeploymentPlan_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEPLOYMENT_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getDeploymentPlan__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl <em>Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicy()
		 * @generated
		 */
		EClass POLICY = eINSTANCE.getPolicy();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__NAME = eINSTANCE.getPolicy_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__DESCRIPTION = eINSTANCE.getPolicy_Description();

		/**
		 * The meta object literal for the '<em><b>Policy Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__POLICY_TYPE = eINSTANCE.getPolicy_PolicyType();

		/**
		 * The meta object literal for the '<em><b>Policy Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY__POLICY_CONSTRAINTS = eINSTANCE.getPolicy_PolicyConstraints();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__TARGETS = eINSTANCE.getPolicy_Targets();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicy_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl <em>Policy Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyConstraint()
		 * @generated
		 */
		EClass POLICY_CONSTRAINT = eINSTANCE.getPolicyConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT__NAME = eINSTANCE.getPolicyConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT__DESCRIPTION = eINSTANCE.getPolicyConstraint_Description();

		/**
		 * The meta object literal for the '<em><b>Policy Constraint Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE = eINSTANCE.getPolicyConstraint_PolicyConstraintType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT__VALUE = eINSTANCE.getPolicyConstraint_Value();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicyConstraint_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl <em>Policy Manager Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getPolicyManagerPlan()
		 * @generated
		 */
		EClass POLICY_MANAGER_PLAN = eINSTANCE.getPolicyManagerPlan();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN__NAME = eINSTANCE.getPolicyManagerPlan_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN__DESCRIPTION = eINSTANCE.getPolicyManagerPlan_Description();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN__ORIGIN = eINSTANCE.getPolicyManagerPlan_Origin();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN__SOURCE_CODE = eINSTANCE.getPolicyManagerPlan_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Action Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLICY_MANAGER_PLAN__ACTION_GROUPS = eINSTANCE.getPolicyManagerPlan_ActionGroups();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY_MANAGER_PLAN__CUSTOM_ATTRIBUTES = eINSTANCE.getPolicyManagerPlan_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLICY_MANAGER_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getPolicyManagerPlan__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_TYPE = eINSTANCE.getService_ServiceType();

		/**
		 * The meta object literal for the '<em><b>Characteristics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__CHARACTERISTICS = eINSTANCE.getService_Characteristics();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__CUSTOM_ATTRIBUTES = eINSTANCE.getService_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl <em>Service Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getServiceCharacteristic()
		 * @generated
		 */
		EClass SERVICE_CHARACTERISTIC = eINSTANCE.getServiceCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC__NAME = eINSTANCE.getServiceCharacteristic_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC__DESCRIPTION = eINSTANCE.getServiceCharacteristic_Description();

		/**
		 * The meta object literal for the '<em><b>Characteristic Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE = eINSTANCE.getServiceCharacteristic_CharacteristicType();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES = eINSTANCE.getServiceCharacteristic_CustomAttributes();

		/**
		 * The meta object literal for the '{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__DESCRIPTION = eINSTANCE.getTransition_Description();

		/**
		 * The meta object literal for the '<em><b>Transition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__TRANSITION_TYPE = eINSTANCE.getTransition_TransitionType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__VALUE = eINSTANCE.getTransition_Value();

		/**
		 * The meta object literal for the '<em><b>Custom Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__CUSTOM_ATTRIBUTES = eINSTANCE.getTransition_CustomAttributes();

		/**
		 * The meta object literal for the '<em><b>Get Custom Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSITION___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN = eINSTANCE.getTransition__GetCustomAttribute__String_Class_boolean();

		/**
		 * The meta object literal for the '<em>Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getMap()
		 * @generated
		 */
		EDataType MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em>Maybe</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.brooklyn.util.guava.Maybe
		 * @see kr.ac.hanyang.oCamp.camp.pdp.impl.PdpPackageImpl#getMaybe()
		 * @generated
		 */
		EDataType MAYBE = eINSTANCE.getMaybe();

	}

} //PdpPackage
