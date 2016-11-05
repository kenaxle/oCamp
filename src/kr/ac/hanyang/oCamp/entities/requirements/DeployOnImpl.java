package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.DynamicSequentialTask;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

public class DeployOnImpl<T> extends EffectorStartableImpl implements Startable, DeployOn{
	private static final Logger log = LoggerFactory.getLogger(DeployOnImpl.class);
	
	public DeployOnImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
	}
	

	@Override
	public void start(Collection<? extends Location> locations) {
		log.info("**** INFO INFO **** Starting DeployOn...");
		Task<Void> startParent = Entities.invokeEffector(this, this.getParent(), Startable.START,MutableMap.of("locations", locations));
		startParent.blockUntilEnded();
		if (startParent.isDone( )/*&& !startParent.isError()*/){
			Task<Void> deployContent = Entities.invokeEffector(this, this.getParent(), IDeployable.DEPLOY, MutableMap.of("url",this.getChildren().iterator().next().config().get(BasicOCampArtifact.CONTENT),
							 								   															 "target",this.config().get(ConfigKeys.newConfigKey(String.class, "target"))));
			deployContent.blockUntilEnded();
			if (deployContent.isDone( )/*&& !deployContent.isError()*/){
				Entity child = this.getChildren().iterator().next(); // get my only child this will be the Artifact
				Task<Void> childTask = Entities.invokeEffector(this,child , Startable.START);
				childTask.blockUntilEnded();
				if (childTask.isDone() && !childTask.isError()){
					log.info("**** INFO INFO ****"+childTask.getStatusSummary());
				}else{
					log.error("**** ERROR ERROR **** ERROR ERROR ****"+childTask.getStatusSummary());
				}
			}else{
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+deployContent.getStatusSummary());
			}
		}else{
			log.error("**** ERROR ERROR **** ERROR ERROR ****"+startParent.getStatusSummary());
		}

	}



}
