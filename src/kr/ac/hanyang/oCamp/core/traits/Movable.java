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

public interface Movable extends Startable {
	
	
	
	 public static class MoveEffectorBody extends EffectorBody<Void> {
	        public static final ConfigKey<Object> LOCATIONS = ConfigKeys.newConfigKey(Object.class, "locations",
	            "The location or locations to move to, as a string, a location object, a list of strings, "
	            + "or a list of location objects");
	        @Override public Void call(ConfigBag parameters) {
	            parameters.put(LOCATIONS, entity().getManagementContext().getLocationRegistry().getListOfLocationsManaged(parameters.get(LOCATIONS)));
	            return new MethodEffector<Void>(Movable.class, "move").call(entity(), parameters.getAllConfig());
	        }
	    }

	
	org.apache.brooklyn.api.effector.Effector<Void> MOVE = Effectors.effector(new MethodEffector<Void>(Movable.class, "move"))
	        // override start to take strings etc
	        .parameter(StartEffectorBody.LOCATIONS)
	        .impl(new StartEffectorBody())
	        .build();
	
	
	@org.apache.brooklyn.core.annotation.Effector(description="Move the process/service represented by an entity")
    void move(@EffectorParam(name="locations") Collection<? extends Location> locations);
	
	
	
	
}
