package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class ActionGroup {
	private String name;
	private PolicyConstraint fulfillment; // constraints that must be fulfilled
	private double weight; //calculated based on the delta
	private List<Action> actions; //calculated after evaluating actions
	
	
	public static class Builder{
	
		private String name;
		private PolicyConstraint fulfillment; // constraints that must be fulfilled
		private double weight; //calculated based on the delta
		private List<Action> actions; //calculated after evaluating actions
		
		public Builder(String name){
			this.name = name;
			this.weight = 0;
			this.actions = new ArrayList<Action>();
		}
		
		public Builder addAction(Action action){
			actions.add(action);
			return this;
		}
		
		public Builder addFulfillment(PolicyConstraint constraint){
			this.fulfillment = constraint;
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
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	//FIXME need to finish this method
	public boolean canFulfill(Policy pol){
		ConstraintSet desiredState = pol.getDesiredState();
		
		return true;
	}
}
