package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

public class BasePolicyManager implements IBasePolicyManager{
	
	private List<Policy> policyList;
	private List<ActionGroup> actionGroups;
	
	// create the policy manager with the appropriate action groups
	public BasePolicyManager(){
		policyList = new ArrayList<Policy>();
		actionGroups = new ArrayList<ActionGroup>();
		for (String action: ACTIONGROUPS){
			actionGroups.add(new ActionGroup(action));
		}
	}
	
	public void addPolicy(Policy pol){
		policyList.add(pol);
	}
	
	public void evaluateActions(){
		// will run O(n^2)
		for (IPolicy policy: this.policyList){
			for (ActionGroup actionGroup: this.actionGroups){
				//1. evaluate the action group
				if()
				//2. enumerate the actions of the group
				
				//3. evaluate each action
			}
		}
		
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
