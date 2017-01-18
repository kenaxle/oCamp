/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.Transition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl#getTransitionType <em>Transition Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.TransitionImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
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
	 * The default value of the '{@link #getTransitionType() <em>Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionType()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSITION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransitionType() <em>Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionType()
	 * @generated
	 * @ordered
	 */
	protected String transitionType = TRANSITION_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.TRANSITION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.TRANSITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransitionType() {
		return transitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionType(String newTransitionType) {
		String oldTransitionType = transitionType;
		transitionType = newTransitionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.TRANSITION__TRANSITION_TYPE, oldTransitionType, transitionType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.TRANSITION__VALUE, oldValue, value));
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.TRANSITION__NAME:
				return getName();
			case PdpPackage.TRANSITION__DESCRIPTION:
				return getDescription();
			case PdpPackage.TRANSITION__TRANSITION_TYPE:
				return getTransitionType();
			case PdpPackage.TRANSITION__VALUE:
				return getValue();
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
			case PdpPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.TRANSITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.TRANSITION__TRANSITION_TYPE:
				setTransitionType((String)newValue);
				return;
			case PdpPackage.TRANSITION__VALUE:
				setValue(newValue);
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
			case PdpPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.TRANSITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.TRANSITION__TRANSITION_TYPE:
				setTransitionType(TRANSITION_TYPE_EDEFAULT);
				return;
			case PdpPackage.TRANSITION__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case PdpPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.TRANSITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.TRANSITION__TRANSITION_TYPE:
				return TRANSITION_TYPE_EDEFAULT == null ? transitionType != null : !TRANSITION_TYPE_EDEFAULT.equals(transitionType);
			case PdpPackage.TRANSITION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(", transitionType: ");
		result.append(transitionType);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
