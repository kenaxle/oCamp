package kr.ac.hanyang.oCamp.entities.services;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;

public interface BasicOCampService {
	
	public static final ConfigKey<Object> LOCATIONS = ConfigKeys.newConfigKey(Object.class, "locations",
			"The location or locations to start in, as a string, a location object, a list of strings, "
					+ "or a list of location objects");
	
	public static final String[] CAPABILITIES = {"DependsOn"};
	
	
}
