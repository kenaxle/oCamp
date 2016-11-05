package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

public class InitialImpl extends TransitionImpl implements Initial{
	
	public InitialImpl(){}
	
	@Override
	public void init(){
		
	}
	

	@Override
	public boolean evaluate(Object obj) {
		Object value = config().get(VALUE);
		if(value == null){
			return obj == null; // or whatever a sensor uses to represent that it has no value
		}else
		if(value.equals("ANYTHING")){
			return obj != null; // or whatever a sensor uses to represent that it has no value
		}else
		if (obj.getClass() == value.getClass()){
			return obj.equals(value);
		}
		return false;
	}

	@Override
	public int getWeight(){
		return Initial.WEIGHT;
	}

}
