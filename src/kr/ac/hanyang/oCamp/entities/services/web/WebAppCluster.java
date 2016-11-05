package kr.ac.hanyang.oCamp.entities.services.web;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.sensor.BasicAttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.group.DynamicCluster;
import org.apache.brooklyn.entity.webapp.ControlledDynamicWebAppCluster;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

@Catalog(name="WebApp Cluster", description="A webapp cluster")
@ImplementedBy(WebAppClusterImpl.class)
public interface WebAppCluster extends ControlledDynamicWebAppCluster, BasicOCampService{

	@SetFromFlag("member")
	ConfigKey<EntitySpec<?>> MEMBER_TYPE = DynamicCluster.MEMBER_SPEC;//new BasicAttributeSensorAndConfigKey<String>(String.class,"","");
//	
//	@SetFromFlag("memberSpec")
//    ConfigKey<EntitySpec<?>> MEMBER_SPEC = ConfigKeys.newConfigKey(
//            new TypeToken<EntitySpec<?>>() { },
//            "dynamiccluster.memberspec", "entity spec for creating new cluster members", getMemberSpec());

	
}
