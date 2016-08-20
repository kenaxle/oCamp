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
	
	public PolicyConstraint getConstraint(Comparable constraint){
		if (constraint instanceof PolicyConstraint)
			return constraints.get(constraints.indexOf(constraint));
		return null; //FIXME should throw exception and log issue instead of returning null
	}
	
	public PolicyConstraint getConstraint(String property){
		return constraints.get(constraints.indexOf(new PolicyConstraint.Builder(property).build()));
	}
	
	public List<PolicyConstraint> getConstraints(){return constraints;}	
	
	// tests if this set is a subset of the other
	// and that they are aligned. if they are aligned then the delta is empty.
	public boolean isAlignedWith(ConstraintSet otherSet){
		//ConstraintSet.Builder returnBuilder = new ConstraintSet.Builder("delta");
		for (PolicyConstraint pConst: constraints){
			PolicyConstraint otherConst = otherSet.getConstraint(pConst.getProperty());
			if(otherConst == null){
				return false;
				//if (! pConst.isAlignedWith(otherConst)) 
				//	returnBuilder.addConstraint(otherConst);
			}
		}
		return true;
	}
	
	public ConstraintSet getDelta(ConstraintSet otherSet){
		ConstraintSet.Builder deltaBuilder = new ConstraintSet.Builder("delta");
		for (PolicyConstraint constraint: constraints){
			PolicyConstraint deltaConstraint = constraint.getDelta(otherSet.getConstraint(constraint));
			if (deltaConstraint != null){
				deltaBuilder.addConstraint(deltaConstraint);
			}
		}
		return deltaBuilder.build();
	}
	
	public boolean isEmpty(){
		return constraints.size() == 0;
	}
	
	//let the weight be the number of items in the set.
	public int getWeight(){
		return constraints.size();
	}
	
}
