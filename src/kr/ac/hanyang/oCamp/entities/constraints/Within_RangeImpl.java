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

public class Within_RangeImpl<T> extends ConstraintImpl<T> implements Within_Range {
	
	public Within_RangeImpl(){}
	
	public void init(){super.init();}
	
	
	public boolean evaluate(SensorEvent event){
		//if (! getValue() instanceof )
//		if (event.getValue().getClass() != getValue().getClass()) return false;
//		return ((T)event.getValue()).equals((T)getValue());
		Object container = getValue();
		if (container instanceof List){
			Integer lower =  (Integer) ((List) container).get(0);
			Integer upper =  (Integer) ((List) container).get(1);
					
			return (lower <= (Double) event.getValue() && (Double) event.getValue() <= upper);
		}
		return true;  
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public ConstraintVector Violated(Entity entity) {
		boolean violated = true;
		Sensor propertySensor = this.config().get(PROPERTY);
		Object actualValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
		Object defaultValue = this.config().get(VALUE);
		if (actualValue != null){
			Integer lower =  (Integer) ((List) defaultValue).get(0);
			Integer upper =  (Integer) ((List) defaultValue).get(1);
			violated = !(lower <= (Double) actualValue && (Double) actualValue <= upper);
		}
		
		return new ConstraintVector(propertySensor,actualValue,defaultValue,violated,this);
										 
	}
	
	
	//FIXME ignoring old value for now
	public Object evaluateOptional(Object oldValue){
		Object newValue; List valRange = (List) this.config().get(VALUE);
		Integer lower =  (Integer) valRange.get(0);
		Integer upper =  (Integer) valRange.get(1);
		int delta = upper - lower;
		int shift = lower - 0;
		
		//if (oldValue == null)
			newValue = new Random().nextInt(delta)+shift;
		//else{		
//			int index = valList.indexOf(oldValue);
//			if (index >=0){
//				valList.remove(index);
//			}
			//newValue = valList.get(new Random().nextInt(valList.size()));
		//}
		return newValue;
	}
	
	//gets a random value from the list
	// not the best way to do this but I will keep this for now.
	public Object initialValue(){
		Object newValue; List valRange = (List) this.config().get(VALUE);
		Integer lower =  (Integer) valRange.get(0);
		Integer upper =  (Integer) valRange.get(1);
		int delta = upper - lower;
		int shift = lower - 0;
		newValue = new Random().nextInt(delta)+shift;
		return newValue;
	}
	

}
