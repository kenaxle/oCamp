package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(Within_RangeImpl.class)
public interface Within_Range<T> extends Constraint<T> {
	
}
