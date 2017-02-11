package kr.ac.hanyang.oCamp.entities.services.web.jboss;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.jboss.JBoss6ServerImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class JBoss6Impl extends JBoss6ServerImpl implements IDeployable, JBoss6, IService, Startable{

	
	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}


}
