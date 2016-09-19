package kr.ac.hanyang.oCamp.core.traits;

import java.util.Collection;

import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.util.core.config.ConfigBag;

public interface oCampStartable extends Startable {
	 
	public static class StartUpEffectorBody extends EffectorBody<Void> {
		public static final ConfigKey<Object> LOCATIONS = ConfigKeys.newConfigKey(Object.class, "locations",
				"The location or locations to start in, as a string, a location object, a list of strings, "
						+ "or a list of location objects");
		@Override public Void call(ConfigBag parameters) {
			parameters.put(LOCATIONS, entity().getManagementContext().getLocationRegistry().getListOfLocationsManaged(parameters.get(LOCATIONS)));
			return new MethodEffector<Void>(oCampStartable.class, "startup").call(entity(), parameters.getAllConfig());
		}
	}
	
    org.apache.brooklyn.api.effector.Effector<Void> STARTUP = Effectors.effector(new MethodEffector<Void>(oCampStartable.class, "startup"))
            // override start to take strings etc
            .parameter(StartUpEffectorBody.LOCATIONS)
            .impl(new StartUpEffectorBody())
            .build();
	
    @org.apache.brooklyn.core.annotation.Effector(description="Start the process/service represented by an entity")
    void startup(@EffectorParam(name="locations") Collection<? extends Location> locations);
    
}
