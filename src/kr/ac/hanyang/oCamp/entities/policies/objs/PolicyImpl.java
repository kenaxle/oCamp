package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.api.policy.Constraint;
import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;

public class PolicyImpl extends AbstractEntity implements Policy{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	//private String name;
	//private String type; //FIXME this is the policy manager.
	private List<Entity> targets; //FIXME may have to use a higher class
	private List<Constraint> desiredState;
	
	
	//public ConstraintSet getDesiredState(){return desiredState;}
	
	
	
	public PolicyImpl(){}
	
	@Override
	public void init(){
		super.init();
		targets = new ArrayList<Entity>();
	}
	
	private SensorEventListener<Object> policyListener(Policy listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				listener.sensors().emit(POLICY_VIOLATED, event.getValue());
			}
		};
	}

	/* The set of constraints is immutable and required therefore there is no need to 
	   connect the sensors there. the sensors will be connected when targets are set */
	@Override
	public boolean setConstraints(List<Constraint> constraints) {
		if (config().set(CONSTRAINTS, constraints) != null){
			for (Constraint constraint: constraints){
				subscriptions().subscribe(constraint, ((ConstraintImpl)constraint).CONSTRAINT_VIOLATED, policyListener(this));
			}
			sensors().emit(CONSTRAINTS_SET, constraints);
			//FIXME need to subscribe
			return true;
		}
		return false;
	}
	
	@Override
	public boolean setTargets(List<Entity> targets) {
		if (config().set(TARGETS, targets) != null){
			connectSensors();
			sensors().emit(CONSTRAINTS_SET, targets);
			return true;
		}
		return false;
	}

	@Override
	public boolean addTarget(Entity entity) {
		if (targets.add(entity)){
			for (Constraint constraint: desiredState){
				constraint.subscriptions().subscribe(entity, ((ConstraintImpl)constraint).getProperty(), ((ConstraintImpl)constraint).getListener());
			}
			sensors().emit(Policy.SUBSCRIBER_ADDED, entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeTarget(Entity entity) {
		if (targets.remove(entity)){
			for (Constraint constraint: desiredState){
				constraint.subscriptions().unsubscribe(entity);
			}
			sensors().emit(Policy.SUBSCRIBER_REMOVED, entity);
			return true;
		}
		return false;	
	}
	
	@Override
	public List<Constraint> getDesiredState(){return desiredState;}

	@Override
	public List<Entity> getTargets(){return targets;}
	
	
	private void connectSensors(){
		for (Constraint constraint: desiredState){
			for (Entity entity: targets){
				constraint.subscriptions().subscribe(entity, ((ConstraintImpl)constraint).getProperty(), ((ConstraintImpl)constraint).getListener());
			}
		}
	}
	
	// will implement later
	//public Entity getTarget()

}
