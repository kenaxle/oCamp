package kr.ac.hanyang.oCamp.entities.services.software;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcess;
import org.apache.brooklyn.util.core.flags.SetFromFlag;


@Catalog(name="oCamp SoftwareProcess Entity", description="Represents a software process")
@ImplementedBy(VanillaSoftwareImpl.class)

public interface VanillaSoftware extends VanillaSoftwareProcess {
    
    @SetFromFlag("install_command")
    ConfigKey<String> INSTALL_COMMAND = VanillaSoftwareProcess.INSTALL_COMMAND;
    
    @SetFromFlag("customize_command")
    ConfigKey<String> CUSTOMIZE_COMMAND = VanillaSoftwareProcess.CUSTOMIZE_COMMAND;
    
    @SetFromFlag("launch_command")
    ConfigKey<String> LAUNCH_COMMAND = VanillaSoftwareProcess.LAUNCH_COMMAND;
    
    @SetFromFlag("stop_command")
    ConfigKey<String> STOP_COMMAND = VanillaSoftwareProcess.STOP_COMMAND;

}
