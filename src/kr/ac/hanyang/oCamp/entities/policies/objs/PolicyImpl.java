package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.ac.hanyang.oCamp.core.traits.oCampEnableable;
import kr.ac.hanyang.oCamp.entities.constraints.Constraint;

public class PolicyImpl extends AbstractEntity implements Policy, oCampEnableable{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	
	
	
	//public ConstraintSet getDesiredState(){return desiredState;}
	
	
	
	public PolicyImpl(){}
	
	@Override
	public void init(){
		super.init();
		initConstraints();
	}
	
	private SensorEventListener<Object> policyListener(Policy listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				log.info("*********Sensor Event**********");
				log.info("Sensor Event: "+event.getValue());
				listener.sensors().emit(POLICY_VIOLATED, event.getValue());
				log.info("*********Emitted Policy Violated **********");
				log.info("Sensor Event: "+event.getValue());
			}
		};
	}

	/* The set of constraints is immutable and required therefore there is no need to 
	   connect the sensors there. the sensors will be connected when targets are set 
	   this this will be done during initialization*/
	//@Override
	public void initConstraints() {
		for (Entity constraint: this.getChildren()){
			subscriptions().subscribe(constraint,  Constraint.CONSTRAINT_VIOLATED, policyListener(this));
		}
		sensors().emit(CONSTRAINTS_INIT, this.getChildren());
	}
	
	//@Override
	public void setTargets(List<Entity> targets) {
		config().set(TARGETS, targets);
		connectSensors();
		sensors().emit(SUBSCRIBERS_SET, targets);
	}

//	@Override
//	public boolean addTarget(Entity entity) {
//		if (this.config().add(entity)){
//			for (Constraint constraint: CONSTRAINTS.getDefaultValue()){
//				constraint.subscriptions().subscribe(entity, ((ConstraintImpl)constraint).getProperty(), ((ConstraintImpl)constraint).getListener());
//			}
//			sensors().emit(Policy.SUBSCRIBER_ADDED, entity);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean removeTarget(Entity entity) {
//		if (targets.remove(entity)){
//			for (Constraint constraint: CONSTRAINTS.getDefaultValue()){
//				constraint.subscriptions().unsubscribe(entity);
//			}
//			sensors().emit(Policy.SUBSCRIBER_REMOVED, entity);
//			return true;
//		}
//		return false;	
//	}
	
	@Override
	public List<Constraint> getDesiredState(){return (List<Constraint>) config().get(CONSTRAINTS);}

	@Override
	public List<Entity> getTargets(){return config().get(TARGETS);}
	
	
	private void connectSensors(){
		for (Entity constraint: this.getChildren()){
			Constraint constr = (Constraint) constraint;
			for (Entity entity: config().get(TARGETS)){
				constr.register(entity);
				//constraint.subscriptions().subscribe(entity, constraint.getProperty(), constraint.getListener());
			}
		}
	}

	@Override
	public void enable() {
		for (Constraint constraint: config().get(CONSTRAINTS)){
			
		}
		//connectSensors();
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}


}
