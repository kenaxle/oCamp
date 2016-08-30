package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicSensor;

public class PolicyConstraint<T, U> extends AbstractEntity{
	private boolean enabled;
	private BasicSensor property; //TODO this should be a Brooklyn attribute or sensor.
	private String function; //FIXME need to change this to a type object
	private U value; // this is the value/values of the property.
	private IBasePolicyManager policyManager;
	private Policy policy;
	private List<INotifiable> subscribers;
	
	public static class Builder<U>{
		
		private BasicSensor property; //TODO this should be a Brooklyn attribute or sensor.
		private String function; //FIXME need to change this to a type object
		private U value; // this is the value/values of the property.
		private IBasePolicyManager policyManager;
		private Policy policy;
		private List<INotifiable> subscribers = new ArrayList<INotifiable>(); 
		
		public Builder(BasicSensor property){
			this.property = property;
		}
		
		public Builder(BasicSensor property, String function, U value){
			this.property = property;
			this.value = value;
			this.function = function;
		}
		
		public Builder function(String function){
			this.function = function;
			return this;
		}
		
		public Builder value(U value){
			this.value = value;
			return this;
		}
		
		public Builder policyManager(IBasePolicyManager policyManager){
			this.policyManager = policyManager;
			return this;
		}
		
		public Builder policy(Policy policy){
			this.policy = policy;
			return this;
		}
		
		public Builder subscribe(INotifiable subscriber){
			subscribers.add(subscriber);
			return this;
		}
		
		public PolicyConstraint build(){
			return new PolicyConstraint(this);
		}
	}
	
	private PolicyConstraint(Builder builder){
		this.enabled = false;
		this.property = builder.property;
		this.function = builder.function;
		this.value = (U) builder.value;
		this.policyManager = builder.policyManager;
		this.policy = builder.policy;
		this.subscribers = builder.subscribers;
	}
	
	public BasicSensor getProperty(){
		return property;
	}
	
	public String getFunctionType() {
		return function;                                                                                                                                                                              
	}

	public U getValue(){
		return value;
	}
	
	public IBasePolicyManager getPolicyManager(){
		return policyManager;
	}
	
	public Policy getPolicy(){
		return policy;
	}
	
	public void enable(Entity entity){
		if (! enabled)
			this.subscriptions().subscribe(entity, property, constraintListener(this));
	}
	
	public void disable(Entity entity){
		if (enabled)
			this.subscriptions().unsubscribe(entity);
	}
	
	private SensorEventListener constraintListener(Entity constraint){
		return new SensorEventListener(){
			public void onEvent(SensorEvent event){
				if (!((PolicyConstraint) constraint).evaluateFunction())
					((PolicyConstraint) constraint).notifySubscribers();
			}
		};
	}
	
	public void subscribe(INotifiable subscriber){
		subscribers.add(subscriber);
	}
	
	public void unsubscribe(INotifiable subscriber){
		subscribers.remove(subscriber);
	}
	
	private void notifySubscribers() {
		for (INotifiable subscriber: subscribers){
			subscriber.notification(this);
		}
	}
	
	// simple equals alignment
	// TODO may have to adjust to perform diferent alignments based on the function/type
	public boolean isAlignedWith(PolicyConstraint constraint){
		if (this.property.equals(constraint.getProperty()) && this.value.equals(constraint.getValue()))
			return true;
		return false;				
	}
	
	// may not need as I can simply check for alignment then use the constraint
	public PolicyConstraint getDelta(PolicyConstraint constraint){
		String hold;
		if (this.property.equals(constraint.getProperty()))
			switch (constraint.getFunctionType()){
			case "equals":
				if (!value.equals(constraint.getValue()))
					return new PolicyConstraint.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
				break;
			case "less_equals":
			    hold = function;
				function = "less_equals";
				if (!this.evaluateFunction())
					return new PolicyConstraint.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
				break;	 
			case "greater_equals":
				hold = function;
				function = "greater_equals";
				if (!this.evaluateFunction())
					return new PolicyConstraint.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
				break;
			case "within":
				hold = function;
				function = "greater_equals";
				if (!this.evaluateFunction())
					return new PolicyConstraint.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
				break;	 
			}
		return null;
	}
	
	//evaluates by testing the string output of the operands
		// using a Guava range here 
	public boolean evaluateFunction(){
		switch (function){
			case "equals":
				return property.toString().equals(value.toString());	
			case "less_equals":
				if(property.toString().compareTo(value.toString()) >= 0)
					return true;		
				break;
			case "greater_equals":
				if(property.toString().compareTo(value.toString()) <= 0)
					return true;		
				break;
			case "within":
				if (value instanceof List<?>)
					if (((List<?>)value).contains(property))
						return true;
				//TODO
//				else if(value instanceof Range<BasicSensor>){
//					if (((Range<BasicSensor>)value).contains(property))
//						return true;
//				}	
				break;
			default:
				return false;
		}
		return false;
	}
	
//	//TODO why is this needed? must re-evaluate
//	@Override
//	public int compareTo(Object obj) {
//		if(obj.getClass() != this.getClass()) throw new ClassCastException("Not a Constraint object");
//		PolicyConstraint polCon = (PolicyConstraint) obj;
//		return this.property.compareTo(polCon.property);
//	}

	public boolean equals(Object obj){
		if(obj.getClass() != getClass()) return false;
		PolicyConstraint polCon = (PolicyConstraint) obj;
		return this.property.equals(polCon.property);
	}
	
	public String toString(){
		return property.toString()+" "+function+" "+value.toString();
	}


	//@Override
	//protected BrooklynObjectInternal configure(Map<?, ?> flags) {
		// TODO Auto-generated method stub
	//	return null;
	//}

}
