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
	
	private Map<Sensor, Action> actionsAsMap;
	private Map<String, Object> parameters;
	
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
		return this.config().get(ACTION_ID);
	}
	
	public FulfillmentVector canFulfill(Collection<ConstraintVector> violatedConstraints){
		FulfillmentVector fulfillment =  new FulfillmentVector(getActionEffector());
		int weight = 0;
		for (ConstraintVector constVect: violatedConstraints){
			if (actionsAsMap.containsKey(constVect.getConstraintSensor())){
				Action action = actionsAsMap.get(constVect.getConstraintSensor());
				int score = action.getScore(constVect, fulfillment);
				if ( score >= 0)
					weight += score;
					
			}else{
				fulfillment.setWeight(-1);
				return fulfillment;
			}
		}
		fulfillment.setWeight(weight);
		
		return fulfillment;
	}
	
}
