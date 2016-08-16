package kr.ac.hanyang.policy;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

public interface IPolicy{
	@SetFromFlag("constraints")
	public static final ConfigKey<String> CONSTRAINTS = new BasicConfigKey<String>(
			String.class, "constraints","The content of this artifact");
	
	@SetFromFlag("targets")
	public static final ConfigKey<String> TARGETS = new BasicConfigKey<String>(
			String.class, "targets","The content of this artifact");
	
}
