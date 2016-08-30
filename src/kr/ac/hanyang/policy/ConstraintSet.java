package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.sensor.BasicSensor;

public class ConstraintSet extends AbstractEntity implements INotifiable{
	private String name;
	//private Policy policy; //TODO this is the policy the set is related to.
	private List<PolicyConstraint> constraints;
	private List<INotifiable> subscribers;
	
	public static class Builder{
		private String name;
		private List<PolicyConstraint> constraints;
		private List<INotifiable> subscribers = new ArrayList<INotifiable>(); 
		
		public Builder(String name){
			this.name = name;
			constraints = new ArrayList<PolicyConstraint>();
		}
		
		public Builder addConstraint(PolicyConstraint constraint){
			this.constraints.add(constraint);
			return this;
		}
		
		public ConstraintSet build(){
			return new ConstraintSet(this);
		}
	}
	
	private ConstraintSet(Builder builder){
		this.name = builder.name;
		this.constraints = builder.constraints;
		this.subscribers = builder.subscribers;
	}
	
	public void addConstraint(PolicyConstraint constraint){
		this.constraints.add(constraint);
	}
	
	public String getName(){ return name;}
	
	public PolicyConstraint getConstraint(PolicyConstraint constraint){
		if (constraint instanceof PolicyConstraint)
			return constraints.get(constraints.indexOf(constraint));
		return null; //FIXME should throw exception and log issue instead of returning null
	}
	
	public PolicyConstraint getConstraint(BasicSensor property){
		return constraints.get(constraints.indexOf(new PolicyConstraint.Builder(property).build()));
	}
	
	public List<PolicyConstraint> getConstraints(){return constraints;}	
	
	// tests if this set is a subset of the other
	// and that they are aligned. if they are aligned then the delta is empty.
	public boolean isAlignedWith(ConstraintSet otherSet){
		//ConstraintSet.Builder returnBuilder = new ConstraintSet.Builder("delta");
		for (PolicyConstraint pConst: constraints){
			PolicyConstraint otherConst = otherSet.getConstraint(pConst.getProperty());
			if(otherConst == null){
				return false;
				//if (! pConst.isAlignedWith(otherConst)) 
				//	returnBuilder.addConstraint(otherConst);
			}
		}
		return true;
	}
	
	public ConstraintSet getDelta(ConstraintSet otherSet){
		ConstraintSet.Builder deltaBuilder = new ConstraintSet.Builder("delta");
		for (PolicyConstraint constraint: constraints){
			PolicyConstraint deltaConstraint = constraint.getDelta(otherSet.getConstraint(constraint));
			if (deltaConstraint != null){
				deltaBuilder.addConstraint(deltaConstraint);
			}
		}
		return deltaBuilder.build();
	}
	
	public boolean isEmpty(){
		return constraints.size() == 0;
	}
	
	//let the weight be the number of items in the set.
	public int getWeight(){
		return constraints.size();
	}
	
	public String toString(){
		String toReturn = "";
		for (PolicyConstraint constraint: constraints){
			toReturn += constraint.toString()+"\n";
		}
		return this.name+"\n"+toReturn;		
	}

	public void subscribe(INotifiable subscriber){
		subscribers.add(subscriber);
	}
	
	public void unsubscribe(INotifiable subscriber){
		subscribers.remove(subscriber);
	}
	
	private void notifySubscribers(Entity entity) {
		for (INotifiable subscriber: subscribers){
			subscriber.notification(entity);
		}
	}
	
	
	@Override
	public void notification(Entity notifier) {
		//immediately notify the policy 
		//or aggregate the notifications into a set over a 
		//period and notify the policy 
		notifySubscribers(notifier);
	}
	
	
}
