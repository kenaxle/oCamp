package kr.ac.hanyang.oCamp.entities.policies.objs;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.config.ConfigBag;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;
import kr.ac.hanyang.oCamp.entities.transitions.Transition;

@ImplementedBy(ActionGroupImpl.class)
public interface ActionGroup extends kr.ac.hanyang.oCamp.api.objs.ActionGroup{
	
	@SetFromFlag("action.id")
	ConfigKey<Effector> ACTION_ID = ConfigKeys.newConfigKey(Effector.class,"action.id","represents the ID of the action");
	
	public static final BasicNotificationSensor<Effector> ACTION_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "action.set", "The action was set");
	
	public static final BasicNotificationSensor<Action> ACTION_ADDED = new BasicNotificationSensor<Action>(
			Action.class, "transition.added", "The transition was added");
	
	public static final BasicNotificationSensor<Action> ACTION_REMOVED = new BasicNotificationSensor<Action>(
			Action.class, "transition.removed", "The transition was removed");
	
	
//	public void setAction(Effector action);
//	public Effector getAction();
	
	public boolean addAction(Action action);
	public boolean removeAction(Action action);
	
}
