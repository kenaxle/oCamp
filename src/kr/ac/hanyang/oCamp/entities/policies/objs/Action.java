package kr.ac.hanyang.oCamp.entities.policies.objs;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@ImplementedBy(ActionImpl.class)
public interface Action extends kr.ac.hanyang.oCamp.api.objs.Action, Entity{
	
	@SetFromFlag("property")
	ConfigKey<Sensor> PROPERTY = ConfigKeys.newConfigKey(Sensor.class,"property","represents the property that was sensed");

	public static final Sensor<Effector> PROPERTY_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "property.set", "The property was set");
	
	
}
