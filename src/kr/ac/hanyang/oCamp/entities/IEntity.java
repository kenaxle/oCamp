package kr.ac.hanyang.oCamp.entities;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.sensor.BasicSensor;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.objs.ConstraintSetImpl;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;

public interface IEntity<T> extends Entity{
	
	ConfigKey<String> LOCATION = ConfigKeys.newStringConfigKey(
            "location",
            "The the entity should be provisioned");
	
//	public static final ConstraintSetImpl CONSTRAINTSET = new ConstraintSetImpl.Builder("Entity Constraints").addConstraint(new ConstraintImpl.Builder( (BasicSensor) Attributes.SERVICE_UP).build())
//																									 .addConstraint(new ConstraintImpl.Builder( (BasicSensor) SoftwareProcess.PROVISIONING_LOCATION).build()).build();
//	
//	public ConstraintSetImpl getConstraintSet();
}
