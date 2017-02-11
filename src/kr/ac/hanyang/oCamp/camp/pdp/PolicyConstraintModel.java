/**
 */
package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Policy Constraint Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getName <em>Name</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getDescription <em>Description</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getPolicyConstraintType <em>Policy Constraint Type</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getValue <em>Value</em>}</li>
 *   <li>{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getCustomAttributes <em>Custom Attributes</em>}</li>
 * </ul>
 *
 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel()
 * @model
 * @generated
 */
public interface PolicyConstraintModel extends EObject {
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getName <em>Name</em>}' attribute.
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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Policy Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Constraint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Constraint Type</em>' attribute.
	 * @see #setPolicyConstraintType(String)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel_PolicyConstraintType()
	 * @model
	 * @generated
	 */
	String getPolicyConstraintType();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getPolicyConstraintType <em>Policy Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Constraint Type</em>' attribute.
	 * @see #getPolicyConstraintType()
	 * @generated
	 */
	void setPolicyConstraintType(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraintModel#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

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
	 * @see kr.ac.hanyang.oCamp.camp.pdp.PdpPackage#getPolicyConstraintModel_CustomAttributes()
	 * @model mapType="kr.ac.hanyang.oCamp.camp.pdp.StringToEObjectMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	EMap<String, Object> getCustomAttributes();

} // PolicyConstraintModel
