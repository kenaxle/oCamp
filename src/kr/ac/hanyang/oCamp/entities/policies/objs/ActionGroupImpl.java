package kr.ac.hanyang.oCamp.entities.policies.objs;

import java.util.List;
import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.core.entity.AbstractEntity;
import kr.ac.hanyang.oCamp.api.objs.Action;

public class ActionGroupImpl extends AbstractEntity implements ActionGroup {
	
	//private Effector ACTION_ID;
	
	private List<Action> actions;
	
	public ActionGroupImpl(){ }
	
	public void init(){
		//actions = new ArrayList<Action>();
	}
	
	@Override
	public boolean setActions(List<Action> actions){
		if (config().set(ACTIONS, actions) != null){
			sensors().emit(ActionGroup.ACTIONS_ADDED, actions);
			return true;
		}
			return false;
	}
	
	@Override
	public boolean setActionID(Effector actionEffector) {
		// TODO Auto-generated method stub
		return config().set(ACTION_ID, actionEffector) != null;
	}


}
