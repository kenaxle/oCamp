package kr.ac.hanyang.oCamp.entities.services.web.tomcat;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.JavaWebAppDriver;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.repackaged.com.google.common.base.Throwables;
import com.google.common.collect.Sets;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
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
	}
	
	public void init(){
		super.init(); 
		int count = 0; boolean val;
	}

	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+Tomcat8.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(Tomcat8.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, Tomcat8.CAPABILITIES.length); 
		return result;
		
	}
	
	@Override
	@Effector(description="Deploys the given artifact, from a source URL, to a given deployment filename/context")
	public void deploy(
            @EffectorParam(name="url", description="URL of WAR file") String url, 
            @EffectorParam(name="targetName", description="context path where WAR should be deployed (/ for ROOT)") String targetName) {
		super.deploy(url, targetName);
//	       try {
//	            
//	            JavaWebAppDriver driver = getDriver();
//	            String deployedName = driver.deploy(url, targetName);
//	            
//	            // Update attribute
//	            Set<String> deployedWars = getAttribute(DEPLOYED_WARS);
//	            if (deployedWars == null) {
//	                deployedWars = Sets.newLinkedHashSet();
//	            }
//	            deployedWars.add(deployedName);
//	            sensors().set(DEPLOYED_WARS, deployedWars);
//	        } catch (RuntimeException e) {
//	            // Log and propagate, so that log says which entity had problems...
//	            log.warn("Error deploying '"+url+"' to "+targetName+" on "+toString()+"; rethrowing...", e);
//	            throw Throwables.propagate(e);
//	        }
	}
	

	
	// need to abstract the starting process because the start method is marked as final 
	// this will initiate the start on the requirements and Artifacts then call 
	// start on itself
	//builds a parallel startup task and waits for the completion of the members.
	public void startup(Collection<? extends Location> locations){
		log.info("**** INFO INFO **** Starting Tomcat...");

		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START));	
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() && !task.isError()){
			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			
		}else{
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			
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
