package kr.ac.hanyang.oCamp.api.policyManager;

import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import kr.ac.hanyang.oCamp.api.policy.Policy;
import kr.ac.hanyang.oCamp.api.objs.ActionGroup;


public interface PolicyManager extends Entity{
	
	public boolean addOCampPolicy(Policy policy);	
	public boolean removeOCampPolicy(Policy policy);
	
	public boolean setActionGroups(List<ActionGroup> actionGroups);
	
}
