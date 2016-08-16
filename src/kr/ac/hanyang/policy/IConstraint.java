package kr.ac.hanyang.policy;

public interface IConstraint<T> {
	
	public String getProperty();
	
	public String getOperator();
	
	public T getValue();
}
