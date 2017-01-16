package kr.ac.hanyang.oCamp.camp.pdp.bk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * @model kind="class" 
 */
public class Service {
	String name;
    String description;
    String serviceType;
    
    List<ServiceCharacteristic> characteristics;
    
    Map<String,Object> customAttributes;
    
    @SuppressWarnings("unchecked")
    public static Service of(Map<String, Object> service) {
        Map<String,Object> fields = MutableMap.copyOf(service);
        
        Service result = new Service();
        result.name = (String) fields.remove("name");
        result.description = (String) fields.remove("description");
        // FIXME _type needed in lots of places
        result.serviceType = (String) Yamls.removeMultinameAttribute(fields, "service_type", "serviceType", "type");
        
        result.characteristics = new ArrayList<ServiceCharacteristic>();
        Object chars = fields.remove("characteristics");
        if (chars instanceof Iterable) {
            for (Object req: (Iterable<Object>)chars) {
                if (req instanceof Map) {
                    result.characteristics.add(ServiceCharacteristic.of((Map<String,Object>) req));
                } else {
                    throw new IllegalArgumentException("characteristics should be a map, not "+req.getClass());
                }
            }
        } else if (chars!=null) {
            // TODO "map" short form
            throw new IllegalArgumentException("services body should be iterable, not "+chars.getClass());
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
    public String getServiceType() {
        return serviceType;
    }
    
    /**
     * @model 
     */
    public List<ServiceCharacteristic> getCharacteristics() {
        return ImmutableList.copyOf(characteristics);
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
