package kr.ac.hanyang.oCamp.entities.policies;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;

public class PolicyManagerImpl extends AbstractEntity implements PolicyManager{
	
	private List<Policy> policyList;
	//private List<ActionGroup> actionGroups;
	
	// create the policy manager with the appropriate action groups
	public PolicyManagerImpl(){ }
	
	@Override
	public void init(){
		
		//policyList = new ArrayList<Policy>();
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

	@Override
	public boolean addOCampPolicy(org.apache.brooklyn.api.policy.Policy policy) {
		if (this.policyList.add((Policy) policy)){
			this.subscriptions().subscribe((Entity) policy, Policy.POLICY_VIOLATED, policyManagerListener(this));
			sensors().emit((Sensor)PolicyManager.POLICY_ADDED, policy);
			return true;
		}
			return false;
	}

	@Override
	public boolean removeOCampPolicy(org.apache.brooklyn.api.policy.Policy policy) {
		if (this.policyList.remove(policy)){
			this.subscriptions().unsubscribe((Entity) policy);
			sensors().emit((Sensor)PolicyManager.POLICY_REMOVED, policy);
			return true;
		}
			return false;
	}

	@Override
	public boolean addActionGroup(kr.ac.hanyang.oCamp.api.objs.ActionGroup actionGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeActionGroupt(kr.ac.hanyang.oCamp.api.objs.ActionGroup actionGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
