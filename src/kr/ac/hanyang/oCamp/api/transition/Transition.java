package kr.ac.hanyang.oCamp.api.transition;

import org.apache.brooklyn.api.entity.Entity;


public interface Transition extends Entity{
	
	public Object getValue();
	
	public boolean evaluate(Object obj);
	
	public int getWeight();
	
}
