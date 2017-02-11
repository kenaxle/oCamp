package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @model kind="class" 
 */
public class PolicyManagerPlan {
	
	String name;
	String origin;
	String description;
	String sourceCode;
	String policyManagerType;
	List<ActionGroup> actionGroups;
	Map<String,Object> customAttributes;
		   
	   
    @SuppressWarnings("unchecked")
    public static PolicyManagerPlan of(Map<String,Object> root, String optionalSourceCode) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        PolicyManagerPlan result = new PolicyManagerPlan();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.origin = (String) attrs.remove("origin");
        result.sourceCode = optionalSourceCode;
        result.policyManagerType = (String) Yamls.removeMultinameAttribute(attrs, "policyManager_type", "policyManagerType", "type");
        // TODO version
        
        result.actionGroups = new ArrayList<ActionGroup>();
        Object actionGroups = attrs.remove("actiongroups");
        if (actionGroups instanceof Iterable) {
            for (Object actionGroup: (Iterable<Object>)actionGroups) {
                if (actionGroup instanceof Map) {
                    result.actionGroups.add(ActionGroup.of((Map<String,Object>) actionGroup));
                } else {
                    throw new UserFacingException("ActionGroup list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(actionGroup));
                }
            }
        } else if (actionGroups!=null) {
            // TODO "map" short form
            throw new UserFacingException("ActionGroups block should be a list, not "+JavaClassNames.superSimpleClassName(actionGroups));
        }
        
        
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
    public String getOrigin() {
        return origin;
    }

    /**
     * @model 
     */
    public String getSourceCode() {
        return sourceCode;
    }
    
    /**
     * @model 
     */
    public List<ActionGroup> getActionGroups() {
        return MutableList.copyOf(actionGroups).asUnmodifiable();
    }

    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes() {
        return MutableMap.copyOf(customAttributes).asUnmodifiable();
    }

    /**
     * Returns a present {@link Maybe} of the custom attribute with the given name if the attribute is
     * non-null and is an instance of the given type. Otherwise returns absent.
     * <p/>
     * Does not remove the attribute from the custom attribute map.
     */
    /**
     * @model 
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

 
}
