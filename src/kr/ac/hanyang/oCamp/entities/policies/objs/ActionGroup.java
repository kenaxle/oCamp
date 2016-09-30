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
		
	public static final Sensor<Effector> ACTION_ID_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "actionID.set", "The actionID was set");

}
