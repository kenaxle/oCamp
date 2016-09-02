package kr.ac.hanyang.oCamp.api.transition;

import org.apache.brooklyn.api.entity.Entity;


public interface Transition extends Entity{
	
	public boolean setValue(Object value);	
	public boolean removeValue(Object value);
	
	public boolean evaluate(Object obj, Entity entity);
	
	public int getWeight();
	
}
