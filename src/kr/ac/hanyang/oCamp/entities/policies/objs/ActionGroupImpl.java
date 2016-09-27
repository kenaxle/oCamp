package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.Iterator;
import java.util.List;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.AbstractEntity;


public class ActionGroupImpl extends AbstractEntity implements ActionGroup {
	
	private Effector actionId;
	
	private List<Action> actions;
	
	private int weight;
	
	public ActionGroupImpl(){ }
	
	public void init(){
		actionId = config().get(ACTION_ID);
		actions = config().get(ACTIONS);
	}
	
	@Override
	public boolean setActions(List<Action> actions){
		if (config().set(ACTIONS, actions) != null){
			sensors().emit(ActionGroup.ACTIONS_ADDED, actions);
			return true;
		}
			return false;
	}
	
	@Override
	public boolean setActionID(Effector actionEffector) {
		return config().set(ACTION_ID, actionEffector) != null;
	}

	@Override
	public Action getAction(Sensor policySensor){
		for(Action action: config().get(ACTIONS))
			return action.getProperty().equals(policySensor) ? action : null;
		return null;
	}
	
	
	
	@Override
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	@Override
	public int getWeight(){
		return weight;
	}
	
	
}
