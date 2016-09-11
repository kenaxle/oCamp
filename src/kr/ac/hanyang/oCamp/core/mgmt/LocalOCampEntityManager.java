package kr.ac.hanyang.oCamp.core.mgmt;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.core.entity.AbstractEntity;
import org.apache.brooklyn.core.mgmt.internal.LocalEntityManager;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.objs.BasicEntityTypeRegistry;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;
import org.apache.brooklyn.core.objs.proxy.InternalPolicyFactory;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.core.objs.proxy.InternalOCampEntityFactory;

public class LocalOCampEntityManager extends LocalEntityManager {

	private static final Logger log = LoggerFactory.getLogger(LocalOCampEntityManager.class);
	private final InternalOCampEntityFactory entityFactory;
	private final LocalManagementContext managementContext;
	
	public LocalOCampEntityManager(LocalManagementContext managementContext) {
		super(managementContext);
		BasicEntityTypeRegistry entityTypeRegistry = new BasicEntityTypeRegistry();
		InternalPolicyFactory policyFactory = new InternalPolicyFactory(managementContext);
        this.entityFactory = new InternalOCampEntityFactory(managementContext, entityTypeRegistry, policyFactory);
        this.managementContext = managementContext;
	}
	
	@Override
	public InternalOCampEntityFactory getEntityFactory() {
        if (!managementContext.isRunning()) throw new IllegalStateException("Management context no longer running");
        return entityFactory;
    }
	
	@Override
    public <T extends Entity> T createEntity(EntitySpec<T> spec) {
		try {
            T entity = this.entityFactory.createEntity(spec);
            Entity proxy = ((AbstractEntity)entity).getProxy();
            checkNotNull(proxy, "proxy for entity %s, spec %s", entity, spec);
            
            manage(entity);
            
            return (T) proxy;
        } catch (Throwable e) {
            log.warn("Failed to create entity using spec "+spec+" (rethrowing)", e);
            throw Exceptions.propagate(e);
        }
	}

}
