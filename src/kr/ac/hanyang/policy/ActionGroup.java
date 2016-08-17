package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class ActionGroup {
	private Delta delta;
	private double weight;
	private List<Action> actions;
	
	public ActionGroup(String goal){
		this.delta = delta;
		weight = 0;
		actions = new ArrayList<Action>();
	}
	
	public void addAction(Action action){
		actions.add(action);
	}
	
	//FIXME need to finish this method
	public boolean canFulfill(Policy pol){
		return true;
	}
}
