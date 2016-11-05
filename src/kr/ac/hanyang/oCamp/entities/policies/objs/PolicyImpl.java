package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.location.BasicLocationRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.oCampEnableable;
import kr.ac.hanyang.oCamp.entities.constraints.Constraint;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class PolicyImpl extends AbstractEntity implements Policy, oCampEnableable{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	private boolean policyState;
	
	public PolicyImpl(){}
	
	@Override
	public void init(){
		super.init();
		policyState = false;
		initConstraints();
	}
	
	private SensorEventListener<Object> policyListener(Policy listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				log.info("*********Sensor Event**********");
				log.info("Sensor Event: "+event.getValue());				
				//try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
				/*if(policyState)*/{
					log.info("*********Emitted Policy Violated **********");
					log.info("Sensor Event: "+event.getValue());
					listener.sensors().emit(POLICY_VIOLATED, event.getValue());
				}
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
	
	public void enable(){ this.policyState = true;}
	
	public void disable(){ this.policyState = false;}
	
	//selects the initial location by random from the list provided and 
	//cross-references with the configured locations.
	@SuppressWarnings("unchecked")
	public void initTargetLocations(BasicLocationRegistry locationReg){
		Constraint<?> constraint; 
		
		String location = null;
		for (Entity ent: getChildren()){
			if (((Constraint<?>)ent).getProperty().equals(ConstraintProperties.PROVISIONING_LOCATION)){
				constraint = (Constraint<?>)ent;
				List<String> locations = (List<String>) constraint.config().get(Constraint.VALUE);
				for( String loc: locations){
					if (locationReg.getDefinedLocationByName(loc) != null){
						location = loc;
						break;
					}
				}
			}
		}
		for(Entity entity: getTargets()){
			entity.config().set(BasicOCampService.LOCATIONS, location);
		}
	}
	
	private void connectSensors(){
		for (Entity constraint: this.getChildren()){
			Constraint<?> constr = (Constraint<?>) constraint;
			for (Entity entity: config().get(TARGETS)){
				constr.register(entity);
				
			}
		}
	}

	

}
