/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.AbstractOCampPlan;
import kr.ac.hanyang.oCamp.camp.pdp.Artifact;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.Service;

import org.apache.brooklyn.util.guava.Maybe;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract OCamp Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getServices <em>Services</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getPolicies <em>Policies</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.AbstractOCampPlanImpl#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractOCampPlanImpl extends MinimalEObjectImpl.Container implements AbstractOCampPlan {
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
	 * The cached value of the '{@link #getArtifacts() <em>Artifacts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Artifact> artifacts;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<Policy> policies;

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
	protected AbstractOCampPlanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.ABSTRACT_OCAMP_PLAN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN__ORIGIN, oldOrigin, origin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Artifact> getArtifacts() {
		if (artifacts == null) {
			artifacts = new EObjectResolvingEList<Artifact>(Artifact.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN__ARTIFACTS);
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectResolvingEList<Service>(Service.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Policy> getPolicies() {
		if (policies == null) {
			policies = new EObjectResolvingEList<Policy>(Policy.class, this, PdpPackage.ABSTRACT_OCAMP_PLAN__POLICIES);
		}
		return policies;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES, oldCustomAttributes, customAttributes));
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN__NAME:
				return getName();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__DESCRIPTION:
				return getDescription();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ORIGIN:
				return getOrigin();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SOURCE_CODE:
				return getSourceCode();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ARTIFACTS:
				return getArtifacts();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SERVICES:
				return getServices();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__POLICIES:
				return getPolicies();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ORIGIN:
				setOrigin((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ARTIFACTS:
				getArtifacts().clear();
				getArtifacts().addAll((Collection<? extends Artifact>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__POLICIES:
				getPolicies().clear();
				getPolicies().addAll((Collection<? extends Policy>)newValue);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ARTIFACTS:
				getArtifacts().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SERVICES:
				getServices().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__POLICIES:
				getPolicies().clear();
				return;
			case PdpPackage.ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.ABSTRACT_OCAMP_PLAN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
			case PdpPackage.ABSTRACT_OCAMP_PLAN__ARTIFACTS:
				return artifacts != null && !artifacts.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__SERVICES:
				return services != null && !services.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__POLICIES:
				return policies != null && !policies.isEmpty();
			case PdpPackage.ABSTRACT_OCAMP_PLAN__CUSTOM_ATTRIBUTES:
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
			case PdpPackage.ABSTRACT_OCAMP_PLAN___GET_CUSTOM_ATTRIBUTE__STRING_CLASS_BOOLEAN:
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
		result.append(", origin: ");
		result.append(origin);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(", customAttributes: ");
		result.append(customAttributes);
		result.append(')');
		return result.toString();
	}

} //AbstractOCampPlanImpl
