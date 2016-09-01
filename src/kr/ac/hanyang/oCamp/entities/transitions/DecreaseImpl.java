package kr.ac.hanyang.oCamp.entities.transitions;

import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.core.entity.AbstractEntity;

public class DecreaseImpl<T> extends TransitionImpl implements Decrease{

	public DecreaseImpl(){}
	
	@Override
	public void init(){
		
	}
	
	@Override
	public boolean evaluate(SensorEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
