package kr.ac.hanyang.oCamp.entities.services.cluster;

import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.machine.pool.ServerPoolImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.Scalable;
import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IEntity;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class LoadBalancedClusterImpl extends ServerPoolImpl implements LoadBalancedCluster, IDeployable, IExecutable, IService, oCampStartable, Scalable, IEntity {

	private static final Logger log = LoggerFactory.getLogger(LoadBalancedClusterImpl.class);
	
	public void init(){
		super.init(); 
		//int count = 0; boolean val;
	}
	
	@Override
	public void startup() {
		log.info("**** INFO INFO **** Starting Cluster...");

		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START,
					//MutableMap.of("locations", MutableList.of("AWS Tokyo (ap-northeast-1)"))));
					MutableMap.of("locations", MutableList.of(e.config().get(BasicOCampService.LOCATIONS)))));	//locations are set by the placement policy
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() && !task.isError()){
			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			
		}else{
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			
		}
	}

	@Override
	@Effector(description="Deploys the given artifact, from a source URL, to a given deployment filename/context")
	public void deploy(
            @EffectorParam(name="url", description="URL of WAR file") String url, 
            @EffectorParam(name="targetName", description="context path where WAR should be deployed (/ for ROOT)") String targetName) {
		
		List<Entity> members = (List<Entity>) super.getMembers();
		if (members.get(0) instanceof IDeployable){
			TaskBuilder<Void> deployTaskBuilder = TaskBuilder.builder();
			for( Entity member: members){	
				deployTaskBuilder.add(Entities.invokeEffector(this, member, IDeployable.DEPLOY,
						MutableMap.of("url", url, "targetName", targetName)));
			}
			Task<Void> task = deployTaskBuilder.parallel(true)
  					 .build();
			task.blockUntilEnded();
			if (task.isDone() && !task.isError()){
				log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
				
			}else{
				log.error("**** ERROR ERROR **** "+task.getStatusSummary());
				
			}
		}else
			log.error("**** ERROR ERROR **** Unable to deploy because members are not deployable");
	}
	
	@Override
	public String executeScript(@EffectorParam(name="command", description="command to be executed") String command) {
		List<Entity> members = (List<Entity>) super.getMembers();
		if (members.get(0) instanceof IExecutable){
			TaskBuilder<Void> exTaskBuilder = TaskBuilder.builder();
			for( Entity member: members){	
				exTaskBuilder.add(Entities.invokeEffector(this, member, IExecutable.EXECUTE,
						MutableMap.of("command", command)));
			}
			Task<Void> task = exTaskBuilder.parallel(true)
  					 .build();
			task.blockUntilEnded();
			if (task.isDone() && !task.isError()){
				log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			}else{
				log.error("**** ERROR ERROR **** "+task.getStatusSummary());
				
			}
		}else
			log.error("**** ERROR ERROR **** Unable to deploy because members are not deployable");
		return "";
	}
	
	@Override
	@Effector(description="Resizes the cluster")
	public Integer resize(
			Integer desiredSize){
		return super.resize(desiredSize);
	}

	public void scaleUp(Integer desiredSize){
		if (this.getCurrentSize() < desiredSize){
			resize(desiredSize);
		}else
			log.error("cannot scale up to "+desiredSize+". The current size is larger");
	}
	
	public void scaleDown(Integer desiredSize){
		if (this.getCurrentSize() > desiredSize){
			resize(desiredSize);
		}else
			log.error("cannot scale down to "+desiredSize+". The current size is smaller");
	}

	

	
}
