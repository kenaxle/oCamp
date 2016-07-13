package kr.ac.hanyang.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.entities.IArtifact;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.artifacts.machine.Machine_Art;

public class ExecuteOn<T> extends EffectorStartableImpl implements Startable {
	private static final Logger log = LoggerFactory.getLogger(Machine_Art.class);
	
	T content;
	
	public ExecuteOn(){
		super();
	}
	
	public void init(){
		content = ((IArtifact)this.getParent()).getContent();
		super.init();
	}
	
	
	//maybe I need to wire this to a start effector.
	public boolean executeContent(Entity child) {
		//Object content =  ((IArtifact)this.getParent()).getContent();
		if(content instanceof String){
				if (child instanceof IExecutable){
					IExecutable fulfillment = (IExecutable) child;
					log.info("Executecuting task on ExecuteOn...");
					return fulfillment.executeContent((String)content);
				}
		}
		return false;
	}

	@Override
	public void start(Collection<? extends Location> locations) {
		
		for(Entity e: this.getChildren()){
			log.info("Starting ExecuteOn...");
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			task.blockUntilEnded(null);
			if (task.isDone())
				executeContent(e);
		}
	}


//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
