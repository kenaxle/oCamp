package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;

public class BasePolicyManager extends AbstractEntity implements IBasePolicyManager{
	
	private List<Policy> policyList;
	//private List<ActionGroup> actionGroups;
	
	// create the policy manager with the appropriate action groups
	public BasePolicyManager(){
		policyList = new ArrayList<Policy>();
//		actionGroups = new ArrayList<ActionGroup>();
//		for (String action: ACTIONGROUPS){
//			actionGroups.add(new ActionGroup(action));
//		}
	}
	
	public void addPolicy(Policy pol){
		policyList.add(pol);
	}
	
	public void evaluateActions(Policy policy, Entity entity){
		//for (Policy policy: this.policyList){
			//get the Goal{desired state}
			//ConstraintSet desiredState = policy.getDesiredState();
			for (ActionGroup actionGroup: ACTIONGROUPS){
				//1. evaluate the action group
				//ConstraintSet delta = actionGroup.canFulfill(policy);
				if(actionGroup.canFulfill(policy)){
					ConstraintSet  delta = (ConstraintSet)entity.getConstraintSet().getDelta(policy.getDesiredState());
					actionGroup.addAction(new Action(this,actionGroup.getName(),entity,delta));
				}
			}
					
					//calculate the weight of the action group
					
					//2. enumerate the actions of the group
				
					//3. evaluate each action
		
	}
	
	//need the policy logic here 
	
	//--------------------------
	
	
	// policy actions **********
	public void startaction(){
		
	}
	
	public void stopaction(){
		
	}
	
	public void restartaction(){
		
	}
}
