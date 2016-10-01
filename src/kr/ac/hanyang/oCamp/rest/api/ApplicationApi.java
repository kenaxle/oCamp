package kr.ac.hanyang.oCamp.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ApplicationApi extends org.apache.brooklyn.rest.api.ApplicationApi {
	
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
