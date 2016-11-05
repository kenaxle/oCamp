package kr.ac.hanyang.oCamp.core.traits;

import java.util.Collection;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.util.core.config.ConfigBag;

public interface Scalable extends Startable {
	 
	public static class ScaleUpEffectorBody extends EffectorBody<Void> {
		
		public static final ConfigKey<Integer> SIZE = ConfigKeys.newConfigKey(Integer.class, "desired size","");
		
		@Override public Void call(ConfigBag parameters) {
			//parameters.put(SIZE, entity().getManagementContext().getLocationRegistry().getListOfLocationsManaged(parameters.get(LOCATION)));
			return new MethodEffector<Void>(Scalable.class, "scale.up").call(entity(), parameters.getAllConfig());
		}
	}
	
	public static class ScaleDownEffectorBody extends EffectorBody<Void> {
		
		public static final ConfigKey<Integer> SIZE = ConfigKeys.newConfigKey(Integer.class, "desired size","");
		
		@Override public Void call(ConfigBag parameters) {
			//parameters.put(SIZE, entity().getManagementContext().getLocationRegistry().getListOfLocationsManaged(parameters.get(LOCATION)));
			return new MethodEffector<Void>(Scalable.class, "scale.down").call(entity(), parameters.getAllConfig());
		}
	}
	
    org.apache.brooklyn.api.effector.Effector<Void> SCALE_UP = Effectors.effector(new MethodEffector<Void>(Scalable.class, "scaleUp"))
            // override start to take strings etc
            .parameter(ScaleUpEffectorBody.SIZE)
            .impl(new ScaleUpEffectorBody())
            .build();
    
    org.apache.brooklyn.api.effector.Effector<Void> SCALE_DOWN = Effectors.effector(new MethodEffector<Void>(Scalable.class, "scaleDown"))
            // override start to take strings etc
            .parameter(ScaleDownEffectorBody.SIZE)
            .impl(new ScaleDownEffectorBody())
            .build();
	
    @org.apache.brooklyn.core.annotation.Effector(description="scale up the dynamic cluster")
    void scaleUp(@EffectorParam(name="desired.size" ) Integer desiredSize);
    
    @org.apache.brooklyn.core.annotation.Effector(description="scale down the dynamic cluster")
    void scaleDown(@EffectorParam(name="desired.size" ) Integer desiredSize);
    
}
