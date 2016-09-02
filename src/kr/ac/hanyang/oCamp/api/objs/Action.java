package kr.ac.hanyang.oCamp.api.objs;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import kr.ac.hanyang.oCamp.api.transition.Transition;


public interface Action extends Entity{
	
	public boolean setProperty(Sensor property);	
	
	public boolean addTransitions(List<Transition> transition);
	
}
