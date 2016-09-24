package kr.ac.hanyang.oCamp.entities;

import java.util.Collection;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.BasicApplicationImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.oCampEnableable;
import kr.ac.hanyang.oCamp.core.traits.oCampStartable;

public class BasicOCampApplicationImpl extends BasicApplicationImpl implements oCampStartable {
	
	private static final Logger log = LoggerFactory.getLogger(BasicOCampApplicationImpl.class);
	//private List policyList;
	
	@Override
	public void startup(Collection<? extends Location> locations) {
		//policyList = MutableList.of();
		log.info("**** INFO INFO **** Starting Application...");
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		TaskBuilder<Void> polTaskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			if (e instanceof Startable)
				taskBuilder.add(Entities.invokeEffector(this, e, oCampStartable.STARTUP));
			else 
			if (e instanceof oCampEnableable){
				polTaskBuilder.add(Entities.invokeEffector(this, e, oCampEnableable.ENABLE));
			}
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() && !task.isError()){
			log.info("**** SUCCESS SUCCESS  Starting Policies now**** "+task.getStatusSummary());
			//now to start the policies 
			Task<Void> polTask = polTaskBuilder.parallel(true)
  					 						 .build();
			polTask.blockUntilEnded();
			if (polTask.isDone() && !polTask.isError()){
				//get the policies in the task and add to the managers
				
			}
			
		}else
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
	}
	
	
}
