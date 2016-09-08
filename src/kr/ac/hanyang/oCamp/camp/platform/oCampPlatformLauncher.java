package kr.ac.hanyang.oCamp.camp.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;

public class oCampPlatformLauncher /*extends BrooklynCampPlatformLauncher*/ {

	
	private oCampPlatform platform;
	private ManagementContext mgmt;
	
	public oCampPlatformLauncher launch() {
		if (platform != null)
			//throw new Exception("platform already exists!"); // will have to fix this
			System.out.println("There is an exception here. the platform already exists");
		if (mgmt == null)
			mgmt = new LocalManagementContext();
		platform = new oCampPlatform(PlatformRootSummary.builder().name("Brooklyn CAMP Platform").build(),
                getManagement());
		return this;
	}
	
	public oCampPlatform getCampPlatform(){
		return platform;
	}
	
	ManagementContext getManagement(){
		return mgmt;
	}
	
}
