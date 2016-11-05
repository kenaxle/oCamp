package kr.ac.hanyang.oCamp.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.brooklyn.rest.domain.ApplicationSummary;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ApplicationApi extends org.apache.brooklyn.rest.api.ApplicationApi {
	
	@GET
	@Path("/policymanagers")
    @ApiOperation(
            value = "Fetch list of policy managers, as ApplicationSummary objects",
            response = org.apache.brooklyn.rest.domain.ApplicationSummary.class
    )
    public List<ApplicationSummary> listPolicyManagers(
            @ApiParam(value = "Regular expression to filter by", required = false)
            @DefaultValue(".*")
            @QueryParam("typeRegex") String typeRegex);

	
	@POST
    @Consumes({"application/x-yaml",
            // see http://stackoverflow.com/questions/332129/yaml-mime-type
            "text/yaml", "text/x-yaml", "application/yaml"})
    @ApiOperation(
            value = "Create and start a new application from YAML",
            response = org.apache.brooklyn.rest.domain.TaskSummary.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Undefined entity or location"),
            @ApiResponse(code = 412, message = "Application already registered")
    })
    public Response createFromYaml(
            @ApiParam(
                    name = "applicationSpec",
                    value = "App spec in CAMP YAML format",
                    required = true)
            String yaml);
	
}
