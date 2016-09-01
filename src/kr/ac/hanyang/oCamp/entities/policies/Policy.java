package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

@ImplementedBy(PolicyConstraintImpl.class)
public interface Policy {

	public static final BasicNotificationSensor<Object> POLICY_VIOLATED = new BasicNotificationSensor<Object>(
            Object.class, "policy.violated", "The policy was violated");
	
//	public static final BasicNotificationSensor<ConstraintSet> CONSTRAINTS_ADDED = new BasicNotificationSensor<ConstraintSet>(
//			ConstraintSet.class, "constraint.added", "The constraint was added");
//	
//	public static final BasicNotificationSensor<ConstraintSet> CONSTRAINTS_REMOVED = new BasicNotificationSensor<ConstraintSet>(
//			ConstraintSet.class, "constraint.removed", "The constraint was removed");
	
	public static final BasicNotificationSensor<Entity> SUBSCRIBER_ADDED = new BasicNotificationSensor<Entity>(
			Entity.class, "subscriber.added", "The subscriber was added");
	
	public static final BasicNotificationSensor<Entity> SUBSCRIBER_REMOVED = new BasicNotificationSensor<Entity>(
			Entity.class, "subscriber.removed", "The subscriber was removed");

	
	//public boolean addConstraintSet(ConstraintSet constraints);
	
	public boolean addSubscriber(Entity entity);
	
	//public boolean removeConstraintSet(ConstraintSet constraints);
	
	public boolean removeSubscriber(Entity entity);
	
}
