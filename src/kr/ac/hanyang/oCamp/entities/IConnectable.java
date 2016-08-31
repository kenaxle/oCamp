package kr.ac.hanyang.oCamp.entities;

import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.util.core.config.ConfigBag;

import kr.ac.hanyang.oCamp.entities.requirements.IConnectTo;
import kr.ac.hanyang.oCamp.entities.requirements.IDeployOn;

public interface IConnectable{
	
	//public boolean executeContent(String command);
	
	AttributeSensor<Boolean> SERVICE_UP = Attributes.SERVICE_UP;

    public static class ExecuteEffectorBody extends EffectorBody<Void> {
        public static final ConfigKey<Object> COMMAND = ConfigKeys.newConfigKey(Object.class, "command",
            "string to find the item to execute.");
        
        @Override public Void call(ConfigBag parameters) {
            parameters.put(COMMAND, (String)((IConnectTo)entity().getParent()).getScript());            
            return new MethodEffector<Void>(IConnectable.class, "executeScript").call(entity(), parameters.getAllConfig());
        }
    }

    org.apache.brooklyn.api.effector.Effector<Void> EXECUTE = Effectors.effector(new MethodEffector<Void>(IConnectable.class, "executeScript"))
        // override start to take strings etc
        .parameter(ExecuteEffectorBody.COMMAND)
        .impl(new ExecuteEffectorBody())
        .build();
    


    /**
     * Deploy content from a specific URL.
     * <p>
     * Some entities may define custom {@link Effector} implementations which support
     * a richer set of parameters.  See the entity-specific {@link #DEPLOY} effector declaration.
     */
    @org.apache.brooklyn.core.annotation.Effector(description="execute a command")
    String executeScript(@EffectorParam(name="command") String command);
	
}
