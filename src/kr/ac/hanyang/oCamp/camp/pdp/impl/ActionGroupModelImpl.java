/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;

import kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel;
import kr.ac.hanyang.oCamp.camp.pdp.ActionModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Group Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getActionId <em>Action Id</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getActionGroupType <em>Action Group Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupModelImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionGroupModelImpl extends MinimalEObjectImpl.Container implements ActionGroupModel {
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
	 * The default value of the '{@link #getActionId() <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionId()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionId() <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionId()
	 * @generated
	 * @ordered
	 */
	protected String actionId = ACTION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionGroupType() <em>Action Group Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionGroupType()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_GROUP_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionGroupType() <em>Action Group Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionGroupType()
	 * @generated
	 * @ordered
	 */
	protected String actionGroupType = ACTION_GROUP_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionModel> actions;

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
	protected ActionGroupModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.ACTION_GROUP_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP_MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionId() {
		return actionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionId(String newActionId) {
		String oldActionId = actionId;
		actionId = newActionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP_MODEL__ACTION_ID, oldActionId, actionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionGroupType() {
		return actionGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionGroupType(String newActionGroupType) {
		String oldActionGroupType = actionGroupType;
		actionGroupType = newActionGroupType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE, oldActionGroupType, actionGroupType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionModel> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ActionModel>(ActionModel.class, this, PdpPackage.ACTION_GROUP_MODEL__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getCustomAttributes() {
		if (customAttributes == null) {
			customAttributes = new EcoreEMap<String,Object>(PdpPackage.Literals.STRING_TO_EOBJECT_MAP, StringToEObjectMapImpl.class, this, PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES);
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
			case PdpPackage.ACTION_GROUP_MODEL__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP_MODEL__NAME:
				return getName();
			case PdpPackage.ACTION_GROUP_MODEL__DESCRIPTION:
				return getDescription();
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_ID:
				return getActionId();
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE:
				return getActionGroupType();
			case PdpPackage.ACTION_GROUP_MODEL__ACTIONS:
				return getActions();
			case PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP_MODEL__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_ID:
				setActionId((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE:
				setActionGroupType((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ActionModel>)newValue);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_ID:
				setActionId(ACTION_ID_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE:
				setActionGroupType(ACTION_GROUP_TYPE_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP_MODEL__ACTIONS:
				getActions().clear();
				return;
			case PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.ACTION_GROUP_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_ID:
				return ACTION_ID_EDEFAULT == null ? actionId != null : !ACTION_ID_EDEFAULT.equals(actionId);
			case PdpPackage.ACTION_GROUP_MODEL__ACTION_GROUP_TYPE:
				return ACTION_GROUP_TYPE_EDEFAULT == null ? actionGroupType != null : !ACTION_GROUP_TYPE_EDEFAULT.equals(actionGroupType);
			case PdpPackage.ACTION_GROUP_MODEL__ACTIONS:
				return actions != null && !actions.isEmpty();
			case PdpPackage.ACTION_GROUP_MODEL__CUSTOM_ATTRIBUTES:
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
		result.append(", actionId: ");
		result.append(actionId);
		result.append(", actionGroupType: ");
		result.append(actionGroupType);
		result.append(')');
		return result.toString();
	}

} //ActionGroupModelImpl
