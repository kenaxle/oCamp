package kr.ac.hanyang.oCamp.rest.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.rest.resources.AbstractBrooklynRestResource;
import org.apache.brooklyn.rest.resources.AccessResource;
import org.apache.brooklyn.rest.resources.ActivityResource;
import org.apache.brooklyn.rest.resources.ApidocResource;

import org.apache.brooklyn.rest.resources.CatalogResource;
import org.apache.brooklyn.rest.resources.EffectorResource;
import org.apache.brooklyn.rest.resources.EntityConfigResource;
import org.apache.brooklyn.rest.resources.EntityResource;
import org.apache.brooklyn.rest.resources.LocationResource;
import org.apache.brooklyn.rest.resources.PolicyConfigResource;
import org.apache.brooklyn.rest.resources.PolicyResource;
import org.apache.brooklyn.rest.resources.ScriptResource;
import org.apache.brooklyn.rest.resources.SensorResource;
import org.apache.brooklyn.rest.resources.ServerResource;
import org.apache.brooklyn.rest.resources.UsageResource;
import org.apache.brooklyn.rest.resources.VersionResource;
import org.apache.brooklyn.rest.util.DefaultExceptionMapper;
import org.apache.brooklyn.rest.util.FormMapProvider;
import org.apache.brooklyn.rest.util.json.BrooklynJacksonJsonProvider;

import com.google.common.collect.Iterables;

import io.swagger.jaxrs.listing.SwaggerSerializers;
import kr.ac.hanyang.oCamp.rest.resources.ApplicationResource;

public class OCampRestApi {
	
	 public static Iterable<AbstractBrooklynRestResource> getBrooklynRestResources() {
	        List<AbstractBrooklynRestResource> resources = new ArrayList<>();
	        resources.add(new LocationResource());
	        resources.add(new CatalogResource());
	        resources.add(new ApplicationResource());
	        resources.add(new EntityResource());
	        resources.add(new EntityConfigResource());
	        resources.add(new SensorResource());
	        resources.add(new EffectorResource());
	        resources.add(new PolicyResource());
	        resources.add(new PolicyConfigResource());
	        resources.add(new ActivityResource());
	        resources.add(new AccessResource());
	        resources.add(new ScriptResource());
	        resources.add(new ServerResource());
	        resources.add(new UsageResource());
	        resources.add(new VersionResource());
	        return resources;
	    }

	    public static Iterable<Object> getApidocResources() {
	        List<Object> resources = new ArrayList<Object>();
	        resources.add(new SwaggerSerializers());
	        resources.add(new ApidocResource());
	        return resources;
	    }

	    public static Iterable<Object> getMiscResources() {
	        List<Object> resources = new ArrayList<Object>();
	        resources.add(new DefaultExceptionMapper());
	        resources.add(new BrooklynJacksonJsonProvider());
	        resources.add(new FormMapProvider());
	        return resources;
	    }

	    public static Iterable<Object> getAllResources() {
	        return Iterables.concat(getBrooklynRestResources(), getApidocResources(), getMiscResources());
	    }
}
