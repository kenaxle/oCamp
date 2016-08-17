package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Policy implements IPolicy{
	
	private static final Logger log = LoggerFactory.getLogger(Policy.class);
	private String name;
	private String type; //FIXME have to change this to a dynamic type
	private Map<String, IConstraint> constraints;
	private List<Entity> targets; //FIXME may have to use a higher class
	private Goal desiredState;
	
	@SuppressWarnings("rawtypes")
	public static class Builder{
		private String name;
		private String type; //FIXME have to change this to a dynamic type
		private Map<String, IConstraint> constraints;
		private List<Entity> targets; //FIXME may have to use a higher class
		private Goal desiredState;
		
		public Builder(String name, String type){
			this.name = name;
			this.type = type;
			constraints = new LinkedHashMap<String, IConstraint>();
			targets = new ArrayList<Entity>();
			desiredState = new Goal("BaseDesiredState");
			desiredState.addConstraint(new PolicyConstraint("STATE"));
		}
		
		public Builder addConstraint(IConstraint<?> constraint){
			constraints.put(constraint.getProperty(), constraint);
			desiredState.addConstraint(constraint);
			return this;
		}
		
		public Builder addTarget(Entity e){
			targets.add(e);
			return this;
		}
		
//		public Builder desiredState(Goal g){
//			desiredState = g;
//			return this;
//		}
		
		public Policy build(){
			return new Policy(this);
		}
		
	}
	
	//TODO may have to address whether this is the proper way to construct
	private Policy(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.constraints = builder.constraints;
		this.targets = builder.targets;
		//this.desiredState = builder.desiredState;
	}
	
	public String getType(){ 
		return type;
	}
    
	public IConstraint<?> getConstraint(String property){
		return constraints.get(property);
	}
	
	public Goal getDesiredState(){return desiredState;}
	
	// will implement later
	//public Entity getTarget()

}
