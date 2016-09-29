package kr.ac.hanyang.oCamp.entities.policies;

import java.util.List;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
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
	
	

// FIXME no moveable exists				
//				add(new ActionGroupImpl(){{	setActionID(Startable.MOVE); 
//					addAction(new ActionImpl(){{ setProperty(Attributes.SERVICE_UP);
//						addTransition(new InitialImpl(){{	setValue(new Boolean(false));	}});
//						addTransition(new SetImpl(){{	    setValue(new Boolean(true));	}});
//					}});
//					addAction(new ActionImpl(){{ setProperty(SoftwareProcess.PROVISIONING_LOCATION);
//						addTransition(new InitialImpl(){{	setValue(Optional.of(Object.class));	}});
//						addTransition(new SetImpl(){{	    setValue(null);							}});
//					}});	
//				}});
//			}});
	
	// = new ActionGroupImpl();
	//public Set<ActionGroup> AGroups;// [];
	

	public List<ActionGroup> evaluateActions(Entity entity, Policy policy);
	
	public void doAction(Effector effector, Entity entity);
	
	public boolean addOCampPolicy(Policy policy);	
	public boolean removeOCampPolicy(Policy policy);
	
	//public boolean setActionGroups(List<ActionGroup> actionGroups);
	

}
