package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.AbstractEntity;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;


public class ActionGroupImpl extends AbstractEntity implements ActionGroup {
	
	//private Effector actionId;
	
	private Map<Sensor, Action> actionsAsMap;
	
	private int weight;
	
	public ActionGroupImpl(){ }
	
	public void init(){
		actionsAsMap = new LinkedHashMap<Sensor, Action>();
		for(Entity child: this.getChildren()){
			actionsAsMap.put(((Action) child).getProperty(), (Action) child);
		}
	}
	
	@Override
	public boolean setActionID(Effector actionEffector) {
		return config().set(ACTION_ID, actionEffector) != null;
	}

	@Override
	public Effector getActionEffector(){
		return this.ACTION_ID.getDefaultValue();
	}
	
	public int canFulfill(Collection<ConstraintVector> violatedConstraints){
		int weight = 0;
		for (ConstraintVector constVect: violatedConstraints){
			if (actionsAsMap.containsKey(constVect.getConstraintSensor())){
				Action action = actionsAsMap.get(constVect.getConstraintSensor());
				int score = action.getScore(constVect);
				if ( score >= 0)
					weight += score;
			}else
				return -1;
		}
		return weight;
	}
	
//	private int getScore(ConstraintVector constVect){ //score to fix the sick sensor
//		((Action) actionsAsMap.get(constraint.getProperty()).get
//	}
	
	@Override
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	@Override
	public int getWeight(){
		return weight;
	}
	
	
}
