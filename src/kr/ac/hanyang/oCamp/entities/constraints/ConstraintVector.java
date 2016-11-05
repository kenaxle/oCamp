package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;

//used for passing information
public class ConstraintVector {
	private boolean violated;
	private Sensor constraintSensor;
	private Object violatedValue;
	private Object desiredValue;
	private Object parameter;
	private Constraint constraint;
	
	public ConstraintVector(Sensor sensor, Object violatedValue, Object desiredValue, boolean violated, Constraint constraint){
		this.constraintSensor = sensor;
		this.violatedValue = violatedValue;
		this.desiredValue = desiredValue;
		this.violated = violated;
		this.constraint = constraint;
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
	
	public String getConstName(){
		return constraintSensor.getName();
	}
	
	public Object getParameter(){
		return parameter;
	}
	
	public Constraint getConstraint(){
		return constraint;
	}
	
}
