package kr.ac.hanyang.oCamp.api.policy;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;

public interface Policy extends Entity{
	
	public void initConstraints();
	
	public void setTargets(List<Entity> targets);
	
	public List<Entity> getTargets();
	
}
