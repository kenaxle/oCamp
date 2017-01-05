/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kr.ac.hanyang.oCamp.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.brooklyn.rest.domain.ApplicationSummary;

@Path("/policymanagers")
@Api("Policy Managers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PolicyManagerApi{

	@GET
	@Path("/fetch")
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
