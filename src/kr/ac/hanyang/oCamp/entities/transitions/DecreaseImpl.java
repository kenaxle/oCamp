package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

public class DecreaseImpl extends TransitionImpl implements Decrease{

	public DecreaseImpl(){}
	
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
				return true;//((Comparable) obj).compareTo(value) < 0;
				//return obj != null; // or whatever a sensor uses to represent that it has no value
			}else{
			//if(obj instanceof Comparable && value instanceof Comparable){	
			//	if (obj.getClass() == value.getClass()){
				Integer lower =  (Integer) ((List) obj).get(0);
				Integer upper =  (Integer) ((List) obj).get(1);
					
				return (lower <= (Double) value && (Double) value <= upper);	
			
			}
			//}
			//return false;
		}
	
	@Override
	public int getWeight(){
		return Decrease.WEIGHT;
	}

}
