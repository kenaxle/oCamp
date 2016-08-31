package kr.ac.hanyang.oCamp.entities.policies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;
import org.apache.brooklyn.core.sensor.BasicSensor;

import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;

public class ConstraintSetImpl extends AbstractEntity implements ConstraintSet{
	private String name;
	//private Policy policy; //TODO this is the policy the set is related to.
	private List<PolicyConstraint> constraints;

	
	public ConstraintSetImpl(){}
	
	@Override
	public boolean addConstraint(PolicyConstraint constraint){
		if (this.constraints.add(constraint)){
			sensors().emit(ConstraintSet.CONSTRAINT_ADDED, constraint);
			return true;
		}
			return false;
	}
	
	@Override
	public boolean removeConstraint(PolicyConstraint constraint) {
		if (this.constraints.remove(constraint)){
			sensors().emit(ConstraintSet.CONSTRAINT_REMOVED, constraint);
			return true;
		}
			return false;
	}
	
	
	public String getName(){ return name;}
	
	public PolicyConstraint getConstraint(PolicyConstraint constraint){
		if (constraint instanceof PolicyConstraint)
			return constraints.get(constraints.indexOf(constraint));
		return null; //FIXME should throw exception and log issue instead of returning null
	}
	
	public List<PolicyConstraint> getConstraints(){return constraints;}	
	
	
	
//	public PolicyConstraintImpl getConstraint(BasicSensor property){
//		return constraints.get(constraints.indexOf(new PolicyConstraintImpl.Builder(property).build()));
//	}
	
	
//	// tests if this set is a subset of the other
//	// and that they are aligned. if they are aligned then the delta is empty.
//	public boolean isAlignedWith(ConstraintSetImpl otherSet){
//		//ConstraintSet.Builder returnBuilder = new ConstraintSet.Builder("delta");
//		for (PolicyConstraintImpl pConst: constraints){
//			PolicyConstraintImpl otherConst = otherSet.getConstraint(pConst.getProperty());
//			if(otherConst == null){
//				return false;
//				//if (! pConst.isAlignedWith(otherConst)) 
//				//	returnBuilder.addConstraint(otherConst);
//			}
//		}
//		return true;
//	}
//	
//	public ConstraintSetImpl getDelta(ConstraintSetImpl otherSet){
//		ConstraintSetImpl.Builder deltaBuilder = new ConstraintSetImpl.Builder("delta");
//		for (PolicyConstraintImpl constraint: constraints){
//			PolicyConstraintImpl deltaConstraint = constraint.getDelta(otherSet.getConstraint(constraint));
//			if (deltaConstraint != null){
//				deltaBuilder.addConstraint(deltaConstraint);
//			}
//		}
//		return deltaBuilder.build();
//	}
	
	public boolean isEmpty(){
		return constraints.size() == 0;
	}
	
	//let the weight be the number of items in the set.
	public int getWeight(){
		return constraints.size();
	}	

	
}
