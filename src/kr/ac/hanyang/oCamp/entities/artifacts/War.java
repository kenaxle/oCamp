package kr.ac.hanyang.oCamp.entities.artifacts;

import java.util.Collection;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.IArtifact;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.IBasicOCampArtifact;

public class War extends BasicOCampArtifact<Object> implements Startable, IWar,IArtifact{
		private static final Logger log = LoggerFactory.getLogger(War.class);
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
		
		@Override
		public void start(Collection<? extends Location> locations){
			for(Entity e: this.getChildren()){
				log.info("**** INFO INFO **** Starting War...");
				Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
				task.blockUntilEnded(null);
				
				if (task.isDone() && !task.isError()){
					log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
				}else
					log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			}
		}
		
		
}
