package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(WithinImpl.class)
public interface Within<T> extends PolicyConstraint<T> {
	
}
