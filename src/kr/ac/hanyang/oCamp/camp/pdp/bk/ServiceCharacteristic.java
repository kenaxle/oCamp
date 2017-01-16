package kr.ac.hanyang.oCamp.camp.pdp.bk;

import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class" 
 */
public class ServiceCharacteristic {
	String name;
    String description;
    String characteristicType;
    
    Map<String,Object> customAttributes;
    
    public static ServiceCharacteristic of(Map<String, Object> req) {
        Map<String,Object> attrs = MutableMap.copyOf(req);
        
        ServiceCharacteristic result = new ServiceCharacteristic();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.characteristicType = (String) Yamls.removeMultinameAttribute(attrs, "characteristicType", "type");
        
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
    public String getCharacteristicType() {
        return characteristicType;
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
