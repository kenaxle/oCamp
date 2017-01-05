package kr.ac.hanyang.oCamp.entities.services.web.tomcat;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8Server;
import org.apache.brooklyn.entity.webapp.tomcat.TomcatServer;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

@Catalog(name="Tomcat Entity", description="Represents a server")
@ImplementedBy(Tomcat8Impl.class)
public interface Tomcat8 extends Tomcat8Server, BasicOCampService {
	
	@SetFromFlag("version")
    ConfigKey<String> SUGGESTED_VERSION = ConfigKeys.newConfigKeyWithDefault(SoftwareProcess.SUGGESTED_VERSION, "8.0.37");

	@SetFromFlag("downloadUrl")
    AttributeSensorAndConfigKey<String, String> DOWNLOAD_URL = ConfigKeys.newSensorAndConfigKeyWithDefault(SoftwareProcess.DOWNLOAD_URL,
            "http://mirror.apache-kr.org/tomcat/tomcat-8/v${version}/bin/apache-tomcat-${version}.tar.gz");

	public static final String[] CAPABILITIES = {"DeployOn"};
		//need to add the characteristics also
		//characteristics should be added as AttributeSensorAndConfigKey
	

}
