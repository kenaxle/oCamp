package kr.ac.hanyang.oCamp.entities.services.web.tomcat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.Attributes;

import kr.ac.hanyang.oCamp.entities.IDeployable;
import kr.ac.hanyang.oCamp.entities.IEntity;
import kr.ac.hanyang.oCamp.entities.IExecutable;
import kr.ac.hanyang.oCamp.entities.IService;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.BasePolicyManager;
import kr.ac.hanyang.oCamp.entities.policies.ConstraintSetImpl;
import kr.ac.hanyang.oCamp.entities.policies.IBasePolicyManager;
import kr.ac.hanyang.oCamp.entities.policies.INotifiable;
import kr.ac.hanyang.oCamp.entities.services.IBasicOCampService;

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
	public ConstraintSetImpl getConstraintSet() {
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
		if (!(entity instanceof PolicyConstraintImpl)) return; //this should be logged as an error
		PolicyConstraintImpl policyConstraint = (PolicyConstraintImpl) entity;
		IBasePolicyManager policyManager = policyConstraint.getPolicyManager();
		policyManager.evaluateActions(policyConstraint.getPolicy(), this);
	}


}
