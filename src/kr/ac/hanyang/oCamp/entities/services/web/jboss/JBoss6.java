package kr.ac.hanyang.oCamp.entities.services.web.jboss;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.jboss.JBoss6ServerImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.IBasicOCampService;

public class JBoss6 extends JBoss6ServerImpl implements IDeployable, IJBoss6, IService, Startable{


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
