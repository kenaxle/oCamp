package kr.ac.hanyang.oCamp.entities.services.web.jboss;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.webapp.jboss.JBoss6Server;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8Server;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

@Catalog(name="JBoss Entity", description="Represents a server")
@ImplementedBy(JBoss7Impl.class)
public interface JBoss7 extends JBoss6Server {

//	@SetFromFlag("version")
//    ConfigKey<String> SUGGESTED_VERSION = ConfigKeys.newConfigKeyWithDefault(SoftwareProcess.SUGGESTED_VERSION, "8.0.36");
//
//	@SetFromFlag("downloadUrl")
//    AttributeSensorAndConfigKey<String, String> DOWNLOAD_URL = ConfigKeys.newSensorAndConfigKeyWithDefault(SoftwareProcess.DOWNLOAD_URL,
//            "http://mirror.apache-kr.org/tomcat/tomcat-8/v${version}/bin/apache-tomcat-${version}.tar.gz");

	public static final String[] CAPABILITIES = {"DeployOn"};
		//need to add the characteristics also
		//characteristics should be added as AttributeSensorAndConfigKey

}
