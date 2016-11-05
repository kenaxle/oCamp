package kr.ac.hanyang.oCamp.core.mgmt;

import java.util.Collection;
import java.util.Map;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.core.internal.BrooklynProperties.Factory.Builder;
import org.apache.brooklyn.core.mgmt.internal.LocalEntityManager;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;

import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;

public class BaseEntityManager extends LocalManagementContext{// implements PolicyManager {

	private LocalOCampEntityManager entityManager;
	private oCampPlatform parentPlatform;
	
	public BaseEntityManager() {
		super();
	}
	
	public synchronized Collection<Application> getPolicyManagers() {
        return ((LocalOCampEntityManager)getEntityManager()).getPolicyManagers();
    }

	
	public BaseEntityManager(Builder brooklynPropertiesBuilder, Map<String, Object> brooklynAdditionalProperties) {
		super(brooklynPropertiesBuilder, brooklynAdditionalProperties);
	}

	public void setParentPlatform(oCampPlatform platform){
		this.parentPlatform = platform;
	}
	
	public oCampPlatform getParentPlatform(){
		return parentPlatform;
	}
	
	@Override
	public InternalEntityFactory getEntityFactory() {
		return getEntityManager().getEntityFactory();
    }

	@Override
	public synchronized LocalEntityManager getEntityManager() {
        if (!isRunning()) throw new IllegalStateException("Management context no longer running");

        if (this.entityManager == null) {
            this.entityManager = new LocalOCampEntityManager(this);
        }
        return this.entityManager;
    }
	

	
	

}
