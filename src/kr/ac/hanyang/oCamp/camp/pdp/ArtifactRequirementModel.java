/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artifact Requirement Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getCustomAttributes <em>Custom Attributes</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getFulfillment <em>Fulfillment</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel()
 * @model
 * @generated
 */
public interface ArtifactRequirementModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Requirement Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Type</em>' attribute.
	 * @see #setRequirementType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel_RequirementType()
	 * @model
	 * @generated
	 */
	String getRequirementType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getRequirementType <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type</em>' attribute.
	 * @see #getRequirementType()
	 * @generated
	 */
	void setRequirementType(String value);

	/**
	 * Returns the value of the '<em><b>Custom Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Attributes</em>' map.
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

	/**
	 * Returns the value of the '<em><b>Fulfillment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fulfillment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fulfillment</em>' attribute.
	 * @see #setFulfillment(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getArtifactRequirementModel_Fulfillment()
	 * @model
	 * @generated
	 */
	String getFulfillment();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirementModel#getFulfillment <em>Fulfillment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fulfillment</em>' attribute.
	 * @see #getFulfillment()
	 * @generated
	 */
	void setFulfillment(String value);

} // ArtifactRequirementModel
