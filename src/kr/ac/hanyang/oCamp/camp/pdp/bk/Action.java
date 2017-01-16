package kr.ac.hanyang.oCamp.camp.pdp.bk;

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

import kr.ac.hanyang.oCamp.camp.platform.oCampReserved;

/**
 * @model kind="class"
 */
public class Action {
	
	String name;
	String description;
	String actionType;
	String property;
	List<Transition> transitions;
	Map<String,Object> customAttributes;
		   
	   
    @SuppressWarnings("unchecked")
    public static Action of(Map<String,Object> root) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        Action result = new Action();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.actionType = oCampReserved.POLICY_PREFIX+"Action";
        result.property = (String) attrs.remove("property");
        // TODO version
        
        result.transitions = new ArrayList<Transition>();
        Object transitions = attrs.remove("transitions");
        if (transitions instanceof Iterable) {
            for (Object transition: (Iterable<Object>)transitions) {
                if (transition instanceof Map) {
                    result.transitions.add(Transition.of((Map<String,Object>) transition));
                } else {
                    throw new UserFacingException("Transitions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(transition));
                }
            }
        } else if (transitions!=null) {
            // TODO "map" short form
            throw new UserFacingException("Transitions block should be a list, not "+JavaClassNames.superSimpleClassName(transitions));
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
    public String getProperty() {
        return property;
    }
    
    /**
     * @model 
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * @model 
     */
    public List<Transition> getTransitions() {
        return MutableList.copyOf(transitions).asUnmodifiable();
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
