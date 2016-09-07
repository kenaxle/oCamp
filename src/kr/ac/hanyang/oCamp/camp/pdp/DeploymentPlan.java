package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.javalang.JavaClassNames;

public class DeploymentPlan extends org.apache.brooklyn.camp.spi.pdp.DeploymentPlan {
	List<Policy> policies;
	
	
	public static DeploymentPlan of(Map<String,Object> root, String optionalSourceCode) {
		Map<String,Object> attrs = MutableMap.copyOf(root);
		DeploymentPlan result = new DeploymentPlan();
		result = (DeploymentPlan) org.apache.brooklyn.camp.spi.pdp.DeploymentPlan.of(root,optionalSourceCode);
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
        return result;
	}
	
	
	 public List<Policy> getPolicies() {
	        return MutableList.copyOf(policies).asUnmodifiable();
	    }
}
