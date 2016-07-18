package kr.ac.hanyang.entities.services.web.tomcat;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;

import kr.ac.hanyang.entities.IDeployable;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class Tomcat8 extends Tomcat8ServerImpl implements IDeployable, ITomcat, IService, Startable{


	@Override
	public String[] getCapabilities() {

		String[] result = new String[IBasicOCampService.CAPABILITIES.length+ITomcat.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(ITomcat.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, ITomcat.CAPABILITIES.length); 
		return result;

	}
	
	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}


}