/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristic;

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
 * An implementation of the model object '<em><b>Service Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl#getCharacteristicType <em>Characteristic Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ServiceCharacteristicImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceCharacteristicImpl extends MinimalEObjectImpl.Container implements ServiceCharacteristic {
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
	 * The default value of the '{@link #getCharacteristicType() <em>Characteristic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicType()
	 * @generated
	 * @ordered
	 */
	protected static final String CHARACTERISTIC_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCharacteristicType() <em>Characteristic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicType()
	 * @generated
	 * @ordered
	 */
	protected String characteristicType = CHARACTERISTIC_TYPE_EDEFAULT;

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
	protected ServiceCharacteristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.SERVICE_CHARACTERISTIC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.SERVICE_CHARACTERISTIC__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCharacteristicType() {
		return characteristicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacteristicType(String newCharacteristicType) {
		String oldCharacteristicType = characteristicType;
		characteristicType = newCharacteristicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE, oldCharacteristicType, characteristicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getCustomAttributes() {
		if (customAttributes == null) {
			customAttributes = new EcoreEMap<String,Object>(PdpPackage.Literals.STRING_TO_EOBJECT_MAP, StringToEObjectMapImpl.class, this, PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES);
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
			case PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.SERVICE_CHARACTERISTIC__NAME:
				return getName();
			case PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION:
				return getDescription();
			case PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE:
				return getCharacteristicType();
			case PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.SERVICE_CHARACTERISTIC__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE:
				setCharacteristicType((String)newValue);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.SERVICE_CHARACTERISTIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE:
				setCharacteristicType(CHARACTERISTIC_TYPE_EDEFAULT);
				return;
			case PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.SERVICE_CHARACTERISTIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.SERVICE_CHARACTERISTIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.SERVICE_CHARACTERISTIC__CHARACTERISTIC_TYPE:
				return CHARACTERISTIC_TYPE_EDEFAULT == null ? characteristicType != null : !CHARACTERISTIC_TYPE_EDEFAULT.equals(characteristicType);
			case PdpPackage.SERVICE_CHARACTERISTIC__CUSTOM_ATTRIBUTES:
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
		result.append(", characteristicType: ");
		result.append(characteristicType);
		result.append(')');
		return result.toString();
	}

} //ServiceCharacteristicImpl
