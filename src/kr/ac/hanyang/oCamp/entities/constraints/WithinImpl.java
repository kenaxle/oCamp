package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.sensor.SensorEvent;

public class WithinImpl<T> extends ConstraintImpl<T> implements Within {
	
	public WithinImpl(){}
	
	public boolean evaluate(SensorEvent event){
		//if (! getValue() instanceof )
		if (event.getValue().getClass() != getValue().getClass()) return false;
		return ((T)event.getValue()).equals((T)getValue());
	}
	
	public boolean isAlignedWith(Constraint constraint){
		return false;
	}
}
