package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(EqualToImpl.class)
public interface EqualTo<T> extends Constraint<T> {
	
}
