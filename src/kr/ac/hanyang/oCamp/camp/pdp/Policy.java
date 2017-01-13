package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

// This class actually represents the policy manager that is responsible for 
// processing the policy in case of a violation. The type of the policy object
// refers to the type of the policy manager entity. 
/**
 * @model kind="class"
 */
public class Policy{

    String name;
    String description;
    String policyType;
    
    List<PolicyConstraint> policyConstraints;
    List<String> targets;
    
    Map<String,Object> customAttributes;
    
    @SuppressWarnings("unchecked")
    public static Policy of(Map<String, Object> policy) {
        Map<String,Object> fields = MutableMap.copyOf(policy);
        
        Policy result = new Policy();
        result.name = (String) fields.remove("name");
        result.description = (String) fields.remove("description");
        // FIXME _type needed in lots of places
        result.policyType = (String) Yamls.removeMultinameAttribute(fields, "policy_type", "policyType", "type");
        
        result.policyConstraints = new ArrayList<PolicyConstraint>();
        
        Object constraints = fields.remove("constraints");
        if (constraints instanceof Iterable) {
            for (Object constr: (Iterable<Object>)constraints) {
                if (constr instanceof Map) {
                    result.policyConstraints.add(PolicyConstraint.of((Map<String,Object>) constr));
                } else {
                    throw new IllegalArgumentException("characteristics should be a map, not "+constr.getClass());
                }
            }
        } else if (constraints!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("services body should be iterable, not "+constraints.getClass());
        }
        
        result.targets = new ArrayList<String>();
        
        Object targets = fields.remove("targets");
        if (targets instanceof Iterable) {
            for (Object target: (Iterable<Object>)targets) {
                if (target instanceof String) {
                    result.targets.add((String)target);
                } else {
                    throw new IllegalArgumentException("targets should be a String, not "+target.getClass());
                }
            }
        } else if (targets!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("targets body should be iterable, not "+targets.getClass());
        }
        result.customAttributes = fields;
        
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
    public String getPolicyType() {
        return policyType;
    }
    
    /**
     * @model 
     */
    public List<PolicyConstraint> getPolicyConstraints() {
        return ImmutableList.copyOf(policyConstraints);
    }
    
    /**
     * @model 
     */
    public List<String> getTargets() {
        return ImmutableList.copyOf(targets);
    }
    
    /**
     * @model 
     */
    public Map<String, Object> getCustomAttributes() {
        return ImmutableMap.copyOf(customAttributes);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    	
}

