package kr.ac.hanyang.oCamp.rest.resources;

import static javax.ws.rs.core.Response.created;
import static org.apache.brooklyn.rest.util.WebResourceUtils.serviceAbsoluteUriBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.Group;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.EntityPredicates;
import org.apache.brooklyn.core.entity.lifecycle.Lifecycle;
import org.apache.brooklyn.core.mgmt.entitlement.EntitlementPredicates;
import org.apache.brooklyn.core.mgmt.entitlement.Entitlements;
import org.apache.brooklyn.entity.group.AbstractGroup;
import org.apache.brooklyn.rest.api.ApplicationApi;
import org.apache.brooklyn.rest.domain.ApplicationSummary;
import org.apache.brooklyn.rest.domain.EntityDetail;
import org.apache.brooklyn.rest.domain.EntitySummary;
import org.apache.brooklyn.rest.resources.AbstractBrooklynRestResource;
import org.apache.brooklyn.rest.transform.ApplicationTransformer;
import org.apache.brooklyn.rest.transform.EntityTransformer;
import org.apache.brooklyn.rest.transform.TaskTransformer;
import org.apache.brooklyn.util.core.ResourceUtils;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.net.Urls;
import org.apache.brooklyn.util.text.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.platform.OCampEntityManagementUtils;
import kr.ac.hanyang.oCamp.camp.platform.OCampEntityManagementUtils.CreationResult;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.camp.spi.resolve.PdpProcessor;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;
import kr.ac.hanyang.oCamp.rest.api.PolicyManagerApi;

public class PolicyManagerResource extends AbstractBrooklynRestResource implements PolicyManagerApi{
	
	private static final Logger log = LoggerFactory.getLogger(PolicyManagerResource.class);
	
	public List<ApplicationSummary> listPolicyManagers(String typeRegex) {
        if (Strings.isBlank(typeRegex)) {
            typeRegex = ".*";
        }
        return FluentIterable
                .from(((BaseEntityManager)mgmt()).getPolicyManagers())
                .filter(EntitlementPredicates.isEntitled(mgmt().getEntitlementManager(), Entitlements.SEE_ENTITY))
                .filter(EntityPredicates.hasInterfaceMatching(typeRegex))
                .transform(ApplicationTransformer.fromApplication(ui.getBaseUriBuilder()))
                .toList();
    }
	
	@Override
    public Response createFromYaml(String yaml) {
        // First of all, see if it's a URL
        Preconditions.checkNotNull(yaml, "Blueprint must not be null");
        URI uri = null;
        try {
            String yamlUrl = yaml.trim();
            if (Urls.isUrlWithProtocol(yamlUrl)) {
                uri = new URI(yamlUrl);
            }
        } catch (URISyntaxException e) {
            // It's not a URI then...
            uri = null;
        }
        if (uri != null) {
            log.debug("Create app called with URI; retrieving contents: {}", uri);
            try {
                yaml = ResourceUtils.create(mgmt()).getResourceAsString(uri.toString());
            } catch (Exception e) {
                Exceptions.propagateIfFatal(e);
                throw new UserFacingException("Cannot resolve URL: "+uri, e);
            }
        }

        log.debug("Creating app from yaml:\n{}", yaml);
        oCampPlatform platform = ((BaseEntityManager)mgmt()).getParentPlatform();
        PdpProcessor pdpProcessor= platform.oCampPdp();
        DeploymentPlan pdp = pdpProcessor.parseDeploymentPlan(yaml);
		AssemblyTemplate at = pdpProcessor.registerDeploymentPlan(pdp);
        Application app = OCampEntityManagementUtils.instantiateApp(at, platform);
        CreationResult<Application,Void> result = OCampEntityManagementUtils.startup(app);
        
        
        URI ref = serviceAbsoluteUriBuilder(ui.getBaseUriBuilder(), ApplicationApi.class, "get").build(app.getApplicationId());
        ResponseBuilder response = created(ref);
        if (result.task() != null)
            response.entity(TaskTransformer.fromTask(ui.getBaseUriBuilder()).apply(result.task()));
        return response.build();
        
    }
	
	 @Context
	    private UriInfo uriInfo;

	    private EntityDetail fromEntity(Entity entity) {
	        Boolean serviceUp = entity.getAttribute(Attributes.SERVICE_UP);

	        Lifecycle serviceState = entity.getAttribute(Attributes.SERVICE_STATE_ACTUAL);

	        String iconUrl = entity.getIconUrl();
	        if (iconUrl!=null) {
	            if (brooklyn().isUrlServerSideAndSafe(iconUrl))
	                // route to server if it is a server-side url
	                iconUrl = EntityTransformer.entityUri(entity, ui.getBaseUriBuilder())+"/icon";
	        }

	        List<EntitySummary> children = Lists.newArrayList();
	        if (!entity.getChildren().isEmpty()) {
	            for (Entity child : entity.getChildren()) {
	                children.add(fromEntity(child));
	            }
	        }

	        String parentId = null;
	        if (entity.getParent()!= null) {
	            parentId = entity.getParent().getId();
	        }

	        List<String> groupIds = Lists.newArrayList();
	        if (!entity.groups().isEmpty()) {
	            groupIds.addAll(entitiesIdAsArray(entity.groups()));
	        }

	        List<Map<String, String>> members = Lists.newArrayList();
	        if (entity instanceof Group) {
	            // use attribute instead of method in case it is read-only
	            Collection<Entity> memberEntities = entity.getAttribute(AbstractGroup.GROUP_MEMBERS);
	            if (memberEntities != null && !memberEntities.isEmpty())
	                members.addAll(entitiesIdAndNameAsList(memberEntities));
	        }

	        return new EntityDetail(
	                entity.getApplicationId(),
	                entity.getId(),
	                parentId,
	                entity.getDisplayName(),
	                entity.getEntityType().getName(),
	                serviceUp,
	                serviceState,
	                iconUrl,
	                entity.getCatalogItemId(),
	                children,
	                groupIds,
	                members);
	    }

	    private List<Map<String, String>> entitiesIdAndNameAsList(Collection<? extends Entity> entities) {
	        List<Map<String, String>> members = Lists.newArrayList();
	        for (Entity entity : entities) {
	            if (Entitlements.isEntitled(mgmt().getEntitlementManager(), Entitlements.SEE_ENTITY, entity)) {
	                members.add(ImmutableMap.of("id", entity.getId(), "name", entity.getDisplayName()));
	            }
	        }
	        return members;
	    }

	    private List<String> entitiesIdAsArray(Iterable<? extends Entity> entities) {
	        List<String> ids = Lists.newArrayList();
	        for (Entity entity : entities) {
	            if (Entitlements.isEntitled(mgmt().getEntitlementManager(), Entitlements.SEE_ENTITY, entity)) {
	                ids.add(entity.getId());
	            }
	        }
	        return ids;
	    }
	
	
}
