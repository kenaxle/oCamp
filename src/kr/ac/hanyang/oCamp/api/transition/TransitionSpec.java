package kr.ac.hanyang.oCamp.api.transition;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.sensor.Sensor;

import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.api.objs.ActionSpec;
import kr.ac.hanyang.oCamp.api.policy.ConstraintSpec;

public class TransitionSpec<T extends Transition> extends EntitySpec{

	public TransitionSpec(Class<T> type) {
		super(type);
	}
	
	private Object value;
	
	public Object getValue(){
		return value;
	}
	
	public TransitionSpec<T> value(Object val) {
        value = checkNotNull(val, "value");
        return this;
	}
	
}
