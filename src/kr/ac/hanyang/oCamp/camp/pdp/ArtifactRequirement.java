package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class"
 */
public class ArtifactRequirement {

    String name;
    String description;
    String requirementType;
    
    Map<String,Object> customAttributes;
    
    public static ArtifactRequirement of(Map<String, Object> req) {
        Map<String,Object> attrs = MutableMap.copyOf(req);
        
        ArtifactRequirement result = new ArtifactRequirement();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.requirementType = (String) (String) Yamls.removeMultinameAttribute(attrs, "requirementType", "type");
        
        // TODO fulfillment
        
        result.customAttributes = attrs;
        
        return result;
    }

    /**
     * @model
     */
    public String getName() {
        return name;
    }
    
    /**
     * @model
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @model
     */
    public String getRequirementType() {
        return requirementType;
    }
    
    /**
     * @model
     */
    public Map<String, Object> getCustomAttributes() {
        return ImmutableMap.copyOf(customAttributes);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
