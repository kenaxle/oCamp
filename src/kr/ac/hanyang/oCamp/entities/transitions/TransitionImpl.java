package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

//import kr.ac.hanyang.oCamp.entities.transitions.Transition;


public abstract class TransitionImpl<T> extends AbstractEntity implements Transition{

	
	public TransitionImpl(){}
	
	@Override
	public void init(){
		
	}
	
	
	public Object getValue() {
		return config().get(VALUE);
	}
	
	@Override
	public int getWeight(){
		return WEIGHT;
	}

	@Override
	public abstract boolean evaluate(Object obj);

	
}
