package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.AbstractEntity;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.transitions.Transition;

public class ActionImpl extends AbstractEntity implements Action{
	
	private List<Transition> transitionsAsList; // this is the value/values of the property.
	
	
	public ActionImpl(){ }

	public void init(){
		transitionsAsList = new ArrayList<Transition>();
		for(Entity child: this.getChildren()){
			transitionsAsList.add((Transition) child);
		}
	}

	@Override
	public boolean setProperty(Sensor property) {
		return config().set(PROPERTY, property) != null;
	}

	@Override
	public Sensor getProperty(){
		return config().get(PROPERTY);
	}
	
	
	public int getScore(ConstraintVector constVect, FulfillmentVector fulfillment){
		int score = -1;
		//compare the initial transition
		Transition first = transitionsAsList.get(0);
		Transition last = transitionsAsList.get(transitionsAsList.size()-1);
		if (first.evaluate(constVect.getViolatedValue()) && last.evaluate(constVect.getDesiredValue())){
			score = 0;
			for(Transition transition: transitionsAsList){
				score += transition.getWeight();
			}
			String parameterName = parseParameter(constVect.getConstName());
			if (parameterName != null)
				fulfillment.addParameter(parameterName, packageValue(parameterName,evaluateParameterValue(constVect, last))); 
		}
		return score;
	}
	
	private Object evaluateParameterValue(ConstraintVector constVect, Transition transition){
		Object val = null;
		if (transition.getValue() != null){
			if (transition.getValue().equals("ANYTHING")){
				val = constVect.getConstraint().evaluateOptional(constVect.getViolatedValue());//selectionStrategy(constVect.getDesiredValue(), constVect.getViolatedValue());
			}else
				val = transition.getValue();//selectionStrategy(transition.getValue(), constVect.getViolatedValue()); // use the specific value.
		}
		return val;
	}
	
	
	
	private Object packageValue(String parsedName, Object value){
		switch(parsedName){
		case"locations": 
			List<String> toReturn = new ArrayList<String>();
			toReturn.add((String) value);
			return toReturn;

		default:
			return value;	
		}
	}
	
	
	private String parseParameter(String name){
		switch(name){
		case"softwareservice.provisioningLocation": return "locations";

		default:
			return null;	
		}
	}

	
}
