package kr.ac.hanyang.oCamp.camp.spi.resolve;

import java.io.Reader;
import java.util.Map;

import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.instantiate.BasicAssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.util.collections.MutableMap;


import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;

public class PdpProcessor extends org.apache.brooklyn.camp.spi.resolve.PdpProcessor {
	
	final CampPlatform campPlatform;
	
	public PdpProcessor(CampPlatform campPlatform){
		super(campPlatform);
		this.campPlatform = campPlatform;
	}
	
	
	/** create and return an AssemblyTemplate based on the given DP (yaml) */
    @Override
	public AssemblyTemplate registerDeploymentPlan(Reader yaml) {
        DeploymentPlan plan = (DeploymentPlan) parseDeploymentPlan(yaml);
        return registerDeploymentPlan(plan);
    }
    
    /** applies matchers to the given deployment plan to create an assembly template */
    public AssemblyTemplate registerDeploymentPlan(DeploymentPlan plan) {
        AssemblyTemplateConstructor atc = new AssemblyTemplateConstructor(campPlatform);
        
        if (plan.getName()!=null) atc.name(plan.getName());
        if (plan.getDescription()!=null) atc.description(plan.getDescription());
        if (plan.getSourceCode()!=null) atc.sourceCode(plan.getSourceCode());
        // nothing done with origin just now...
        
        if (plan.getServices()!=null) {
            for (Service svc: plan.getServices()) {
                applyMatchers(svc, atc);
            }
        }

        if (plan.getArtifacts()!=null) {
            for (Artifact art: plan.getArtifacts()) {
                applyMatchers(art, atc);
            }
        }
        
        if (plan.getPolicies()!=null){
        	for (Policy pol: plan.getPolicies()) {
        		applyMatchers(pol, atc);
        	}
        }

        Map<String, Object> attrs = plan.getCustomAttributes();
        if (attrs!=null && !attrs.isEmpty()) {
            Map<String, Object> customAttrs = attrs;
            if (customAttrs.containsKey("id")) {
                // id shouldn't be leaking to entities, see InternalEntityFactory.createEntityAndDescendantsUninitialized.
                // If set it will go through to the spec because AbstractBrooklynObject has @SetFromFlag("id") on the id property.
                // Follows logic in BrooklynEntityMatcher.apply(...).
                customAttrs = MutableMap.copyOf(attrs);
                customAttrs.put("planId", customAttrs.remove("id"));
            }
            atc.addCustomAttributes(customAttrs);
        }
        
        if (atc.getInstantiator()==null)
            // set a default instantiator which just invokes the component's instantiators
            // (or throws unsupported exceptions, currently!)
            atc.instantiator(BasicAssemblyTemplateInstantiator.class);

        return atc.commit();
    }
	
}
