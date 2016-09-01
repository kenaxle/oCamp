package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(SetImpl.class)
public interface Set<T> extends Transition<T>{
	
	public static final int WEIGHT = 1;
	
}
