package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.api.policy.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;

public class PolicyImpl extends AbstractEntity implements Policy{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	private String name;
	//private String type; //FIXME this is the policy manager.
	private List<Entity> targets; //FIXME may have to use a higher class
	private ConstraintSet desiredState;
	
	
	public ConstraintSet getDesiredState(){return desiredState;}
	
	public List<Entity> getTargets(){return targets;}
	
	public PolicyImpl(){}
	
	@Override
	public void init(){
		super.init();
		targets = new ArrayList<Entity>();
	}
	
//	@Override
//	public boolean addConstraintSet(ConstraintSet constraints) {
//		if (desiredState.addConstraintSet(constraints)){
//			sensors().emit(Policy.CONSTRAINTS_ADDED, constraints);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean removeConstraintSet(ConstraintSet constraints) {
//		if (desiredState.removeConstraint(constraints)){
//			sensors().emit(Policy.CONSTRAINTS_ADDED, constraints);
//			return true;
//		}
//		return false;
//	}


	private SensorEventListener<Object> policyListener(Entity listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				listener.sensors().emit(Policy.POLICY_VIOLATED, event.getValue());
			}
		};
	}

	@Override
	public boolean addConstraint(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeConstraint(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTarget(Entity entity) {
		if (targets.add(entity)){
			desiredState.registerEntity(entity);
			for (Constraint policyConst: desiredState.getConstraints()){
				this.subscriptions().subscribe((Entity) policyConst, ConstraintImpl.CONSTRAINT_VIOLATED, policyListener(this));
			}
			sensors().emit(Policy.SUBSCRIBER_ADDED, entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeTarget(Entity entity) {
		if (targets.remove(entity)){
			desiredState.unregisterEntity(entity);
			sensors().emit(Policy.SUBSCRIBER_REMOVED, entity);
			return true;
		}
		return false;	
	}
	
	
	// will implement later
	//public Entity getTarget()

}
