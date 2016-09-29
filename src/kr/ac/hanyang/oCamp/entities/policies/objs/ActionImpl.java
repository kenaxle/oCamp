package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.transitions.Transition;

public class ActionImpl extends AbstractEntity implements Action{
	
	//private BasicAttributeSensor property; //TODO this should be a Brooklyn attribute or sensor.
	private Effector action;
	private List<Transition> transitionsAsList; // this is the value/values of the property.
	
	
	public ActionImpl(){ }

	public void init(){
		transitionsAsList = new ArrayList<Transition>();
		for(Entity child: this.getChildren()){
			transitionsAsList.add((Transition) child);
		}
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
	
	public int getScore(ConstraintVector constVect){
		int score = -1;
		//compare the initial transition
		Transition first = transitionsAsList.get(0);
		Transition last = transitionsAsList.get(transitionsAsList.size()-1);
		if (first.evaluate(constVect.getViolatedValue()) && last.evaluate(constVect.getDesiredValue())){
			score = 0;
			for(Transition transition: transitionsAsList){
				score += transition.getWeight();
			}
		}
		return score;
	}


	
//	@Effector(description="Executes an action on an entity once given the action name")
//	public void action(	@EffectorParam(name="effectorName", description="name of the action to perform") MethodEffector effectorName){
//		
//		Task<Void> action = Entities.invokeEffector(policyManager, entity, effectorName);
//		
//	}

	
}
