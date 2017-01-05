package kr.ac.hanyang.oCamp.api.platform;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.camp.BasicCampPlatform.BasicPlatformTransaction;
import org.apache.brooklyn.camp.brooklyn.spi.dsl.BrooklynDslInterpreter;
import org.apache.brooklyn.camp.spi.ApplicationComponent;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponent;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.PlatformTransaction;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;

import kr.ac.hanyang.oCamp.camp.spi.PolicyManagerTemplate;
import kr.ac.hanyang.oCamp.camp.spi.resolve.PdpProcessor;
import kr.ac.hanyang.oCamp.camp.spi.resolve.oCampMatcher;

public interface OCampPlatform {
	public BasicResourceLookup<PlatformComponentTemplate> platformComponentTemplates();


    public BasicResourceLookup<ApplicationComponentTemplate> applicationComponentTemplates();

    public BasicResourceLookup<AssemblyTemplate> assemblyTemplates();
    
    public BasicResourceLookup<PlatformComponent> platformComponents();

  
    public BasicResourceLookup<ApplicationComponent> applicationComponents();

    public BasicResourceLookup<Assembly> assemblies();
    
    
    public PlatformTransaction transaction();
    
	public ManagementContext getBrooklynManagementContext();
	
	public PdpProcessor oCampPdp();
    
    public BasicResourceLookup<PolicyManagerTemplate> policyManagerTemplates();
    
}
