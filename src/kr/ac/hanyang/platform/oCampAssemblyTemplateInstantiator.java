package kr.ac.hanyang.platform;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.api.objs.SpecParameter;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampReservedKeys;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynAssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate.Builder;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.collection.ResolvableLink;
import org.apache.brooklyn.core.mgmt.EntityManagementUtils;
import org.apache.brooklyn.core.mgmt.HasBrooklynManagementContext;
import org.apache.brooklyn.core.mgmt.EntityManagementUtils.CreationResult;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.entity.stock.BasicApplicationImpl;
import org.apache.brooklyn.util.collections.MutableSet;
import org.apache.brooklyn.util.core.flags.TypeCoercions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

public class oCampAssemblyTemplateInstantiator extends BrooklynAssemblyTemplateInstantiator {

	private static final Logger log = LoggerFactory.getLogger(BrooklynAssemblyTemplateInstantiator.class);

	public static final String NEVER_UNWRAP_APPS_PROPERTY = "wrappedApp"; 
	
	public Assembly instantiate(AssemblyTemplate template, CampPlatform platform) {
//			return super.instantiate(template, platform);
	        Application app = create(template, platform);
	        CreationResult<Application, Void> start = EntityManagementUtils.start(app);
	        log.debug("CAMP created "+app+"; starting in "+start.task());
	        return platform.assemblies().get(app.getApplicationId());
	    }

	    private Application create(AssemblyTemplate template, CampPlatform platform) {
	        ManagementContext mgmt = getManagementContext(platform);
	        BrooklynClassLoadingContext loader = JavaBrooklynClassLoadingContext.create(mgmt);
	        EntitySpec<? extends Application> spec = createApplicationSpec(template, platform, loader, MutableSet.<String>of());
	        Application instance = mgmt.getEntityManager().createEntity(spec);
	        log.info("CAMP created '{}'", instance);
	        return instance;
	    }

	    @Override
	    public List<EntitySpec<?>> createServiceSpecs(
	            AssemblyTemplate template,
	            CampPlatform platform, BrooklynClassLoadingContext itemLoader,
	            Set<String> encounteredRegisteredTypeIds) {
	        return buildTemplateServicesAsSpecs(itemLoader, template, platform, encounteredRegisteredTypeIds);
	    }
	    
	    
	    public List<EntitySpec<?>> createArtifactSpecs(
	            AssemblyTemplate template,
	            CampPlatform platform, BrooklynClassLoadingContext itemLoader,
	            Set<String> encounteredRegisteredTypeIds) {
	        return buildTemplateArtifactsAsSpecs(itemLoader, template, platform, encounteredRegisteredTypeIds);
	    }

	   
	    
	    @Override
	    public EntitySpec<? extends Application> createApplicationSpec(
	            AssemblyTemplate template,
	            CampPlatform platform,
	            BrooklynClassLoadingContext loader,
	            Set<String> encounteredTypeSymbolicNames) {
	        log.debug("CAMP creating application instance for {} ({})", template.getId(), template);

	        // AssemblyTemplates created via PDP, _specifying_ then entities to put in

	        EntitySpec<? extends Application> app = /*CampInternalUtils.*/createWrapperApp(template, loader);
	        app.configure(EntityManagementUtils.WRAPPER_APP_MARKER, Boolean.TRUE);

	        // first build the children into an empty shell app
	        List<EntitySpec<?>> childSpecs = createArtifactSpecs(template, platform, loader, encounteredTypeSymbolicNames);
	        for (EntitySpec<?> childSpec : childSpecs) {
	            // children get parsed and unwrapped irrespective of the NEVER_UNWRAP_APPS setting;
	            // we could support a NEVER_UNWRAP_NESTED_ENTITIES item but i don't know if there's a use case
	            app.child(EntityManagementUtils.unwrapEntity(childSpec));
	        }

	        if (allowedToUnwrap(template, app)) {
	            app = EntityManagementUtils.unwrapApplication(app);
	        }

	        return app;
	    }

	    private boolean allowedToUnwrap(AssemblyTemplate template, EntitySpec<? extends Application> app) {
	        return !(Boolean.TRUE.equals(TypeCoercions.coerce(template.getCustomAttributes().get(NEVER_UNWRAP_APPS_PROPERTY), Boolean.class)));
	    }
	    
