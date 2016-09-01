package kr.ac.hanyang.oCamp.api.objs;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;

import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.api.policy.ConstraintSpec;
import kr.ac.hanyang.oCamp.api.transition.Transition;
import kr.ac.hanyang.oCamp.api.transition.TransitionSpec;

public class ActionSpec<T extends Action> extends EntitySpec{

	public ActionSpec(Class<T> type) {
		super(type);
	}
	
	private Sensor property;
	private final List<Transition> transitions = Lists.newArrayList();
	private final List<TransitionSpec<?>> transitionSpecs = Lists.newArrayList();
	
	
	public Sensor getProperty(){
		return property;
	}
	
	public ActionSpec<T> property(Sensor val) {
        property = checkNotNull(val, "property");
        return this;
	}
	
	public List<TransitionSpec<?>> getTransitionSpecs() {
        return transitionSpecs;
    }
	
	public ActionSpec<T> transition(TransitionSpec<?> val) {
		transitionSpecs.add(checkNotNull(val, "transitionSpec"));
        return this;
	}
	
}
