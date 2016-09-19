package kr.ac.hanyang.oCamp.entities.services.web.tomcat;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;
import org.apache.brooklyn.entity.webapp.tomcat.TomcatServerImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.Entities;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.artifacts.WarImpl;
import kr.ac.hanyang.oCamp.entities.policies.PolicyManagerImpl;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IEntity;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class Tomcat8Impl extends Tomcat8ServerImpl implements IDeployable, Tomcat8, IService, oCampStartable, IEntity{
	
	private static final Logger log = LoggerFactory.getLogger(WarImpl.class);
	private Map<String,PolicyManagerImpl> policyManagers;
	
	public Tomcat8Impl(){
		super();
		System.out.println("");
		//this.config().set("location", "AWS Tokyo (ap-northeast-1)");
	}
	
	public void init(){
		super.init();
		//policyManagers = new LinkedHashMap<String,PolicyManagerImpl>();
		//configure the constraint set here 
		//BasicSensorSupport sensorSup = this.sensors();
		//sensorSup.set(Attributes.SERVICE_UP, true);
	
		//System.out.println("The sensors "+sensorSup.getAll());
		//CONSTRAINTSET.addConstraint(new PolicyConstraint.Builder()));
	}

	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+Tomcat8.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(Tomcat8.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, Tomcat8.CAPABILITIES.length); 
		return result;

	}
	
	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}
	

	
	// need to abstract the starting process because the start method is marked as final 
	// this will initiate the start on the requirements and Artifacts then call 
	// start on itself
	//builds a parallel startup task and waits for the completion of the members.
//	public void startup(Collection<? extends Location> locations){
//		log.info("**** INFO INFO **** Starting Tomcat...");
//		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
//		for(Entity e: this.getChildren()){
//			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START));	
//		}
//		Task<Void> task = taskBuilder.parallel(true)
//				   					 .build();
//		task.blockUntilEnded();
//		if (task.isDone() /*&& !task.isError()*/){
//			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
//		}else
//			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
//	}

	
	public void startup(Collection<? extends Location> locations){
		log.info("**** INFO INFO **** Starting Tomcat...");
		try {
		    Thread.sleep(10000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START));	
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() /*&& !task.isError()*/){
			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			try {
			    Thread.sleep(10000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}else{
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			try {
			    Thread.sleep(10000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}

	
//	@Override
//	public ConstraintSetImpl getConstraintSet() {
//		return CONSTRAINTSET;
//	}
//	
//	public void subscribe(PolicyManagerImpl subscriber){
//		policyManagers.put(subscriber.getType(), subscriber);
//	}
//	
//	public void unsubscribe(PolicyManagerImpl subscriber){
//		policyManagers.remove(subscriber.getType());
//	}
//	
//	
//	//the entity is a constraint entity that is forwarded by the constraintset
//	// extract the policy manager and then initiate the policy manager's process
//	//for handling the 
//	@Override
//	public void notification(Entity entity) {
//		if (!(entity instanceof ConstraintImpl)) return; //this should be logged as an error
//		ConstraintImpl policyConstraint = (ConstraintImpl) entity;
//		PolicyManager policyManager = policyConstraint.getPolicyManager();
//		policyManager.evaluateActions(policyConstraint.getPolicy(), this);
//	}


}
