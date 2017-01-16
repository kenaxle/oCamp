package kr.ac.hanyang.oCamp.camp.pdp.bk;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class"
 */
public class ArtifactContent {
	String href;
    Map<String,Object> customAttributes;
    
    public static ArtifactContent of(Object spec) {
        if (spec==null) return null;
        
        ArtifactContent result = new ArtifactContent();
        if (spec instanceof String) {
            result.href = (String)spec;
        } else if (spec instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String,Object> attrs = MutableMap.copyOf( (Map<String,Object>) spec );
            result.href = (String) attrs.remove("href");
            result.customAttributes = attrs;            
        } else {
            throw new IllegalArgumentException("artifact content should be map or string, not "+spec.getClass());
        }
        
        return result;
    }

    /**
     * @model
     */
    public String getHref() {
        return href;
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
