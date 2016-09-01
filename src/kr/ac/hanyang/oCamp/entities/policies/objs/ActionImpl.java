package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.List;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;

import kr.ac.hanyang.oCamp.api.transition.Transition;

public class ActionImpl extends AbstractEntity implements Action{
	
	private BasicAttributeSensor property; //TODO this should be a Brooklyn attribute or sensor.
	private Effector action;
	private List<Transition> transitions; // this is the value/values of the property.
	
	
	public ActionImpl(){ }

	public void init(){
		transitions = new ArrayList<Transition>();
	}
	
	public void setAction(Effector action){
		this.action = action;
		sensors().emit(Action.ACTION_SET, action);
	}
	
	public Effector getAction(){
		return action;
	}

	@Override
	public boolean setProperty(Sensor property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProperty(Sensor property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTransition(Transition transition) {
		if (this.transitions.add(transition)){
			sensors().emit((Sensor)Action.TRANSITION_ADDED, transition);
			return true;
		}
			return false;
	}

	@Override
	public boolean removeTransition(Transition transition) {
		if (this.transitions.remove(transition)){
			sensors().emit((Sensor)Action.TRANSITION_REMOVED, transition);
			return true;
		}
			return false;
	}



	
//	@Effector(description="Executes an action on an entity once given the action name")
//	public void action(	@EffectorParam(name="effectorName", description="name of the action to perform") MethodEffector effectorName){
//		
//		Task<Void> action = Entities.invokeEffector(policyManager, entity, effectorName);
//		
//	}

	
}
