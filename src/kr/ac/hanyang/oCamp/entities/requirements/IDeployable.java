package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.annotation.EffectorParam;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.util.core.config.ConfigBag;



public interface IDeployable{
	
	AttributeSensor<Boolean> SERVICE_UP = Attributes.SERVICE_UP;

    public static class DeployEffectorBody extends EffectorBody<Void> {
        public static final ConfigKey<String> URL = ConfigKeys.newConfigKey(String.class, "url",
            "string to find the item to deploy.");
        public static final ConfigKey<String> TARGET = ConfigKeys.newConfigKey(String.class, "target",
                "where the content will be hosted.");
        @Override public Void call(ConfigBag parameters) {
            parameters.put(URL, parameters.get(URL));
            parameters.put(TARGET, parameters.get(TARGET));
            return new MethodEffector<Void>(IDeployable.class, "deploy").call(entity(), parameters.getAllConfig());
        }
    }

    org.apache.brooklyn.api.effector.Effector<Void> DEPLOY = Effectors.effector(new MethodEffector<Void>(IDeployable.class, "deploy"))
        // override start to take strings etc
        .parameter(DeployEffectorBody.URL)
        .parameter(DeployEffectorBody.TARGET)
        .impl(new DeployEffectorBody())
        .build();
    


    /**
     * Deploy content from a specific URL.
     * <p>
     * Some entities may define custom {@link Effector} implementations which support
     * a richer set of parameters.  See the entity-specific {@link #DEPLOY} effector declaration.
     */
    @org.apache.brooklyn.core.annotation.Effector(description="deploy the content to the service")
    void deploy(@EffectorParam(name="url") String url, @EffectorParam(name="target") String targetName);
	
}
