package kr.ac.hanyang.oCamp.camp.spi;

import org.apache.brooklyn.camp.spi.AbstractResource;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup.EmptyResourceLookup;
import org.apache.brooklyn.camp.spi.instantiate.AssemblyTemplateInstantiator;

import com.google.common.base.Preconditions;

public class oCampAssemblyTemplate extends AssemblyTemplate {
	/** Holds the metadata (name, description, etc) for a PCT
	 * as well as fields pointing to behaviour (eg creation of PlatformComponent).
	 * <p>
	 * See {@link AbstractResource} for more general information.
	 */

		public static final String CAMP_TYPE = "oCampAssemblyTemplate";
	    static { assert CAMP_TYPE.equals(PolicyManagerTemplate.class.getSimpleName()); }
	    
	    Class<? extends AssemblyTemplateInstantiator> instantiator;
	    ResourceLookup<ApplicationComponentTemplate> applicationComponentTemplates;
	    ResourceLookup<PlatformComponentTemplate> platformComponentTemplates;
	    
	    // TODO
//	    "parameterDefinitionUri": URI,
//	    "pdpUri" : URI ?
	                    
	    /** Use {@link #builder()} to create */
	    protected oCampAssemblyTemplate() {}

	    public Class<? extends AssemblyTemplateInstantiator> getInstantiator() {
	        return instantiator;
	    }
	    public ResourceLookup<ApplicationComponentTemplate> getApplicationComponentTemplates() {
	        return applicationComponentTemplates != null ? applicationComponentTemplates : new EmptyResourceLookup<ApplicationComponentTemplate>();
	    }
	    public ResourceLookup<PlatformComponentTemplate> getPlatformComponentTemplates() {
	        return platformComponentTemplates != null ? platformComponentTemplates : new EmptyResourceLookup<PlatformComponentTemplate>();
	    }
	    
	    private void setInstantiator(Class<? extends AssemblyTemplateInstantiator> instantiator) {
	        this.instantiator = instantiator;
	    }
	    private void setApplicationComponentTemplates(ResourceLookup<ApplicationComponentTemplate> applicationComponentTemplates) {
	        this.applicationComponentTemplates = applicationComponentTemplates;
	    }
	    private void setPlatformComponentTemplates(ResourceLookup<PlatformComponentTemplate> platformComponentTemplates) {
	        this.platformComponentTemplates = platformComponentTemplates;
	    }
	    
	    // builder
	    public static Builder<? extends oCampAssemblyTemplate> templateBuilder() {
	        return new oCampAssemblyTemplate().new Builder<oCampAssemblyTemplate>(CAMP_TYPE);
	    }
	    
	    public class Builder<T extends oCampAssemblyTemplate> extends AbstractResource.Builder<T,Builder<T>> {
	        
	        protected Builder(String type) { super(type); }
	        
	        public Builder<T> instantiator(Class<? extends AssemblyTemplateInstantiator> x) { oCampAssemblyTemplate.this.setInstantiator(x); return thisBuilder(); }
	        public Builder<T> applicationComponentTemplates(ResourceLookup<ApplicationComponentTemplate> x) { oCampAssemblyTemplate.this.setApplicationComponentTemplates(x); return thisBuilder(); }
	        public Builder<T> platformComponentTemplates(ResourceLookup<PlatformComponentTemplate> x) { oCampAssemblyTemplate.this.setPlatformComponentTemplates(x); return thisBuilder(); }

	        /** allows callers to see the partially formed instance when needed, for example to query instantiators;
	         *  could be replaced by specific methods as and when that is preferred */
	        @SuppressWarnings("unchecked")
	        public T peek() { return (T) oCampAssemblyTemplate.this; }
	        
	        public synchronized Builder<T> add(ApplicationComponentTemplate x) {
	            if (oCampAssemblyTemplate.this.applicationComponentTemplates==null) {
	            	oCampAssemblyTemplate.this.applicationComponentTemplates = new BasicResourceLookup<ApplicationComponentTemplate>();
	            }
	            if (!(oCampAssemblyTemplate.this.applicationComponentTemplates instanceof BasicResourceLookup)) {
	                throw new IllegalStateException("Cannot add to resource lookup "+oCampAssemblyTemplate.this.applicationComponentTemplates);
	            }
	            ((BasicResourceLookup<ApplicationComponentTemplate>)oCampAssemblyTemplate.this.applicationComponentTemplates).add(x);
	            return thisBuilder();
	        }
	        
	        public synchronized Builder<T> add(PlatformComponentTemplate x) {
	            if (oCampAssemblyTemplate.this.platformComponentTemplates==null) {
	            	oCampAssemblyTemplate.this.platformComponentTemplates = new BasicResourceLookup<PlatformComponentTemplate>();
	            }
	            if (!(oCampAssemblyTemplate.this.platformComponentTemplates instanceof BasicResourceLookup)) {
	                throw new IllegalStateException("Cannot add to resource lookup "+oCampAssemblyTemplate.this.platformComponentTemplates);
	            }
	            ((BasicResourceLookup<PlatformComponentTemplate>)oCampAssemblyTemplate.this.platformComponentTemplates).add(x);
	            return thisBuilder();
	        }
	        
	        @Override
	        public synchronized T build() {
	            Preconditions.checkNotNull(oCampAssemblyTemplate.this.instantiator);
	            return super.build();
	        }
	    }

	}


