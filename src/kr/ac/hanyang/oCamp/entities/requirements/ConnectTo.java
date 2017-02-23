package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcess;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Catalog(name="ConnectTo relationship", description="Represents the relationship ConnectsTo")
@ImplementedBy(ConnectToImpl.class)
public interface ConnectTo extends Entity{
	
	@SetFromFlag("user")
    ConfigKey<String> USERNAME = ConfigKeys.newConfigKey(String.class,"user" ,"username to connect using","admin");
	
	@SetFromFlag("password")
    ConfigKey<String> PASSWORD = ConfigKeys.newConfigKey(String.class,"password" ,"password to connect using","");
	
	@SetFromFlag("launchCommand")
    public static final ConfigKey<String> LAUNCH_COMMAND = VanillaSoftwareProcess.LAUNCH_COMMAND;
	
	public <T> T getScript();
}
