package kr.ac.hanyang.oCamp.api.objs;

import java.util.Collection;
import java.util.List;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.sensor.Sensor;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintVector;
import kr.ac.hanyang.oCamp.entities.policies.objs.FulfillmentVector;


public interface ActionGroup extends Entity{
	
	public boolean setActionID(Effector actionEffector);	
	
	public FulfillmentVector canFulfill(Collection<ConstraintVector> violatedConstraints);
	
	public Effector getActionEffector();
	
	
}
