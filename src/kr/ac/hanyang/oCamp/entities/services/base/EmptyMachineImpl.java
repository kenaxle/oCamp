package kr.ac.hanyang.oCamp.entities.services.base;

import java.util.Collection;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.entity.EntityType;
import org.apache.brooklyn.api.entity.Group;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.api.policy.Policy;
import org.apache.brooklyn.api.policy.PolicySpec;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Enricher;
import org.apache.brooklyn.api.sensor.EnricherSpec;
import org.apache.brooklyn.api.sensor.Feed;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.config.ConfigKey.HasConfigKey;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcessImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.apache.brooklyn.util.guava.Maybe;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployable;
import kr.ac.hanyang.oCamp.entities.requirements.IEntity;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;
import kr.ac.hanyang.oCamp.entities.services.web.tomcat.Tomcat8;

public class EmptyMachineImpl extends VanillaSoftwareProcessImpl implements EmptyMachine,  IService, oCampStartable, IEntity {

	public EmptyMachineImpl(){
		super();
	}
	
	public void init(){
		super.init(); 
		//int count = 0; boolean val;
	}

	@Override
	public void startup() {
		TaskBuilder<Void> taskBuilder = TaskBuilder.builder();
		for(Entity e: this.getChildren()){
			taskBuilder.add(Entities.invokeEffector(this, e, Startable.START,
					MutableMap.of("locations", MutableList.of(e.config().get(BasicOCampService.LOCATIONS)))));	//locations are set by the placement policy
		}
		Task<Void> task = taskBuilder.parallel(true)
				   					 .build();
		task.blockUntilEnded();
		if (task.isDone() /*&& !task.isError()*/){
			//log.info("**** SUCCESS SUCCESS **** "+task.getStatusSummary());
			
		}else{
			//log.error("**** ERROR ERROR **** "+task.getStatusSummary());
			
		}
	}

	@Override
	public String[] getCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
