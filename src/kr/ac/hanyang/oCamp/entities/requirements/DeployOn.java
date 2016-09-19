package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Catalog(name="DeployOn relationship", description="Represents the relationship DeployOn")
@ImplementedBy(DeployOnImpl.class)
public interface DeployOn extends Entity{
	
	@SetFromFlag("target")
    ConfigKey<String> TARGET = ConfigKeys.newConfigKey(String.class,"target" ,"/webapp");
	
//	@SetFromFlag("contentUrl")
//    ConfigKey<String> CONTENTURL = ConfigKeys.newConfigKey(String.class,"contentUrl");
	
	public <T> T getContentUrl();
	public String getTarget();
}
