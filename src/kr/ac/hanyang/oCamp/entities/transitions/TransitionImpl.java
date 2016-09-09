package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

//import kr.ac.hanyang.oCamp.entities.transitions.Transition;


public abstract class TransitionImpl<T> extends AbstractEntity implements Transition{

	//private T value; // this is the value/values of the transition.
	
	public TransitionImpl(){}
	
	@Override
	public void init(){
		
	}
	
	
	public Object getValue() {
		return config().get(VALUE);
	}
	
//	public ConfigKey getConfigKey(){
//		return config().get(CONFIGKEY);
//	}
	
	@Override
	public int getWeight(){
		return WEIGHT;
	}

	
	public boolean evaluate(SensorEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setValue(Object value) {
		return (config().set((ConfigKey)VALUE, value) != null);
	}
	
//	public boolean setConfigKey(ConfigKey conf){
//		return (config().set((ConfigKey)CONFIGKEY, conf) != null);
//	}

	
	//will have to remove this
	@Override
	public boolean removeValue(Object value) {
		return true;
	}

	@Override
	public abstract boolean evaluate(Object obj, Entity entity);

	
//	@Override
//	public boolean addTransition(Transition transition) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean removeTransition(Transition transition) {
//		// TODO Auto-generated method stub
//		return false;
//	}



//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
