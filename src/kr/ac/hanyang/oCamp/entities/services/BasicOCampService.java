package kr.ac.hanyang.oCamp.entities.services;

import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

public interface BasicOCampService {
	
	public static final String[] CAPABILITIES = {"DependsOn"};
	
//	@SetFromFlag("location")
//	public static final ConfigKey<Location> LOCATION = ConfigKeys.newConfigKey(Location.class,"location","location to deploy the service");

	//public static final ConstraintSet[] CONSTRAINTS = {new ConstraintSet.Builder("base").addConstraint(new PolicyConstraint("state","equals","started"))
	//																					.addConstraint(new PolicyConstraint("state","equals","stopped"))
	//																					.build()};
}
