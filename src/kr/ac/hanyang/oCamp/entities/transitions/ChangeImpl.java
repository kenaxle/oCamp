package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;

public class ChangeImpl extends TransitionImpl implements Change{

	public ChangeImpl(){}
	
	@Override
	public void init(){
		
	}

	@Override
	public boolean evaluate(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getWeight(){
		return Change.WEIGHT;
	}

}
