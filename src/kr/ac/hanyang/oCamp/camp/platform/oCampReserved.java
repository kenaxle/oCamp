package kr.ac.hanyang.oCamp.camp.platform;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;

public interface oCampReserved {
	public static final String OCAMP_PREFIX = "kr.ac.hanyang.oCamp.";
	public static final String POLICYMGR_PREFIX = "kr.ac.hanyang.oCamp.entities.policies.";
	public static final String POLICY_PREFIX = "kr.ac.hanyang.oCamp.entities.policies.objs.";
	public static final String SERVICE_PREFIX = "kr.ac.hanyang.oCamp.entities.services.";
	public static final String TRANSITION_PREFIX = "kr.ac.hanyang.oCamp.entities.transitions.";
	
	public static final ConfigKey IS_POLMGR = ConfigKeys.newBooleanConfigKey("is.policy.mgr");
}
