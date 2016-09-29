package kr.ac.hanyang.oCamp.api.policy;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;

public interface Constraint<T> extends Entity{
	
	public boolean setProperty(Sensor property);
	//public boolean removeProperty(Sensor constraint);
	
	public boolean setValue(Object object);
	//public boolean removeValue(Entity entity);
	
	public Sensor getProperty();

	public T getValue();
	
	
	//public ConstraintVector isViolated(Entity entity);
	
}
