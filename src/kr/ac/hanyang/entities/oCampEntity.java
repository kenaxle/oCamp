package kr.ac.hanyang.entities;

import org.apache.brooklyn.entity.stock.EffectorStartableImpl;

import kr.ac.hanyang.policy.ConstraintSet;

public class oCampEntity extends EffectorStartableImpl{
	private ConstraintSet entityConstraints;
	
	public ConstraintSet getConstraintSet(){
		return entityConstraints;
	}
}
