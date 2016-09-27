package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.lang.reflect.Field;

import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.entity.machine.MachineAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;

public class ConstraintProperties {
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	
	public static final Sensor PROVISIONING_LOCATION = SoftwareProcess.PROVISIONING_LOCATION;
	public static final Sensor SERVICE_UP = Attributes.SERVICE_UP;
	public static final Sensor SERVICE_STATE = Attributes.SERVICE_STATE_ACTUAL;
	public static final Sensor CPU_USAGE = MachineAttributes.CPU_USAGE;
	public static final Sensor ENTITY_STARTED = IService.ENTITY_STARTED;
	
	public static Sensor getProperty(String name){
		Sensor result = null;
		Class clazz = ConstraintProperties.class;
		try{
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			if (field.isAccessible()){
				result = (Sensor) field.get(null);
			}else{
				return null;
			}
		}catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e){
			log.error("ERROR: cannot return sensor "+name+". Reason: "+e.getMessage());
		}
		return result;
	}
	
}
