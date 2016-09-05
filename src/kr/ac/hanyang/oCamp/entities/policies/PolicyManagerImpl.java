package kr.ac.hanyang.oCamp.entities.policies;

import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;

import kr.ac.hanyang.oCamp.api.objs.Action;
import kr.ac.hanyang.oCamp.api.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.PolicyImpl;
import kr.ac.hanyang.oCamp.api.policy.Constraint;
import kr.ac.hanyang.oCamp.api.policy.Policy;
//import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;

public class PolicyManagerImpl extends AbstractEntity implements PolicyManager{
	
	private List<Policy> policyList;
	private List<ActionGroup> actionGroups;
	
	private List<ActionGroup> validActions;
	// create the policy manager with the appropriate action groups
	public PolicyManagerImpl(){ }
	
	@Override
	public void init(){
		
		//policyList = new ArrayList<Policy>();
	}

	@Override
	public boolean addOCampPolicy(Policy policy) {
		if (this.policyList.add(policy)){
			this.subscriptions().subscribe((PolicyImpl)policy, PolicyImpl.POLICY_VIOLATED, policyManagerListener(this));
			sensors().emit(PolicyManager.POLICY_ADDED, (PolicyImpl)policy);
			return true;
		}
			return false;
	}
	
	@Override
	public boolean removeOCampPolicy(Policy policy) {
		if (this.policyList.remove(policy)){
			this.subscriptions().unsubscribe((PolicyImpl) policy);
			sensors().emit(PolicyManager.POLICY_REMOVED, (PolicyImpl)policy);
			return true;
		}
			return false;
	}
	
	private SensorEventListener<Object> policyManagerListener(PolicyManager listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				Object value = ((SensorEvent<Object>)event.getValue()).getValue();
				Entity source = ((SensorEvent<Object>)event.getValue()).getSource();
				Sensor sensor = ((SensorEvent<Object>)event.getValue()).getSensor();
				Policy policy = (Policy)(SensorEvent<Object>)event.getSource();
				listener.evaluateActions(source,policy,sensor);
			}
		};
	}
	

	@Override
	public boolean setActionGroups(List<ActionGroup> actionGroups) {
		if(config().set(ACTIONGROUPS, actionGroups) != null){
			sensors().emit(PolicyManager.ACTIONGROUPS_SET, actionGroups);
			return true;
		}
		return false;
	}

	@Override
	public List<ActionGroup> evaluateActions(Entity entity, Policy policy, Sensor sensor) {
		for(ActionGroup actionGroup: actionGroups){
			boolean badGroup = false;
			int taskCount = 0;
			for(Constraint constraint: policy.getDesiredState()){
				Sensor policySensor = constraint.getProperty();
				Action action = actionGroup.getAction(policySensor); //this may be null so there is risk of null pointer
				if (! constraint.isViolated(policySensor, entity)){ // if the constraint is not violated on the entity we have a different approach
					if (action.getLastTransition().evaluate(constraint,null)){// FIXME change this to the desired state
						taskCount += action.getWeight(); //Continue from here
					}
					
				}else if (constraint.isViolated(policySensor, entity)){
					if(action.getFirstTransition().evaluate(policySensor, entity) && action.getLastTransition().evaluate(constraint, null)){
						taskCount += action.getWeight(); //weight if all the transactions
					}
					//if (action.getFirstTransition().evaluate(, entity))
				}else{
					//the action group is bad
					// this is not the solution.
					badGroup = true;
					break;
				}
				
			}if(! badGroup){
				actionGroup.setWeight(taskCount);
				validActions.add(actionGroup);//add group to a list sorted by weight.
			}
		}
		return validActions;
	}


// policy actions **********
	@Override
	public void doAction(Effector effector, Entity entity){
		
	}
	
	
	
	

}
