package kr.ac.hanyang.oCamp.entities.services.web.jetty;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8Server;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Catalog(name="Jetty Entity", description="Represents a Jetty server")
@ImplementedBy(Jetty6.class)
public interface IJetty6 extends Tomcat8Server {

	public static final String[] CAPABILITIES = {"DeployOn"};
		
}
