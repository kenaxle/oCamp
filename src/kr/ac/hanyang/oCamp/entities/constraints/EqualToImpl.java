package kr.ac.hanyang.oCamp.entities.constraints;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.lifecycle.Lifecycle;
import org.apache.brooklyn.core.entity.lifecycle.ServiceStateLogic;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.api.policy.Policy;

public class EqualToImpl<T> extends ConstraintImpl<T> implements EqualTo {
	
	public EqualToImpl(){}
	
	@Override
	public boolean evaluate(SensorEvent event){
		//if (event.getValue().getClass() != getValue().getClass()) return false;
		if ( event.getSource().sensors().get(ServiceStateLogic.SERVICE_STATE_ACTUAL).equals(Lifecycle.CREATED))
			return event.getValue().equals(getValue());
		return true;
	}
	
	public boolean isAlignedWith(ConstraintImpl constraint){
		return (this.getProperty().equals(constraint.getProperty()) && 
				this.getValue().equals(constraint.getValue()));			
	}

	@Override
	public ConstraintVector Violated(Entity entity) {
		boolean violated = true;
		Sensor propertySensor = this.config().get(PROPERTY);
		Object actualValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
		Object defaultValue = this.config().get(VALUE);
		if (actualValue != null)
			violated = !actualValue.equals(defaultValue);
		
		return new ConstraintVector(propertySensor,actualValue,defaultValue,violated,this);
										 
	}
	
	public Object initialValue(){
		return this.config().get(VALUE);
	}
	
	public Object evaluateOptional(Object oldValue){
		
		//if(oldValue != null && ! oldValue.equals(this.config().get(VALUE)))
			return this.config().get(VALUE);
		//else
			//return null;
	}

}
