package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.Entities;

public class Action implements IAction{
	
	private String type;
	private Entity entity;
	private BasePolicyManager policyManager;
	private ConstraintSet constraintSet;
	
	public Action(BasePolicyManager policyManager, String type, Entity entity, ConstraintSet constraintSet){
		this.policyManager = policyManager;
		this.type = type;
		this.entity = entity;
		this.constraintSet = constraintSet;
	}

	@Effector(description="Executes an action on an entity once given the action name")
	public void action(	@EffectorParam(name="effectorName", description="name of the action to perform") MethodEffector effectorName){
		
		Task<Void> action = Entities.invokeEffector(policyManager, entity, effectorName);
		
	}

	
}
