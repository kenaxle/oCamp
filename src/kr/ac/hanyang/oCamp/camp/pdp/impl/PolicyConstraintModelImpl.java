/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Constraint Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl#getPolicyConstraintType <em>Policy Constraint Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl#getValue <em>Value</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintModelImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyConstraintModelImpl extends MinimalEObjectImpl.Container implements PolicyConstraintModel {
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
	 * The default value of the '{@link #getPolicyConstraintType() <em>Policy Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyConstraintType()
	 * @generated
	 * @ordered
	 */
	protected static final String POLICY_CONSTRAINT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPolicyConstraintType() <em>Policy Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyConstraintType()
	 * @generated
	 * @ordered
	 */
	protected String policyConstraintType = POLICY_CONSTRAINT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

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
	protected PolicyConstraintModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.POLICY_CONSTRAINT_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT_MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPolicyConstraintType() {
		return policyConstraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyConstraintType(String newPolicyConstraintType) {
		String oldPolicyConstraintType = policyConstraintType;
		policyConstraintType = newPolicyConstraintType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE, oldPolicyConstraintType, policyConstraintType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT_MODEL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getCustomAttributes() {
		if (customAttributes == null) {
			customAttributes = new EcoreEMap<String,Object>(PdpPackage.Literals.STRING_TO_EOBJECT_MAP, StringToEObjectMapImpl.class, this, PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES);
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
			case PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.POLICY_CONSTRAINT_MODEL__NAME:
				return getName();
			case PdpPackage.POLICY_CONSTRAINT_MODEL__DESCRIPTION:
				return getDescription();
			case PdpPackage.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE:
				return getPolicyConstraintType();
			case PdpPackage.POLICY_CONSTRAINT_MODEL__VALUE:
				return getValue();
			case PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PdpPackage.POLICY_CONSTRAINT_MODEL__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE:
				setPolicyConstraintType((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__VALUE:
				setValue(newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.POLICY_CONSTRAINT_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE:
				setPolicyConstraintType(POLICY_CONSTRAINT_TYPE_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.POLICY_CONSTRAINT_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.POLICY_CONSTRAINT_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.POLICY_CONSTRAINT_MODEL__POLICY_CONSTRAINT_TYPE:
				return POLICY_CONSTRAINT_TYPE_EDEFAULT == null ? policyConstraintType != null : !POLICY_CONSTRAINT_TYPE_EDEFAULT.equals(policyConstraintType);
			case PdpPackage.POLICY_CONSTRAINT_MODEL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case PdpPackage.POLICY_CONSTRAINT_MODEL__CUSTOM_ATTRIBUTES:
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
		result.append(", policyConstraintType: ");
		result.append(policyConstraintType);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //PolicyConstraintModelImpl
