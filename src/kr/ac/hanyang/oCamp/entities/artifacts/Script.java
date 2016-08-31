package kr.ac.hanyang.oCamp.entities.artifacts;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.IBasicOCampArtifact;

public class Script<T> extends BasicOCampArtifact<Object> implements Startable, ISoftware{
	private static final Logger log = LoggerFactory.getLogger(Script.class);
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public Script(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public String[] getRequirements() {
		// TODO Auto-generated method stub
		String[] result = new String[IBasicOCampArtifact.REQUIREMENTS.length+ISoftware.REQUIREMENTS.length];
		System.arraycopy(IBasicOCampArtifact.REQUIREMENTS, 0, result, 0, IBasicOCampArtifact.REQUIREMENTS.length);
		System.arraycopy(ISoftware.REQUIREMENTS, 0, result, IBasicOCampArtifact.REQUIREMENTS.length, ISoftware.REQUIREMENTS.length); 
		return result;
	}

	
//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
