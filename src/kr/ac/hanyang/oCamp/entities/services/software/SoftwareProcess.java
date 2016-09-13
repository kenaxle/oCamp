package kr.ac.hanyang.oCamp.entities.services.software;


import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcessImpl;

import kr.ac.hanyang.oCamp.entities.artifacts.Software;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class SoftwareProcess extends VanillaSoftwareProcessImpl implements IExecutable, ISoftwareProcess, IService, Startable{
	public SoftwareProcess(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public String executeScript(String command) {
		return command;
		//return super..execCommand(command) != null;
		//no-op;
		
	}

	public String[] getCapabilities() {
		String[] result = new String[BasicOCampService.CAPABILITIES.length+ISoftwareProcess.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(ISoftwareProcess.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, ISoftwareProcess.CAPABILITIES.length); 
		return result;
	}


//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//public static void main(String [] args){
//	Machine ma = new Machine();
//	for (String cap: ma.getCapabilities())
//		System.out.println(cap);
//}
	
}
