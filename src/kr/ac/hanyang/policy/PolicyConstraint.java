package kr.ac.hanyang.policy;

import java.util.List;

import com.google.common.collect.Range;

public class PolicyConstraint<T extends Comparable, U> implements Comparable{
	private T property; //TODO this should be a Brooklyn attribute or sensor.
	private String function; //FIXME need to change this to a type object
	private U value; // this is the value/values of the property.
	
	
	public static class Builder<T extends Comparable,U>{
		
		private T property; //TODO this should be a Brooklyn attribute or sensor.
		private String function; //FIXME need to change this to a type object
		private U value; // this is the value/values of the property.
		
		public Builder(T property){
			this.property = property;
		}
		
		public Builder(T property, String function, U value){
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
		
		public PolicyConstraint build(){
			return new PolicyConstraint(this);
		}
	}
	
	private PolicyConstraint(Builder builder){
		this.property = (T)builder.property;
		this.function = builder.function;
		this.value = (U)builder.value;
	}
	
	
	public T getProperty(){
		return property;
	}
	
	public String getFunctionType() {
		return function;                                                                                                                                                                              
	}

	public U getValue(){
		return value;
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
					else if(value instanceof Range<?>){
						if (((Range<T>)value).contains((T) property))
							return true;
					}	
					break;
				default:
					return false;
			}
			return false;
		}
	
	//TODO why is this needed? must re-evaluate
	@Override
	public int compareTo(Object obj) {
		if(obj.getClass() != this.getClass()) throw new ClassCastException("Not a Constraint object");
		PolicyConstraint polCon = (PolicyConstraint) obj;
		return this.property.compareTo(polCon.property);
	}

	public boolean equals(Object obj){
		if(obj.getClass() != getClass()) return false;
		PolicyConstraint polCon = (PolicyConstraint) obj;
		return this.property.equals(polCon.property);
	}
	
}
