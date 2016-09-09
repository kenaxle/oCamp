package kr.ac.hanyang.oCamp.camp.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.AggregatingCampPlatform;
import org.apache.brooklyn.camp.BasicCampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.dsl.BrooklynDslInterpreter;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.core.mgmt.HasBrooklynManagementContext;

import com.google.common.base.Preconditions;

import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerComponent;
import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerComponentTemplate;
import kr.ac.hanyang.oCamp.camp.spi.resolve.PdpProcessor;
import kr.ac.hanyang.oCamp.camp.spi.resolve.oCampMatcher;

public class oCampPlatform extends BasicCampPlatform implements HasBrooklynManagementContext{
	
	BasicResourceLookup<PolicyManagerComponentTemplate> policyManagerComponentTemplates = new BasicResourceLookup<PolicyManagerComponentTemplate>();
    BasicResourceLookup<PolicyManagerComponent> policyManagerComponents = new BasicResourceLookup<PolicyManagerComponent>();
    
    public BasicResourceLookup<PolicyManagerComponentTemplate> policyManagerComponentTemplates() {
        return policyManagerComponentTemplates;
    }
	
    public BasicResourceLookup<PolicyManagerComponent> policyManagerComponent() {
        return policyManagerComponents;
    }
    
	private PdpProcessor pdp;
	private final PlatformRootSummary root;
	private ManagementContext mgmt; // need a management context. this is a brooklyn object that manages brooklyn components
    									  // the management context is created outside so we need a handle to it
	// need to add a resourcelookup for the policies
	//constructor
	public oCampPlatform(PlatformRootSummary root, ManagementContext mgmt) {
		this(root);
		//this.addPlatform(new BasicCampPlatform(root));
		this.mgmt = mgmt;
		addMatchers();
		addInterpreters();
		//pdp().addMatcher(new oCampMatcher(mgmt));
		//pdp().addInterpreter(new BrooklynDslInterpreter()); // will have to fix this to a DSL that can interpret basic camp.
		// TODO Auto-generated constructor stub
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
	
	
}
