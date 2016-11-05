package kr.ac.hanyang.oCamp.camp.spi.resolve;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.instantiate.BasicAssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.camp.spi.resolve.PdpMatcher;
import org.apache.brooklyn.camp.spi.resolve.PlanInterpreter;
import org.apache.brooklyn.camp.spi.resolve.interpret.PlanInterpretationContext;
import org.apache.brooklyn.camp.spi.resolve.interpret.PlanInterpretationNode;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.exceptions.UserFacingException;
import org.apache.brooklyn.util.stream.Streams;
import org.apache.brooklyn.util.yaml.Yamls;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.yaml.snakeyaml.error.YAMLException;

import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;

import groovy.util.logging.Log;
import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.DeploymentPlan;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.pdp.PolicyConstraint;
import kr.ac.hanyang.oCamp.camp.pdp.oCampAssemblyTemplateConstructor;
import kr.ac.hanyang.oCamp.camp.pdp.oCampPMTemplateConstructor;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import org.apache.brooklyn.core.location.BasicLocationDefinition;


public class PdpProcessor{
	
	final oCampPlatform campPlatform;
	final List<oCampMatcher> matchers = new ArrayList<oCampMatcher>();
    final List<PlanInterpreter> interpreters = new ArrayList<PlanInterpreter>();
	
	
    public PdpProcessor(oCampPlatform campPlatform){
		this.campPlatform = campPlatform;
	}
	
    
    public DeploymentPlan parseDeploymentPlan(Reader yaml) {
        return parseDeploymentPlan(Streams.readFully(yaml));
    }
    
    @SuppressWarnings("unchecked")
    public DeploymentPlan parseDeploymentPlan(String yaml) {
        Iterable<Object> template = Yamls.parseAll(yaml);
        
        Map<String, Object> dpRootUninterpreted = null;
        try {
            dpRootUninterpreted = Yamls.getAs(template, Map.class);
        } catch (Exception e) {
            Exceptions.propagateIfFatal(e);
            throw new YAMLException("Plan not in acceptable format: "+(e.getMessage()!=null ? e.getMessage() : ""+e), e);
        }
        //add the base policy manager here 
        if (!(dpRootUninterpreted.containsKey("type")&& dpRootUninterpreted.containsKey("actiongroups")))
        	configureBasePolicy(dpRootUninterpreted);
        
        Map<String, Object> dpRootInterpreted = applyInterpreters(dpRootUninterpreted);
       
        return DeploymentPlan.of(dpRootInterpreted, yaml);
    }
    
    
    private void configureBasePolicy(Map<String, Object> dpRoot){
		List services = ((List) dpRoot.get("services"));
		List policies = ((List) dpRoot.get("policies"));
		if (policies == null) policies = new ArrayList<Map<String,Object>>();
		Map<String, Object> basePolicy = Yamls.getAs(((List)Yamls.parseAll(kr.ac.hanyang.oCamp.entities.policies.objs.Policy.BASE_PLACEMENT_POLICY)).get(0),Map.class);
		for(Object service: services){
			boolean managed = false;
			String serviceName = (String)((Map<String, Object>) service).get("id");
			for (Object policy: policies){
				List targets = (List) ((Map<String, Object>) policy).get("targets");
				if (targets.contains(serviceName) && isPlacement(policy)) managed = true;
			}
			if(! managed){
				((List) basePolicy.get("targets")).add(serviceName);
			}

		}
		if (!((List) basePolicy.get("targets")).isEmpty()){
			List<String> locations =  new ArrayList<String>();
			for(Object locationDef : campPlatform.getBrooklynManagementContext().getLocationRegistry().getDefinedLocations().values()){
				String locationName = ((BasicLocationDefinition) locationDef).getName();
				locations.add(locationName);
			}
			for (Object constraint: (List)basePolicy.get("constraints")){
				Map<String, Object> constMap = (Map<String,Object>) constraint;
				if (constMap.get("property").equals("PROVISIONING_LOCATION"))
					constMap.put("value", locations);
			}
			
			//basePolicy.put("targets", locations);
			policies.add(basePolicy);
			dpRoot.put("policies", policies);
			//dpRoot.
			//List locations = (List);
			//configure the locations
			//then return 
			//System.out.println("");
		}
    }
    
    private boolean isPlacement(Object policy){
    	for (Object constraint: (List)((Map<String, Object>) policy).get("constraints")){
    		Map<String, Object> constMap = (Map<String,Object>) constraint;
			if (constMap.get("property").equals("PROVISIONING_LOCATION"))
				return true;
    	}
    	return false;
    }
    
    /** create and return an AssemblyTemplate based on the given DP (yaml) */
	public AssemblyTemplate registerDeploymentPlan(Reader yaml) {
        DeploymentPlan plan = parseDeploymentPlan(yaml);
        return registerDeploymentPlan(plan);
    }
    
    /** applies matchers to the given deployment plan to create an assembly template */
    public AssemblyTemplate registerDeploymentPlan(DeploymentPlan plan) {
    	AssemblyTemplateConstructor atc;
    	if(plan.getType() != null){
    		atc = new oCampPMTemplateConstructor(campPlatform);
    	}else{
    		atc = new oCampAssemblyTemplateConstructor(campPlatform);
    	}
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
        
        if (plan.getActionGroups()!=null){
        	for (ActionGroup actionGroup: plan.getActionGroups()) {
        		applyMatchers(actionGroup, atc);
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
    
    public AssemblyTemplate registerPdpFromArchive(InputStream archiveInput) {
        try {
            ArchiveInputStream input = new ArchiveStreamFactory()
                .createArchiveInputStream(archiveInput);
            
            while (true) {
                ArchiveEntry entry = input.getNextEntry();
                if (entry==null) break;
                // TODO unpack entry, create a space on disk holding the archive ?
            }

            // use yaml...
            throw new UnsupportedOperationException("in progress");
            
        } catch (Exception e) {
            throw Exceptions.propagate(e);
        }
    }


    // ----------------------------
    
    public void addMatcher(oCampMatcher m) {
        // TODO a list is a crude way to do matching ... but good enough to start
        matchers.add(m);
    }

    public List<oCampMatcher> getMatchers() {
        return matchers;
    }


    protected void applyMatchers(Object deploymentPlanItem, AssemblyTemplateConstructor atc) {
        for (PdpMatcher matcher: getMatchers()) {
            if (matcher.accepts(deploymentPlanItem)) {
                // TODO first accepting is a crude way to do matching ... but good enough to start
                if (matcher.apply(deploymentPlanItem, atc))
                    return;
            }
        }
        throw new UserFacingException("Unable to match plan item: "+deploymentPlanItem);
    }

    // ----------------------------

    public void addInterpreter(PlanInterpreter interpreter) {
        interpreters.add(interpreter);
    }
    
    /** returns a DeploymentPlan object which is the result of running the interpretation
     * (with all interpreters) against the supplied deployment plan YAML object,
     * essentially a post-parse processing step before matching */
    @SuppressWarnings("unchecked")
    @VisibleForTesting
    public Map<String, Object> applyInterpreters(Map<String, ?> originalDeploymentPlan) {
        PlanInterpretationNode interpretation = new PlanInterpretationNode(
                new PlanInterpretationContext(originalDeploymentPlan, interpreters));
        return (Map<String, Object>) interpretation.getNewValue();
    }
    
}

