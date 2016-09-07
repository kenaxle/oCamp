package kr.ac.hanyang.oCamp.entities.services.web.tomcat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;
import org.apache.brooklyn.core.entity.Attributes;

import kr.ac.hanyang.oCamp.entities.IDeployable;
import kr.ac.hanyang.oCamp.entities.IEntity;
import kr.ac.hanyang.oCamp.entities.IService;
import kr.ac.hanyang.oCamp.entities.policies.PolicyManagerImpl;
import kr.ac.hanyang.oCamp.entities.services.IBasicOCampService;

public class Tomcat8 extends Tomcat8ServerImpl implements IDeployable, ITomcat, IService, Startable, IEntity{
	
	private Map<String,PolicyManagerImpl> policyManagers;
	
	public Tomcat8(){
		super();
		System.out.println("");
		//this.config().set("location", "AWS Tokyo (ap-northeast-1)");
	}
	
	public void init(){
		super.init();
		policyManagers = new LinkedHashMap<String,PolicyManagerImpl>();
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
