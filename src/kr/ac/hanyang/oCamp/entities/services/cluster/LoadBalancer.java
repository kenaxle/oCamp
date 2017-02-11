package kr.ac.hanyang.oCamp.entities.services.cluster;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.proxy.LoadBalancerCluster;

public interface LoadBalancer extends LoadBalancerCluster, Entity, Startable{
	
}
