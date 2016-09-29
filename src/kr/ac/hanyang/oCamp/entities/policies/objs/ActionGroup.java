package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.Collection;
import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import com.google.common.reflect.TypeToken;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;

@ImplementedBy(ActionGroupImpl.class)
public interface ActionGroup extends kr.ac.hanyang.oCamp.api.objs.ActionGroup, Entity{
	
	@SetFromFlag("actionId")
	public static final ConfigKey<Effector> ACTION_ID = ConfigKeys.newConfigKey(Effector.class,"actionId","represents the ID of the action");
	
//	@SetFromFlag("actions")
//	public static final ConfigKey<List<Action>> ACTIONS = ConfigKeys.newConfigKey(new TypeToken<List<Action>>(){ },"actions","represents the list of actions");	
	
	public static final Sensor<Effector> ACTION_ID_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "actionID.set", "The actionID was set");
	
//	public static final Sensor<Object> ACTIONS_ADDED = new BasicNotificationSensor<Object>(
//			Object.class, "actions.added", "The actions were added");
	
	public boolean setActionID(Effector actionEffector);	
	//public boolean removeActionID(Effector actionEffector);
	
	//public boolean setActions(List<Action> actions);
	//public boolean removeAction(Action action);
	
	public int canFulfill(Collection<ConstraintVector> violatedConstraints);
	
	public Effector getActionEffector();
	
	public void setWeight(int weight);
	public int getWeight();

}
