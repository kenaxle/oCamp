package kr.ac.hanyang.oCamp.entities.policies;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.Entities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.ConstraintProperties;
import kr.ac.hanyang.oCamp.entities.policies.objs.FulfillmentVector;
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
				log.info("*********Sensor Event Detected**********");
				log.info("Sensor Event: "+event.getValue());
				try{
					PrintWriter outStream = new PrintWriter(new FileOutputStream("/users/kena/datafile_detect2.txt"));
					outStream.println("Making decision "+ System.currentTimeMillis());
					
				
				//try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
				Entity violator = (Entity) event.getValue();
				Policy policy = (Policy)event.getSource();
				listener.doAction(listener.evaluateActions(violator,policy),violator);
				outStream.println("made decision "+ System.currentTimeMillis());
				outStream.close();
				}catch(Exception e){
					
				}
			}
		};
	}
	

	@Override
	public List<FulfillmentVector> evaluateActions(Entity entity, Policy policy) {
		List<ConstraintVector> violatedConstraints = new ArrayList<ConstraintVector>();
		List<FulfillmentVector> suggestedActions = new ArrayList<FulfillmentVector>();
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
			FulfillmentVector fulfillment = ((ActionGroup) actionGroup).canFulfill(violatedConstraints);
			if ( fulfillment.getWeight() > 0){
				suggestedActions.add(fulfillment);
			}
		}
		return suggestedActions;
	}
	

// policy actions **********
	@SuppressWarnings("unchecked")
	@Override
	public void doAction(List<FulfillmentVector> suggestedActions, Entity entity){
		Effector actionEffector = suggestedActions.get(0).getActionId();
		Map<String, Object> parameters = suggestedActions.get(0).getParameters();
		log.info("*********Performing action: "+actionEffector+"**********");		
		Entities.invokeEffector(this, entity, actionEffector, parameters);   
	}

	


	


	
	
	
	
	

}
