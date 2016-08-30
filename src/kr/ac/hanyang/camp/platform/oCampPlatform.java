package kr.ac.hanyang.camp.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.AggregatingCampPlatform;
import org.apache.brooklyn.camp.BasicCampPlatform;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynEntityMatcher;
import org.apache.brooklyn.camp.brooklyn.spi.dsl.BrooklynDslInterpreter;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import org.apache.brooklyn.core.mgmt.HasBrooklynManagementContext;

public class oCampPlatform extends AggregatingCampPlatform implements HasBrooklynManagementContext{
	
	private final ManagementContext mgmt; // need a management context. this is a brooklyn object that manages brooklyn components
    									  // the management context is created outside so we need a handle to it
	//constructor
	public oCampPlatform(PlatformRootSummary root, ManagementContext mgmt) {
		super(root);
		this.addPlatform(new BasicCampPlatform(root));
		this.mgmt = mgmt;
		pdp().addMatcher(new oCampMatcher(mgmt));
		pdp().addInterpreter(new BrooklynDslInterpreter()); // will have to fix this to a DSL that can interpret basic camp.
		// TODO Auto-generated constructor stub
	}
	@Override
	public ManagementContext getBrooklynManagementContext(){	
		return mgmt;
	}
	
	
	
	
}
