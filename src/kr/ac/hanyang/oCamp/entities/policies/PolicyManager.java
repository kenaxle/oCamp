package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.config.ConfigBag;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import com.google.common.reflect.TypeToken;

import kr.ac.hanyang.oCamp.api.objs.Action;
import kr.ac.hanyang.oCamp.api.objs.ActionGroup;
import kr.ac.hanyang.oCamp.api.transition.Transition;
import kr.ac.hanyang.oCamp.api.policy.Policy;
import kr.ac.hanyang.oCamp.entities.IDeployable.DeployEffectorBody;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroupImpl;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionImpl;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployOn;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;
import kr.ac.hanyang.oCamp.entities.transitions.InitialImpl;
import kr.ac.hanyang.oCamp.entities.transitions.SetImpl;

@ImplementedBy(PolicyManagerImpl.class)
public interface PolicyManager extends kr.ac.hanyang.oCamp.api.policyManager.PolicyManager{
	
	public static final Sensor<Policy> POLICY_ADDED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.added", "The policy was added");
	
	public static final Sensor<Policy> POLICY_REMOVED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.removed", "The policy was removed");
	
	public static final Sensor<Object> ACTIONGROUPS_SET = new BasicNotificationSensor<Object>(
			Object.class, "policy.removed", "The policy was removed");
	
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
						}});
						add(new ActionImpl(){{ 
							setProperty(SoftwareProcess.PROVISIONING_LOCATION);
							addTransitions(new ArrayList<Transition>(){{
								add(new InitialImpl(){{	setValue(null);							}});
								add(new SetImpl(){{	    setValue(Optional.of(Object.class));	}});
							}});
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
	
	//private MutableMap policy = ;
//	org.apache.brooklyn.api.effector.Effector<Void> ACTION_EFFECTOR = Effectors.effector(new MethodEffector<Void>(PolicyManagerImpl.class, "action.effector"))
//	        .impl(new ActionBody())
//	        .build();	
//	
//	org.apache.brooklyn.api.effector.Effector<Void> STOP = Effectors.effector(new MethodEffector<Void>(ActionImpl.class, "stop"))
//	        .impl(new StopActionBody())
//	        .build();
//	
//	org.apache.brooklyn.api.effector.Effector<Void> MOVE = Effectors.effector(new MethodEffector<Void>(ActionImpl.class, "move"))
//	        .impl(new MoveActionBody())
//	        .build();
//	
	//public static final ActionGroup[] ACTIONGROUPS = {new ActionGroup.Builder("START").addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) Attributes.SERVICE_UP,"set_to",true).build())
//																					  .addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) SoftwareProcess.PROVISIONING_LOCATION,"obtained_from",null).build()) //FIXME
//																					  .build(),
//													  new ActionGroup.Builder("STOP").addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) Attributes.SERVICE_UP,"equals",false).build())
//													  								 .build()
//													  };
	
//	public boolean addPolicy(Policy policy);
//	
//	public boolean removePolicy(Policy policy);
//	
//	
	public List<ActionGroup> evaluateActions(Entity entity, Policy policy, Sensor sensor);
	
	public void doAction(Effector effector, Entity entity);
	
	
//	public static class ActionBody extends EffectorBody<Void> {
//			public static final ConfigKey<Effector> EFFECTOR = ConfigKeys.newConfigKey(Effector.class, "effector",
//	            "effector to be invoked on the entity.");
//	        public static final ConfigKey<Entity> ENTITY = ConfigKeys.newConfigKey(Entity.class, "entity",
//	                "entity the effector will be invoked on.");
//        @Override public Void call(ConfigBag parameters) {
//        	 parameters.put(EFFECTOR, (String)((IDeployOn)entity().getParent()).getContentUrl());
//             parameters.put(ENTITY, (String)((IDeployOn)entity().getParent()).getTarget());
//            return new MethodEffector<Void>(PolicyManagerImpl.class, "action.effector").call(entity(), parameters.getAllConfig());
//        }
//    }
//	
//	public static class StopActionBody extends EffectorBody<Void> {
//      @Override public Void call(ConfigBag parameters) {
//          return new MethodEffector<Void>(IPlacement.class, "stopaction").call(entity(), parameters.getAllConfig());
//      }
//    }
//	
//	public static class RestartActionBody extends EffectorBody<Void> {
//	      @Override public Void call(ConfigBag parameters) {
//	          return new MethodEffector<Void>(IPlacement.class, "restartaction").call(entity(), parameters.getAllConfig());
//	      }
//	}
//
//    org.apache.brooklyn.api.effector.Effector<Void> STARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "startaction"))
//    	.parameter(ActionBody.EFFECTOR)
//        .parameter(ActionBody.ENTITY)
//        .impl(new ActionBody())
//        .build();
    
//    org.apache.brooklyn.api.effector.Effector<Void> STOPACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "stopaction"))
//            .impl(new StartActionBody())
//            .build();
//    
//    org.apache.brooklyn.api.effector.Effector<Void> RESTARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "restartaction"))
//            .impl(new StartActionBody())
//            .build();
//    
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="startaction effector")
//    public void doAction(@EffectorParam(name="url") String url, @EffectorParam(name="target") String target);
    //void doAction();
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="stopaction effector")
//    void stopaction();
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="restartaction effector")
//    void restartaction();
    
	
}
