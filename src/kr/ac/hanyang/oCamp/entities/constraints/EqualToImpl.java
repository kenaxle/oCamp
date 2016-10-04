package kr.ac.hanyang.oCamp.entities.constraints;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.api.policy.Policy;

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

	@Override
	public ConstraintVector Violated(Entity entity) {
		Sensor propertySensor = this.config().get(PROPERTY);
		Object actualValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
		Object defaultValue = this.config().get(VALUE);
		boolean violated = !actualValue.equals(defaultValue);
		
		return new ConstraintVector(propertySensor,actualValue,defaultValue,violated);
										 
	}
	
	public Object initialValue(){
		return this.config().get(VALUE);
	}

}
