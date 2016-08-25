package kr.ac.hanyang.entities;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.Attributes;

import kr.ac.hanyang.policy.ConstraintSet;
import kr.ac.hanyang.policy.PolicyConstraint;
import kr.ac.hanyang.policy.SensorSet;

public interface IEntity<T> extends Entity{
	
	public static final SensorSet POLICY_SENSORS = new SensorSet.Builder("Policy Sensors").addSensor(Attributes.SERVICE_UP).build();
	public static final ConstraintSet CONSTRAINTSET = new ConstraintSet.Builder("Tomcat Constraints").addConstraint(new PolicyConstraint.Builder((Comparable) Attributes.SERVICE_UP).build()).build();
	
	public ConstraintSet getConstraintSet();
}
