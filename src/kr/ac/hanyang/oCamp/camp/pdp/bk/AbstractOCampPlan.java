package kr.ac.hanyang.oCamp.camp.pdp.bk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.ac.hanyang.oCamp.camp.pdp.Artifact;
import kr.ac.hanyang.oCamp.camp.pdp.Service;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.javalang.JavaClassNames;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @model kind="class"
 */
public class AbstractOCampPlan {//extends  org.apache.brooklyn.camp.spi.pdp.DeploymentPlan{
	
	String name;
	String origin;
	String description;
	String sourceCode;
	List<Artifact> artifacts;
	List<Service> services;
	List<Policy> policies;
	Map<String,Object> customAttributes;
		   
	   
    @SuppressWarnings("unchecked")
    public static AbstractOCampPlan of(Map<String,Object> root, String optionalSourceCode) {
        Map<String,Object> attrs = MutableMap.copyOf(root);
        
        AbstractOCampPlan result = new AbstractOCampPlan();
        result.name = (String) attrs.remove("name");
        result.description = (String) attrs.remove("description");
        result.origin = (String) attrs.remove("origin");
        result.sourceCode = optionalSourceCode;
        // TODO version
        
        result.services = new ArrayList<Service>();
        Object services = attrs.remove("services");
        if (services instanceof Iterable) {
            for (Object service: (Iterable<Object>)services) {
                if (service instanceof Map) {
                    result.services.add(Service.of((Map<String,Object>) service));
                } else {
                    throw new UserFacingException("Services list should have a map for each entry, not "+JavaClassNames.superSimpleClassName(service));
                }
            }
        } else if (services!=null) {
            // TODO "map" short form
            throw new UserFacingException("Services block should be a list, not "+JavaClassNames.superSimpleClassName(services));
        }
        
        result.artifacts = new ArrayList<Artifact>();
        Object artifacts = attrs.remove("artifacts");
        if (artifacts instanceof Iterable) {
            for (Object artifact: (Iterable<Object>)artifacts) {
                if (artifact instanceof Map) {
                    result.artifacts.add(Artifact.of((Map<String,Object>) artifact));
                } else {
                    throw new UserFacingException("Artifacts list should contain map items, not "+JavaClassNames.superSimpleClassName(artifact));
                }
            }
        } else if (artifacts!=null) {
            // TODO "map" short form
            throw new UserFacingException("Artifacts block should contain a list, not "+JavaClassNames.superSimpleClassName(artifacts));
        }
        
        result.policies = new ArrayList<Policy>();
        Object policies = attrs.remove("policies");
        if (policies instanceof Iterable) {
            for (Object policy: (Iterable<Object>)policies) {
                if (policy instanceof Map) {
                    result.policies.add(Policy.of((Map<String,Object>) policy));
                } else {
                    throw new UserFacingException("Policies list should contain map items, not "+JavaClassNames.superSimpleClassName(policy));
                }
            }
        } else if (policies!=null) {
            // TODO "map" short form
            throw new UserFacingException("Policies block should contain a list, not "+JavaClassNames.superSimpleClassName(policies));
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
    public List<Artifact> getArtifacts() {
        return MutableList.copyOf(artifacts).asUnmodifiable();
    }

    /**
     * @model 
     */
    public List<Service> getServices() {
        return MutableList.copyOf(services).asUnmodifiable();
    }
  
    /**
     * @model
     */
    public List<Policy> getPolicies() {
        return MutableList.copyOf(policies).asUnmodifiable();
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
