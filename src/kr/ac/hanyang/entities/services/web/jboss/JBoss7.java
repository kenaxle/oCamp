package kr.ac.hanyang.entities.services.web.jboss;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;

import kr.ac.hanyang.entities.IDeployable;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class JBoss7 extends Tomcat8ServerImpl implements IDeployable, IJBoss6, IService, Startable{


	@Override
	public String[] getCapabilities() {

		String[] result = new String[IBasicOCampService.CAPABILITIES.length+IJBoss6.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(IJBoss6.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, IJBoss6.CAPABILITIES.length); 
		return result;

	}
	
	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}


}
