package kr.ac.hanyang.oCamp.entities;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.sensor.BasicSensor;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.ConstraintSetImpl;
import kr.ac.hanyang.oCamp.entities.policies.INotifiable;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;

public interface IEntity<T> extends Entity, INotifiable{
	
	ConfigKey<String> LOCATION = ConfigKeys.newStringConfigKey(
            "location",
            "The the entity should be provisioned");
	
	public static final ConstraintSetImpl CONSTRAINTSET = new ConstraintSetImpl.Builder("Entity Constraints").addConstraint(new PolicyConstraintImpl.Builder( (BasicSensor) Attributes.SERVICE_UP).build())
																									 .addConstraint(new PolicyConstraintImpl.Builder( (BasicSensor) SoftwareProcess.PROVISIONING_LOCATION).build()).build();
	
	public ConstraintSetImpl getConstraintSet();
}
