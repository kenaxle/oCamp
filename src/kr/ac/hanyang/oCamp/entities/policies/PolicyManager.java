package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;

@ImplementedBy(PolicyManagerImpl.class)
public interface PolicyManager extends kr.ac.hanyang.oCamp.api.policyManager.PolicyManager{
	
	public static final ConfigKey<Object> POLMGRTYPE = ConfigKeys.newConfigKey(Object.class,"policymanager.type","used only to get the policy manager type from the spec");
	
	public static final Sensor<Policy> POLICY_ADDED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.added", "The policy was added");
	
	public static final Sensor<Policy> POLICY_REMOVED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.removed", "The policy was removed");
	
	public static final Sensor<Object> ACTIONGROUPS_SET = new BasicNotificationSensor<Object>(
			Object.class, "actiongroups.set", "The actiongroups were set");
	
	public static final String DEFAULT = "type: kr.ac.hanyang.oCamp.entities.policies.PolicyManager\n"
									   + "actiongroups:\n"
									   + "- id: START\n"
									   + "  actions:\n"
									   + "  - property: SERVICE_UP\n"
									   + "    transitions:\n"
									   + "    - type: Initial\n"
									   + "      value: false\n"
									   + "    - type: Set\n"
									   + "      value: true\n"
									   + "  - property: PROVISIONING_LOCATION\n"
									   + "    transitions:\n"
									   + "    - type: Initial\n"
									   + "      value: null\n"
									   + "    - type: Set\n"
									   + "      value: OPTIONAL\n"
									   + "- id: STOP\n"
									   + "  actions:\n"
									   + "  - property: SERVICE_UP\n"
									   + "    transitions:\n"
									   + "    - type: Initial\n"
									   + "      value: true\n"
									   + "    - type: Set\n"
									   + "      value: false\n"
									   + "  - property: PROVISIONING_LOCATION\n"
									   + "    transitions:\n"
									   + "    - type: Initial\n"
									   + "      value: OPTIONAL\n"
									   + "    - type: Set\n"
									   + "      value: null\n";
	
}
