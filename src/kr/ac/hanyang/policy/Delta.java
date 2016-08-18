package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class Delta {
	private String name;
	private List<IConstraint> constraints;
	
	public Delta(String name){
		this.name = name;
		constraints = new ArrayList<IConstraint>();
	}
	
	public String getName(){ return name;}
	
	public void addConstraint(IConstraint constraint){
		this.constraints.add(constraint);
	}
	
	public List<IConstraint> getConstraints(){return constraints;}
	
	public IConstraint getConstraint(String property){
		return constraints.get(constraints.indexOf(new PolicyConstraint(property)));
	}
	
}
