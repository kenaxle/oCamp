package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.config.SetConfigKey;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@ImplementedBy(TransitionImpl.class)
public interface Transition<T> extends kr.ac.hanyang.oCamp.api.transition.Transition, Entity{
	
	@SetFromFlag("value")
	ConfigKey<Object> VALUE = ConfigKeys.newConfigKey(Object.class,"value","represents the value of the transition");
	
	
	public static final int WEIGHT = 0;
	
	public T getValue();
	
	
	//public boolean evaluate(SensorEvent event);
	
}
