package kr.ac.hanyang.oCamp.entities.services.web;

import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.group.DynamicCluster;
import org.apache.brooklyn.entity.webapp.ControlledDynamicWebAppClusterImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.Scalable;
import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.artifacts.WarImpl;
import kr.ac.hanyang.oCamp.entities.policies.PolicyManagerImpl;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IEntity;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;
import kr.ac.hanyang.oCamp.entities.services.web.tomcat.Tomcat8;

public class WebAppClusterImpl extends ControlledDynamicWebAppClusterImpl implements IDeployable, WebAppCluster, IService, oCampStartable,Scalable, IEntity{

	private static final Logger log = LoggerFactory.getLogger(WebAppClusterImpl.class);
	//private Map<String,PolicyManagerImpl> policyManagers;
	
	public WebAppClusterImpl(){
		super();
	}
	
	public void init(){
		super.init(); 
		//int count = 0; boolean val;
	}

	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+Tomcat8.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(Tomcat8.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, Tomcat8.CAPABILITIES.length); 
		return result;
		
	}
	
	
	@Override
	@Effector(description="Deploys the given artifact, from a source URL, to a given deployment filename/context")
	public void deploy(
            @EffectorParam(name="url", description="URL of WAR file") String url, 
            @EffectorParam(name="targetName", description="context path where WAR should be deployed (/ for ROOT)") String targetName) {
		super.deploy(url, targetName);
	}
	
	@Override
	@Effector(description="Resizes the cluster")
	public Integer resize(
			Integer desiredSize){
		return super.resize(desiredSize);
	}
	
	// need to abstract the starting process because the start method is marked as final 
	// this will initiate the start on the requirements and Artifacts then call 
	// start on itself
	//builds a parallel startup task and waits for the completion of the members.
	public void startup(/*Collection<? extends Location> locations*/){
		log.info("**** INFO INFO **** Starting WebAppCluster...");

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
