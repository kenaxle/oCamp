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
	public boolean isViolated(Sensor propertySensor, Entity entity) {
		T value = entity.sensors().get((AttributeSensor<T>) propertySensor);
		return ! value.equals(getValue());
	}

	@Override
	public void register(Policy policy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Policy policy) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
