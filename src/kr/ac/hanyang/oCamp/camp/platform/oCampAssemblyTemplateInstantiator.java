package kr.ac.hanyang.oCamp.camp.platform;

import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import java.util.Set;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.Task;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.api.objs.SpecParameter;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampReservedKeys;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynAssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate.Builder;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.collection.ResolvableLink;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.mgmt.EntityManagementUtils;
import org.apache.brooklyn.core.mgmt.HasBrooklynManagementContext;
import org.apache.brooklyn.core.mgmt.EntityManagementUtils.CreationResult;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.entity.stock.BasicApplicationImpl;
import org.apache.brooklyn.util.collections.MutableList;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.collections.MutableSet;
import org.apache.brooklyn.util.core.flags.TypeCoercions;
import org.apache.brooklyn.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import kr.ac.hanyang.oCamp.core.traits.oCampStartable;
import kr.ac.hanyang.oCamp.entities.BasicOCampApplicationImpl;

public class oCampAssemblyTemplateInstantiator extends BrooklynAssemblyTemplateInstantiator {

	private static final Logger log = LoggerFactory.getLogger(BrooklynAssemblyTemplateInstantiator.class);

	public static final String NEVER_UNWRAP_APPS_PROPERTY = "wrappedApp"; 
	
	//private List<EntitySpec<?>> servicesList;// = Lists.newArrayList();
	private List<EntitySpec<?>> artifactList = Lists.newArrayList();
	
	public Assembly instantiate(AssemblyTemplate template, CampPlatform platform) {
//			return super.instantiate(template, platform);
	        Application app = create(template, platform);
	       //***************** 
	       // do not start the app. instead issue a manage command which will start the policy manager for all components of the application
	       
	       CreationResult<Application, Void> start = startup(app);
	       // log.debug("CAMP created "+app+"; starting in "+start.task());
	        return platform.assemblies().get(app.getApplicationId());
	    }
	
	 private <T extends Application> CreationResult<T,Void> startup(T app) {
	        Task<Void> task = Entities.invokeEffector(app, app, oCampStartable.STARTUP,
	            // locations already set in the entities themselves;
	            // TODO make it so that this arg does not have to be supplied to START !
	            MutableMap.of("locations", MutableList.of("AWS Tokyo (ap-northeast-1)"))
	            );
	        task.blockUntilEnded();
	        return CreationResult.of(app, task);
	    }
	 
	  public static class CreationResult<T,U> {
	        private final T thing;
	        @Nullable private final Task<U> task;
	        public CreationResult(T thing, Task<U> task) {
	            super();
	            this.thing = thing;
	            this.task = task;
	        }
	        
	        protected static <T,U> CreationResult<T,U> of(T thing, @Nullable Task<U> task) {
	            return new CreationResult<T,U>(thing, task);
	        }
	        
	        /** returns the thing/things created */
	        @Nullable public T get() { return thing; }
	        /** associated task, ie the one doing the creation/starting */
	        public Task<U> task() { return task; }
	        public CreationResult<T,U> blockUntilComplete(Duration timeout) { if (task!=null) task.blockUntilEnded(timeout); return this; }
	        public CreationResult<T,U> blockUntilComplete() { if (task!=null) task.blockUntilEnded(); return this; }
	    }

	    private Application create(AssemblyTemplate template, CampPlatform platform) {
	        ManagementContext mgmt = getManagementContext(platform);
	        BrooklynClassLoadingContext loader = JavaBrooklynClassLoadingContext.create(mgmt);
	        EntitySpec<? extends Application> spec = createApplicationSpec(template, platform, loader, MutableSet.<String>of());
	        Application instance = mgmt.getEntityManager().createEntity(spec);
//	        Application instance2 = mgmt.getEntityManager().createEntity(spec);
	        log.info("CAMP created '{}'", instance);
	        return instance;
	    }

//	    @Override
//	    public List<EntitySpec<?>> createServiceSpecs(
//	            AssemblyTemplate template,
//	            CampPlatform platform, BrooklynClassLoadingContext itemLoader,
//	            Set<String> encounteredRegisteredTypeIds) {
//	        return buildTemplateServicesAsSpecs(itemLoader, template, platform, encounteredRegisteredTypeIds);
//	    }
//	    
//	    
//	    public List<EntitySpec<?>> createArtifactSpecs(
//	            AssemblyTemplate template,
//	            CampPlatform platform, BrooklynClassLoadingContext itemLoader,
//	            Set<String> encounteredRegisteredTypeIds) {
//	        return buildTemplateArtifactsAsSpecs(itemLoader, template, platform, encounteredRegisteredTypeIds);
//	    }
	    
