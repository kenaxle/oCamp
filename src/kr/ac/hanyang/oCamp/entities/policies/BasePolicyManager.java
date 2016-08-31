package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;

import kr.ac.hanyang.oCamp.entities.IEntity;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

public class BasePolicyManager extends AbstractEntity implements IBasePolicyManager{
	
	private String type;
	private List<PolicyImpl> policyList;
	//private List<ActionGroup> actionGroups;
	
	// create the policy manager with the appropriate action groups
	public BasePolicyManager(String type){
		policyList = new ArrayList<PolicyImpl>();
//		actionGroups = new ArrayList<ActionGroup>();
//		for (String action: ACTIONGROUPS){
//			actionGroups.add(new ActionGroup(action));
//		}
	}
	
	public String getType(){
		return type;
	}
	
	public void addPolicy(PolicyImpl pol){
		policyList.add(pol);
		for (Entity entity: pol.getTargets()){
			
		}
		//subscribe to the Entity of each policy
	}
	
	private void recursiveTest(PolicyConstraintImpl desired ){
		
	}
	
	public void evaluateActions(PolicyImpl policy, IEntity entity){
		
			for (ActionGroup actionGroup: ACTIONGROUPS){
				//1. evaluate the action group
				//ConstraintSet delta = actionGroup.canFulfill(policy);
				if(actionGroup.canFulfill(policy)){
					ConstraintSetImpl  delta = (ConstraintSetImpl)entity.getConstraintSet().getDelta(policy.getDesiredState()); //FIXME I dont need the delta
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

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass()) return false;
		BasePolicyManager other = (BasePolicyManager) obj;
		return this.type.equals(other.type);
	}
	
	

}
