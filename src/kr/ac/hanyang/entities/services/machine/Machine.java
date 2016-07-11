package kr.ac.hanyang.entities.services.machine;


import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;

import kr.ac.hanyang.entities.IExecutable;

public class Machine extends MachineEntityImpl implements IExecutable, IMachine, Startable{
	public Machine(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public void executeContent(String command) {
		super.execCommand(command);
	}

	@Override
	public String[] getCapabilities() {
		return Capabilities;
	}


//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
}
