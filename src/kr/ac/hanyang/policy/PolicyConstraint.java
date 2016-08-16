package kr.ac.hanyang.policy;

public class PolicyConstraint<T> implements IConstraint<T>{
	private String property;
	private String operator; //FIXME need to change this to a type object
	private T value; // this is the value/values of the property.
	
	public PolicyConstraint(String property, String type, T value){
		this.property = property;
		this.operator = type;
		this.value = value;
	}
	
	public String getProperty(){
		return property;
	}
	
	@Override
	public String getOperator() {
		return operator;
	}

	public T getValue(){
		return value;
	}

	
	
}
