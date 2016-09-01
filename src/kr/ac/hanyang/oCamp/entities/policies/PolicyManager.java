package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.core.effector.EffectorBody;
import org.apache.brooklyn.core.effector.Effectors;
import org.apache.brooklyn.core.effector.MethodEffector;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.sensor.BasicNotificationSensor;
import org.apache.brooklyn.core.sensor.BasicSensor;
import org.apache.brooklyn.util.core.config.ConfigBag;

import kr.ac.hanyang.oCamp.entities.IEntity;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraint;
import kr.ac.hanyang.oCamp.entities.constraints.PolicyConstraintImpl;
import kr.ac.hanyang.oCamp.entities.policies.placement.IPlacement;
import kr.ac.hanyang.oCamp.entities.services.software.SoftwareProcess;

@ImplementedBy(PolicyManagerImpl.class)
public interface PolicyManager {
	
	public static final BasicNotificationSensor<Policy> POLICY_ADDED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.added", "The policy was added");
	
	public static final BasicNotificationSensor<Policy> POLICY_REMOVED = new BasicNotificationSensor<Policy>(
			Policy.class, "policy.removed", "The policy was removed");
	
//	@SuppressWarnings("unchecked")
//	public static final ActionGroup[] ACTIONGROUPS = {new ActionGroup.Builder("START").addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) Attributes.SERVICE_UP,"set_to",true).build())
//																					  .addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) SoftwareProcess.PROVISIONING_LOCATION,"obtained_from",null).build()) //FIXME
//																					  .build(),
//													  new ActionGroup.Builder("STOP").addConstraint(new PolicyConstraintImpl.Builder((BasicSensor) Attributes.SERVICE_UP,"equals",false).build())
//													  								 .build()
//													  };
	
	public boolean addPolicy(Policy policy);
	
	public boolean removePolicy(Policy policy);
	
	
	public void evaluateActions(Entity entity);
//	public static class StartActionBody extends EffectorBody<Void> {
//        @Override public Void call(ConfigBag parameters) {
//            return new MethodEffector<Void>(IPlacement.class, "startaction").call(entity(), parameters.getAllConfig());
//        }
//    }
//	
//	public static class StopActionBody extends EffectorBody<Void> {
//      @Override public Void call(ConfigBag parameters) {
//          return new MethodEffector<Void>(IPlacement.class, "stopaction").call(entity(), parameters.getAllConfig());
//      }
//    }
//	
//	public static class RestartActionBody extends EffectorBody<Void> {
//	      @Override public Void call(ConfigBag parameters) {
//	          return new MethodEffector<Void>(IPlacement.class, "restartaction").call(entity(), parameters.getAllConfig());
//	      }
//	}
//
//    org.apache.brooklyn.api.effector.Effector<Void> STARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "startaction"))
//        .impl(new StartActionBody())
//        .build();
//    
//    org.apache.brooklyn.api.effector.Effector<Void> STOPACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "stopaction"))
//            .impl(new StartActionBody())
//            .build();
//    
//    org.apache.brooklyn.api.effector.Effector<Void> RESTARTACTION = Effectors.effector(new MethodEffector<Void>(IPlacement.class, "restartaction"))
//            .impl(new StartActionBody())
//            .build();
//    
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="startaction effector")
//    void startaction();
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="stopaction effector")
//    void stopaction();
//    
//    @org.apache.brooklyn.core.annotation.Effector(description="restartaction effector")
//    void restartaction();
    
	
}
