package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import com.google.common.reflect.TypeToken;
import kr.ac.hanyang.oCamp.api.transition.Transition;
import kr.ac.hanyang.oCamp.entities.policies.objs.Action;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroupImpl;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionImpl;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;
import kr.ac.hanyang.oCamp.entities.transitions.InitialImpl;
import kr.ac.hanyang.oCamp.entities.transitions.SetImpl;

@ImplementedBy(PolicyManagerImpl.class)
public interface PolicyManager extends kr.ac.hanyang.oCamp.api.policyManager.PolicyManager{
	
	public static final ConfigKey<Object> POLMGRTYPE = ConfigKeys.newConfigKey(Object.class,"policymanager.type","used only to get the policy manager type from the spec");
	
	public static final Sensor<Policy> POLICY_ADDED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.added", "The policy was added");
	
	public static final Sensor<Policy> POLICY_REMOVED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.removed", "The policy was removed");
	
	public static final Sensor<Object> ACTIONGROUPS_SET = new BasicNotificationSensor<Object>(
			Object.class, "actiongroups.set", "The actiongroups were set");
	
//	public static final Map<String, Object> DEFAULT_ACTIONGROUPS = MutableMap.builder().put("actionGroups", MutableList.builder().add(MutableMap.of));
	//public static final Map<String, Object> DEFAULT_ACTIONGROUPS = MutableMap.of(               "actionGroups", 
//																   MutableList.of(MutableMap.of(   "id","START",
//																								   "actions",
//																				  MutableList.of(            ))));
//	
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
	
	
	
	
	@SetFromFlag("actiongroups")
	ConfigKey<List<ActionGroup>> ACTIONGROUPS = ConfigKeys.newConfigKey(new TypeToken<List<ActionGroup>>(){ },
			"actiongroups","represents the list of actiongroups",
			new ArrayList<ActionGroup>(){{
				add(new ActionGroupImpl(){{	
					setActionID(Startable.START); 
					setActions(new ArrayList<Action>(){{ 
						add(new ActionImpl(){{ 
							setProperty(Attributes.SERVICE_UP);
							addTransitions(new ArrayList<Transition>(){{
								add(new InitialImpl(){{	setValue(new Boolean(false));	}});
								add(new SetImpl(){{	    setValue(new Boolean(true));	}});
							}});
							setConfig(null);
						}});
						add(new ActionImpl(){{ 
							setProperty(SoftwareProcess.PROVISIONING_LOCATION);
							addTransitions(new ArrayList<Transition>(){{
								add(new InitialImpl(){{	setValue(null);							}});
								add(new SetImpl(){{	    setValue(Optional.of(Object.class));	}});
							}});
							//setConfig();
						}});
					}});
				}});
				add(new ActionGroupImpl(){{	
					setActionID(Startable.STOP); 
					setActions(new ArrayList<Action>(){{ 
						add(new ActionImpl(){{ 
							setProperty(Attributes.SERVICE_UP);
							addTransitions(new ArrayList<Transition>(){{
								add(new InitialImpl(){{	setValue(new Boolean(true));	}});
								add(new SetImpl(){{	    setValue(new Boolean(false));	}});
							}});
						}});
						add(new ActionImpl(){{ 
							setProperty(SoftwareProcess.PROVISIONING_LOCATION);
							addTransitions(new ArrayList<Transition>(){{
								add(new InitialImpl(){{	setValue(Optional.of(Object.class));	}});
								add(new SetImpl(){{	    setValue(null);							}});
							}});
						}});
					}});
				}});
			}});

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
	

	public List<ActionGroup> evaluateActions(Entity entity, Policy policy, Sensor sensor);
	
	public void doAction(Effector effector, Entity entity);
	
	public boolean addOCampPolicy(Policy policy);	
	public boolean removeOCampPolicy(Policy policy);
	
	public boolean setActionGroups(List<ActionGroup> actionGroups);
	

}
