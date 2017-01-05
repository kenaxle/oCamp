package kr.ac.hanyang.oCamp.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.catalog.CatalogItem;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.core.mgmt.entitlement.Entitlements;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.apache.brooklyn.rest.domain.EffectorSummary;
import org.apache.brooklyn.rest.domain.EntityConfigSummary;
import org.apache.brooklyn.rest.domain.SensorSummary;
import org.apache.brooklyn.rest.resources.AbstractBrooklynRestResource;
import org.apache.brooklyn.rest.transform.CatalogTransformer;
import org.apache.brooklyn.rest.util.BrooklynRestResourceUtils;
import org.apache.brooklyn.rest.util.WebResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.rest.api.CatalogApi;
import kr.ac.hanyang.oCamp.rest.transform.ServiceCatalogTransformer;
import kr.ac.hanyang.oCamp.rest.util.OCampRestResourceUtils;

public class ServiceCatalogResource extends AbstractBrooklynRestResource implements CatalogApi{
	private static final Logger log = LoggerFactory.getLogger(ServiceCatalogResource.class);
	
	private OCampRestResourceUtils oCampRestResourceUtils;
	
	public synchronized OCampRestResourceUtils oCamp() {
        if (oCampRestResourceUtils!=null) return oCampRestResourceUtils;
        oCampRestResourceUtils = new OCampRestResourceUtils(mgmt());
        return oCampRestResourceUtils;
    }
	
	
	public CatalogEntitySummary getEntity(String symbolicName) {
        @SuppressWarnings("unchecked")
        EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItemSpec(symbolicName);

        if (result==null) {
            throw WebResourceUtils.notFound("Entity with id '%s' not found", symbolicName);
        }

        return ServiceCatalogTransformer.catalogEntitySummary(result, ui.getBaseUriBuilder());
    }

	@Override
	public List<CatalogEntitySummary> listEntities() {
		return ServiceCatalogTransformer.listEntities(oCamp().getServiceCatalog().getServiceSpecs());
	}

	public List<SensorSummary> getEntitySensors(String symbolicName) {
		@SuppressWarnings("unchecked")
        EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItemSpec(symbolicName);

		if (result==null) {
            throw WebResourceUtils.notFound("Entity with id '%s' not found", symbolicName);
        }

        return ServiceCatalogTransformer.catalogEntitySensorsSummary(result, ui.getBaseUriBuilder());
       
    }
	
	public List<EntityConfigSummary> getEntityConfigs(String symbolicName) {
		@SuppressWarnings("unchecked")
        EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItemSpec(symbolicName);

		if (result==null) {
            throw WebResourceUtils.notFound("Entity with id '%s' not found", symbolicName);
        }

        return ServiceCatalogTransformer.catalogEntityConfigsSummary(result, ui.getBaseUriBuilder());
       
    }
	
	public List<EffectorSummary> getEntityEffectors(String symbolicName) {
		@SuppressWarnings("unchecked")
        EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItemSpec(symbolicName);

		if (result==null) {
            throw WebResourceUtils.notFound("Entity with id '%s' not found", symbolicName);
        }

        return ServiceCatalogTransformer.catalogEntityEffectorsSummary(result, ui.getBaseUriBuilder());
       
    }
	
	public List<CatalogEntitySummary> getEntitiesByConfig(String config) {
		//EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItem(sensors);

		if (config==null||config.isEmpty()) {
            throw WebResourceUtils.notFound("No sensors were supplied");
        }

        return ServiceCatalogTransformer.listEntitiesbyConfig(config, oCamp().getServiceCatalog().getServiceSpecs());
	}
	
	
	public List<CatalogEntitySummary> getEntitiesBySensor(String sensor) {
		//EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItem(sensors);

		if (sensor==null||sensor.isEmpty()) {
            throw WebResourceUtils.notFound("No sensors were supplied");
        }

        return ServiceCatalogTransformer.listEntitiesbySensor(sensor, oCamp().getServiceCatalog().getServiceSpecs());
	}
	
	public List<CatalogEntitySummary> getEntitiesByEffector(String effector) {
		//EntitySpec<?> result = oCamp().getServiceCatalog().getCatalogItem(sensors);

		if (effector==null||effector.isEmpty()) {
            throw WebResourceUtils.notFound("No sensors were supplied");
        }

        return ServiceCatalogTransformer.listEntitiesbyEffector(effector, oCamp().getServiceCatalog().getServiceSpecs());
	}
	
}
