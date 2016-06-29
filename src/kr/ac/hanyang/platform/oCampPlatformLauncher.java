package kr.ac.hanyang.platform;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.brooklyn.camp.brooklyn.BrooklynCampPlatformLauncherAbstract;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.apache.brooklyn.launcher.camp.BrooklynCampPlatformLauncher;

public class AppPlatformLauncher extends BrooklynCampPlatformLauncher {
	BrooklynLauncher launcher;
	BrooklynCampPlatformLauncherAbstract yLauncher;
	
	
	public BrooklynCampPlatformLauncher launch(){
		launcher = BrooklynLauncher.newInstance().start();
		//yLauncher	
		return this;
	}
	
	public static void main (String[] args){
		new AppPlatformLauncher().launch();
	}
	
	public void stopServers() throws Exception {
        yLauncher = new SimpleYamlLauncher().newPlatformLauncher();
		//launcher.getServerDetails().getWebServer().stop();
        //campServer.stop();
       // yLauncher.launch();
    }
	
}
