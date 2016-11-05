package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import com.google.common.reflect.TypeToken;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;

@ImplementedBy(PolicyImpl.class)
public interface Policy extends kr.ac.hanyang.oCamp.api.policy.Policy {

	@SetFromFlag("constraints")
	public static final ConfigKey<List<Constraint>> CONSTRAINTS = ConfigKeys.newConfigKey(new TypeToken<List<Constraint>>(){ },"constraints","represents the ID of the action");
	
	@SetFromFlag("targets")
	public static final ConfigKey<List<Entity>> TARGETS = ConfigKeys.newConfigKey(new TypeToken<List<Entity>>(){ },"targets","represents the list of actiongroups");	
	
	public static final Sensor<Object> POLICY_VIOLATED = new BasicNotificationSensor<Object>(
            Object.class, "policy.violated", "The policy was violated");
	
	public static final Sensor<Object> CONSTRAINTS_INIT = new BasicNotificationSensor<Object>(
			Object.class, "constraint.init", "initialized the constraints.");
	
	public static final Sensor<Object> SUBSCRIBERS_SET = new BasicNotificationSensor<Object>(
			Object.class, "subscriber.set", "The list of entities was set");
	
	public static final String BASE_PLACEMENT_TYPE = "- type: kr.ac.hanyang.oCamp.entities.policies.PolicyManager\n"
			  										+"  constraints:\n";
	
	public static final String BASE_PLACEMENT_SETTINGS = "  - property: SERVICE_UP\n"
													    +"    type: kr.ac.hanyang.oCamp.entities.constraints.EqualTo\n"
													    +"    value: true\n"
													    +"  - property: PROVISIONING_LOCATION\n"
													    +"    type: kr.ac.hanyang.oCamp.entities.constraints.Within\n"
													    +"    value: []\n";
	
	public static final String BASE_PLACEMENT_POLICY = BASE_PLACEMENT_TYPE
													  +BASE_PLACEMENT_SETTINGS 
			  										  +"  targets: []";
}
