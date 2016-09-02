package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

public class InitialImpl<T> extends TransitionImpl implements Initial{
	
	public InitialImpl(){}
	
	@Override
	public void init(){
		
	}
	
	@Override
	public boolean evaluate(SensorEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object obj, Entity entity) {
		if (obj instanceof Sensor){
			Sensor propertySensor = (AttributeSensor) obj;			
			T propertyValue = entity.sensors().get((AttributeSensor<T>) propertySensor);
			Object value = config().get(VALUE);
			if(value == null){
				return propertyValue == null; // or whatever a sensor uses to represent that it has no value
			}else
			if(value.getClass().getName().equals("java.util.Optional")){
				return propertyValue != null; // or whatever a sensor uses to represent that it has no value
			}else
			if (propertyValue.getClass() == value.getClass()){
						return propertyValue.equals(value);
			}
			
		}
			
		return false;
	}

	@Override
	public int getWeight(){
		return Initial.WEIGHT;
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
