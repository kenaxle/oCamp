package kr.ac.hanyang.oCamp.entities.services.nginx;

import org.apache.brooklyn.entity.group.DynamicCluster;
import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(LoadBalancerClusterImpl.class)
public interface LoadBalancerCluster extends DynamicCluster, LoadBalancer{

}
