package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.core.sensor.BasicSensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

public class PolicyImpl extends AbstractEntity implements Policy{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyImpl.class);
	private String name;
	//private String type; //FIXME this is the policy manager.
	private List<Entity> targets; //FIXME may have to use a higher class
	private ConstraintSetImpl desiredState;
	
//	@SuppressWarnings("rawtypes")
//	public static class Builder{
//		private String name;
//		private String type; //FIXME have to change this to a dynamic type
//		private List<Entity> targets; //FIXME may have to use a higher class
//		private ConstraintSet desiredState;
//		
//		public Builder(String name, String type){
//			this.name = name;
//			this.type = type;
//			targets = new ArrayList<Entity>();
//			desiredState = new ConstraintSet.Builder("BaseDesiredState").addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) Attributes.SERVICE_UP,"equals",true).build()).build();
//		}
//		
//		public Builder addConstraint(PolicyConstraintImpl constraint){
//			desiredState.addConstraint(constraint);
//			return this;
//		}
//		
//		public Builder addTarget(Entity e){
//			targets.add(e);
//			return this;
//		}
//		
//		public Builder desiredState(ConstraintSet g){
//			desiredState = g;
//			return this;
//		}
//		
//		public Policy build(){
//			return new Policy(this);
//		}
//		
//	}
	
//	//TODO may have to address whether this is the proper way to construct
//	private Policy(Builder builder) {
//		this.name = builder.name;
//		this.type = builder.type;
//		this.targets = builder.targets;
//		this.desiredState = builder.desiredState;
//	}	
	
//	public String getType(){ 
//		return type;
//	}
	
	
	
	public ConstraintSetImpl getDesiredState(){return desiredState;}
	
	public List<Entity> getTargets(){return targets;}

	@Override
	public boolean addConstraint(PolicyConstraint constraint) {
		if (desiredState.addConstraint(constraint)){
			sensors().emit(Policy.CONSTRAINT_ADDED, constraint);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeConstraint(PolicyConstraint constraint) {
		if (desiredState.removeConstraint(constraint)){
			sensors().emit(Policy.CONSTRAINT_ADDED, constraint);
			return true;
		}
		return false;
	}

	
	
	
	// will implement later
	//public Entity getTarget()

}
