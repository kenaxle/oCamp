package kr.ac.hanyang.oCamp.entities.services.web.nodejs;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.nodejs.NodeJsWebAppServiceImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class NodeJSImpl extends NodeJsWebAppServiceImpl implements NodeJS, IService, Startable{


	@Override
	public String[] getCapabilities() {
		String[] result = new String[BasicOCampService.CAPABILITIES.length+NodeJS.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(NodeJS.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, NodeJS.CAPABILITIES.length); 
		return result;

	}
	
	

}
