package kr.ac.hanyang.oCamp.entities.services.web.nodejs;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.webapp.nodejs.NodeJsWebAppService;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8Server;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Catalog(name="NodeJS Entity", description="Represents a Node.js")
@ImplementedBy(NodeJSImpl.class)
public interface NodeJS extends NodeJsWebAppService {

	public static final String[] CAPABILITIES = {};
		
	
}
