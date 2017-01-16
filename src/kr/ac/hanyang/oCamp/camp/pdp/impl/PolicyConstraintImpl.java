/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl#getPolicyConstraintType <em>Policy Constraint Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl#getValue <em>Value</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.PolicyConstraintImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicyConstraintImpl extends MinimalEObjectImpl.Container implements PolicyConstraint {
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
	 * The cached value of the '{@link #getCustomAttributes() <em>Custom Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomAttributes()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Object> customAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolicyConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.POLICY_CONSTRAINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE, oldPolicyConstraintType, policyConstraintType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Object> getCustomAttributes() {
		return customAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomAttributes(Map<String, Object> newCustomAttributes) {
		Map<String, Object> oldCustomAttributes = customAttributes;
		customAttributes = newCustomAttributes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES, oldCustomAttributes, customAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.POLICY_CONSTRAINT__NAME:
				return getName();
			case PdpPackage.POLICY_CONSTRAINT__DESCRIPTION:
				return getDescription();
			case PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE:
				return getPolicyConstraintType();
			case PdpPackage.POLICY_CONSTRAINT__VALUE:
				return getValue();
			case PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES:
				return getCustomAttributes();
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
			case PdpPackage.POLICY_CONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE:
				setPolicyConstraintType((String)newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT__VALUE:
				setValue(newValue);
				return;
			case PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES:
				setCustomAttributes((Map<String, Object>)newValue);
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
			case PdpPackage.POLICY_CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE:
				setPolicyConstraintType(POLICY_CONSTRAINT_TYPE_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES:
				setCustomAttributes((Map<String, Object>)null);
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
			case PdpPackage.POLICY_CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.POLICY_CONSTRAINT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.POLICY_CONSTRAINT__POLICY_CONSTRAINT_TYPE:
				return POLICY_CONSTRAINT_TYPE_EDEFAULT == null ? policyConstraintType != null : !POLICY_CONSTRAINT_TYPE_EDEFAULT.equals(policyConstraintType);
			case PdpPackage.POLICY_CONSTRAINT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case PdpPackage.POLICY_CONSTRAINT__CUSTOM_ATTRIBUTES:
				return customAttributes != null;
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
		result.append(", customAttributes: ");
		result.append(customAttributes);
		result.append(')');
		return result.toString();
	}

} //PolicyConstraintImpl
