package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class oCampPolicy implements IPolicy{
	
	private static final Logger log = LoggerFactory.getLogger(oCampPolicy.class);
	
	private String type; //FIXME have to change this to a dynamic type
	private Map<String, IConstraint> constraints;
	private List<Entity> targets; //FIXME may have to use a higher class
	
	@SuppressWarnings("rawtypes")
	public static class Builder{
		private String type; //FIXME have to change this to a dynamic type
		private Map<String, IConstraint> constraints;
		private List<Entity> targets; //FIXME may have to use a higher class
		
		public Builder(String type){
			this.type = type;
			constraints = new LinkedHashMap<String, IConstraint>();
			targets = new ArrayList<Entity>();
		}
		
		public Builder addConstraint(IConstraint constraint){
			constraints.put(constraint.getProperty(), constraint);
			return this;
		}
		
		public Builder addTarget(Entity e){
			targets.add(e);
			return this;
		}
		
		public oCampPolicy build(){
			return new oCampPolicy(this);
		}
		
	}
	
	//TODO may have to address whether this is the proper way to construct
	public oCampPolicy(Builder builder) {
		this.type = builder.type;
		this.constraints = builder.constraints;
		this.targets = builder.targets;
	}
	
	public String getType(){ 
		return type;
	}
    
	public IConstraint getConstraint(String property){
		return constraints.get(property);
	}
	
	// will implement later
	//public Entity getTarget()

}
