package kr.ac.hanyang.policy;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Deprecated
public interface IPolicy{
	
	@SetFromFlag("state")
	public static final ConfigKey<String> STATE = new BasicConfigKey<String>(
			String.class, "state","The state of the entity");
	
//	@SetFromFlag("constraints")
//	public static final ConfigKey<String> CONSTRAINTS = new BasicConfigKey<String>(
//			String.class, "constraints","The content of this artifact");
//	
//	@SetFromFlag("targets")
//	public static final ConfigKey<String> TARGETS = new BasicConfigKey<String>(
//			String.class, "targets","The content of this artifact");
	
}
