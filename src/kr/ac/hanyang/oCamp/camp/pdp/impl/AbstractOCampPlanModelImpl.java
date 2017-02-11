/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;

import kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlanModel;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactModel;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyModel;
import kr.ac.hanyang.oCamp.camp.pdp.ServiceModel;

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
 * An implementation of the model object '<em><b>Abstract OCamp Plan Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getServices <em>Services</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getPolicies <em>Policies</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanModelImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractOCampPlanModelImpl extends MinimalEObjectImpl.Container implements AbstractOCampPlanModel {
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
	 * The cached value of the '{@link #getArtifacts() <em>Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<ArtifactModel> artifacts;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceModel> services;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<PolicyModel> policies;

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
	protected AbstractOCampPlanModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.ABSTRACT_OCAMP_PLAN_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN, oldOrigin, origin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArtifactModel> getArtifacts() {
		if (artifacts == null) {
			artifacts = new EObjectContainmentEList<ArtifactModel>(ArtifactModel.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS);
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceModel> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<ServiceModel>(ServiceModel.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PolicyModel> getPolicies() {
		if (policies == null) {
			policies = new EObjectContainmentEList<PolicyModel>(PolicyModel.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES);
		}
		return policies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getCustomAttributes() {
		if (customAttributes == null) {
			customAttributes = new EcoreEMap<String,Object>(PdpPackage.Literals.STRING_TO_EOBJECT_MAP, StringToEObjectMapImpl.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES);
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS:
				return ((InternalEList<?>)getArtifacts()).basicRemove(otherEnd, msgs);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES:
				return ((InternalEList<?>)getPolicies()).basicRemove(otherEnd, msgs);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__NAME:
				return getName();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION:
				return getDescription();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN:
				return getOrigin();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE:
				return getSourceCode();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS:
				return getArtifacts();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES:
				return getServices();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES:
				return getPolicies();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN:
				setOrigin((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS:
				getArtifacts().clear();
				getArtifacts().addAll((Collection<? extends ArtifactModel>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends ServiceModel>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES:
				getPolicies().clear();
				getPolicies().addAll((Collection<? extends PolicyModel>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS:
				getArtifacts().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES:
				getServices().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES:
				getPolicies().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__ARTIFACTS:
				return artifacts != null && !artifacts.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__SERVICES:
				return services != null && !services.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__POLICIES:
				return policies != null && !policies.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN_MODEL__CUSTOM_ATTRIBUTES:
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
		result.append(", origin: ");
		result.append(origin);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(')');
		return result.toString();
	}

} //AbstractOCampPlanModelImpl
