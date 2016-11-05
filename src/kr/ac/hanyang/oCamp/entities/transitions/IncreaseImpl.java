package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

public class IncreaseImpl extends TransitionImpl implements Increase{

	public IncreaseImpl(){}
	
	@Override
	public void init(){
		
	}
		
	// the objects must be comparable
	@Override
	public boolean evaluate(Object obj) {
		Object value = config().get(VALUE);
		if(value == null){
			return obj == null; // or whatever a sensor uses to represent that it has no value
		}else
		if(value.equals("ANYTHING")){//.getClass().getName().equals("java.util.Optional")){
			return obj != null; // or whatever a sensor uses to represent that it has no value
		}else
		if(obj instanceof Comparable && value instanceof Comparable){	
			if (obj.getClass() == value.getClass()){
				return ((Comparable) obj).compareTo(value) > 0;
			}
		}
		return false;
	}
	
	@Override
	public int getWeight(){
		return Increase.WEIGHT;
	}

}
