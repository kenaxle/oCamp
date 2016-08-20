package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Policy{
	
	private static final Logger log = LoggerFactory.getLogger(Policy.class);
	private String name;
	private String type; //FIXME have to change this to a dynamic type
	private List<Entity> targets; //FIXME may have to use a higher class
	private ConstraintSet desiredState;
	
	@SuppressWarnings("rawtypes")
	public static class Builder{
		private String name;
		private String type; //FIXME have to change this to a dynamic type
		private List<Entity> targets; //FIXME may have to use a higher class
		private ConstraintSet desiredState;
		
		public Builder(String name, String type){
			this.name = name;
			this.type = type;
			targets = new ArrayList<Entity>();
			desiredState = new ConstraintSet.Builder("BaseDesiredState").addConstraint(new PolicyConstraint.Builder("SERVICE_ACTUAL_STATE","equals","started").build()).build();
		}
		
		public Builder addConstraint(PolicyConstraint constraint){
			desiredState.addConstraint(constraint);
			return this;
		}
		
		public Builder addTarget(Entity e){
			targets.add(e);
			return this;
		}
		
		public Builder desiredState(ConstraintSet g){
			desiredState = g;
			return this;
		}
		
		public Policy build(){
			return new Policy(this);
		}
		
	}
	
	//TODO may have to address whether this is the proper way to construct
	private Policy(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.targets = builder.targets;
		this.desiredState = builder.desiredState;
	}
	
	public String getType(){ 
		return type;
	}
	
	public ConstraintSet getDesiredState(){return desiredState;}
	
	public List<Entity> getTargets(){return targets;}
	
	
	
	// will implement later
	//public Entity getTarget()

}
