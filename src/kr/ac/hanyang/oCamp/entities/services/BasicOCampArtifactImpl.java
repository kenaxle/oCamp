package kr.ac.hanyang.oCamp.entities.services;

import java.util.Collection;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;



public class BasicOCampArtifactImpl<T> extends EffectorStartableImpl implements BasicOCampArtifact {

	private T content;
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public BasicOCampArtifactImpl(){
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
		return (T) this.content;
	}
	
	@Override
	public void start(Collection<? extends Location> locations ){
		/**Noop*/
	}

	@Override
	public String[] getRequirements() {
		return BasicOCampArtifact.REQUIREMENTS;
	}

}
