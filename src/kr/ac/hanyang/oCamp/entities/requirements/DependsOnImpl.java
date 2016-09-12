package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DependsOnImpl<T> extends EffectorStartableImpl implements Startable, DependsOn{
	private static final Logger log = LoggerFactory.getLogger(DependsOnImpl.class);
	
	
	public DependsOnImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
	}
	
	
	@Override
	public void start(Collection<? extends Location> locations) {
		
		for(Entity e: this.getChildren()){
			log.info("**** INFO INFO **** Starting DeployOn...");
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			task.blockUntilEnded(null);
			
			if (task.isDone() /*&& !task.isError()*/){
				log.info("**** INFO INFO **** "+task.getStatusSummary());

			}else
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+task.getStatusSummary());
		}
	}



}
