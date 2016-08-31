package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.IArtifact;
import kr.ac.hanyang.oCamp.entities.IDeployable;
import kr.ac.hanyang.oCamp.entities.IExecutable;

public class ConnectTo<T> extends EffectorStartableImpl implements Startable, IConnectTo{
	private static final Logger log = LoggerFactory.getLogger(ConnectTo.class);
	
	T script;
	
	public ConnectTo(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
		script = ((IArtifact)this.getParent()).getContent();
	}
	

	public <T> T getScript() {
		return null;
	}

	
	public boolean executeContent(Entity child) {
		//Object content =  ((IArtifact)this.getParent()).getContent();
		if(script instanceof String){
				if (child instanceof IDeployable){
					IExecutable fulfillment = (IExecutable) child;
					log.info("**** INFO INFO **** Executecuting task on DeployOn...");
					fulfillment.executeScript((String) script);
					return true;
				}
		}
		return false;
	}

	@Override
	public void start(Collection<? extends Location> locations) {
		
		for(Entity e: this.getChildren()){
			log.info("**** INFO INFO **** Starting DeployOn...");
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			task.blockUntilEnded(null);
			
			if (task.isDone() /*&& !task.isError()*/){
				log.info("**** INFO INFO **** "+task.getStatusSummary());
				Task<Void> deployTask = Entities.invokeEffector(this, e, IDeployable.DEPLOY);
				log.info("**** INFO INFO ****"+deployTask.getStatusSummary());
			}else
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+task.getStatusSummary());
		}
	}




}
