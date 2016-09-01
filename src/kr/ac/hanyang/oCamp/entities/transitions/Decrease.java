package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(DecreaseImpl.class)
public interface Decrease<T> extends Transition<T>{
	
	public static final int WEIGHT = 1;
	
}
