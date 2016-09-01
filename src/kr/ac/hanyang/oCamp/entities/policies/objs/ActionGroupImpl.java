package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.objs.BrooklynObjectInternal;

import kr.ac.hanyang.oCamp.entities.constraints.ConstraintImpl;
import kr.ac.hanyang.oCamp.entities.transitions.Transition;

public class ActionGroupImpl extends AbstractEntity implements ActionGroup {
	//private Effector actionID;
	private List<Action> actions; //calculated after evaluating actions
	
	
	public ActionGroupImpl(){ }
	
	public void init(){
		actions = new ArrayList<Action>();
	}
	
	public boolean addAction(Action action){
		if (this.actions.add(action)){
			sensors().emit(ActionGroup.ACTION_ADDED, action);
			return true;
		}
			return false;
	}
	
	public boolean removeAction(Action action){
		if (this.actions.remove(action)){
			sensors().emit(ActionGroup.ACTION_REMOVED, action);
			return true;
		}
			return false;
	}

	@Override
	public boolean setActionID(Effector actionEffector) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeActionID(Effector actionEffector) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAction(kr.ac.hanyang.oCamp.api.objs.Action action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAction(kr.ac.hanyang.oCamp.api.objs.Action action) {
		// TODO Auto-generated method stub
		return false;
	}

	
//	public String getActionID(){
//		return name;
//	}
//	
//	public void setWeight(double weight){
//		this.weight = weight;
//	}
//	
//	public double getWeight(){
//		return weight;
//	}
//	
//	public void addAction(ActionImpl action){
//		actions.add(action);
//	}
//	
//	//FIXME need to finish this method
//	// must use the delta of the entity and the actionable
//	// then using that delta
//	public boolean canFulfill(PolicyImpl pol){
//		ConstraintSetImpl desiredState = pol.getDesiredState();
//		return desiredState.isAlignedWith(actionableConstraints);
//	}
//	

}
