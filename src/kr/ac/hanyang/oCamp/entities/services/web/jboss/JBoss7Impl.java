package kr.ac.hanyang.oCamp.entities.services.web.jboss;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.tomcat.Tomcat8ServerImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class JBoss7Impl extends Tomcat8ServerImpl implements IDeployable, JBoss7, IService, Startable{


	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+JBoss6.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(JBoss6.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, JBoss6.CAPABILITIES.length); 
		return result;

	}
	
	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}


}
