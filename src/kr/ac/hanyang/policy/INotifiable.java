package kr.ac.hanyang.policy;

import org.apache.brooklyn.api.entity.Entity;

public interface INotifiable {
	
	public void notification(Entity entity);
	
}
