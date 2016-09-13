package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.apache.brooklyn.util.core.task.DynamicSequentialTask;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

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
		// get the content
		Entity child = this.getChildren().iterator().next(); // get my only child this will be the Artifact
		T content = ((BasicOCampArtifact)child).getContent(); // I should instead have a general method to get all configurations 
		log.info("**** INFO INFO **** Starting DeployOn...");
			Task<Object> parentTasks = TaskBuilder.builder().add(Entities.invokeEffector(this, this.getParent(), Startable.START))
								 						   .add(Entities.invokeEffector(this, this.getParent(), IDeployable.DEPLOY))
								 						   .dynamic(true)
								 						   .build();
			parentTasks.blockUntilEnded(null);
			if (parentTasks.isDone() && !parentTasks.isError()){
				log.info("**** INFO INFO **** "+parentTasks.getStatusSummary());			
				Task<Void> childTask = Entities.invokeEffector(this,child , Startable.START);
				childTask.blockUntilEnded(null);
				if (childTask.isDone() && !childTask.isError()){
					log.info("**** INFO INFO ****"+childTask.getStatusSummary());
				}
			}else
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+parentTasks.getStatusSummary());
	}



}
