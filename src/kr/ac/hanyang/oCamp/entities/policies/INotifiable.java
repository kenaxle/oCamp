package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.Entity;

public interface INotifiable {
	
	public void notification(Entity entity);
	
}
