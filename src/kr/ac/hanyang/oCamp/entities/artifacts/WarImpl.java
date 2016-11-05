package kr.ac.hanyang.oCamp.entities.artifacts;

import java.util.Collection;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifactImpl;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

public class WarImpl extends BasicOCampArtifactImpl<Object> implements Startable, War,BasicOCampArtifact{
		private static final Logger log = LoggerFactory.getLogger(WarImpl.class);
		boolean connectedSensors = false; // not sure if I need sensors as yet
		
		public WarImpl(){
			super();
		}
		
		public void init(){
			super.init();
		}

		@Override
		public String[] getRequirements() {
			// TODO Auto-generated method stub
			String[] result = new String[BasicOCampArtifact.REQUIREMENTS.length+War.REQUIREMENTS.length];
			System.arraycopy(BasicOCampArtifact.REQUIREMENTS, 0, result, 0, BasicOCampArtifact.REQUIREMENTS.length);
			System.arraycopy(War.REQUIREMENTS, 0, result, BasicOCampArtifact.REQUIREMENTS.length, War.REQUIREMENTS.length); 
			return result;
		}
		
		@Override
		public void start(Collection<? extends Location> locations){
			log.info("**** Sucessfully started Artifact "+ this);
				
		}
		
		
}
