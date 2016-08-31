package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

@ImplementedBy(ConstraintSetImpl.class)
public interface ConstraintSet {

	public static final BasicNotificationSensor<PolicyConstraint> CONSTRAINT_ADDED = new BasicNotificationSensor<PolicyConstraint>(
			PolicyConstraint.class, "constraint.added", "The policy was violated");
	
	public static final BasicNotificationSensor<PolicyConstraint> CONSTRAINT_REMOVED = new BasicNotificationSensor<PolicyConstraint>(
			PolicyConstraint.class, "constraint.removed", "The policy was violated");
	
	public boolean addConstraint(PolicyConstraint constraint);
	
	public boolean removeConstraint(PolicyConstraint constraint);
	
}
