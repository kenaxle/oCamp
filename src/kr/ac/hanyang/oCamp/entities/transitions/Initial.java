package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(InitialImpl.class)
public interface Initial extends Transition{
	
	public static final int WEIGHT = 1;
	
}