	    public List<EntitySpec<?>> createComponentSpecs(
	            AssemblyTemplate template,
	            CampPlatform platform, BrooklynClassLoadingContext itemLoader,
	            Set<String> encounteredRegisteredTypeIds) {
	        return buildTemplateArtifactsOrServiceAsSpecs(itemLoader, template, platform, encounteredRegisteredTypeIds);
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
	        
	        List<EntitySpec<?>> childSpecs = createComponentSpecs(template, platform, loader, encounteredTypeSymbolicNames);
	        
	        for (EntitySpec<?> childSpec : childSpecs) {
	            // children get parsed and unwrapped irrespective of the NEVER_UNWRAP_APPS setting;
	            // we could support a NEVER_UNWRAP_NESTED_ENTITIES item but i don't know if there's a use case
	            app.child(EntityManagementUtils.unwrapEntity(childSpec));
	        }
	        
	        
//	        if (allowedToUnwrap(template, app)) {
//	            app = EntityManagementUtils.unwrapApplication(app);
//	        }

	        return app;
	    }

	    private boolean allowedToUnwrap(AssemblyTemplate template, EntitySpec<? extends Application> app) {
	        return !(Boolean.TRUE.equals(TypeCoercions.coerce(template.getCustomAttributes().get(NEVER_UNWRAP_APPS_PROPERTY), Boolean.class)));
	    }
	    
//	    private List<EntitySpec<?>> buildTemplateArtifactsAsSpecs(BrooklynClassLoadingContext loader, AssemblyTemplate template, CampPlatform platform, Set<String> encounteredRegisteredTypeIds) {
//	        List<EntitySpec<?>> result = Lists.newArrayList();
//
//	        //for (PlatformComponentTemplate pctl: (List)template.getPlatformComponentTemplates())
//	        
//	        for (ResolvableLink<PlatformComponentTemplate> ctl: template.getPlatformComponentTemplates().links()) {
//	            //use link's get id to and its resource provider to get the item i.e. resolve()
//	        	// the item will be the platform component template
//	        	
//	        	PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
//	            BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
//	            //get the type of the component
//	            // if the component is an artifact then try to find the requirements
//	            // then for each requirement find the service
//	            // add the service as a child spec.
//	            
//	            
//	            //appChildComponentTemplate.getType();
//	            
//	            
//	            EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
//	            spec.children(buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds));
//	            //System.out.println(spec.getType());
//	            result.add(spec);
//	        }
//	        return result;
//	    }

	    
	    private List<EntitySpec<?>> buildTemplateArtifactsOrServiceAsSpecs(BrooklynClassLoadingContext loader, AssemblyTemplate template, CampPlatform platform, Set<String> encounteredRegisteredTypeIds) {
	        List<EntitySpec<?>> result = Lists.newArrayList();

	        //for (PlatformComponentTemplate pctl: (List)template.getPlatformComponentTemplates())
	        
	        for (ResolvableLink<PlatformComponentTemplate> ctl: template.getPlatformComponentTemplates().links()) {
	            //use link's get id to and its resource provider to get the item i.e. resolve()
	        	// the item will be the platform component template
	        	
	        	PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	            BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	            //get the type of the component
	            // if the component is an artifact then try to find the requirements
	            // then for each requirement find the service
	            // add the service as a child spec.
	            
	            
	            //appChildComponentTemplate.getType();
	            
	            if(appChildComponentTemplate.getCustomAttributes().containsKey("serviceID")){
	            	EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	            	spec.children(buildReqSpec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds));
	            	result.add(spec);
	            }else{
	            	//this is a policy we need to create and link
	            	
	            }
	            //System.out.println(spec.getType());
	            //result.add(spec);
	        }
	        return result;
	    }
	    
	    private List<EntitySpec<?>> buildReqSpec(BrooklynClassLoadingContext loader, oCampPlatformComponentTemplate pctl, Set<String> encounteredRegisteredTypeIds){
	    	List<EntitySpec<?>> result = Lists.newArrayList();
	    	for (ResolvableLink<PlatformComponentTemplate> ctl: pctl.getPlatformComponentTemplates().links()) {
	    		PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	    		//should not just launch new instance. need to determine if it was already built.
	    		BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	    		EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	    		//EntitySpec<?> childSpec = buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds);
	    		spec.child(buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds));
	    		result.add(spec);
	    	}
	    	return result;
	    }
	    
	  //TODO need to complete this method
	    private EntitySpec<?> buildTemplateSpecRec(BrooklynClassLoadingContext loader, oCampPlatformComponentTemplate pctl, Set<String> encounteredRegisteredTypeIds){
	    	//List<EntitySpec<?>> result = Lists.newArrayList();
	    	for (ResolvableLink<PlatformComponentTemplate> ctl: pctl.getPlatformComponentTemplates().links()) {
	    		PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
	    		//should not just launch new instance. need to determine if it was already built.
	    		BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
	    		EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
	    		EntitySpec<?> childSpec = buildTemplateSpecRec(loader, (oCampPlatformComponentTemplate)appChildComponentTemplate, encounteredRegisteredTypeIds);
	    		if (childSpec == null){
		    		//if (childSpec.getChildren().isEmpty()){
		    			//the this is an Artifact see if it exists before.
		    			for(EntitySpec<?> artSpec:artifactList){
		    				if(artSpec.getConfig().get(new BasicConfigKey<String>(String.class,"camp.template.id"))
		    						.equals(spec.getConfig().get(new BasicConfigKey<String>(String.class,"camp.template.id")))){
		    					//found the artifact in the list
		    					return artSpec;
		    				}
		    			}
		    			artifactList.add(spec);
		    			return spec;
		    		//}/*else{
			    		//spec.child(childSpec);
			    		
			    		//result.add(spec);
		    		//}//*/
	    		}
	    		return spec;
	    	}
	    	return null;//result;
	    }

	    
