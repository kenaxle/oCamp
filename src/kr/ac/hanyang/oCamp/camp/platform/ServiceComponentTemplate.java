package kr.ac.hanyang.oCamp.camp.platform;

import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup.EmptyResourceLookup;

public class ServiceComponentTemplate extends PlatformComponentTemplate {
	ResourceLookup<PlatformComponentTemplate> platformComponentTemplates;
	
	public ResourceLookup<PlatformComponentTemplate> getPlatformComponentTemplates(){
		return platformComponentTemplates != null ? platformComponentTemplates : new EmptyResourceLookup<PlatformComponentTemplate>();
	}
	
	private void setPlatformComponentTemplates(ResourceLookup<PlatformComponentTemplate> platformComponentTemplates) {
        this.platformComponentTemplates = platformComponentTemplates;
    }
	
	// had to make the object mutable
	public synchronized void add(PlatformComponentTemplate x) {
        if (this.platformComponentTemplates==null) {
           this.platformComponentTemplates = new BasicResourceLookup<PlatformComponentTemplate>();
        }
        if (!(this.platformComponentTemplates instanceof BasicResourceLookup)) {
            throw new IllegalStateException("Cannot add to resource lookup "+this.platformComponentTemplates);
        }
        ((BasicResourceLookup<PlatformComponentTemplate>)this.platformComponentTemplates).add(x);
    }
	
	public static Builder<? extends ServiceComponentTemplate> builder(){
		return new ServiceComponentTemplate().new Builder<ServiceComponentTemplate>(CAMP_TYPE);
	}
	
	
	
	public class Builder<T extends ServiceComponentTemplate> extends PlatformComponentTemplate.Builder<T> {
		
		protected Builder(String type) { super(type); }
		
		
		public ServiceComponentTemplate.Builder<T> platformComponentTemplates(ResourceLookup<PlatformComponentTemplate> x) { 
			ServiceComponentTemplate.this.setPlatformComponentTemplates(x); 
			return (Builder<T>) thisBuilder(); 
		}
        
        public synchronized ServiceComponentTemplate.Builder<T> add(PlatformComponentTemplate x) {
            if (ServiceComponentTemplate.this.platformComponentTemplates==null) {
            	ServiceComponentTemplate.this.platformComponentTemplates = new BasicResourceLookup<PlatformComponentTemplate>();
            }
            if (!(ServiceComponentTemplate.this.platformComponentTemplates instanceof BasicResourceLookup)) {
                throw new IllegalStateException("Cannot add to resource lookup "+ServiceComponentTemplate.this.platformComponentTemplates);
            }
            ((BasicResourceLookup<PlatformComponentTemplate>)ServiceComponentTemplate.this.platformComponentTemplates).add(x);
            return (Builder<T>) thisBuilder();
        }
		
		
		
	}
	
}