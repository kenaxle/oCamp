package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class PolicyImpl extends AbstractEntity implements Policy{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	
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
	
	@Override
	public List<Entity> getTargets(){return config().get(TARGETS);}
	
	public void initTargetLocations(){
		Constraint constraint; 
		String location = "";
		for (Entity ent: getChildren()){
			if (((Constraint)ent).getProperty().equals(ConstraintProperties.PROVISIONING_LOCATION)){
				constraint = (Constraint)ent;
				location = (String) constraint.initialValue();
				
			}
		}
		for(Entity entity: getTargets()){
			entity.config().set(BasicOCampService.LOCATIONS, location);
		}
	}
	
	private void connectSensors(){
		for (Entity constraint: this.getChildren()){
			Constraint constr = (Constraint) constraint;
			for (Entity entity: config().get(TARGETS)){
				constr.register(entity);
				
			}
		}
	}
	
	

}
