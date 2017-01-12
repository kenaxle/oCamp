package kr.ac.hanyang.oCamp.api.policy;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.location.BasicLocationRegistry;


public interface Policy extends Entity{
	
	
	public void initConstraints();
	
	public void setTargets(List<Entity> targets);
	
	public List<Entity> getTargets();
	
	public void initTargetLocations(BasicLocationRegistry locationReg);
	
	public void enable();
	
	public void disable();
}
