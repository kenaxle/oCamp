package kr.ac.hanyang.camp.platform;

import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup.EmptyResourceLookup;

public class oCampPlatformComponentTemplate extends PlatformComponentTemplate {
	ResourceLookup<PlatformComponentTemplate> platformComponentTemplates;
	
	public ResourceLookup<PlatformComponentTemplate> getPlatformComponentTemplates(){
		return platformComponentTemplates != null ? platformComponentTemplates : new EmptyResourceLookup<PlatformComponentTemplate>();
	}
	

	private void setPlatformComponentTemplates(ResourceLookup<PlatformComponentTemplate> platformComponentTemplates) {
        this.platformComponentTemplates = platformComponentTemplates;
    }
	
	public static Builder<? extends oCampPlatformComponentTemplate> builder(){
		return new oCampPlatformComponentTemplate().new Builder<oCampPlatformComponentTemplate>(CAMP_TYPE);
	}
	
	public class Builder<T extends oCampPlatformComponentTemplate> extends PlatformComponentTemplate.Builder<T> {
		
		protected Builder(String type) { super(type); }
		
		
		public oCampPlatformComponentTemplate.Builder<T> platformComponentTemplates(ResourceLookup<PlatformComponentTemplate> x) { 
			oCampPlatformComponentTemplate.this.setPlatformComponentTemplates(x); 
			return (Builder<T>) thisBuilder(); 
		}
        
        public synchronized oCampPlatformComponentTemplate.Builder<T> add(PlatformComponentTemplate x) {
            if (oCampPlatformComponentTemplate.this.platformComponentTemplates==null) {
               oCampPlatformComponentTemplate.this.platformComponentTemplates = new BasicResourceLookup<PlatformComponentTemplate>();
            }
            if (!(oCampPlatformComponentTemplate.this.platformComponentTemplates instanceof BasicResourceLookup)) {
                throw new IllegalStateException("Cannot add to resource lookup "+oCampPlatformComponentTemplate.this.platformComponentTemplates);
            }
            ((BasicResourceLookup<PlatformComponentTemplate>)oCampPlatformComponentTemplate.this.platformComponentTemplates).add(x);
            return (Builder<T>) thisBuilder();
        }
		
		
		
	}
	
}
