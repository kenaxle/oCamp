package kr.ac.hanyang.oCamp.api.policy;

import static com.google.common.base.Preconditions.checkNotNull;
import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;

import com.google.common.collect.Lists;

public class PolicySpec<T extends Policy> extends EntitySpec{

	public PolicySpec(Class<T> type) {
		super(type);
	}
	
	private final List<Constraint> constraints = Lists.newArrayList();
	private final List<ConstraintSpec<?>> constraintSpecs = Lists.newArrayList();
	private final List<Entity> targets = Lists.newArrayList();
	private final List<EntitySpec<?>> targetSpecs = Lists.newArrayList();
		
	
	public List<ConstraintSpec<?>> getConstraintSpecs() {
        return constraintSpecs;
    }
	
	public List<EntitySpec<?>> getTargetSpecs() {
        return targetSpecs;
    }
	
	public PolicySpec<T> constraint(ConstraintSpec<?> val) {
        constraintSpecs.add(checkNotNull(val, "constraintSpec"));
        return this;
	}
	 
	public PolicySpec<T> target(EntitySpec<?> val) {
		targetSpecs.add(checkNotNull(val, "targetSpec"));
	    return this;
	}
	
}
