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
import kr.ac.hanyang.entities.IExecutable;

public class DeployOn<T> extends EffectorStartableImpl implements Startable {
	private static final Logger log = LoggerFactory.getLogger(DeployOn.class);
	
	T content;
	String target;
	
	public DeployOn(){
		super();
	}
	
	public void init(){
		content = ((IArtifact)this.getParent()).getContent();
		target = "~/brooklyn-managed-processes/installs/ITomcat_8.0.36/apache-tomcat-8.0.36/webapps/";
		super.init();
	}
	
	
	
	public boolean deployContent(Entity child) {
		//Object content =  ((IArtifact)this.getParent()).getContent();
		if(content instanceof String){
				if (child instanceof IDeployable){
					IDeployable fulfillment = (IDeployable) child;
					log.info("Executecuting task on DeployOn...");
					fulfillment.deploy((String)content, target);
					return true;
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
				deployContent(e);
		}
	}


//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
