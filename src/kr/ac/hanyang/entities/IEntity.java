package kr.ac.hanyang.entities;

import org.apache.brooklyn.api.entity.Entity;

import kr.ac.hanyang.policy.ConstraintSet;

public interface IEntity extends Entity{
	
	public static final ConstraintSet CONSTRAINTSET = new ConstraintSet.Builder("constraints").build();
	
	public ConstraintSet getConstraintSet();
}
