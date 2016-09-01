package kr.ac.hanyang.oCamp.api.objs;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.sensor.Sensor;

import kr.ac.hanyang.oCamp.api.transition.Transition;


public interface Action extends Entity{
	
	public boolean setProperty(Sensor property);	
	public boolean removeProperty(Sensor property);
	
	public boolean addTransition(Transition transition);
	public boolean removeTransition(Transition transition);
	
}
