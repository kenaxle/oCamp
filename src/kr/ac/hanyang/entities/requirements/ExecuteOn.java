package kr.ac.hanyang.entities.requirements;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;

import kr.ac.hanyang.entities.IArtifact;
import kr.ac.hanyang.entities.IExecutable;
import kr.ac.hanyang.entities.services.AbstractOCampService;

public class ExecuteOn extends EffectorStartableImpl implements Startable {
	
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

	@Override
	public void start(Collection<? extends Location> locations) {
		for(Entity e: this.getChildren()){
			
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);
			//Entities.waitForServiceUp(e,);
			System.out.println("ExecuteOn task... "+task.getStatusSummary());
		}
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
