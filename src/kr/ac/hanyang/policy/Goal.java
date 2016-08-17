package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class Goal {
	private String name;
	private List<IConstraint> constraints;
	
	public Goal(String name){
		this.name = name;
		constraints = new ArrayList<IConstraint>();
	}
	
	public String getName(){ return name;}
	
	public void addConstraint(IConstraint constraint){
		this.constraints.add(constraint);
	}
	
	public IConstraint getConstraint(String property){
		return constraints.get(constraints.indexOf(new PolicyConstraint(property)));
	}
	
}