package kr.ac.hanyang.policy;

import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.util.core.config.ConfigBag;

public interface IAction {
		
	public static class ActionBody extends EffectorBody<Void> {
        @Override public Void call(ConfigBag parameters) {
            return new MethodEffector<Void>(Action.class, "action").call(entity(), parameters.getAllConfig());
        }
    }
	
	org.apache.brooklyn.api.effector.Effector<Void> ACTION = Effectors.effector(new MethodEffector<Void>(Action.class, "action"))
		        .impl(new ActionBody())
		        .build();
	 
	@org.apache.brooklyn.core.annotation.Effector(description="action effector")
	    void action(@EffectorParam(name="actionName") MethodEffector effectorName);
}
