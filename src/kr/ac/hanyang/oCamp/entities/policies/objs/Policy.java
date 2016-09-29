package kr.ac.hanyang.oCamp.entities.policies.objs;

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

import kr.ac.hanyang.oCamp.api.objs.Action;
import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;

@ImplementedBy(PolicyImpl.class)
public interface Policy extends kr.ac.hanyang.oCamp.api.policy.Policy {

	@SetFromFlag("constraints")
	public static final ConfigKey<List<Constraint>> CONSTRAINTS = ConfigKeys.newConfigKey(new TypeToken<List<Constraint>>(){ },"constraints","represents the ID of the action");
	
	@SetFromFlag("targets")
	public static final ConfigKey<List<Entity>> TARGETS = ConfigKeys.newConfigKey(new TypeToken<List<Entity>>(){ },"targets","represents the list of actiongroups");	
	
	public static final Sensor<Object> POLICY_VIOLATED = new BasicNotificationSensor<Object>(
            Object.class, "policy.violated", "The policy was violated");
	
	public static final Sensor<Object> CONSTRAINTS_INIT = new BasicNotificationSensor<Object>(
			Object.class, "constraint.init", "initialized the constraints.");
	
	public static final Sensor<Object> SUBSCRIBERS_SET = new BasicNotificationSensor<Object>(
			Object.class, "subscriber.set", "The list of entities was set");
	
	public static final Sensor<Entity> SUBSCRIBER_ADDED = new BasicNotificationSensor<Entity>(
			Entity.class, "subscriber.added", "The subscriber was added");
	
	public static final Sensor<Entity> SUBSCRIBER_REMOVED = new BasicNotificationSensor<Entity>(
			Entity.class, "subscriber.removed", "The subscriber was removed");

	public void initConstraints();
	
	public void setTargets(List<Entity> targets);
	
	public List<Constraint> getDesiredState();
	public List<Entity> getTargets();
	
	
}
