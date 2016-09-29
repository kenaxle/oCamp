package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.sensor.Sensor;

//used for passing information
public class ConstraintVector {
	private boolean violated;
	private Sensor constraintSensor;
	private Object violatedValue;
	private Object desiredValue;
	
	public ConstraintVector(Sensor sensor, Object violatedValue, Object desiredValue, boolean violated){
		this.constraintSensor = sensor;
		this.violatedValue = violatedValue;
		this.desiredValue = desiredValue;
		this.violated = violated;
	}

	public Sensor getConstraintSensor() {
		return constraintSensor;
	}

	public Object getViolatedValue() {
		return violatedValue;
	}

	public Object getDesiredValue() {
		return desiredValue;
	}
	
	public boolean isViolated(){
		return violated;
	}
	
}
