package kr.ac.hanyang.oCamp.api.policy;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;

import com.google.common.collect.Lists;

public class ConstraintSpec<T extends Constraint> extends EntitySpec{

	public ConstraintSpec(Class<T> type) {
		super(type);
	}
	
	private Sensor property;
	private Entity value;
	
	public ConstraintSpec<T> property(Sensor val) {
        property = checkNotNull(val, "property");
        return this;
	}
	 
	public ConstraintSpec<T> value(Entity val) {
        value = checkNotNull(val, "value");
        return this;
	}
	
	public Sensor getProperty() {
        return property;
    }
	
	public Entity getValue() {
        return value;
    }
	
	
	
	
}
