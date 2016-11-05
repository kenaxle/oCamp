package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.common.collect.ImmutableMap;

public class PolicyConstraint{
	String name;
    String description;
    String policyConstraintType;
    
    String property;
    Object value;
    
    Map<String,Object> customAttributes;
    
    public static PolicyConstraint of(Map<String, Object> policyConstraint) {
        Map<String,Object> fields = MutableMap.copyOf(policyConstraint);
        
        PolicyConstraint result = new PolicyConstraint();
        result.name = (String) fields.remove("name");
        result.description = (String) fields.remove("description");
        // FIXME _type needed in lots of places
        result.policyConstraintType = (String) Yamls.removeMultinameAttribute(fields, "constraint_type", "constraintType", "type");
     
        result.value = fields.remove("value");    
        
        result.customAttributes = fields;
        
        return result;
    }
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getPolicyConstraintType() {
        return policyConstraintType;
    }
    public Object getValue() {
        return value;
    }
    public Map<String, Object> getCustomAttributes() {
        return ImmutableMap.copyOf(customAttributes);
    }
    
 

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
