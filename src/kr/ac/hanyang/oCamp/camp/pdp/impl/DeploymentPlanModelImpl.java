/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;

import kr.ac.hanyang.oCamp.camp.pdp.ActionGroupModel;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Plan Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl#getType <em>Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.DeploymentPlanModelImpl#getActionGroups <em>Action Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeploymentPlanModelImpl extends AbstractOCampPlanModelImpl implements DeploymentPlanModel {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActionGroups() <em>Action Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionGroupModel> actionGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentPlanModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.DEPLOYMENT_PLAN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.DEPLOYMENT_PLAN_MODEL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionGroupModel> getActionGroups() {
		if (actionGroups == null) {
			actionGroups = new EObjectContainmentEList<ActionGroupModel>(ActionGroupModel.class, this, PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS);
		}
		return actionGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS:
				return ((InternalEList<?>)getActionGroups()).basicRemove(otherEnd, msgs);
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
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__TYPE:
				return getType();
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS:
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
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__TYPE:
				setType((String)newValue);
				return;
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS:
				getActionGroups().clear();
				getActionGroups().addAll((Collection<? extends ActionGroupModel>)newValue);
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
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS:
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
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case PdpPackage.DEPLOYMENT_PLAN_MODEL__ACTION_GROUPS:
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DeploymentPlanModelImpl
