package kr.ac.hanyang.policy;

public interface IConstraint<T> {
	
	public String getProperty();
	
	public String getType();
	
	public T getValue();
}
