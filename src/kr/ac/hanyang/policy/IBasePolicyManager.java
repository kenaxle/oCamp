package kr.ac.hanyang.policy;

import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.util.core.config.ConfigBag;


import kr.ac.hanyang.policy.placement.IPlacement;

public interface IBasePolicyManager {
	public static final String[] ACTIONGROUPS = {"START","STOP","RESTART"};
	
	public static class StartActionBody extends EffectorBody<Void> {
        @Override public Void call(ConfigBag parameters) {
            return new MethodEffector<Void>(IPlacement.class, "startaction").call(entity(), parameters.getAllConfig());
        }
    }
	
	public static class StopActionBody extends EffectorBody<Void> {
      @Override public Void call(ConfigBag parameters) {
          return new MethodEffector<Void>(IPlacement.class, "stopaction").call(entity(), parameters.getAllConfig());
      }
    }
	
	public static class RestartActionBody extends EffectorBody<Void> {
	      @Override public Void call(ConfigBag parameters) {
	          return new MethodEffector<Void>(IPlacement.class, "restartaction").call(entity(), parameters.getAllConfig());
	      }
	}

    org.apache.brooklyn.api.effector.Effector<Void> STARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "startaction"))
        .impl(new StartActionBody())
        .build();
    
    org.apache.brooklyn.api.effector.Effector<Void> STOPACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "stopaction"))
            .impl(new StartActionBody())
            .build();
    
    org.apache.brooklyn.api.effector.Effector<Void> RESTARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "restartaction"))
            .impl(new StartActionBody())
            .build();
    
    
    @org.apache.brooklyn.core.annotation.Effector(description="startaction effector")
    void startaction();
    
    @org.apache.brooklyn.core.annotation.Effector(description="stopaction effector")
    void stopaction();
    
    @org.apache.brooklyn.core.annotation.Effector(description="restartaction effector")
    void restartaction();
    
	
}
