package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class ConstraintSet {
	private String name;
	private List<PolicyConstraint> constraints;
	
	public static class Builder{
		private String name;
		private List<PolicyConstraint> constraints;
		
		public Builder(String name){
			this.name = name;
			constraints = new ArrayList<PolicyConstraint>();
		}
		
		public Builder addConstraint(PolicyConstraint constraint){
			this.constraints.add(constraint);
			return this;
		}
		
		public ConstraintSet build(){
			return new ConstraintSet(this);
		}
	}
	
	private ConstraintSet(Builder builder){
		this.name = builder.name;
		this.constraints = builder.constraints;
	}
	
	public void addConstraint(PolicyConstraint constraint){
		this.constraints.add(constraint);
	}
	
	public String getName(){ return name;}
	
//	public PolicyConstraint getConstraint(PolicyConstraint constraint){
//		return constraints.get(constraints.indexOf(constraint));
//	}
	
	public PolicyConstraint getConstraint(String property){
		return constraints.get(constraints.indexOf(new PolicyConstraint(property)));
	}
	
	public List<PolicyConstraint> getConstraints(){return constraints;}	
	
	public boolean isAlignedWith(ConstraintSet desiredState){
		for (PolicyConstraint pConst: constraints){
			PolicyConstraint desiredConst = desiredState.getConstraint(pConst.getProperty());
			if(desiredConst != null){
				if (! pConst.isAlignedWith(desiredConst)) return false;
			}
		}
		return true;
	}
	
}
