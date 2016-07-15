package kr.ac.hanyang.entities.artifacts;

import org.apache.brooklyn.core.entity.trait.Startable;
import kr.ac.hanyang.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.entities.services.IBasicOCampArtifact;

public class War extends BasicOCampArtifact<Object> implements Startable, IWar{
		
		boolean connectedSensors = false; // not sure if I need sensors as yet
		
		public War(){
			super();
		}
		
		public void init(){
			super.init();
		}

		@Override
		public String[] getRequirements() {
			// TODO Auto-generated method stub
			String[] result = new String[IBasicOCampArtifact.REQUIREMENTS.length+IWar.REQUIREMENTS.length];
			System.arraycopy(IBasicOCampArtifact.REQUIREMENTS, 0, result, 0, IBasicOCampArtifact.REQUIREMENTS.length);
			System.arraycopy(IWar.REQUIREMENTS, 0, result, IBasicOCampArtifact.REQUIREMENTS.length, IWar.REQUIREMENTS.length); 
			return result;
		}
		
}
