package kr.ac.hanyang.oCamp.api.objs;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.sensor.Sensor;

import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.api.policy.ConstraintSpec;

public class ActionGroupSpec<T extends ActionGroup> extends EntitySpec{

	public ActionGroupSpec(Class<T> type) {
		super(type);
	}
	
	private Effector actionID;
	private final List<Action> actions = Lists.newArrayList();
	private final List<ActionSpec<?>> actionSpecs = Lists.newArrayList();
	
	public Effector getActionID(){
		return actionID;
	}
	
	public ActionGroupSpec<T> actionID(Effector val) {
        actionID = checkNotNull(val, "actionID");
        return this;
	}
	
	public List<ActionSpec<?>> getActionSpecs() {
        return actionSpecs;
    }
	
	public ActionGroupSpec<T> action(ActionSpec<?> val) {
		actionSpecs.add(checkNotNull(val, "actionSpec"));
        return this;
	}
	
}
