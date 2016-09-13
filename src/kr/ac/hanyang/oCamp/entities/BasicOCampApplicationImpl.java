package kr.ac.hanyang.oCamp.entities;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.BasicApplicationImpl;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;

public class BasicOCampApplicationImpl extends BasicApplicationImpl implements oCampStartable {
	
	private static final Logger log = LoggerFactory.getLogger(BasicOCampApplicationImpl.class);
	
	@Override
	public void startup(Collection<? extends Location> locations) {
		log.info("**** INFO INFO **** Starting Application...");
		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START));	
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() && !task.isError()){
			log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
		}else
			log.error("**** ERROR ERROR **** "+task.getStatusSummary());
	}

}
