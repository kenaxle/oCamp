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
	ConfigKey<Sensor> PROPERTY = ConfigKeys.newConfigKey(Sensor.class,"property","represents the property of the action");
	
	@SetFromFlag("configkey")
	ConfigKey<ConfigKey> CONFIGKEY = ConfigKeys.newConfigKey(ConfigKey.class,"configkey","represents the config key to be altered. it may be null");
	
	@SetFromFlag("transitions")
	ConfigKey<List<Transition>> TRANSITIONS = ConfigKeys.newConfigKey(new TypeToken<List<Transition>>(){ },"actiongroups","represents the list of actiongroups");
	
	
	public static final Sensor<Effector> PROPERTY_SET = new BasicNotificationSensor<Effector>(
            Effector.class, "action.set", "The action was set");
	
	public static final Sensor<Object> TRANSITIONS_ADDED = new BasicNotificationSensor<Object>(
			Object.class, "transition.added", "The transition was added");
	
	
//	org.apache.brooklyn.api.effector.Effector<Void> ACTION = Effectors.effector(new MethodEffector<Void>(ActionImpl.class, "action"))
//		        .impl(new ActionBody())
//		        .build();
	
		
//	public static class ActionBody extends EffectorBody<Void> {
//        @Override 
//        public Void call(ConfigBag parameters) {
//            return new MethodEffector<Void>(ActionImpl.class, "action").call(entity(), parameters.getAllConfig());
//        }
//    }
//	
	
//	 
//	@org.apache.brooklyn.core.annotation.Effector(description="action effector")
//	    void action(@EffectorParam(name="actionName") MethodEffector effectorName);
	
	
}
