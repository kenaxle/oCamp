package kr.ac.hanyang.oCamp.entities.requirements;

import java.util.Collection;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;
import org.apache.brooklyn.util.collections.MutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

/**
 * 
 * @author kena
 * 
 * @param <T>
 * 
 * TODO I need to provide properties for 
 * 		port: 
 * 		root_password: credentials
 * 		this is to facilitate connections 
 * 		also make use of default port and password in configuration file.
 */


public class ConnectToImpl<T> extends EffectorStartableImpl implements Startable, ConnectTo{
	private static final Logger log = LoggerFactory.getLogger(ConnectToImpl.class);
	
	T script;
	
	public ConnectToImpl(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		super.init();
	}
	

	public <T> T getScript() {
		return (T) this.config().get(LAUNCH_COMMAND);
	}

	
//	public boolean executeContent(Entity child) {
//		//Object content =  ((IArtifact)this.getParent()).getContent();
//		if(script instanceof String){
//				if (child instanceof IDeployable){
//					IExecutable fulfillment = (IExecutable) child;
//					log.info("**** INFO INFO **** Executecuting task on ConnectTo...");
//					fulfillment.executeScript((String) script);
//					return true;
//				}
//		}
//		return false;
//	}

	@Override
	public void start(Collection<? extends Location> locations) {
		log.info("**** INFO INFO **** Starting ConnectTo...");
		Task<Void> startParent = Entities.invokeEffector(this, this.getParent(), Startable.START,MutableMap.of("locations", locations));
		startParent.blockUntilEnded();
		if (startParent.isDone( )/*&& !startParent.isError()*/){
			Task<Void> executeConnection = Entities.invokeEffector(this, this.getParent(), IConnectable.EXECUTE, MutableMap.of("launchCommand",this.getChildren().iterator().next().config().get(BasicOCampArtifact.CONTENT)));
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



}
