package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.util.core.config.ConfigBag;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import kr.ac.hanyang.oCamp.api.transition.Transition;
import com.google.common.reflect.TypeToken;

@ImplementedBy(ActionImpl.class)
public interface Action extends kr.ac.hanyang.oCamp.api.objs.Action{
	
	@SetFromFlag("property")
	ConfigKey<Sensor> PROPERTY = ConfigKeys.newConfigKey(Sensor.class,"property","represents the property that was sensed");
	
	@SetFromFlag("configkey")
	ConfigKey<ConfigKey> CONFIGKEY = ConfigKeys.newConfigKey(ConfigKey.class,"configkey","represents the config key to be altered. it may be null");
	
	@SetFromFlag("transitions")
	ConfigKey<List<Transition>> TRANSITIONS = ConfigKeys.newConfigKey(new TypeToken<List<Transition>>(){ },"transitions","represents the list of transitions");
	
	
	public static final Sensor<Effector> PROPERTY_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "property.set", "The property was set");
	
	public static final Sensor<Object> TRANSITIONS_ADDED = new BasicNotificationSensor<Object>(
			Object.class, "transition.added", "The transition was added");
	
	
	public boolean setProperty(Sensor property);	
	
	public boolean addTransitions(List<Transition> transition);
	
	public boolean setConfig(ConfigKey config);
	
	public Sensor getProperty();
	
	public ConfigKey getConfig();
	
	public Transition getFirstTransition();
	
	public Transition getLastTransition();
	
	public int getWeight();
	
	
}
