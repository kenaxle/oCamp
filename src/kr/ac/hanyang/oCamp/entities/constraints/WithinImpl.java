package kr.ac.hanyang.oCamp.entities.constraints;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.api.policy.Policy;

public class WithinImpl<T> extends ConstraintImpl<T> implements Within {
	
	public WithinImpl(){}
	
	public void init(){super.init();}
	
	public boolean evaluate(SensorEvent event){
		//if (! getValue() instanceof )
//		if (event.getValue().getClass() != getValue().getClass()) return false;
//		return ((T)event.getValue()).equals((T)getValue());
		return true; // using for testing 
	}
	
	public boolean isAlignedWith(Constraint constraint){
		return false;
	}
	
	
	@Override
	public ConstraintVector Violated(Entity entity) {
		Sensor propertySensor = this.PROPERTY.getDefaultValue();
		Object actualValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
		Object defaultValue = this.VALUE.getDefaultValue();
		boolean violated = actualValue.equals(defaultValue);
		
		return new ConstraintVector(propertySensor,actualValue,defaultValue,violated);
										 
	}
	
}
