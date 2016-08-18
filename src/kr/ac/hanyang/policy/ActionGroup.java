package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class ActionGroup {
	private String name;
	private Delta delta; // constraints that must be fulfilled
	private double weight; //calculated based on the delta
	private List<Action> actions; //calculated after evaluating actions
	
	public ActionGroup(String name){
		this.name = name;
		weight = 0;
		actions = new ArrayList<Action>();
	}
	
	public void addAction(Action action){
		actions.add(action);
	}
	
	//FIXME need to finish this method
	public boolean canFulfill(Policy pol){
		Goal desiredState = pol.getDesiredState();
		
		return true;
	}
}
