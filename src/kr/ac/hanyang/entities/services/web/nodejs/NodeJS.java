package kr.ac.hanyang.entities.services.web.nodejs;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.nodejs.NodeJsWebAppServiceImpl;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class NodeJS extends NodeJsWebAppServiceImpl implements INodeJS, IService, Startable{


	@Override
	public String[] getCapabilities() {
		String[] result = new String[IBasicOCampService.CAPABILITIES.length+INodeJS.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(INodeJS.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, INodeJS.CAPABILITIES.length); 
		return result;

	}
	
	

}
