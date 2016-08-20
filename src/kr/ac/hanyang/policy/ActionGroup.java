package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;

public class ActionGroup {
	private String name;
	private ConstraintSet actionableConstraints; // constraints that the actiongroup can influence;
	private double weight; //calculated based on the delta
	private List<Action> actions; //calculated after evaluating actions
	
	public static class Builder{
	
		private String name;
		private ConstraintSet actionableConstraints; // constraints that must be fulfilled
		private double weight; //calculated based on the delta
		private List<Action> actions; //calculated after evaluating actions
		
		public Builder(String name){
			this.name = name;
			this.weight = 0;
			this.actions = new ArrayList<Action>();
		}
		
//		public Builder addAction(Action action){
//			actions.add(action);
//			return this;
//		}
		
		public Builder addConstraint(PolicyConstraint constraint){
			this.actionableConstraints.addConstraint(constraint); 
			return this;
		}
		
		public ActionGroup build(){
			return new ActionGroup(this);
		}
		
	}
	
	private ActionGroup(Builder builder){
		this.name = builder.name;
		this.weight = builder.weight;
		this.actions = builder.actions;
	}
	
	public String getName(){
		return name;
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void addAction(Action action){
		actions.add(action);
	}
	
	//FIXME need to finish this method
	// must use the delta of the entity and the actionable
	// then using that delta
	public boolean canFulfill(Policy pol){
		ConstraintSet desiredState = pol.getDesiredState();
		return desiredState.isAlignedWith(actionableConstraints);
	}
	
//	public ConstraintSet getDelta(Policy pol, Entity entity){
//		for (PolicyConstraint constraint: pol.getDesiredState().getConstraints()){
//			
//		}
//	}
}
