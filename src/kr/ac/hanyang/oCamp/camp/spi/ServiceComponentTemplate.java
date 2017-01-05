package kr.ac.hanyang.oCamp.camp.spi;

import org.apache.brooklyn.camp.spi.AbstractResource;

public class ServiceComponentTemplate extends AbstractResource {

	    public static final String CAMP_TYPE = "ServiceComponentTemplate";
	    static { assert CAMP_TYPE.equals(ServiceComponentTemplate.class.getSimpleName()); }
	    
	    /** Use {@link #builder()} to create */
	    protected ServiceComponentTemplate() {}

	    
	    // no fields beyond basic resource
	    
	    
	    // builder
	    
	    public static Builder<? extends ServiceComponentTemplate> builder() {
	        return new ServiceComponentTemplate().new Builder<ServiceComponentTemplate>(CAMP_TYPE);
	    }
	    
	    public class Builder<T extends ServiceComponentTemplate> extends AbstractResource.Builder<T,Builder<T>> {
	        
	        protected Builder(String type) { super(type); }
	        

	    }

}
