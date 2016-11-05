package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.util.collections.MutableMap;

public class FulfillmentVector {
	private int weight;
	private Effector actionId;
	private Map<String,Object> parameters;
	
	public FulfillmentVector( Effector actionId){
		this.weight = -0;
		this.actionId = actionId;
		this.parameters = MutableMap.of();
	}

	public int getWeight() {
		return weight;
	}

	public Effector getActionId() {
		return actionId;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public void addParameter(String key, Object value){
		parameters.put(key, value);
	}
	
}
