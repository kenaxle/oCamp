package kr.ac.hanyang.oCamp.entities.services;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.ConstraintSetImpl;

public interface IBasicOCampService {
	
	public static final String[] CAPABILITIES = {"DependsOn"};
	
	//public static final ConstraintSet[] CONSTRAINTS = {new ConstraintSet.Builder("base").addConstraint(new PolicyConstraint("state","equals","started"))
	//																					.addConstraint(new PolicyConstraint("state","equals","stopped"))
	//																					.build()};
}
