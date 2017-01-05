package kr.ac.hanyang.oCamp.camp.platform;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.BasicCampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.dsl.BrooklynDslInterpreter;
import org.apache.brooklyn.camp.spi.ApplicationComponent;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponent;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import org.apache.brooklyn.camp.spi.PlatformTransaction;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.core.mgmt.HasBrooklynManagementContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import kr.ac.hanyang.oCamp.api.platform.OCampPlatform;
import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerTemplate;
import kr.ac.hanyang.oCamp.camp.spi.ServiceComponentTemplate;
import kr.ac.hanyang.oCamp.camp.spi.oCampAssemblyTemplate;
import kr.ac.hanyang.oCamp.camp.spi.resolve.PdpProcessor;
import kr.ac.hanyang.oCamp.camp.spi.resolve.oCampMatcher;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;


public class oCampPlatform extends BasicCampPlatform implements HasBrooklynManagementContext, OCampPlatform{
	
	private static final Logger log = LoggerFactory.getLogger(oCampPlatform.class);
    
	private PdpProcessor pdp;
	private final PlatformRootSummary root;
	private ManagementContext mgmt; 
	
	// need to add a resourcelookup for the policies
	BasicResourceLookup<PolicyManagerTemplate> policyManagerTemplates = new BasicResourceLookup<PolicyManagerTemplate>();
	
	//constructor
	public oCampPlatform(PlatformRootSummary root, ManagementContext mgmt) {
		this(root);
		oCampPlatformTransaction transaction = (oCampPlatformTransaction) transaction();
		this.mgmt = mgmt;
		((BaseEntityManager) mgmt).setParentPlatform(this);
		addMatchers();
		addInterpreters();
	}
	
	 public oCampPlatform(PlatformRootSummary root){  
		 super(root);
		 this.root = Preconditions.checkNotNull(root, "root");
	     pdp = new PdpProcessor(this);
	}
	
	@Override
	public ManagementContext getBrooklynManagementContext(){	
		return mgmt;
	}
	
	public PdpProcessor oCampPdp(){
		return this.pdp;
	}

	 protected void addMatchers() {
        pdp.addMatcher(new oCampMatcher(mgmt));
	 }
	    
    protected void addInterpreters() {
        pdp.addInterpreter(new BrooklynDslInterpreter());
    }
    
    public BasicResourceLookup<PolicyManagerTemplate> policyManagerTemplates(){
    	return policyManagerTemplates;
    }
 
    
    @Override
    public oCampPlatformTransaction transaction() {
        return new oCampPlatformTransaction(this);
    }
	
    public static class oCampPlatformTransaction extends PlatformTransaction {
        private final oCampPlatform platform;
        private final AtomicBoolean committed = new AtomicBoolean(false);
        
        public oCampPlatformTransaction(oCampPlatform platform) {
            this.platform = platform;
        }
        
        public PlatformComponentTemplate getPlatformComponentTemplate(String id){
        	for(Object obj: additions){
        		if(obj instanceof PlatformComponentTemplate){
        			if (((PlatformComponentTemplate)obj).getType().contains("services")) return (PlatformComponentTemplate)obj;
        		}
        	}
        	return null;
        }

        public PlatformTransaction add(PolicyManagerTemplate pmt) {
            additions.add(pmt);
            return this;
        }
        
        @Override
        public void commit() {
            if (committed.getAndSet(true)) 
                throw new IllegalStateException("transaction being committed multiple times");
            
            for (Object o: additions) {
                if (o instanceof oCampAssemblyTemplate) {
                    platform.assemblyTemplates().add((AssemblyTemplate) o);
                    continue;
                }
                if (o instanceof PlatformComponentTemplate) {
                    platform.platformComponentTemplates().add((PlatformComponentTemplate) o);
                    continue;
                }
                if (o instanceof ApplicationComponentTemplate) {
                    platform.applicationComponentTemplates().add((ApplicationComponentTemplate) o);
                    continue;
                }

                if (o instanceof PlatformComponent) {
                    platform.platformComponents().add((PlatformComponent) o);
                    continue;
                }
                if (o instanceof ApplicationComponent) {
                    platform.applicationComponents().add((ApplicationComponent) o);
                    continue;
                }
                if (o instanceof PolicyManagerTemplate) {
                    platform.policyManagerTemplates().add((PolicyManagerTemplate) o);
                    continue;
                }

                throw new UnsupportedOperationException("Object "+o+" of type "+o.getClass()+" cannot be added to "+platform);
            }
        }
        
        @Override
        protected void finalize() throws Throwable {
            if (!committed.get()) {
                // normal, in the case of errors (which might occur when catalog tries to figure out the right plan format); shouldn't happen otherwise
                // if we want log.warn visibility of these, then we will have to supply an abandon() method on this interface and ensure that is invoked on errors
                log.debug("transaction "+this+" was never applied");
            }
            super.finalize();
        }
    }

	
}
