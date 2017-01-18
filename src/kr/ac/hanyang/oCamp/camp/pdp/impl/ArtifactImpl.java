/**
 */
package kr.ac.hanyang.oCamp.camp.pdp.impl;

import java.util.Collection;
import kr.ac.hanyang.oCamp.camp.pdp.Artifact;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactContent;
import kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement;
import kr.ac.hanyang.oCamp.camp.pdp.PdpPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl#getArtifactType <em>Artifact Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl#getContent <em>Content</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.impl.ArtifactImpl#getRequirements <em>Requirements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArtifactImpl extends MinimalEObjectImpl.Container implements Artifact {
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
	 * The default value of the '{@link #getArtifactType() <em>Artifact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactType()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifactType() <em>Artifact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactType()
	 * @generated
	 * @ordered
	 */
	protected String artifactType = ARTIFACT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected ArtifactContent content;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<ArtifactRequirement> requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdpPackage.Literals.ARTIFACT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ARTIFACT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ARTIFACT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArtifactType() {
		return artifactType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactType(String newArtifactType) {
		String oldArtifactType = artifactType;
		artifactType = newArtifactType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ARTIFACT__ARTIFACT_TYPE, oldArtifactType, artifactType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactContent getContent() {
		if (content != null && content.eIsProxy()) {
			InternalEObject oldContent = (InternalEObject)content;
			content = (ArtifactContent)eResolveProxy(oldContent);
			if (content != oldContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PdpPackage.ARTIFACT__CONTENT, oldContent, content));
			}
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactContent basicGetContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(ArtifactContent newContent) {
		ArtifactContent oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdpPackage.ARTIFACT__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArtifactRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectResolvingEList<ArtifactRequirement>(ArtifactRequirement.class, this, PdpPackage.ARTIFACT__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdpPackage.ARTIFACT__NAME:
				return getName();
			case PdpPackage.ARTIFACT__DESCRIPTION:
				return getDescription();
			case PdpPackage.ARTIFACT__ARTIFACT_TYPE:
				return getArtifactType();
			case PdpPackage.ARTIFACT__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
			case PdpPackage.ARTIFACT__REQUIREMENTS:
				return getRequirements();
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
			case PdpPackage.ARTIFACT__NAME:
				setName((String)newValue);
				return;
			case PdpPackage.ARTIFACT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PdpPackage.ARTIFACT__ARTIFACT_TYPE:
				setArtifactType((String)newValue);
				return;
			case PdpPackage.ARTIFACT__CONTENT:
				setContent((ArtifactContent)newValue);
				return;
			case PdpPackage.ARTIFACT__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends ArtifactRequirement>)newValue);
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
			case PdpPackage.ARTIFACT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdpPackage.ARTIFACT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PdpPackage.ARTIFACT__ARTIFACT_TYPE:
				setArtifactType(ARTIFACT_TYPE_EDEFAULT);
				return;
			case PdpPackage.ARTIFACT__CONTENT:
				setContent((ArtifactContent)null);
				return;
			case PdpPackage.ARTIFACT__REQUIREMENTS:
				getRequirements().clear();
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
			case PdpPackage.ARTIFACT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdpPackage.ARTIFACT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PdpPackage.ARTIFACT__ARTIFACT_TYPE:
				return ARTIFACT_TYPE_EDEFAULT == null ? artifactType != null : !ARTIFACT_TYPE_EDEFAULT.equals(artifactType);
			case PdpPackage.ARTIFACT__CONTENT:
				return content != null;
			case PdpPackage.ARTIFACT__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
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
		result.append(", artifactType: ");
		result.append(artifactType);
		result.append(')');
		return result.toString();
	}

} //ArtifactImpl
