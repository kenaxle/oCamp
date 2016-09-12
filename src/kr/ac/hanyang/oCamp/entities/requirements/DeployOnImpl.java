package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeployOnImpl<T> extends EffectorStartableImpl implements Startable, DeployOn{
	private static final Logger log = LoggerFactory.getLogger(DeployOnImpl.class);
	
	T contentUrl;
	String target;
	
	public DeployOnImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
		//contentUrl = ((BasicOCampArtifact) getParent()).getContent();
		//target = "/webapp";
	}
	
	@SuppressWarnings("unchecked")
	public T getContentUrl(){return contentUrl;}
	public String getTarget(){return target;}
	

	@Override
	public void start(Collection<? extends Location> locations) {
		
		for(Entity e: this.getChildren()){
			log.info("**** INFO INFO **** Starting DeployOn...");
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			task.blockUntilEnded(null);
			
			if (task.isDone() /*&& !task.isError()*/){
				log.info("**** INFO INFO **** "+task.getStatusSummary());
				Task<Void> deployTask = Entities.invokeEffector(this, e, IDeployable.DEPLOY);
				log.info("**** INFO INFO ****"+deployTask.getStatusSummary());
			}else
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+task.getStatusSummary());
		}
	}



}
