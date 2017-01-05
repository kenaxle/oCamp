package kr.ac.hanyang.oCamp.camp.spi;

import org.apache.brooklyn.camp.spi.AbstractResource;
import org.apache.brooklyn.camp.spi.ApplicationComponent;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup.EmptyResourceLookup;

/** Holds the metadata (name, description, etc) for a PCT
	 * as well as fields pointing to behaviour (eg creation of ServiceComponent).
	 * <p>
	 * See {@link AbstractResource} for more general information.
	 */
	public class ServiceComponent extends AbstractResource {

	    public static final String CAMP_TYPE = "ServiceComponent";
	    static { assert CAMP_TYPE.equals(ServiceComponent.class.getSimpleName()); }
	    
	    /** Use {@link #builder()} to create */
	    protected ServiceComponent() {}

	    ResourceLookup<ApplicationComponent> applicationComponents;
	    ResourceLookup<ServiceComponent> ServiceComponents;
	    String externalManagementUri;
	    
	    public ResourceLookup<ApplicationComponent> getApplicationComponents() {
	        return applicationComponents != null ? applicationComponents : new EmptyResourceLookup<ApplicationComponent>();
	    }
	    public ResourceLookup<ServiceComponent> getServiceComponents() {
	        return ServiceComponents != null ? ServiceComponents : new EmptyResourceLookup<ServiceComponent>();
	    }

	    private void setApplicationComponents(ResourceLookup<ApplicationComponent> applicationComponents) {
	        this.applicationComponents = applicationComponents;
	    }
	    private void setServiceComponents(ResourceLookup<ServiceComponent> ServiceComponents) {
	        this.ServiceComponents = ServiceComponents;
	    }
	    
	    public String getExternalManagementUri() {
	        return externalManagementUri;
	    }
	    private void setExternalManagementUri(String externalManagementUri) {
	        this.externalManagementUri = externalManagementUri;
	    }
	    
	    // builder
	    
	    public static Builder<? extends ServiceComponent> builder() {
	        return new ServiceComponent().new Builder<ServiceComponent>(CAMP_TYPE);
	    }
	    
	    public class Builder<T extends ServiceComponent> extends AbstractResource.Builder<T,Builder<T>> {
	        
	        protected Builder(String type) { super(type); }
	        
	        public Builder<T> externalManagementUri(String x) { ServiceComponent.this.setExternalManagementUri(x); return thisBuilder(); }
	        public Builder<T> applicationComponentTemplates(ResourceLookup<ApplicationComponent> x) { ServiceComponent.this.setApplicationComponents(x); return thisBuilder(); }
	        public Builder<T> ServiceComponentTemplates(ResourceLookup<ServiceComponent> x) { ServiceComponent.this.setServiceComponents(x); return thisBuilder(); }
	        
	        public synchronized Builder<T> add(ApplicationComponent x) {
	            if (ServiceComponent.this.applicationComponents==null) {
	                ServiceComponent.this.applicationComponents = new BasicResourceLookup<ApplicationComponent>();
	            }
	            if (!(ServiceComponent.this.applicationComponents instanceof BasicResourceLookup)) {
	                throw new IllegalStateException("Cannot add to resource lookup "+ServiceComponent.this.applicationComponents);
	            }
	            ((BasicResourceLookup<ApplicationComponent>)ServiceComponent.this.applicationComponents).add(x);
	            return thisBuilder();
	        }
	        
	        public synchronized Builder<T> add(ServiceComponent x) {
	            if (ServiceComponent.this.ServiceComponents==null) {
	                ServiceComponent.this.ServiceComponents = new BasicResourceLookup<ServiceComponent>();
	            }
	            if (!(ServiceComponent.this.ServiceComponents instanceof BasicResourceLookup)) {
	                throw new IllegalStateException("Cannot add to resource lookup "+ServiceComponent.this.ServiceComponents);
	            }
	            ((BasicResourceLookup<ServiceComponent>)ServiceComponent.this.ServiceComponents).add(x);
	            return thisBuilder();
	        }
	    }

}
