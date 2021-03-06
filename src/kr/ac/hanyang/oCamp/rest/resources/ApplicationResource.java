package kr.ac.hanyang.oCamp.rest.resources;

import static javax.ws.rs.core.Response.created;
import static org.apache.brooklyn.rest.util.WebResourceUtils.serviceAbsoluteUriBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.core.entity.EntityPredicates;
import org.apache.brooklyn.core.mgmt.entitlement.EntitlementPredicates;
import org.apache.brooklyn.core.mgmt.entitlement.Entitlements;
import org.apache.brooklyn.rest.api.ApplicationApi;
import org.apache.brooklyn.rest.domain.ApplicationSummary;
import org.apache.brooklyn.rest.transform.ApplicationTransformer;
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

import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.platform.OCampEntityManagementUtils;
import kr.ac.hanyang.oCamp.camp.platform.OCampEntityManagementUtils.CreationResult;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.camp.spi.resolve.PdpProcessor;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;

public class ApplicationResource extends org.apache.brooklyn.rest.resources.ApplicationResource {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationResource.class);
	
	
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
}