	    private List<EntitySpec<?>> buildTemplateArtifactsAsSpecs(BrooklynClassLoadingContext loader, AssemblyTemplate template, CampPlatform platform, Set<String> encounteredRegisteredTypeIds) {
	        List<EntitySpec<?>> result = Lists.newArrayList();

	        //for (PlatformComponentTemplate pctl: (List)template.getPlatformComponentTemplates())
	        
	        for (ResolvableLink<PlatformComponentTemplate> ctl: template.getPlatformComponentTemplates().links()) {
	            //use link's get id to and its resource provider to get the item i.e. resolve()
	        	// the item will be the platform component template
	        	
	        	PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	            oCampComponentTemplateResolver entityResolver = oCampComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	            //get the type of the component
	            // if the component is an artifact then try to find the requirements
	            // then for each requirement find the service
	            // add the service as a child spec.
	            
	            
	            //appChildComponentTemplate.getType();
	            
	            
	            EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	            spec.children(buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds));
	            //System.out.println(spec.getType());
	            result.add(spec);
	        }
	        return result;
	    }
	    
	  //TODO need to complete this method
	    private List<EntitySpec<?>> buildTemplateSpecRec(BrooklynClassLoadingContext loader, oCampPlatformComponentTemplate pctl, Set<String> encounteredRegisteredTypeIds){
	    	List<EntitySpec<?>> result = Lists.newArrayList();
	    	for (ResolvableLink<PlatformComponentTemplate> ctl: pctl.getPlatformComponentTemplates().links()) {
	    		PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	    		oCampComponentTemplateResolver entityResolver = oCampComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	    		EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	    		spec.children(buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds));
	    		result.add(spec);
	    	}
	    	return result;
	    }

	    
	    private List<EntitySpec<?>> buildTemplateServicesAsSpecs(BrooklynClassLoadingContext loader, AssemblyTemplate template, CampPlatform platform, Set<String> encounteredRegisteredTypeIds) {
	        List<EntitySpec<?>> result = Lists.newArrayList();

	        for (ResolvableLink<PlatformComponentTemplate> ctl: template.getPlatformComponentTemplates().links()) {
	            PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	            oCampComponentTemplateResolver entityResolver = oCampComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	            EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	            result.add(spec);
	        }
	        return result;
	    }

	    private static ManagementContext getManagementContext(CampPlatform platform) {
	        return ((HasBrooklynManagementContext)platform).getBrooklynManagementContext();
	    } 
	    
	    // Extra helpers taken from CampInternalUtils
	    
	    private void resetSpecIfTemplateHasNoExplicitParameters(AssemblyTemplate template, EntitySpec<? extends Application> wrapperSpec) {
	        if (!template.getCustomAttributes().containsKey(BrooklynCampReservedKeys.BROOKLYN_PARAMETERS)) {
	            // Clear out default parameters (coming from the wrapper app's class) so they don't overwrite the entity's params on unwrap.
	            wrapperSpec.parameters(ImmutableList.<SpecParameter<?>>of());
	        }
	    }

	    
	    private static AssemblyTemplate buildWrapperAppTemplate(AssemblyTemplate template) {
	        Builder<? extends AssemblyTemplate> builder = AssemblyTemplate.builder();
	        builder.type("brooklyn:" + BasicApplicationImpl.class.getName());
	        builder.id(template.getId());
	        builder.name(template.getName());
	        builder.sourceCode(template.getSourceCode());
	        for (Entry<String, Object> entry : template.getCustomAttributes().entrySet()) {
	            builder.customAttribute(entry.getKey(), entry.getValue());
	        }
	        builder.instantiator(template.getInstantiator());
	        AssemblyTemplate wrapTemplate = builder.build();
	        return wrapTemplate;
	    }

	    private EntitySpec<? extends Application> createWrapperApp(AssemblyTemplate template, BrooklynClassLoadingContext loader) {
	        oCampComponentTemplateResolver resolver = oCampComponentTemplateResolver.Factory.newInstance(
 	            loader, buildWrapperAppTemplate(template));
	        EntitySpec<Application> wrapperSpec = resolver.resolveSpec(ImmutableSet.<String>of());
	        resetSpecIfTemplateHasNoExplicitParameters(template, wrapperSpec);
	        // caller always sets WRAPPER_APP config; should we do it here?
	        return wrapperSpec;
	    }
}
