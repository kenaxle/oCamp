package kr.ac.hanyang.entities.artifacts;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.entities.services.IBasicOCampArtifact;

public class Machine_Art<T> extends BasicOCampArtifact<Object> implements Startable, IMachine_Art{
	private static final Logger log = LoggerFactory.getLogger(Machine_Art.class);
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public Machine_Art(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public String[] getRequirements() {
		// TODO Auto-generated method stub
		String[] result = new String[IBasicOCampArtifact.REQUIREMENTS.length+IMachine_Art.REQUIREMENTS.length];
		System.arraycopy(IBasicOCampArtifact.REQUIREMENTS, 0, result, 0, IBasicOCampArtifact.REQUIREMENTS.length);
		System.arraycopy(IMachine_Art.REQUIREMENTS, 0, result, IBasicOCampArtifact.REQUIREMENTS.length, IMachine_Art.REQUIREMENTS.length); 
		return result;
	}

	
//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
