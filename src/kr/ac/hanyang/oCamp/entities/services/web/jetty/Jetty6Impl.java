package kr.ac.hanyang.oCamp.entities.services.web.jetty;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.jetty.Jetty6ServerImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class Jetty6Impl extends Jetty6ServerImpl implements IDeployable, Jetty6, IService, Startable{

	@Override
	public void deploy(String url, String targetName) {
		super.deploy(url, targetName);
	}


}
