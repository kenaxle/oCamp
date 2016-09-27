package kr.ac.hanyang.oCamp.api.policyManager;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.ManagementContext;


public interface PolicyManager extends Entity{
	
	ManagementContext getManagementContext();
	
}
