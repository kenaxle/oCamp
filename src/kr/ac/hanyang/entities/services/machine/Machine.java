package kr.ac.hanyang.entities.services.machine;


import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;

import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.IService;
import kr.ac.hanyang.entities.artifacts.machine.IMachine_Art;
import kr.ac.hanyang.entities.services.IBasicOCampArtifact;
import kr.ac.hanyang.entities.services.IBasicOCampService;

public class Machine extends MachineEntityImpl implements IExecutable, IMachine, IService, Startable{
	public Machine(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public boolean executeContent(String command) {
		return super.execCommand(command) != null;
	}

	public String[] getCapabilities() {
		String[] result = new String[IBasicOCampService.CAPABILITIES.length+IMachine.CAPABILITIES.length];
		System.arraycopy(IBasicOCampService.CAPABILITIES, 0, result, 0, IBasicOCampService.CAPABILITIES.length);
		System.arraycopy(IMachine.CAPABILITIES, 0, result, IBasicOCampService.CAPABILITIES.length, IMachine.CAPABILITIES.length); 
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
