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
		setContent();
	}
	
	@SuppressWarnings("unchecked")
	public void setContent(){
		this.content = (T) getConfig(CONTENT);
	}
	
	@SuppressWarnings("unchecked")
	public T getContent(){
		//return (T) this.getConfig(new BasicConfigKey(null, "content"));
		return (T) this.content;
	}
	
	@Override
	public void start(Collection<? extends Location> locations ){
		for(Entity e: this.getChildren()){
			Task<Void> task = Entities.invokeEffector(this, e, Startable.START);	
			//task.blockUntilEnded(null);
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
