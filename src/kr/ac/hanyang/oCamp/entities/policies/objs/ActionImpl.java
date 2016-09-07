package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;

import kr.ac.hanyang.oCamp.api.transition.Transition;

public class ActionImpl extends AbstractEntity implements Action{
	
	//private BasicAttributeSensor property; //TODO this should be a Brooklyn attribute or sensor.
	private Effector action;
	private List<Transition> transitions; // this is the value/values of the property.
	
	
	public ActionImpl(){ }

	public void init(){
		//transitions = new ArrayList<Transition>();
	}
	
	public void setAction(Effector action){
		this.action = action;
		sensors().emit(Action.PROPERTY_SET, action);
	}
	
	public Effector getAction(){
		return action;
	}

	@Override
	public boolean setProperty(Sensor property) {
		return config().set(PROPERTY, property) != null;
	}
	
	@Override
	public boolean setConfig(ConfigKey config) {
		return config().set(CONFIGKEY, config) != null;
	}
	
	@Override
	public Sensor getProperty(){
		return config().get(PROPERTY);
	}
	
	@Override
	public ConfigKey getConfig(){
		return config().get(CONFIGKEY);
	}
	

	@Override
	public boolean addTransitions(List<Transition> transitions) {
		if (config().set(TRANSITIONS, transitions) != null){
			sensors().emit(Action.TRANSITIONS_ADDED, transitions);
			return true;
		}
			return false;
	}

	@Override
	public Transition getFirstTransition() {
		return transitions.get(0);
	}

	@Override
	public Transition getLastTransition() {
		return transitions.get(transitions.size()-1);
	}
	
	@Override
	public int getWeight(){
		int count = 0;
		for (Transition transition: transitions){
			count += transition.getWeight();
		}
		return count;
	}


	
//	@Effector(description="Executes an action on an entity once given the action name")
//	public void action(	@EffectorParam(name="effectorName", description="name of the action to perform") MethodEffector effectorName){
//		
//		Task<Void> action = Entities.invokeEffector(policyManager, entity, effectorName);
//		
//	}

	
}
