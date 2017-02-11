package kr.ac.hanyang.oCamp.entities.services.cluster;

import org.apache.brooklyn.entity.machine.pool.ServerPool;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;

@ImplementedBy(LoadBalancedClusterImpl.class)
public interface LoadBalancedCluster extends ServerPool{
	@SetFromFlag("member")
	ConfigKey<EntitySpec<?>> MEMBER_TYPE = ServerPool.MEMBER_SPEC;
	
	@SetFromFlag("inboundPorts")
	ConfigKey<EntitySpec<?>> INBOUND_PORTS = ServerPool.MEMBER_SPEC;
}
