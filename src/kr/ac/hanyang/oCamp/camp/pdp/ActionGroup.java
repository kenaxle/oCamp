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

public class ActionGroup {
	
	String name;
	String description;
	String actionGroupType;
	String actionId;
	List<Action> actions;
	Map<String,Object> customAttributes;
		   
	   
    @SuppressWarnings("unchecked")
    public static ActionGroup of(Map<String,Object> root) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        ActionGroup result = new ActionGroup();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.actionGroupType = (String) Yamls.removeMultinameAttribute(attrs, "actiongroup_type", "actionGroupType", "type");
        result.actionId = (String) Yamls.removeMultinameAttribute(attrs, "actiong_id", "actionId", "id");
        // TODO version
        
        result.actions = new ArrayList<Action>();
        Object actions = attrs.remove("actions");
        if (actions instanceof Iterable) {
            for (Object action: (Iterable<Object>)actions) {
                if (action instanceof Map) {
                    result.actions.add(Action.of((Map<String,Object>) action));
                } else {
                    throw new UserFacingException("Actions list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(action));
                }
            }
        } else if (actions!=null) {
            // TODO "map" short form
            throw new UserFacingException("Actions block should be a list, not "+JavaClassNames.superSimpleClassName(actions));
        }
        
        
        result.customAttributes = attrs;
        
        return result;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getActionId() {
        return actionId;
    }

    public List<Action> getActions() {
        return MutableList.copyOf(actions).asUnmodifiable();
    }

    public Map<String, Object> getCustomAttributes() {
        return MutableMap.copyOf(customAttributes).asUnmodifiable();
    }

    /**
     * Returns a present {@link Maybe} of the custom attribute with the given name if the attribute is
     * non-null and is an instance of the given type. Otherwise returns absent.
     * <p/>
     * Does not remove the attribute from the custom attribute map.
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
