package kr.ac.hanyang.oCamp.api.objs;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;

import kr.ac.hanyang.oCamp.api.transition.Transition;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.policies.objs.FulfillmentVector;


public interface Action extends Entity{
	
	public boolean setProperty(Sensor property);	
	
	public Sensor getProperty();
	
	public int getScore(ConstraintVector constVect, FulfillmentVector fulfillment);
	
}
