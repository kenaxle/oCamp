package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.util.collections.MutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.policies.objs.Action;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;
import kr.ac.hanyang.oCamp.entities.policies.objs.PolicyImpl;


public class PolicyManagerImpl extends AbstractEntity implements PolicyManager{
	private static final Logger log = LoggerFactory.getLogger(PolicyManagerImpl.class);
	private List<Policy> policyList;	
	private List<ActionGroup> validActions;

	public PolicyManagerImpl(){ }
	
	@Override
	public void init(){
		policyList = new ArrayList<Policy>();
		validActions = new ArrayList<ActionGroup>();
	}

	@Override
	public boolean addOCampPolicy(Policy policy) {
		if (this.policyList.add(policy)){
			this.subscriptions().subscribe(policy, PolicyImpl.POLICY_VIOLATED, policyManagerListener(this));
			sensors().emit(PolicyManager.POLICY_ADDED, (PolicyImpl)policy);
			return true;
		}
			return false;
	}
	
	//@Override
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
				log.info("*********Sensor Event**********");
				log.info("Sensor Event: "+event.getValue());
				//Object value = ((SensorEvent<Object>)event.getValue()).getValue();
				Entity violator = (Entity) event.getValue();
				//Sensor sensor = ((SensorEvent<Object>)event.getValue()).getSensor();
				Policy policy = (Policy)event.getSource();
				listener.doAction(listener.evaluateActions(violator,policy).get(0).getActionEffector(),violator);
				log.info("*********I should do something but I dont know what to do **********");
				log.info("Sensor Event: "+event.getValue());
			}
		};
	}
	

//	@Override
//	public boolean setActionGroups(List<ActionGroup> actionGroups) {
//		if(config().set(ACTIONGROUPS, actionGroups) != null){
//			sensors().emit(PolicyManager.ACTIONGROUPS_SET, actionGroups);
//			return true;
//		}
//		return false;
//	}

	@Override
	public List<ActionGroup> evaluateActions(Entity entity, Policy policy) {
		List<ConstraintVector> violatedConstraints = new ArrayList<ConstraintVector>();
		List<ActionGroup> suggestedActions = new ArrayList<ActionGroup>();
		for(Entity constr: policy.getChildren()){
			Constraint constraint = (Constraint) constr;
			ConstraintVector constVect = constraint.Violated(entity);
			if(constVect.isViolated()){
				violatedConstraints.add(constVect);
			}
		}// should have a list of all the constraints that were violated by the entity
		// now get the action groups
		
		//Collection<Entity> actionGroups = this.getChildren();
		for(Entity actionGroup: this.getChildren()){
			if (((ActionGroup) actionGroup).canFulfill(violatedConstraints) >= 0){
				suggestedActions.add((ActionGroup) actionGroup);
			}
		}
		return suggestedActions;
	}


// policy actions **********
	@Override
	public void doAction(Effector effector, Entity entity){
		Entities.invokeEffector(this, entity, effector);
		// map to config key.
		// get the new config for the entity 
		// the locations should be treated differently to other configs 
		
		//then invoke the effector on the entity
	}

	


	


	
	
	
	
	

}
