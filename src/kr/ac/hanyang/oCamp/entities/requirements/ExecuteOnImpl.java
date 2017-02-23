package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.apache.brooklyn.util.collections.MutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;
import kr.ac.hanyang.oCamp.entities.services.software.VanillaSoftware;

public class ExecuteOnImpl<T> extends EffectorStartableImpl implements Startable, ExecuteOn{
	private static final Logger log = LoggerFactory.getLogger(ExecuteOnImpl.class);
	
	//T content;
	
	public ExecuteOnImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		//content = ((IArtifact)this.getParent()).getContent();
		//content = (T) new String("apt-get install php5");
		super.init();
	}
	
	
//	//maybe I need to wire this to a start effector.
//	public boolean executeContent(Entity child) {
//		//Object content =  ((IArtifact)this.getParent()).getContent();
//		if(content instanceof String){
//				if (child instanceof IExecutable){
//					IExecutable fulfillment = (IExecutable) child;
//					log.info("Executecuting task on ExecuteOn...");
//					fulfillment.executeScript((String)content);
//					return true;
//				}
//		}
//		return false;
//	}

	@Override
	public void start(Collection<? extends Location> locations) {
		log.info("**** INFO INFO **** Starting ExecuteOn...");
		Task<Void> startParent = Entities.invokeEffector(this, this.getParent(), Startable.START,MutableMap.of("locations", locations));
		startParent.blockUntilEnded();
		if (startParent.isDone( )/*&& !startParent.isError()*/){
			Task<Void> executeConnection = Entities.invokeEffector(this, this.getParent(), IExecutable.EXECUTE, MutableMap.of("command",this.getChildren().iterator().next().config().get(BasicOCampArtifact.CONTENT)));
			executeConnection.blockUntilEnded();
			if (executeConnection.isDone( )/*&& !deployContent.isError()*/){
				Entity child = this.getChildren().iterator().next(); // get my only child this will be the Artifact
				Task<Void> childTask = Entities.invokeEffector(this,child , Startable.START);
				childTask.blockUntilEnded();
				if (childTask.isDone() && !childTask.isError()){
					log.info("**** INFO INFO ****"+childTask.getStatusSummary());
				}else{
					log.error("**** ERROR ERROR **** ERROR ERROR ****"+childTask.getStatusSummary());
				}
			}else{
				log.error("**** ERROR ERROR **** ERROR ERROR ****"+executeConnection.getStatusSummary());
			}
		}else{
			log.error("**** ERROR ERROR **** ERROR ERROR ****"+startParent.getStatusSummary());
		}

		
	}

	@Override
	public <T> T getContent() {
		return null;//(T) content;
	}



//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
