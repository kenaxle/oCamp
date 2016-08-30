package kr.ac.hanyang.entities.services.web.tomcat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.Attributes;

import kr.ac.hanyang.entities.IDeployable;
import kr.ac.hanyang.entities.IEntity;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.services.IBasicOCampService;
import kr.ac.hanyang.policy.BasePolicyManager;
import kr.ac.hanyang.policy.ConstraintSet;
import kr.ac.hanyang.policy.IBasePolicyManager;
import kr.ac.hanyang.policy.INotifiable;
import kr.ac.hanyang.policy.PolicyConstraint;

public class Tomcat8 extends Tomcat8ServerImpl implements IDeployable, ITomcat, IService, Startable, IEntity{
	
	private Map<String,BasePolicyManager> policyManagers;
	
	public Tomcat8(){
		super();
		System.out.println("");
	}
	
	public void init(){
		super.init();
		policyManagers = new LinkedHashMap<String,BasePolicyManager>();
		//configure the constraint set here 
		BasicSensorSupport sensorSup = this.sensors();
		//sensorSup.set(Attributes.SERVICE_UP, true);
	
		System.out.println("The sensors "+sensorSup.getAll());
		//CONSTRAINTSET.addConstraint(new PolicyConstraint.Builder()));
	}

	@Override
	public String[] getCapabilities() {

		String[] result = new String[IBasicOCampService.CAPABILITIES.length+ITomcat.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(ITomcat.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, ITomcat.CAPABILITIES.length); 
		return result;

	}
	
	@Override
	public void deploy(String url, String targetName) {
		System.out.println(this.sensors().getAll());
		System.out.println(this.sensors().get(Attributes.SERVICE_UP));
		System.out.println(PROVISIONING_LOCATION);
		super.deploy(url, targetName);
	}

	@Override
	public ConstraintSet getConstraintSet() {
		return CONSTRAINTSET;
	}
	
	public void subscribe(BasePolicyManager subscriber){
		policyManagers.put(subscriber.getType(), subscriber);
	}
	
	public void unsubscribe(BasePolicyManager subscriber){
		policyManagers.remove(subscriber.getType());
	}
	
	
	//the entity is a constraint entity that is forwarded by the constraintset
	// extract the policy manager and then initiate the policy manager's process
	//for handling the 
	@Override
	public void notification(Entity entity) {
		if (!(entity instanceof PolicyConstraint)) return; //this should be logged as an error
		PolicyConstraint policyConstraint = (PolicyConstraint) entity;
		IBasePolicyManager policyManager = policyConstraint.getPolicyManager();
		policyManager.evaluateActions(policyConstraint.getPolicy(), this);
	}


}
