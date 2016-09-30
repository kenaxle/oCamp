package kr.ac.hanyang.oCamp.api.policyManager;

import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.ManagementContext;

import kr.ac.hanyang.oCamp.entities.policies.objs.ActionGroup;
import kr.ac.hanyang.oCamp.entities.policies.objs.Policy;


public interface PolicyManager extends Application{
	
	ManagementContext getManagementContext();
	
	public List<ActionGroup> evaluateActions(Entity entity, Policy policy);
	
	public void doAction(Effector effector, Entity entity);
	
	public boolean addOCampPolicy(Policy policy);	
	
	public boolean removeOCampPolicy(Policy policy);
}
