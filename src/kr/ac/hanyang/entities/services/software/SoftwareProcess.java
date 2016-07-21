package kr.ac.hanyang.entities.services.software;


import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcessImpl;

import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.artifacts.ISoftware;
import kr.ac.hanyang.entities.services.IBasicOCampArtifact;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class SoftwareProcess extends VanillaSoftwareProcessImpl implements IExecutable, ISoftwareProcess, IService, Startable{
	public SoftwareProcess(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public void execute(String command) {
		//return super..execCommand(command) != null;
		//no-op;
		
	}

	public String[] getCapabilities() {
		String[] result = new String[IBasicOCampService.CAPABILITIES.length+ISoftwareProcess.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(ISoftwareProcess.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, ISoftwareProcess.CAPABILITIES.length); 
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
