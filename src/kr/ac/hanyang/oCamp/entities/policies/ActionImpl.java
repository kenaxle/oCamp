package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;

public class ActionImpl extends AbstractEntity implements Action{
	
	private BasicAttributeSensor property; //TODO this should be a Brooklyn attribute or sensor.
	//private T value; // this is the value/values of the property.
	
	//private String type;
	//private Entity entity;
	//private PolicyManagerImpl policyManager;
	//private ConstraintSetImpl constraintSet;
	
	public ActionImpl(){ }

	@Effector(description="Executes an action on an entity once given the action name")
	public void action(	@EffectorParam(name="effectorName", description="name of the action to perform") MethodEffector effectorName){
		
		Task<Void> action = Entities.invokeEffector(policyManager, entity, effectorName);
		
	}

	
}
