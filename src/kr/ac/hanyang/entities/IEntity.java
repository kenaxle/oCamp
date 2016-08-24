package kr.ac.hanyang.entities;

import org.apache.brooklyn.api.entity.Entity;

import kr.ac.hanyang.policy.ConstraintSet;
import kr.ac.hanyang.policy.PolicyConstraint;

public interface IEntity extends Entity{
	
	public static final ConstraintSet CONSTRAINTSET = new ConstraintSet.Builder("Tomcat Constraints").addConstraint(new PolicyConstraint.Builder("START","equals","started").build()).build();
	
	public ConstraintSet getConstraintSet();
}
