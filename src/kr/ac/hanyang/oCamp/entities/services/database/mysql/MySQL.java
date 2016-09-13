package kr.ac.hanyang.oCamp.entities.services.database.mysql;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.database.mysql.MySqlNodeImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class MySQL extends MySqlNodeImpl implements IExecutable, IMySQL, IService, Startable{


	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+IMySQL.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(IMySQL.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, IMySQL.CAPABILITIES.length); 
		return result;

	}

	@Override
	public String executeScript(String command) {
		return super.executeScript(command);
		
	}

	


}
