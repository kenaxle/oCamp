package kr.ac.hanyang.oCamp.api.policyManager;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;

import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.api.objs.ActionGroup;
import kr.ac.hanyang.oCamp.api.objs.ActionGroupSpec;
import kr.ac.hanyang.oCamp.api.policy.ConstraintSpec;

public class PolicyManagerSpec<T extends PolicyManager> extends EntitySpec{

	public PolicyManagerSpec(Class<T> type) {
		super(type);
	}
	
	private final List<ActionGroup> actionGroups = Lists.newArrayList();
	private final List<ActionGroupSpec<?>> actionGroupSpecs = Lists.newArrayList();
	
	public List<ActionGroupSpec<?>> getActionGroupSpecs() {
        return actionGroupSpecs;
    }
	
	public PolicyManagerSpec<T> actionGroup(ActionGroupSpec<?> val) {
		actionGroupSpecs.add(checkNotNull(val, "actionGroupSpec"));
        return this;
	}
	
}
