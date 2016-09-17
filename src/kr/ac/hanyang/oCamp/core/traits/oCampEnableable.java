package kr.ac.hanyang.oCamp.core.traits;

import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.util.core.config.ConfigBag;

public interface oCampEnableable {
	 
	public static class enableEffectorBody extends EffectorBody<Void> {
		
		@Override public Void call(ConfigBag parameters) {
			return new MethodEffector<Void>(oCampEnableable.class, "enable").call(entity(), parameters.getAllConfig());
		}
	}
	
	public static class disableEffector extends EffectorBody<Void> {
		
		@Override public Void call(ConfigBag parameters) {
			return new MethodEffector<Void>(oCampEnableable.class, "disable").call(entity(), parameters.getAllConfig());
		}
	}
	
    org.apache.brooklyn.api.effector.Effector<Void> ENABLE = Effectors.effector(new MethodEffector<Void>(oCampEnableable.class, "enable"))
            .impl(new enableEffectorBody())
            .build();
	
    org.apache.brooklyn.api.effector.Effector<Void> DISABLE = Effectors.effector(new MethodEffector<Void>(oCampEnableable.class, "disable"))
            .impl(new enableEffectorBody())
            .build();
    
    @org.apache.brooklyn.core.annotation.Effector(description="enable a policy")
    void enable();
    
    @org.apache.brooklyn.core.annotation.Effector(description="disable a policy")
    void disable();
}
