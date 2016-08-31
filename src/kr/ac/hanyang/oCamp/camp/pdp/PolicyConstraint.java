package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicSensor;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class PolicyConstraint{
	String name;
    String description;
    String policyConstraintType;
    
    String property;
    
    List<String> targets;
    
    Map<String,Object> customAttributes;
    
    @SuppressWarnings("unchecked")
    public static PolicyConstraint of(Map<String, Object> policyConstraint) {
        Map<String,Object> fields = MutableMap.copyOf(policyConstraint);
        
        PolicyConstraint result = new PolicyConstraint();
        result.name = (String) fields.remove("name");
        result.description = (String) fields.remove("description");
        // FIXME _type needed in lots of places
        result.policyConstraintType = (String) Yamls.removeMultinameAttribute(fields, "constraint_type", "constraintType", "type");
        
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
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getPolicyConstraintType() {
        return policyConstraintType;
    }
    public List<String> getTargets() {
        return ImmutableList.copyOf(targets);
    }
    public Map<String, Object> getCustomAttributes() {
        return ImmutableMap.copyOf(customAttributes);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
