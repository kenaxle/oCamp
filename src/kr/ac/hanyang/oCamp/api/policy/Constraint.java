package kr.ac.hanyang.oCamp.api.policy;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;

public interface Constraint extends Entity{
	
	public boolean addProperty(AttributeSensor property);
	public boolean removeProperty(AttributeSensor constraint);
	
	public boolean addValue(Entity entity);
	public boolean removeValue(Entity entity);
	
}
