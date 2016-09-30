package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(ChangeImpl.class)
public interface Change<T> extends Transition{
	
	public static final int WEIGHT = 2;
	
}
