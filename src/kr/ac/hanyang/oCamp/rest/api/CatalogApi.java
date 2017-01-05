package kr.ac.hanyang.oCamp.rest.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.apache.brooklyn.rest.domain.CatalogItemSummary;
import org.apache.brooklyn.rest.domain.EffectorSummary;
import org.apache.brooklyn.rest.domain.EntityConfigSummary;
import org.apache.brooklyn.rest.domain.SensorSummary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/catalog")
@Api("Catalog")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CatalogApi {


    @GET
    @Path("/entities")
    @ApiOperation(value = "List available entity types optionally matching a query", 
            response = CatalogItemSummary.class,
            responseContainer = "List")
    public List<CatalogEntitySummary> listEntities();


    @GET
    @Path("/entity/{symbolicName}")
    @ApiOperation(value = "Fetch a specific version of an entity's definition from the catalog", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public CatalogEntitySummary getEntity(
        @ApiParam(name = "symbolicName", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("symbolicName") String symbolicName);

    @GET
    @Path("/entity/{symbolicName}/config")
    @ApiOperation(value = "Fetch a list of sensors from a specific version of an entity's definition from the catalog", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<EntityConfigSummary> getEntityConfigs(
        @ApiParam(name = "symbolicName", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("symbolicName") String symbolicName);

    @GET
    @Path("/entity/{symbolicName}/sensors")
    @ApiOperation(value = "Fetch a list of sensors from a specific version of an entity's definition from the catalog", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<SensorSummary> getEntitySensors(
        @ApiParam(name = "symbolicName", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("symbolicName") String symbolicName);

    @GET
    @Path("/entity/{symbolicName}/effectors")
    @ApiOperation(value = "Fetch a list of sensors from a specific version of an entity's definition from the catalog", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<EffectorSummary> getEntityEffectors(
        @ApiParam(name = "symbolicName", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("symbolicName") String symbolicName);

    @GET
    @Path("/entities/config/{config}")
    @ApiOperation(value = "Fetch a list of entities that have the following sensors", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<CatalogEntitySummary> getEntitiesByConfig(
        @ApiParam(name = "config", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("config") String sensor);
    
    
    @GET
    @Path("/entities/sensor/{sensor}")
    @ApiOperation(value = "Fetch a list of entities that have the following sensors", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<CatalogEntitySummary> getEntitiesBySensor(
        @ApiParam(name = "sensor", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("sensor") String sensor);
   
    @GET
    @Path("/entities/effector/{effector}")
    @ApiOperation(value = "Fetch a list of entities that have the following sensors", 
            response = CatalogEntitySummary.class,
            responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Entity not found")
    })
    public List<CatalogEntitySummary> getEntitiesByEffector(
        @ApiParam(name = "effector", value = "The symbolic name of the entity or template to retrieve", required = true)
        @PathParam("effector") String effector);
    
    
}
