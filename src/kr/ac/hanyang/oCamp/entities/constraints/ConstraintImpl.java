package kr.ac.hanyang.oCamp.entities.constraints;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.api.sensor.SensorEvent;
import org.apache.brooklyn.api.sensor.SensorEventListener;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicAttributeSensor;

import kr.ac.hanyang.oCamp.api.policy.Policy;

public abstract class ConstraintImpl<T> extends AbstractEntity implements Constraint{
	private BasicAttributeSensor property; //TODO this should be a Brooklyn attribute or sensor.
	private T value; // this is the value/values of the property.
	
	// No-arg constructor
	public ConstraintImpl(){}
	
	@Override
	public void init(){
		super.init();
	}
	
	public BasicAttributeSensor getProperty(){
		return property;
	}

	public T getValue(){
		return value;
	}
	
	//these may be effector methods
	@SuppressWarnings("unchecked")
	public void register(Policy policy){
		this.subscriptions().subscribe(policy, property, constraintListener(this));
	}
	
	public void unregister(Policy policy){
		this.subscriptions().unsubscribe(policy);
	}
	
	private SensorEventListener<Object> constraintListener(Constraint listener){
		return new SensorEventListener<Object>(){
			public void onEvent(SensorEvent<Object> event){
				if (! listener.evaluate(event)){
					listener.sensors().emit(Constraint.CONSTRAINT_VIOLATED, event);
				}
			}
		};
	}
	
	public abstract boolean isViolated(Sensor propertySensor, Entity entity);
		
	
	
	// simple equals alignment
	// TODO may have to adjust to perform different alignments based on the function/type
//	public boolean isAlignedWith(PolicyConstraintImpl constraint){
//		if (this.property.equals(constraint.getProperty()) && this.value.equals(constraint.getValue()))
//			return true;
//		return false;				
//	}
	
	// may not need as I can simply check for alignment then use the constraint
//	public PolicyConstraintImpl getDelta(PolicyConstraintImpl constraint){
//		String hold;
//		if (this.property.equals(constraint.getProperty()))
//			switch (constraint.getFunctionType()){
//			case "equals":
//				if (!value.equals(constraint.getValue()))
//					return new PolicyConstraintImpl.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
//				break;
//			case "less_equals":
//			    hold = function;
//				function = "less_equals";
//				if (!this.evaluateFunction())
//					return new PolicyConstraintImpl.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
//				break;	 
//			case "greater_equals":
//				hold = function;
//				function = "greater_equals";
//				if (!this.evaluateFunction())
//					return new PolicyConstraintImpl.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
//				break;
//			case "within":
//				hold = function;
//				function = "greater_equals";
//				if (!this.evaluateFunction())
//					return new PolicyConstraintImpl.Builder(constraint.getProperty(),"equals",constraint.getValue()).build();
//				break;	 
//			}
//		return null;
//	}
	
	//evaluates by testing the string output of the operands
		// using a Guava range here 
//	public boolean evaluateFunction(){
//		switch (function){
//			case "equals":
//				return property.toString().equals(value.toString());	
//			case "less_equals":
//				if(property.toString().compareTo(value.toString()) >= 0)
//					return true;		
//				break;
//			case "greater_equals":
//				if(property.toString().compareTo(value.toString()) <= 0)
//					return true;		
//				break;
//			case "within":
//				if (value instanceof List<?>)
//					if (((List<?>)value).contains(property))
//						return true;
//				//TODO
////				else if(value instanceof Range<BasicSensor>){
////					if (((Range<BasicSensor>)value).contains(property))
////						return true;
////				}	
//				break;
//			default:
//				return false;
//		}
//		return false;
//	}
	
//	//TODO why is this needed? must re-evaluate
//	@Override
//	public int compareTo(Object obj) {
//		if(obj.getClass() != this.getClass()) throw new ClassCastException("Not a Constraint object");
//		PolicyConstraint polCon = (PolicyConstraint) obj;
//		return this.property.compareTo(polCon.property);
//	}

//	public boolean equals(Object obj){
//		if(obj.getClass() != getClass()) return false;
//		PolicyConstraintImpl polCon = (PolicyConstraintImpl) obj;
//		return this.property.equals(polCon.property);
//	}
	
    @Override
	public boolean evaluate(SensorEvent event){
		return false;
	}
	
	//--------------------------------------------------------
    
    
    
    public boolean isAlignedWith(Constraint constraint){
		return false;
	}

	@Override
	public boolean setProperty(Sensor property) {
		if (config().set(PROPERTY, property) != null){
			sensors().emit(PROPERTY_SET, property);
			return true;
		}
		return false;
	}

	@Override
	public boolean setValue(Object object) {
		if (config().set(VALUE, object) != null){
			sensors().emit(VALUE_SET, object);
			return true;
		}
		return false;
	}
	
	public SensorEventListener<T> getListener(){
		return (SensorEventListener<T>) constraintListener(this);
	}


	//@Override
	//protected BrooklynObjectInternal configure(Map<?, ?> flags) {
		// TODO Auto-generated method stub
	//	return null;
	//}

}
