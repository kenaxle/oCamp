package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.entities.IEntity;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

public class PolicyManagerImpl extends AbstractEntity implements PolicyManager{
	
	private List<Policy> policyList;
	//private List<ActionGroup> actionGroups;
	
	// create the policy manager with the appropriate action groups
	public PolicyManagerImpl(){ }
	
	@Override
	public void init(){
		policyList = new ArrayList<Policy>();
//		actionGroups = new ArrayList<ActionGroup>();
//		for (String action: ACTIONGROUPS){
//			actionGroups.add(new ActionGroup(action));
//		}
	}
	
	@Override
	public boolean addPolicy(Policy policy) {
		if (this.policyList.add(policy)){
			this.subscriptions().subscribe((Entity) policy, Policy.POLICY_VIOLATED, policyManagerListener(this));
			sensors().emit(PolicyManager.POLICY_ADDED, policy);
			return true;
		}
			return false;
	}

	@Override
	public boolean removePolicy(Policy policy) {
		if (this.policyList.remove(policy)){
			this.subscriptions().unsubscribe((Entity) policy);
			sensors().emit(PolicyManager.POLICY_REMOVED, policy);
			return true;
		}
			return false;
	}
	
	private SensorEventListener<Object> policyManagerListener(Entity listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				((PolicyManager) listener).evaluateActions(((SensorEvent<Object>)event.getValue()).getSource());
			}
		};
	}
	
	
	public void evaluateActions(Entity entity){
		
//			for (ActionGroup actionGroup: ACTIONGROUPS){
//				//1. evaluate the action group
//				//ConstraintSet delta = actionGroup.canFulfill(policy);
//				if(actionGroup.canFulfill(policy)){
//					ConstraintSetImpl  delta = (ConstraintSetImpl)entity.getConstraintSet().getDelta(policy.getDesiredState()); //FIXME I dont need the delta
//					actionGroup.addAction(new Action(this,actionGroup.getName(),entity,delta));
//				}
//			}
//					
//					//calculate the weight of the action group
//					
//					//2. enumerate the actions of the group
//				
//					//3. evaluate each action
//		
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
