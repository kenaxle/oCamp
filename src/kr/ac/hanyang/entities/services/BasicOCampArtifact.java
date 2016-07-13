package kr.ac.hanyang.entities.services;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;


public class BasicOCampArtifact<T> extends EffectorStartableImpl implements IBasicOCampArtifact {

	private T content;
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public BasicOCampArtifact(){
		super();
	}
	
	public void init(){
		super.init();
	}
	
	public void setContent(T content){
		this.content = content;
	}
	
	@SuppressWarnings("unchecked")
	public T getContent(){
		return (T) this.content;
	}
	
	@Override
	public void start(Collection<? extends Location> locations) {
		// TODO Auto-generated method stub
		//super.start(locations);
		for(Entity e: this.getChildren()){
			
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);
			//Entities.waitForServiceUp(e,);
			System.out.println("Machine_Art... task "+task.getStatusSummary());
		}
	}

	@Override
	public String[] getRequirements() {
		return IBasicOCampArtifact.REQUIREMENTS;
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
