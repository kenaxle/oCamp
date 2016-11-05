package kr.ac.hanyang.oCamp.core.mgmt;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.BrooklynConfigKeys;
import org.apache.brooklyn.entity.group.DynamicCluster;

public class oCampConfigKeys extends BrooklynConfigKeys {
	public static final ConfigKey<EntitySpec<?>> MEMBER = DynamicCluster.MEMBER_SPEC;//ConfigKeys.newConfigKey(EntitySpec.class, "member", "the member of a dynamic cluster");
}
