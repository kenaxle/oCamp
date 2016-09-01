package kr.ac.hanyang.oCamp.api.policy;

import org.apache.brooklyn.api.entity.Entity;

public interface Policy extends Entity{
	
	public boolean addConstraint(Constraint constraint);
	public boolean removeConstraint(Constraint constraint);
	
	public boolean addTarget(Entity entity);
	public boolean removeTarget(Entity entity);
	
}
