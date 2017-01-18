package kr.ac.hanyang.oCamp.camp.pdp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model 
 */
public interface Artifact extends EObject {
//	String name;
//    String description;
//    String artifactType;
//    
//    ArtifactContent content;
//    List<ArtifactRequirement> requirements;
//    
//    Map<String,Object> customAttributes;
//    
//    @SuppressWarnings("unchecked")
//    public static Artifact of(Map<String, Object> artifact) {
//        Map<String,Object> fields = MutableMap.copyOf(artifact);
//        
//        Artifact result = new Artifact();
//        result.name = (String) fields.remove("name");
//        result.description = (String) fields.remove("description");
//        result.artifactType = (String) (String) Yamls.removeMultinameAttribute(fields, "artifactType", "type");
//        
//        result.content = ArtifactContent.of( fields.remove("content") );
//        
//        result.requirements = new ArrayList<ArtifactRequirement>();
//        Object reqs = fields.remove("requirements");
//        if (reqs instanceof Iterable) {
//            for (Object req: (Iterable<Object>)reqs) {
//                if (req instanceof Map) {
//                    result.requirements.add(ArtifactRequirement.of((Map<String,Object>) req));
//                } else {
//                    throw new IllegalArgumentException("requirement should be a map, not "+req.getClass());
//                }
//            }
//        } else if (reqs!=null) {
//            // TODO "map" short form
//            throw new IllegalArgumentException("artifacts body should be iterable, not "+reqs.getClass());
//        }
//        
//        result.customAttributes = fields;
//        
//        return result;
//    }
    
    /**
     * @model 
     */
    public String getName();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getName <em>Name</em>}' attribute.
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
    public String getDescription();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getDescription <em>Description</em>}' attribute.
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
    public String getArtifactType();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getArtifactType <em>Artifact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Type</em>' attribute.
	 * @see #getArtifactType()
	 * @generated
	 */
	void setArtifactType(String value);

				/**
     * @model 
     */
    public ArtifactContent getContent();
    
    /**
	 * Sets the value of the '{@link kr.ac.hanyang.oCamp.camp.pdp.Artifact#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(ArtifactContent value);

				/**
     * @model 
     */
    public EList<ArtifactRequirement> getRequirements() ;
    
    
    @Override
    public String toString() ;

}
