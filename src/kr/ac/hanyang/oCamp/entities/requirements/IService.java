package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.core.sensor.Sensors;

public interface IService{
	
	public String[] getCapabilities();
	
	public static final AttributeSensor<Boolean> ENTITY_STARTED = Sensors.newBooleanSensor("entity.started", "the entity is started or not");
	
	
}
