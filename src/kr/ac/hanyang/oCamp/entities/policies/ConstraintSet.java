package kr.ac.hanyang.oCamp.entities.policies;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

@ImplementedBy(ConstraintSetImpl.class)
public interface ConstraintSet {

	public static final BasicNotificationSensor<PolicyConstraint> CONSTRAINT_ADDED = new BasicNotificationSensor<PolicyConstraint>(
			PolicyConstraint.class, "constraint.added", "The constraint was added");
	
	public static final BasicNotificationSensor<PolicyConstraint> CONSTRAINT_REMOVED = new BasicNotificationSensor<PolicyConstraint>(
			PolicyConstraint.class, "constraint.removed", "The constraint was removed");
	
	public static final BasicNotificationSensor<Entity> ENTITY_REGISTERED = new BasicNotificationSensor<Entity>(
			Entity.class, "entity.registered", "The entity was registered");
	
	public static final BasicNotificationSensor<Entity> ENTITY_UNREGISTERED = new BasicNotificationSensor<Entity>(
			Entity.class, "entity.unregistered", "The entity was unregistered");
	
	public boolean addConstraint(PolicyConstraint constraint);
	
	public boolean removeConstraint(PolicyConstraint constraint);
	
	public void registerEntity(Entity entity);
	
	public void unregisterEntity(Entity entity);
	
	public List<PolicyConstraint> getConstraints();
	
}
