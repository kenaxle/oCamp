package kr.ac.hanyang.oCamp.entities.constraints;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import kr.ac.hanyang.oCamp.api.policy.Policy;

public abstract class ConstraintImpl<T> extends AbstractEntity implements Constraint{
	private static final Logger log = LoggerFactory.getLogger(ConstraintImpl.class);
	
	public ConstraintImpl(){}
	
	@Override
	public void init(){
		super.init();
	}
	
	public Sensor getProperty(){
		return  config().get(PROPERTY);
	}

	//TODO need to fix this
	public Object getValue(){
		//return null;//value;
		return config().get(VALUE);//.getDefaultValue().getClass();//.getType();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void register(Entity entity){
		this.subscriptions().subscribe(entity, config().get(PROPERTY), constraintListener(this));
	}
	
	@Override
	public void unregister(Entity entity){
		this.subscriptions().unsubscribe(entity);
	}
	
	private SensorEventListener<Object> constraintListener(Constraint listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				log.info("*********Sensor Event**********");
				log.info("Sensor Event: "+event.getValue());
				if (!listener.evaluate(event)){
					log.info("*********Emitted Constraint Violated **********");
					log.info("Sensor Event: "+event.getValue());
					//try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
					try{
						PrintWriter outStream = new PrintWriter(new FileOutputStream("/users/kena/datafile_detect.txt"));
						outStream.println("failure detected on at time "+ System.currentTimeMillis());
						outStream.close();
					}catch(Exception e){
						
					}
					
					listener.sensors().emit(Constraint.CONSTRAINT_VIOLATED, event.getSource());
					
				}
			}
		};
	}
	
	
	public abstract ConstraintVector Violated(Entity entity);
		
	
    @Override
    
	public abstract boolean evaluate(SensorEvent event);
  
    public abstract Object evaluateOptional(Object oldValue);
    
    public abstract Object initialValue();
	
	public SensorEventListener<T> getListener(){
		return (SensorEventListener<T>) constraintListener(this);
	}


}
