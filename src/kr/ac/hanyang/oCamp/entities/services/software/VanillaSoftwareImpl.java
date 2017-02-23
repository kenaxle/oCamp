package kr.ac.hanyang.oCamp.entities.services.software;


import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.machine.MachineEntityImpl;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcessImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.task.TaskBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.artifacts.Software;
import kr.ac.hanyang.oCamp.entities.requirements.IExecutable;
import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;
import kr.ac.hanyang.oCamp.entities.services.database.mysql.MySQLImpl;

public class VanillaSoftwareImpl extends VanillaSoftwareProcessImpl implements IExecutable, VanillaSoftware, IService, Startable{
	private static final Logger log = LoggerFactory.getLogger(MySQLImpl.class);
	
	public VanillaSoftwareImpl(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public String executeScript(String command) {
		return "";
		//return super..execCommand(command) != null;
		//no-op;
		
	}

	public void startup(){
		log.info("**** INFO INFO **** Starting Vanilla Software...");

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

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//public static void main(String [] args){
//	Machine ma = new Machine();
//	for (String cap: ma.getCapabilities())
//		System.out.println(cap);
//}
	
}
