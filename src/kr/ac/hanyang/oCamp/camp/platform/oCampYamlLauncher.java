package kr.ac.hanyang.oCamp.camp.platform;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.location.LocationDefinition;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampPlatformLauncherAbstract;
import org.apache.brooklyn.camp.brooklyn.YamlLauncherAbstract;
import org.apache.brooklyn.camp.server.rest.CampServer;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.location.BasicLocationDefinition;
import org.apache.brooklyn.core.mgmt.BrooklynTaskTags;
import org.apache.brooklyn.core.mgmt.classloading.BrooklynClassLoadingContextSequential;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.mgmt.internal.BrooklynShutdownHooks;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.apache.brooklyn.util.core.ResourceUtils;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.guava.Maybe;
import org.apache.brooklyn.util.stream.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class oCampYamlLauncher {
	private static final Logger log = LoggerFactory.getLogger(oCampYamlLauncher.class);
	protected boolean shutdownAppsOnExit = false;
	
	
	oCampPlatform platform;
	BrooklynLauncher launcher;
	oCampPlatformLauncher platformLauncher;
	ManagementContext oCampManagement;
	CampServer server;
	
	
	public oCampYamlLauncher(){
		this.platformLauncher = new oCampPlatformLauncher(); 
		platformLauncher.launch();
		this.platform = platformLauncher.getCampPlatform();
		this.oCampManagement = platformLauncher.getManagement();
	}
	
	public ManagementContext getManagement(){
		return oCampManagement;
	}
	
	public Application launchAppYaml(String url) {
        return launchAppYaml(url, true);
    }
	
	public Application launchAppYaml(String url, boolean waitForTasksToComplete) {
        try {
            Reader input = Streams.reader(new ResourceUtils(this).getResourceFromUrl(url));
            Application app = launchAppYaml(input, waitForTasksToComplete);
            log.info("Application started from YAML file "+url+": "+app);
            return app;
        } catch (Exception e) {
        	//System.out.println("Exception here"); //will have to fix this.
            throw Exceptions.propagate(e);
        }
    }
	
	public Application launchAppYaml(Reader input) {
        return launchAppYaml(input, true);
    }

    public Application launchAppYaml(Reader input, boolean waitForTasksToComplete) {
        try {
            AssemblyTemplate at = platform.pdp().registerDeploymentPlan(input);

            Assembly assembly = at.getInstantiator().newInstance().instantiate(at, platform);
            Entity app = oCampManagement.getEntityManager().getEntity(assembly.getId()); // an exception is thrown here... 
            log.info("Launching "+app);

            if (getShutdownAppsOnExit()) BrooklynShutdownHooks.invokeStopOnShutdown(app);

            if (waitForTasksToComplete) {
                Set<Task<?>> tasks = BrooklynTaskTags.getTasksInEntityContext(oCampManagement.getExecutionManager(), app);
                log.info("Waiting on "+tasks.size()+" task(s)");
                for (Task<?> t: tasks) {
                    t.blockUntilEnded();
                }
            }

            log.info("Application started from YAML: "+app);
            Entities.dumpInfo(app);
            return (Application)app;
        } catch (Exception e) {
            throw Exceptions.propagate(e);
        }
    }

    public boolean getShutdownAppsOnExit() {
        return shutdownAppsOnExit;
    }
    
    public void setShutdownAppsOnExit(boolean shutdownAppsOnExit) {
        this.shutdownAppsOnExit = shutdownAppsOnExit;
    }
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args){
		oCampYamlLauncher l = new oCampYamlLauncher();
		l.setShutdownAppsOnExit(true);
		l.launchAppYaml("file:///Users/Kena/Git/oCamp/src/kr/ac/hanyang/platform/basic-empty-app-and-entity-blueprint3.yaml");
		//l.launchAppYaml("file:///C:/Users/Kena/Git/oCamp/src/kr/ac/hanyang/platform/basic-empty-app-and-entity-blueprint2.yaml");
		
		
		

		
	}
	
//	public void stopServers() throws Exception {
//        yLauncher =  new oCampYamlLauncher().launch();
//		launcher.getServerDetails().getWebServer().stop();
//        campServer.stop();
//        yLauncher.launch();
//    }
}
