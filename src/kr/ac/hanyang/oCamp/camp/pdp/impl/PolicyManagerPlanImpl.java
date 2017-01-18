/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyManagerPlan;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Manager Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getPolicyManagerType <em>Policy Manager Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyManagerPlanImpl#getActionGroups <em>Action Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyManagerPlanImpl extends MinimalEObjectImpl.Container implements PolicyManagerPlan {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceCode() <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceCode() <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCode()
	 * @generated
	 * @ordered
	 */
	protected String sourceCode = SOURCE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolicyManagerType() <em>Policy Manager Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyManagerType()
	 * @generated
	 * @ordered
	 */
	protected static final String POLICY_MANAGER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPolicyManagerType() <em>Policy Manager Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyManagerType()
	 * @generated
	 * @ordered
	 */
	protected String policyManagerType = POLICY_MANAGER_TYPE_EDEFAULT;

	
	/**
	 * The cached value of the '{@link #getActionGroups() <em>Action Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionGroup> actionGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyManagerPlanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.POLICY_MANAGER_PLAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MANAGER_PLAN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MANAGER_PLAN__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceCode(String newSourceCode) {
		String oldSourceCode = sourceCode;
		sourceCode = newSourceCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPolicyManagerType() {
		return policyManagerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyManagerType(String newPolicyManagerType) {
		String oldPolicyManagerType = policyManagerType;
		policyManagerType = newPolicyManagerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE, oldPolicyManagerType, policyManagerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionGroup> getActionGroups() {
		if (actionGroups == null) {
			actionGroups = new EObjectResolvingEList<ActionGroup>(ActionGroup.class, this, PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS);
		}
		return actionGroups;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.POLICY_MANAGER_PLAN__NAME:
				return getName();
			case PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION:
				return getDescription();
			case PdpPackage.POLICY_MANAGER_PLAN__ORIGIN:
				return getOrigin();
			case PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE:
				return getSourceCode();
			case PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE:
				return getPolicyManagerType();
			case PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS:
				return getActionGroups();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PdpPackage.POLICY_MANAGER_PLAN__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__ORIGIN:
				setOrigin((String)newValue);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE:
				setPolicyManagerType((String)newValue);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS:
				getActionGroups().clear();
				getActionGroups().addAll((Collection<? extends ActionGroup>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PdpPackage.POLICY_MANAGER_PLAN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE:
				setPolicyManagerType(POLICY_MANAGER_TYPE_EDEFAULT);
				return;
			case PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS:
				getActionGroups().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PdpPackage.POLICY_MANAGER_PLAN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.POLICY_MANAGER_PLAN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.POLICY_MANAGER_PLAN__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case PdpPackage.POLICY_MANAGER_PLAN__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
			case PdpPackage.POLICY_MANAGER_PLAN__POLICY_MANAGER_TYPE:
				return POLICY_MANAGER_TYPE_EDEFAULT == null ? policyManagerType != null : !POLICY_MANAGER_TYPE_EDEFAULT.equals(policyManagerType);
			case PdpPackage.POLICY_MANAGER_PLAN__ACTION_GROUPS:
				return actionGroups != null && !actionGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", origin: ");
		result.append(origin);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(", policyManagerType: ");
		result.append(policyManagerType);
		result.append(')');
		return result.toString();
	}

} //PolicyManagerPlanImpl
