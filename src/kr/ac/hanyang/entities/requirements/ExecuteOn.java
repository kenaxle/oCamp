package kr.ac.hanyang.entities.requirements;

import java.util.Collection;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.core.entity.AbstractEntity;

import kr.ac.hanyang.entities.IArtifact;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.services.AbstractOCampService;

public class ExecuteOn extends AbstractEntity {
	
	//private Artifact art;
	private AbstractOCampService serviceFulfillment;
	
	public ExecuteOn(){
		super();
	}
	
	public void init(){
		super.init();
	}
	
	
	void postStart(Collection<? extends Location> locations){
		
	}
	
	//maybe I need to wire this to a start effector.
	public void executeContent() {
		Object content =  ((IArtifact)this.getParent()).getContent();
		if(content instanceof String)
			for(Entity child: this.getChildren()){
				IExecutable fulfillment = (IExecutable) child;
				fulfillment.executeContent((String)content);
			}
	}
	
	
	

}