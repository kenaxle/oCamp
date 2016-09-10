package kr.ac.hanyang.oCamp.camp.pdp;

import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate.Builder;
import org.apache.brooklyn.camp.spi.PlatformTransaction;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;

import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;

public class oCampAssemblyTemplateConstructor extends AssemblyTemplateConstructor {
	
	private final oCampPlatform campPlatform;

	public oCampAssemblyTemplateConstructor(CampPlatform campPlatform) {
		super(campPlatform);
		this.campPlatform = (oCampPlatform)campPlatform;
	}

	public oCampPlatform getPlatform(){
		return campPlatform;
	}
	
	

}

//need this class only to expose the platform