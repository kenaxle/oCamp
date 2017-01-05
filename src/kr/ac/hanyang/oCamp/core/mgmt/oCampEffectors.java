package kr.ac.hanyang.oCamp.core.mgmt;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.core.entity.BrooklynConfigKeys;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.JavaWebAppService;

import kr.ac.hanyang.oCamp.core.traits.Movable;
import kr.ac.hanyang.oCamp.core.traits.Scalable;
import kr.ac.hanyang.oCamp.core.traits.oCampStartable;

public class oCampEffectors extends BrooklynConfigKeys {
	
	public static final Effector<Void> STARTUP = oCampStartable.STARTUP;
	
	public static final Effector<Void> START = Startable.START;
	public static final Effector<Void> STOP = Startable.STOP;
	public static final Effector<Void> RESTART = Startable.RESTART;
	public static final Effector<Void> MOVE = Movable.MOVE;
	
	public static final Effector<Void> DEPLOY = JavaWebAppService.CanDeployAndUndeploy.DEPLOY;
	public static final Effector<Void> UNDEPLOY = JavaWebAppService.CanDeployAndUndeploy.UNDEPLOY;
	public static final Effector<Void> REDEPLOY = JavaWebAppService.CanRedeployAll.REDEPLOY_ALL;
	
	public static final Effector<Void> SCALE_UP = Scalable.SCALE_UP;
	public static final Effector<Void> SCALE_DOWN = Scalable.SCALE_DOWN;
	
	
}
