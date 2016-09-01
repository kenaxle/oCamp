package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;

@ImplementedBy(ConstraintSetImpl.class)
public interface ConstraintSet{

	public static final BasicNotificationSensor<Constraint> CONSTRAINT_ADDED = new BasicNotificationSensor<Constraint>(
			Constraint.class, "constraint.added", "The constraint was added");
	
	public static final BasicNotificationSensor<Constraint> CONSTRAINT_REMOVED = new BasicNotificationSensor<Constraint>(
			Constraint.class, "constraint.removed", "The constraint was removed");
	
	public static final BasicNotificationSensor<Entity> ENTITY_REGISTERED = new BasicNotificationSensor<Entity>(
			Entity.class, "entity.registered", "The entity was registered");
	
	public static final BasicNotificationSensor<Entity> ENTITY_UNREGISTERED = new BasicNotificationSensor<Entity>(
			Entity.class, "entity.unregistered", "The entity was unregistered");
	
	public boolean addConstraint(Constraint constraint);
	
	public boolean removeConstraint(Constraint constraint);
	
	public void registerEntity(Entity entity);
	
	public void unregisterEntity(Entity entity);
	
	public List<Constraint> getConstraints();
	
}
