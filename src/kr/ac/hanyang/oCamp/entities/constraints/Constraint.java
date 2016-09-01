package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.config.SetConfigKey;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@ImplementedBy(ConstraintImpl.class)
public interface Constraint<T> extends kr.ac.hanyang.oCamp.api.policy.Constraint{
	
	public static final BasicNotificationSensor<SensorEvent> CONSTRAINT_VIOLATED = new BasicNotificationSensor<SensorEvent>(
	            SensorEvent.class, "constraint.violated", "The constraint was violated");
	
	@SetFromFlag("property")
	ConfigKey<BasicAttributeSensor> PROPERTY = ConfigKeys.newConfigKey(BasicAttributeSensor.class,"property","represents the property of the constraint");
	
	@SetFromFlag("value")
	SetConfigKey<Object> VALUE = new SetConfigKey<Object>(Object.class,"value","represents the property of the constraint");
	
	public BasicAttributeSensor<?> getProperty();

	public T getValue();
	
	public void register(Entity entity);
	
	public void unregister(Entity entity);
	
	public boolean evaluate(SensorEvent event);
	
	public boolean isAlignedWith(Constraint constraint);
}
