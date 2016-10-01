package kr.ac.hanyang.oCamp.rest;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import kr.ac.hanyang.oCamp.rest.api.OCampRestApi;

public class OCampRestApp {
	 private Set<Object> singletons;

	    public OCampRestApp() {
	        singletons = Sets.newHashSet(OCampRestApi.getAllResources());
	    }

	    public OCampRestApp singleton(Object singleton) {
	        singletons.add(singleton);
	        return this;
	    }

	    public Set<Object> getSingletons() {
	        return singletons;
	    }

	    //Uncomment after removing jersey dependencies
	    //@Override
	    public Map<String, Object> getProperties() {
	        return ImmutableMap.<String, Object>of(
	                // Makes sure that all exceptions are handled by our custom DefaultExceptionMapper
	                "default.wae.mapper.least.specific", Boolean.TRUE);
	    }

}
