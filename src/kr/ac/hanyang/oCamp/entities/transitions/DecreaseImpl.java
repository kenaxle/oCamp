package kr.ac.hanyang.oCamp.entities.transitions;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

public class DecreaseImpl extends TransitionImpl implements Decrease{

	public DecreaseImpl(){}
	
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
		return Decrease.WEIGHT;
	}

}
