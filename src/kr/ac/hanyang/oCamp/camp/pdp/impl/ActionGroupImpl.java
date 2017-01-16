/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.Action;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;

import org.apache.brooklyn.util.guava.Maybe;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getActionId <em>Action Id</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getActionGroupType <em>Action Group Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ActionGroupImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionGroupImpl extends MinimalEObjectImpl.Container implements ActionGroup {
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
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

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
	protected ActionGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.ACTION_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP__ACTION_ID, oldActionId, actionId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE, oldActionGroupType, actionGroupType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, PdpPackage.ACTION_GROUP__ACTIONS);
		}
		return actions;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ACTION_GROUP__CUSTOM_ATTRIBUTES, oldCustomAttributes, customAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 */
	@SuppressWarnings("unchecked")
	public <T> Maybe<T> getCustomAttribute(String attributeName, Class<T> type, boolean throwIfTypeMismatch) {
		Object attribute = customAttributes.get(attributeName);
        if (attribute == null) {
            return Maybe.absent("Custom attributes does not contain " + attributeName);
        } else if (!type.isAssignableFrom(attribute.getClass())) {
            String message = "Custom attribute " + attributeName + " is not of expected type: " +
                    "expected=" + type.getName() + " actual=" + attribute.getClass().getName();
            if (throwIfTypeMismatch) {
                throw new IllegalArgumentException(message);
            }
            return Maybe.absent(message);
        } else {
            return Maybe.of((T) attribute);
        }
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.ACTION_GROUP__NAME:
				return getName();
			case PdpPackage.ACTION_GROUP__DESCRIPTION:
				return getDescription();
			case PdpPackage.ACTION_GROUP__ACTION_ID:
				return getActionId();
			case PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE:
				return getActionGroupType();
			case PdpPackage.ACTION_GROUP__ACTIONS:
				return getActions();
			case PdpPackage.ACTION_GROUP__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP__ACTION_ID:
				setActionId((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE:
				setActionGroupType((String)newValue);
				return;
			case PdpPackage.ACTION_GROUP__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case PdpPackage.ACTION_GROUP__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP__ACTION_ID:
				setActionId(ACTION_ID_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE:
				setActionGroupType(ACTION_GROUP_TYPE_EDEFAULT);
				return;
			case PdpPackage.ACTION_GROUP__ACTIONS:
				getActions().clear();
				return;
			case PdpPackage.ACTION_GROUP__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ACTION_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.ACTION_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.ACTION_GROUP__ACTION_ID:
				return ACTION_ID_EDEFAULT == null ? actionId != null : !ACTION_ID_EDEFAULT.equals(actionId);
			case PdpPackage.ACTION_GROUP__ACTION_GROUP_TYPE:
				return ACTION_GROUP_TYPE_EDEFAULT == null ? actionGroupType != null : !ACTION_GROUP_TYPE_EDEFAULT.equals(actionGroupType);
			case PdpPackage.ACTION_GROUP__ACTIONS:
				return actions != null && !actions.isEmpty();
			case PdpPackage.ACTION_GROUP__CUSTOM_ATTRIBUTES:
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
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PdpPackage.ACTION_GROUP___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN:
				return getCustomAttribute((String)arguments.get(0), (Class)arguments.get(1), (Boolean)arguments.get(2));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", customAttributes: ");
		result.append(customAttributes);
		result.append(')');
		return result.toString();
	}

} //ActionGroupImpl
