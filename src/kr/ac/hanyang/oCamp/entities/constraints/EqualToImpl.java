package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.sensor.SensorEvent;

public class EqualToImpl<T> extends ConstraintImpl<T> implements EqualTo {
	
	public EqualToImpl(){}
	
	@Override
	public boolean evaluate(SensorEvent event){
		if (event.getValue().getClass() != getValue().getClass()) return false;
		return ((T)event.getValue()).equals((T)getValue());
	}
	
	public boolean isAlignedWith(ConstraintImpl constraint){
		return (this.getProperty().equals(constraint.getProperty()) && 
				this.getValue().equals(constraint.getValue()));			
	}
	
	
}
