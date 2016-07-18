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
import kr.ac.hanyang.entities.IDeployable;

public class DeployOn<T> extends EffectorStartableImpl implements Startable, IDeployOn{
	private static final Logger log = LoggerFactory.getLogger(DeployOn.class);
	
	T url;
	String target;
	
	public DeployOn(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
		url = ((IArtifact)this.getParent()).getContent();//(T) "http://search.maven.org/remotecontent?filepath=io/brooklyn/example/brooklyn-example-hello-world-sql-webapp/0.6.0-M2/brooklyn-example-hello-world-sql-webapp-0.6.0-M2.war";
		target = "/webapp";
	}
	
	@SuppressWarnings("unchecked")
	public T getUrl(){return url;}
	public String getTarget(){return target;}
	
	
	public boolean deployContent(Entity child) {
		//Object content =  ((IArtifact)this.getParent()).getContent();
		if(url instanceof String){
				if (child instanceof IDeployable){
					IDeployable fulfillment = (IDeployable) child;
					log.info("**** INFO INFO **** Executecuting task on DeployOn...");
					fulfillment.deploy((String)url, target);
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
