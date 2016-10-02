package kr.ac.hanyang.oCamp.camp.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;

public class oCampPlatformLauncher{

	
	private oCampPlatform platform;
	private ManagementContext mgmt;
	
	public oCampPlatformLauncher launch() {
		if (platform != null)
			//throw new Exception("platform already exists!"); // will have to fix this
			System.out.println("There is an exception here. the platform already exists");
		if (mgmt == null)
			mgmt = new BaseEntityManager();
			
		platform = new oCampPlatform(PlatformRootSummary.builder().name("oCAMP Platform").build(),
                getManagement());
		((BaseEntityManager) mgmt).setParentPlatform(platform);
		return this;
	}
	
	public oCampPlatformLauncher useManagementContext(ManagementContext mgmt){
		this.mgmt = mgmt;
		return this;
	}
	
	public oCampPlatform getCampPlatform(){
		return platform;
	}
	
	ManagementContext getManagement(){
		return mgmt;
	}
	
}
