package kr.ac.hanyang.oCamp.entities.constraints;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.api.policy.Policy;

public class WithinImpl<T> extends ConstraintImpl<T> implements Within {
	
	public WithinImpl(){}
	
	public void init(){super.init();}
	
	public boolean evaluate(SensorEvent event){
		//if (! getValue() instanceof )
//		if (event.getValue().getClass() != getValue().getClass()) return false;
//		return ((T)event.getValue()).equals((T)getValue());
		return true; // using for testing 
	}
	
	public boolean isAlignedWith(Constraint constraint){
		return false;
	}

	@Override
	public boolean isViolated(Sensor propertySensor, Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void register(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	

	
}
