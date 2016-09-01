package kr.ac.hanyang.oCamp.api.policyManager;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.policy.Policy;

import kr.ac.hanyang.oCamp.api.objs.ActionGroup;


public interface PolicyManager extends Entity{
	
	public boolean addOCampPolicy(Policy policy);	
	public boolean removeOCampPolicy(Policy policy);
	
	public boolean addActionGroup(ActionGroup actionGroup);
	public boolean removeActionGroupt(ActionGroup actionGroup);
	
}
