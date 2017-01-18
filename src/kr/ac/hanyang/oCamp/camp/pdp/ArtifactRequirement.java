package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.ecore.EObject;

/**
 * @model 
 */
public interface ArtifactRequirement extends EObject {
//
//    String name;
//    String description;
//    String requirementType;
//    
//    Map<String,Object> customAttributes;
//    
//    public static ArtifactRequirement of(Map<String, Object> req) {
//        Map<String,Object> attrs = MutableMap.copyOf(req);
//        
//        ArtifactRequirement result = new ArtifactRequirement();
//        result.name = (String) attrs.remove("name");
//        result.description = (String) attrs.remove("description");
//        result.requirementType = (String) (String) Yamls.removeMultinameAttribute(attrs, "requirementType", "type");
//        
//        // TODO fulfillment
//        
//        result.customAttributes = attrs;
//        
//        return result;
//    }

    /**
     * @model
     */
    public String getName() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

				/**
     * @model
     */
    public String getDescription() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

				/**
     * @model
     */
    public String getRequirementType() ;
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.ArtifactRequirement#getRequirementType <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type</em>' attribute.
	 * @see #getRequirementType()
	 * @generated
	 */
	void setRequirementType(String value);

	
    @Override
    public String toString() ;

}
