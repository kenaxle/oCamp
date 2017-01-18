/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl#getPolicyConstraints <em>Policy Constraints</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyImpl extends MinimalEObjectImpl.Container implements Policy {
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
	 * The default value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyType()
	 * @generated
	 * @ordered
	 */
	protected static final String POLICY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyType()
	 * @generated
	 * @ordered
	 */
	protected String policyType = POLICY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPolicyConstraints() <em>Policy Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<PolicyConstraint> policyConstraints;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<String> targets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.POLICY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPolicyType() {
		return policyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyType(String newPolicyType) {
		String oldPolicyType = policyType;
		policyType = newPolicyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY__POLICY_TYPE, oldPolicyType, policyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PolicyConstraint> getPolicyConstraints() {
		if (policyConstraints == null) {
			policyConstraints = new EObjectResolvingEList<PolicyConstraint>(PolicyConstraint.class, this, PdpPackage.POLICY__POLICY_CONSTRAINTS);
		}
		return policyConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTargets() {
		if (targets == null) {
			targets = new EDataTypeUniqueEList<String>(String.class, this, PdpPackage.POLICY__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.POLICY__NAME:
				return getName();
			case PdpPackage.POLICY__DESCRIPTION:
				return getDescription();
			case PdpPackage.POLICY__POLICY_TYPE:
				return getPolicyType();
			case PdpPackage.POLICY__POLICY_CONSTRAINTS:
				return getPolicyConstraints();
			case PdpPackage.POLICY__TARGETS:
				return getTargets();
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
			case PdpPackage.POLICY__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.POLICY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.POLICY__POLICY_TYPE:
				setPolicyType((String)newValue);
				return;
			case PdpPackage.POLICY__POLICY_CONSTRAINTS:
				getPolicyConstraints().clear();
				getPolicyConstraints().addAll((Collection<? extends PolicyConstraint>)newValue);
				return;
			case PdpPackage.POLICY__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends String>)newValue);
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
			case PdpPackage.POLICY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.POLICY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.POLICY__POLICY_TYPE:
				setPolicyType(POLICY_TYPE_EDEFAULT);
				return;
			case PdpPackage.POLICY__POLICY_CONSTRAINTS:
				getPolicyConstraints().clear();
				return;
			case PdpPackage.POLICY__TARGETS:
				getTargets().clear();
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
			case PdpPackage.POLICY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.POLICY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.POLICY__POLICY_TYPE:
				return POLICY_TYPE_EDEFAULT == null ? policyType != null : !POLICY_TYPE_EDEFAULT.equals(policyType);
			case PdpPackage.POLICY__POLICY_CONSTRAINTS:
				return policyConstraints != null && !policyConstraints.isEmpty();
			case PdpPackage.POLICY__TARGETS:
				return targets != null && !targets.isEmpty();
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
		result.append(", policyType: ");
		result.append(policyType);
		result.append(", targets: ");
		result.append(targets);
		result.append(')');
		return result.toString();
	}

} //PolicyImpl
