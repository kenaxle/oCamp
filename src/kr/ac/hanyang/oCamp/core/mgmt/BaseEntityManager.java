package kr.ac.hanyang.oCamp.core.mgmt;

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
