/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;

import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyModel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getPolicyType <em>Policy Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getPolicyConstraints <em>Policy Constraints</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyModelImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyModelImpl extends MinimalEObjectImpl.Container implements PolicyModel {
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
	 * The cached value of the '{@link #getPolicyConstraints() <em>Policy Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<PolicyConstraintModel> policyConstraints;

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
	 * The cached value of the '{@link #getCustomAttributes() <em>Custom Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomAttributes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> customAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.POLICY_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MODEL__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_MODEL__POLICY_TYPE, oldPolicyType, policyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PolicyConstraintModel> getPolicyConstraints() {
		if (policyConstraints == null) {
			policyConstraints = new EObjectContainmentEList<PolicyConstraintModel>(PolicyConstraintModel.class, this, PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS);
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
			targets = new EDataTypeUniqueEList<String>(String.class, this, PdpPackage.POLICY_MODEL__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getCustomAttributes() {
		if (customAttributes == null) {
			customAttributes = new EcoreEMap<String,Object>(PdpPackage.Literals.STRING_TO_EOBJECT_MAP, StringToEObjectMapImpl.class, this, PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES);
		}
		return customAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS:
				return ((InternalEList<?>)getPolicyConstraints()).basicRemove(otherEnd, msgs);
			case PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES:
				return ((InternalEList<?>)getCustomAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.POLICY_MODEL__NAME:
				return getName();
			case PdpPackage.POLICY_MODEL__DESCRIPTION:
				return getDescription();
			case PdpPackage.POLICY_MODEL__POLICY_TYPE:
				return getPolicyType();
			case PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS:
				return getPolicyConstraints();
			case PdpPackage.POLICY_MODEL__TARGETS:
				return getTargets();
			case PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES:
				if (coreType) return getCustomAttributes();
				else return getCustomAttributes().map();
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
			case PdpPackage.POLICY_MODEL__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.POLICY_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.POLICY_MODEL__POLICY_TYPE:
				setPolicyType((String)newValue);
				return;
			case PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS:
				getPolicyConstraints().clear();
				getPolicyConstraints().addAll((Collection<? extends PolicyConstraintModel>)newValue);
				return;
			case PdpPackage.POLICY_MODEL__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends String>)newValue);
				return;
			case PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES:
				((EStructuralFeature.Setting)getCustomAttributes()).set(newValue);
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
			case PdpPackage.POLICY_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.POLICY_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.POLICY_MODEL__POLICY_TYPE:
				setPolicyType(POLICY_TYPE_EDEFAULT);
				return;
			case PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS:
				getPolicyConstraints().clear();
				return;
			case PdpPackage.POLICY_MODEL__TARGETS:
				getTargets().clear();
				return;
			case PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES:
				getCustomAttributes().clear();
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
			case PdpPackage.POLICY_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.POLICY_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.POLICY_MODEL__POLICY_TYPE:
				return POLICY_TYPE_EDEFAULT == null ? policyType != null : !POLICY_TYPE_EDEFAULT.equals(policyType);
			case PdpPackage.POLICY_MODEL__POLICY_CONSTRAINTS:
				return policyConstraints != null && !policyConstraints.isEmpty();
			case PdpPackage.POLICY_MODEL__TARGETS:
				return targets != null && !targets.isEmpty();
			case PdpPackage.POLICY_MODEL__CUSTOM_ATTRIBUTES:
				return customAttributes != null && !customAttributes.isEmpty();
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

} //PolicyModelImpl
