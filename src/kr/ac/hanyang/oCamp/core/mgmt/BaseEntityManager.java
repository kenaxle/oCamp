package kr.ac.hanyang.oCamp.core.mgmt;

import org.apache.brooklyn.core.mgmt.internal.LocalEntityManager;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;

public class BaseEntityManager extends LocalManagementContext{// implements PolicyManager {

	private LocalOCampEntityManager entityManager;
	
	
	public BaseEntityManager() {
		super();
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
