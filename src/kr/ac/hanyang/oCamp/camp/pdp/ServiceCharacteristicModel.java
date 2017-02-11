/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Characteristic Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCharacteristicType <em>Characteristic Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCustomAttributes <em>Custom Attributes</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel()
 * @model
 * @generated
 */
public interface ServiceCharacteristicModel extends EObject {
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getName <em>Name</em>}' attribute.
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Characteristic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristic Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic Type</em>' attribute.
	 * @see #setCharacteristicType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel_CharacteristicType()
	 * @model
	 * @generated
	 */
	String getCharacteristicType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getCharacteristicType <em>Characteristic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characteristic Type</em>' attribute.
	 * @see #getCharacteristicType()
	 * @generated
	 */
	void setCharacteristicType(String value);

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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference.
	 * @see #setMember(ServiceModel)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getServiceCharacteristicModel_Member()
	 * @model containment="true"
	 * @generated
	 */
	ServiceModel getMember();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ServiceCharacteristicModel#getMember <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' containment reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(ServiceModel value);

} // ServiceCharacteristicModel
