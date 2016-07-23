package kr.ac.hanyang.entities.services.database.mysql;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.database.mysql.MySqlNodeImpl;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class MySQL extends MySqlNodeImpl implements IExecutable, IMySQL, IService, Startable{


	@Override
	public String[] getCapabilities() {

		String[] result = new String[IBasicOCampService.CAPABILITIES.length+IMySQL.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(IMySQL.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, IMySQL.CAPABILITIES.length); 
		return result;

	}

	@Override
	public String executeScript(String command) {
		return super.executeScript(command);
		
	}

	


}
