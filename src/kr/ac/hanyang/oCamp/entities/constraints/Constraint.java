package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@ImplementedBy(ConstraintImpl.class)
public interface Constraint<T> extends kr.ac.hanyang.oCamp.api.policy.Constraint{
	
	public static final BasicNotificationSensor<Entity> CONSTRAINT_VIOLATED = new BasicNotificationSensor<Entity>(
	            Entity.class, "constraint.was.violated", "The constraint was violated");
	
	public static final BasicNotificationSensor<Sensor> PROPERTY_SET = new BasicNotificationSensor<Sensor>(
            Sensor.class, "property.set", "The property sensor was set");
	
	public static final BasicNotificationSensor<Object> VALUE_SET = new BasicNotificationSensor<Object>(
            Object.class, "value.set", "The desired value was violated");
	
	@SetFromFlag("property")
	public static final ConfigKey<Sensor> PROPERTY = ConfigKeys.newConfigKey(Sensor.class,"property","represents the property of the constraint");
	
	@SetFromFlag("value")
	public static final ConfigKey<Object> VALUE = ConfigKeys.newConfigKey(Object.class,"value","represents the desired value of the constraint");
	
	
}
