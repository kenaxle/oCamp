package kr.ac.hanyang.oCamp.entities.services.database.mysql;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.annotation.Effector;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.database.mysql.MySqlNodeImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.artifacts.WarImpl;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IEntity;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;
import kr.ac.hanyang.oCamp.entities.services.web.tomcat.Tomcat8;

public class MySQLImpl extends MySqlNodeImpl implements IExecutable, MySQL, IService, oCampStartable, IEntity{

	private static final Logger log = LoggerFactory.getLogger(MySQLImpl.class);
	
	@Override
	public String[] getCapabilities() {

		String[] result = new String[BasicOCampService.CAPABILITIES.length+MySQL.CAPABILITIES.length];
		System.arraycopy(BasicOCampService.CAPABILITIES, 0, result, 0, BasicOCampService.CAPABILITIES.length);
		System.arraycopy(MySQL.CAPABILITIES, 0, result, BasicOCampService.CAPABILITIES.length, MySQL.CAPABILITIES.length); 
		return result;

	}

	

	@Override
	@Effector(description="Deploys the given artifact, from a source URL, to a given deployment filename/context")
	public String executeScript(
            @EffectorParam(name="command", description="command to execute") String command) {
		return super.executeScript(command);
	}
	

	
	// need to abstract the starting process because the start method is marked as final 
	// this will initiate the start on the requirements and Artifacts then call 
	// start on itself
	//builds a parallel startup task and waits for the completion of the members.
	public void startup(){
		log.info("**** INFO INFO **** Starting MySQL...");

		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START,
					MutableMap.of("locations", MutableList.of(e.config().get(BasicOCampService.LOCATIONS)))));	//locations are set by the placement policy
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() /*&& !task.isError()*/){
			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			
		}else{
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			
		}
	}


}
