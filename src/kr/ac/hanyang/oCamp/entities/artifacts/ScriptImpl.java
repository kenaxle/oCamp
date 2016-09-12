package kr.ac.hanyang.oCamp.entities.artifacts;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifactImpl;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

public class ScriptImpl<T> extends BasicOCampArtifactImpl<Object> implements Startable, Software{
	private static final Logger log = LoggerFactory.getLogger(ScriptImpl.class);
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public ScriptImpl(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public String[] getRequirements() {
		// TODO Auto-generated method stub
		String[] result = new String[BasicOCampArtifact.REQUIREMENTS.length+Software.REQUIREMENTS.length];
		System.arraycopy(BasicOCampArtifact.REQUIREMENTS, 0, result, 0, BasicOCampArtifact.REQUIREMENTS.length);
		System.arraycopy(Software.REQUIREMENTS, 0, result, BasicOCampArtifact.REQUIREMENTS.length, Software.REQUIREMENTS.length); 
		return result;
	}

	
//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
