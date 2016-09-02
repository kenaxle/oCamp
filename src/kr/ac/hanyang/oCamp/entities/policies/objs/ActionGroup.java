package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import kr.ac.hanyang.oCamp.api.objs.Action;
import com.google.common.reflect.TypeToken;

@ImplementedBy(ActionGroupImpl.class)
public interface ActionGroup extends kr.ac.hanyang.oCamp.api.objs.ActionGroup{
	
	@SetFromFlag("actionID")
	public static final ConfigKey<Effector> ACTION_ID = ConfigKeys.newConfigKey(Effector.class,"actionID","represents the ID of the action");
	
	@SetFromFlag("actions")
	public static final ConfigKey<List<Action>> ACTIONS = ConfigKeys.newConfigKey(new TypeToken<List<Action>>(){ },"actiongroups","represents the list of actiongroups");	
	
	public static final Sensor<Effector> ACTION_ID_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "actionID.set", "The actionID was set");
	
	public static final Sensor<Object> ACTIONS_ADDED = new BasicNotificationSensor<Object>(
			Object.class, "transition.added", "The transition was added");
	
//	public void setAction(Effector action);
//	public Effector getAction();

}