//	    private List<EntitySpec<?>> buildTemplateServicesAsSpecs(BrooklynClassLoadingContext loader, AssemblyTemplate template, CampPlatform platform, Set<String> encounteredRegisteredTypeIds) {
//	        List<EntitySpec<?>> result = Lists.newArrayList();
//
//	        for (ResolvableLink<PlatformComponentTemplate> ctl: template.getPlatformComponentTemplates().links()) {
//	            PlatformComponentTemplate appChildComponentTemplate = ctl.resolve();
//	            BrooklynComponentTemplateResolver entityResolver = BrooklynComponentTemplateResolver.Factory.newInstance(loader, appChildComponentTemplate);
//	            EntitySpec<?> spec = entityResolver.resolveSpec(encounteredRegisteredTypeIds);
//	            result.add(spec);
//	        }
//	        return result;
//	    }

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
	        builder.type("brooklyn:" + BasicOCampApplicationImpl.class.getName());  //FIXME leaving brooklyn tags for now 
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
	    
	    //I may not need this as this mainly adds brooklyn parameters and the name
	    //I will keep it for the time being
	    private EntitySpec<? extends Application> createWrapperApp(AssemblyTemplate template, BrooklynClassLoadingContext loader) {
	        BrooklynComponentTemplateResolver resolver = BrooklynComponentTemplateResolver.Factory.newInstance(
 	            loader, buildWrapperAppTemplate(template));
	        EntitySpec<Application> wrapperSpec = resolver.resolveSpec(ImmutableSet.<String>of());
	        resetSpecIfTemplateHasNoExplicitParameters(template, wrapperSpec); // may not need to reset since I will not have brooklyn.parameters
	        // caller always sets WRAPPER_APP config; should we do it here?
	        return wrapperSpec;
	    }
}
