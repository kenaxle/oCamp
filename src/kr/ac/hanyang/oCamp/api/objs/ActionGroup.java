package kr.ac.hanyang.oCamp.api.objs;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.policy.Policy;


public interface ActionGroup extends Entity{
	
	public boolean setActionID(Effector actionEffector);	
	public boolean removeActionID(Effector actionEffector);
	
	public boolean addAction(Action action);
	public boolean removeAction(Action action);
	
}
