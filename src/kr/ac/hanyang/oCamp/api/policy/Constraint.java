package kr.ac.hanyang.oCamp.api.policy;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;

public interface Constraint<T> extends Entity{
	
	public Sensor getProperty();

	public Object getValue();
	
	public ConstraintVector Violated(Entity entity);
	
	public void register(Entity entity);
	
	public void unregister(Entity entity);
	
	public boolean evaluate(SensorEvent event);
	
	public SensorEventListener<T> getListener();
	
	public Object initialValue();
}
