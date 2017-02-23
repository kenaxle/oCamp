package kr.ac.hanyang.oCamp.camp.platform;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.camp.server.rest.CampServer;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.mgmt.BrooklynTaskTags;
import org.apache.brooklyn.core.mgmt.internal.BrooklynShutdownHooks;
import org.apache.brooklyn.entity.webapp.DynamicWebAppCluster;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.ResourceUtils;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.stream.Streams;
import org.apache.brooklyn.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;

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
            AssemblyTemplate at = platform.oCampPdp().registerDeploymentPlan(input);
            //Application app = ((oCampAssemblyTemplateInstantiator)at.getInstantiator().newInstance()).instantiateApp(at, platform);
            Application app = (OCampEntityManagementUtils.instantiateApp(at, platform));
            //Entity app = oCampManagement.getEntityManager().getEntity(assembly.getId()); // an exception is thrown here...if the app is not actually deployed 
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
	public static void main (String[] args) throws FileNotFoundException{
		PrintWriter outStream = new PrintWriter(new FileOutputStream("C:/users/kenax/datafile.txt"));
		Application app = null;
		oCampYamlLauncher l = new oCampYamlLauncher();
		l.setShutdownAppsOnExit(true);
		
		//l.launchAppYaml("file:///C:/Users/Kena/Git/oCamp/src/kr/ac/hanyang/oCamp/camp/platform/basic-empty-app-and-entity-blueprint2.yaml");
		Scanner myScanner = new Scanner(System.in);
		while (true){
			System.out.println("Select an option. ");
			System.out.println("1: Create application ");
			System.out.println("2: Start the application ");
			System.out.println("3: Get entity names. ");
			System.out.println("4: Simulate failure on specific entity. ");
			System.out.println("5: Exit oCamp. ");
			String choice = myScanner.next();
			switch (choice){
				case "1":
					app = l.launchAppYaml("file:///C:/Users/Kenax/Git/oCamp/src/kr/ac/hanyang/oCamp/camp/platform/desired-wordpress-blueprint-sql.yaml");
					break;
				case "2":
					outStream.println("Starting Appliction"+ System.currentTimeMillis());
					Task task = Entities.invokeEffector(app, app, oCampStartable.STARTUP//,
				            // locations already set in the entities themselves;
				            // TODO make it so that this arg does not have to be supplied to START !
				            //MutableMap.of("locations", MutableList.of("AWS Tokyo (ap-northeast-1)"))
				            );
					task.blockUntilEnded(new Duration(15, TimeUnit.MINUTES));
					outStream.println("finished starting  "+ System.currentTimeMillis());
					outStream.close();
					break;
				case "3":
					for(Entity entity: app.getChildren()){
						System.out.println(entity.getDisplayName());
					}
					break;
				case "4":
					System.out.println("Enter the entity name");
					String name = myScanner.next();
					long time1 = System.currentTimeMillis();
					outStream.println("failure started on "+name+" at time "+ time1);
					System.out.println("Select a failure. ");
					System.out.println("1: System State down ");
					System.out.println("2: System State up ");
					System.out.println("3: Scale up . ");
					System.out.println("4: Scale down. ");
					System.out.println("5: Cancel. ");
					String choice2 = myScanner.next();
					switch (choice2){
					case "1":
						for(Entity entity: app.getChildren()){
							if(entity.getDisplayName().equals(name))
								entity.sensors().set(Attributes.SERVICE_UP, false);
								//System.out.println(entity.toString());
						}
						break;
					case "2":
						for(Entity entity: app.getChildren()){
							if(entity.getDisplayName().equals(name))
								entity.sensors().set(Attributes.SERVICE_UP, true);
								//System.out.println(entity.toString());
						}
						break;
					case "3":
						for(Entity entity: app.getChildren()){
							if(entity.getDisplayName().equals(name)){
								entity.sensors().set(DynamicWebAppCluster.REQUESTS_PER_SECOND_LAST_PER_NODE, new Double(10));
								break;
							}
								//System.out.println(entity.toString());
						}
						break;
					case "4":
						for(Entity entity: app.getChildren()){
							if(entity.getDisplayName().equals(name)){
								entity.sensors().set(DynamicWebAppCluster.REQUESTS_PER_SECOND_LAST_PER_NODE, new Double(1));
								break;
							}
								//System.out.println(entity.toString());
						}
						break;
					case "5":
						break;
					}
					
					
					break;
				case "5":
					outStream.close();
					System.exit(0);
					break;
				default:
					break;
			}
			
		}
		

		
	}
	
//	public void stopServers() throws Exception {
//        yLauncher =  new oCampYamlLauncher().launch();
//		launcher.getServerDetails().getWebServer().stop();
//        campServer.stop();
//        yLauncher.launch();
//    }
}
