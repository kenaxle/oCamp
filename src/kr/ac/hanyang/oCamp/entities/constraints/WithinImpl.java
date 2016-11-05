package kr.ac.hanyang.oCamp.entities.constraints;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.api.policy.Policy;

public class WithinImpl<T> extends ConstraintImpl<T> implements Within {
	
	public WithinImpl(){}
	
	public void init(){super.init();}
	
	@Deprecated
	public boolean evaluate(SensorEvent event){
		//if (! getValue() instanceof )
//		if (event.getValue().getClass() != getValue().getClass()) return false;
//		return ((T)event.getValue()).equals((T)getValue());
		Object container = getValue();
		if (container instanceof List){
			return ((List)container).contains(event.getValue());
		}
		return true;  
	}
	
	public boolean isAlignedWith(Constraint constraint){
		return false;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public ConstraintVector Violated(Entity entity) {
		boolean violated = true;
		Sensor propertySensor = this.config().get(PROPERTY);
		Object actualValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
		Object defaultValue = this.config().get(VALUE);
		if (actualValue != null)
			violated = !((List)defaultValue).contains(actualValue); 
		
		return new ConstraintVector(propertySensor,actualValue,defaultValue,violated,this);
										 
	}
	
	public Object evaluateOptional(Object oldValue){
		Object newValue; List valList = (List) this.config().get(VALUE);
		if (oldValue == null)
			newValue = valList.get(new Random().nextInt(valList.size()));
		else{		
			int index = valList.indexOf(oldValue);
			if (index >=0){
				valList.remove(index);
			}
			newValue = valList.get(new Random().nextInt(valList.size()));
		}
		return newValue;
	}
	
	//gets a random value from the list
	// not the best way to do this but I will keep this for now.
	public Object initialValue(){
		Object newValue; List valList = (List) this.config().get(VALUE);
		newValue = valList.get(new Random().nextInt(valList.size()));
		return newValue;
	}
	

}
