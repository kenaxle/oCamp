package kr.ac.hanyang.oCamp.entities.services;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.location.cloud.CloudLocationConfig;
import org.apache.brooklyn.location.jclouds.JcloudsLocationConfig;
import org.jclouds.compute.domain.OsFamily;

public interface BasicOCampService {
	
	public static final ConfigKey<Object> LOCATIONS = ConfigKeys.newConfigKey(Object.class, "locations",
			"The location or locations to start in, as a string, a location object, a list of strings, "
					+ "or a list of location objects");
	
	public static final String[] CAPABILITIES = {"DependsOn"};
	
	public static final ConfigKey<OsFamily> OS_FAMILY = JcloudsLocationConfig.OS_FAMILY;
	public static final ConfigKey<String> OS_VERSION = JcloudsLocationConfig.OS_VERSION_REGEX;
	public static final ConfigKey<Boolean> OS_64BIT = CloudLocationConfig.OS_64_BIT;		    
	public static final ConfigKey<Object> MIN_RAM = CloudLocationConfig.MIN_RAM;			
	public static final ConfigKey<Integer> MIN_CORES = CloudLocationConfig.MIN_CORES;		    
	public static final ConfigKey<Object> MIN_DISK = CloudLocationConfig.MIN_DISK;	
	public static final ConfigKey<String> DOMAIN_NAME = CloudLocationConfig.DOMAIN_NAME;
	
	
}
