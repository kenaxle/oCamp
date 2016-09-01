package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(IncreaseImpl.class)
public interface Increase<T> extends Transition<T>{
	
	public static final int WEIGHT = 1;
	
}
