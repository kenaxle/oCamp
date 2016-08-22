package kr.ac.hanyang.entities.services;

import kr.ac.hanyang.policy.ConstraintSet;
import kr.ac.hanyang.policy.PolicyConstraint;

public interface IBasicOCampService {
	
	public static final String[] CAPABILITIES = {"DependsOn"};
	
	//public static final ConstraintSet[] CONSTRAINTS = {new ConstraintSet.Builder("base").addConstraint(new PolicyConstraint("state","equals","started"))
	//																					.addConstraint(new PolicyConstraint("state","equals","stopped"))
	//																					.build()};
}
