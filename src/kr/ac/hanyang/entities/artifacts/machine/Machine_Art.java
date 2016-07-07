package kr.ac.hanyang.entities.artifacts.machine;

import org.apache.brooklyn.core.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.entities.IArtifact;

public class Machine_Art<T> extends AbstractEntity{
	//private static final Logger log = LoggerFactory.getLogger(Machine_Art.class);
	
	private T content;
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public Machine_Art(){
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
	
}
