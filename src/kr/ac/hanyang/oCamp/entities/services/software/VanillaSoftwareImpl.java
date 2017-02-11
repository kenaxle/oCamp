package kr.ac.hanyang.oCamp.entities.services.software;


import java.util.Map;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcessImpl;

import kr.ac.hanyang.oCamp.entities.artifacts.Software;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class VanillaSoftwareImpl extends VanillaSoftwareProcessImpl implements IExecutable, VanillaSoftware, IService, Startable{
	public VanillaSoftwareImpl(){
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
