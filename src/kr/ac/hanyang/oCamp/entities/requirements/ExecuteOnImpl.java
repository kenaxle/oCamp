package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.software.VanillaSoftware;

public class ExecuteOnImpl<T> extends EffectorStartableImpl implements Startable, ExecuteOn{
	private static final Logger log = LoggerFactory.getLogger(ExecuteOnImpl.class);
	
	T content;
	
	public ExecuteOnImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		//content = ((IArtifact)this.getParent()).getContent();
		content = (T) new String("apt-get install php5");
		super.init();
	}
	
	
	//maybe I need to wire this to a start effector.
	public boolean executeContent(Entity child) {
		//Object content =  ((IArtifact)this.getParent()).getContent();
		if(content instanceof String){
				if (child instanceof IExecutable){
					IExecutable fulfillment = (IExecutable) child;
					log.info("Executecuting task on ExecuteOn...");
					fulfillment.executeScript((String)content);
					return true;
				}
		}
		return false;
	}

	@Override
	public void start(Collection<? extends Location> locations) {
		
		for(Entity e: this.getChildren()){
			log.info("Starting ExecuteOn...");
			e.config().set((ConfigKey<T>)VanillaSoftware.INSTALL_COMMAND,content);
			//e.setConfig((T)ISoftwareProcess.INSTALL_COMMAND,content);
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			task.blockUntilEnded(null);
			if (task.isDone())
				executeContent(e);
		}
	}

	@Override
	public <T> T getContent() {
		return (T) content;
	}



//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
