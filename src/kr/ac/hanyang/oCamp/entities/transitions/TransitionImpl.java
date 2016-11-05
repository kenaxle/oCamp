package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.core.entity.AbstractEntity;

//import kr.ac.hanyang.oCamp.entities.transitions.Transition;


public abstract class TransitionImpl extends AbstractEntity implements Transition{

	
	public TransitionImpl(){}
	
	@Override
	public void init(){
		
	}
	
	
	public Object getValue() {
		return config().get(VALUE);
	}
	
	@Override
	public int getWeight(){
		return WEIGHT;
	}

	@Override
	public abstract boolean evaluate(Object obj);

	
}
