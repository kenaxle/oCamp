package kr.ac.hanyang.policy;

public class PolicyConstraint<T> implements IConstraint<T>, Comparable{
	private String property; //TODO this should be a Brooklyn attribute or sensor.
	private String type; //FIXME need to change this to a type object
	private T value; // this is the value/values of the property.
	
	public PolicyConstraint(String property){
		this.property = property;
	}
	
	public PolicyConstraint(String property, String type, T value){
		this.property = property;
		this.type = type;
		this.value = value;
	}
	
	public String getProperty(){
		return property;
	}
	
	@Override
	public String getType() {
		return type;                                                                                                                                                                              
	}

	public T getValue(){
		return value;
	}
	
	// simple equals alignment
	// TODO may have to adjust to perform diferent alignments based on the function/type
	public boolean isAlignedWith(PolicyConstraint constraint){
		if (this.property.equals(constraint.getProperty()) && this.value.equals(constraint.getValue()))
			return true;
		return false;
					
	}

	@Override
	public int compareTo(Object obj) {
		if(obj.getClass() != getClass()) throw new ClassCastException("Not a Constraint object");
		PolicyConstraint polCon = (PolicyConstraint) obj;
		return this.property.compareTo(polCon.property);
	}

	public boolean equals(Object obj){
		if(obj.getClass() != getClass()) return false;
		PolicyConstraint polCon = (PolicyConstraint) obj;
		return this.property.equals(polCon.property);
	}
	
}
