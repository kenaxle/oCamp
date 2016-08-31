package kr.ac.hanyang.oCamp.entities.policies;

public interface PolicyConstraint<T> {
	
	public String getProperty();
	
	public String getType();
	
	public T getValue();
	
	public boolean isEnabled();
}
