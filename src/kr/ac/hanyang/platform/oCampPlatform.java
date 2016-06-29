package kr.ac.hanyang.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.AggregatingCampPlatform;
import org.apache.brooklyn.camp.BasicCampPlatform;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynEntityMatcher;
import org.apache.brooklyn.camp.brooklyn.spi.dsl.BrooklynDslInterpreter;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;

public class oCampPlatform extends AggregatingCampPlatform{
	
	private final ManagementContext mgmt; // need a management context. this is a brooklyn object so I will have to understand it
    									  // the management context is created outside so we need a handle to it
	//constructor
	public oCampPlatform(PlatformRootSummary root, ManagementContext mgmt) {
		super(root);
		this.addPlatform(new BasicCampPlatform(root));
		this.mgmt = mgmt;
		pdp().addMatcher(new BrooklynEntityMatcher(mgmt));
		pdp().addInterpreter(new BrooklynDslInterpreter()); // will have to fix this to a DSL that can interpret basic camp.
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
