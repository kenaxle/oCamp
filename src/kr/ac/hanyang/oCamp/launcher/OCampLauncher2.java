/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kr.ac.hanyang.oCamp.launcher;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Closeable;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import javax.annotation.Nullable;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.location.Location;
import org.apache.brooklyn.api.location.PortRange;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.ha.HighAvailabilityManager;
import org.apache.brooklyn.api.mgmt.ha.HighAvailabilityMode;
import org.apache.brooklyn.api.mgmt.ha.ManagementNodeState;
import org.apache.brooklyn.api.mgmt.ha.ManagementPlaneSyncRecord;
import org.apache.brooklyn.api.mgmt.ha.ManagementPlaneSyncRecordPersister;
import org.apache.brooklyn.api.mgmt.rebind.PersistenceExceptionHandler;
import org.apache.brooklyn.api.mgmt.rebind.RebindManager;
import org.apache.brooklyn.api.mgmt.rebind.mementos.BrooklynMementoRawData;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.BrooklynCampPlatformLauncherNoServer;
import org.apache.brooklyn.camp.spi.PlatformRootSummary;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.catalog.internal.CatalogInitialization;
import org.apache.brooklyn.core.config.ConfigPredicates;
import org.apache.brooklyn.core.entity.Entities;
import org.apache.brooklyn.core.entity.StartableApplication;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.internal.BrooklynProperties;
import org.apache.brooklyn.core.location.PortRanges;
import org.apache.brooklyn.core.mgmt.EntityManagementUtils;
import org.apache.brooklyn.core.mgmt.ha.HighAvailabilityManagerImpl;
import org.apache.brooklyn.core.mgmt.ha.ManagementPlaneSyncRecordPersisterToObjectStore;
import org.apache.brooklyn.core.mgmt.internal.BrooklynShutdownHooks;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.mgmt.internal.ManagementContextInternal;
import org.apache.brooklyn.core.mgmt.persist.BrooklynMementoPersisterToObjectStore;
import org.apache.brooklyn.core.mgmt.persist.BrooklynPersistenceUtils;
import org.apache.brooklyn.core.mgmt.persist.PersistMode;
import org.apache.brooklyn.core.mgmt.persist.PersistenceObjectStore;
import org.apache.brooklyn.core.mgmt.rebind.PersistenceExceptionHandlerImpl;
import org.apache.brooklyn.core.mgmt.rebind.RebindManagerImpl;
import org.apache.brooklyn.core.mgmt.rebind.transformer.CompoundTransformer;
import org.apache.brooklyn.core.server.BrooklynServerConfig;
import org.apache.brooklyn.core.server.BrooklynServerPaths;
import org.apache.brooklyn.entity.brooklynnode.BrooklynNode;
import org.apache.brooklyn.entity.brooklynnode.LocalBrooklynNode;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.stock.BasicApplication;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.apache.brooklyn.launcher.BrooklynServerDetails;
import org.apache.brooklyn.launcher.BrooklynWebServer;
import org.apache.brooklyn.launcher.WebAppContextProvider;
import org.apache.brooklyn.launcher.common.BrooklynPropertiesFactoryHelper;
import org.apache.brooklyn.launcher.config.StopWhichAppsOnShutdown;
import org.apache.brooklyn.rest.BrooklynWebConfig;
import org.apache.brooklyn.rest.filter.BrooklynPropertiesSecurityFilter;
import org.apache.brooklyn.rest.security.provider.BrooklynUserWithRandomPasswordSecurityProvider;
import org.apache.brooklyn.rest.util.ShutdownHandler;
import org.apache.brooklyn.util.exceptions.Exceptions;
import org.apache.brooklyn.util.exceptions.FatalConfigurationRuntimeException;
import org.apache.brooklyn.util.exceptions.FatalRuntimeException;
import org.apache.brooklyn.util.exceptions.RuntimeInterruptedException;
import org.apache.brooklyn.util.net.Networking;
import org.apache.brooklyn.util.os.Os;
import org.apache.brooklyn.util.stream.Streams;
import org.apache.brooklyn.util.text.Strings;
import org.apache.brooklyn.util.time.Duration;
import org.apache.brooklyn.util.time.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.Beta;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatformLauncher;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;
import kr.ac.hanyang.oCamp.core.traits.oCampStartable;

/**
 * Example usage is:
 *  * <pre>
 * {@code
 * BasicLauncher launcher = BasicLauncher.newInstance()
 *     .application(new WebClusterDatabaseExample().appDisplayName("Web-cluster example"))
 *     .location("localhost")
 *     .start();
 * 
 * Entities.dumpInfo(launcher.getApplications());
 * </pre>

 * @param <T> */
public class OCampLauncher2<T> {

    private static final Logger LOG = LoggerFactory.getLogger(OCampLauncher2.class);

    private final Map<String,Object> brooklynAdditionalProperties = Maps.newLinkedHashMap();
    private BrooklynProperties brooklynProperties;
    private ManagementContext managementContext;
    
    private final List<String> locationSpecs = new ArrayList<String>();
    private final List<Location> locations = new ArrayList<Location>();

    private final List<Application> appsToManage = new ArrayList<Application>();
    @SuppressWarnings("deprecation") // TODO convert to EntitySpec; should be easy when users not allowed to pass in a builder
    private final List<org.apache.brooklyn.core.entity.factory.ApplicationBuilder> appBuildersToManage = new ArrayList<org.apache.brooklyn.core.entity.factory.ApplicationBuilder>();
    private final List<String> yamlAppsToManage = new ArrayList<String>();
    private final List<Application> apps = new ArrayList<Application>();
    
    private boolean startBrooklynNode = false;
    
    private boolean ignorePersistenceErrors = true;
    private boolean ignoreCatalogErrors = true;
    private boolean ignoreAppErrors = true;
    
    private CatalogInitialization catalogInitialization = null;
    
    private PersistMode persistMode = PersistMode.DISABLED;
    private HighAvailabilityMode highAvailabilityMode = HighAvailabilityMode.DISABLED;
    private String persistenceDir;
    private String persistenceLocation;
    private Duration persistPeriod = Duration.ONE_SECOND;
    // these default values come from config in HighAvailablilityManagerImpl
    private Duration haHeartbeatTimeoutOverride = null;
    private Duration haHeartbeatPeriodOverride = null;
    
    private boolean started;
    
    private BrooklynProperties.Factory.Builder brooklynPropertiesBuilder;

    private CampPlatform campPlatform;

    
 //---------------------------------------------------------------------------------
    
    private boolean startWebApps = true;
    private PortRange port = null;
    private Boolean useHttps = null;
    private InetAddress bindAddress = null;
    private InetAddress publicAddress = null;
    private List<WebAppContextProvider> webApps = new LinkedList<WebAppContextProvider>();
    private Map<String, ?> webconsoleFlags = Maps.newLinkedHashMap();
    private Boolean skipSecurityFilter = null;
    
    private boolean ignoreWebErrors = false;
    
    private StopWhichAppsOnShutdown stopWhichAppsOnShutdown = StopWhichAppsOnShutdown.THESE_IF_NOT_PERSISTED;
    private ShutdownHandler shutdownHandler;
    
    private Function<ManagementContext,Void> customizeManagement = null;
    
    private volatile OCampWebServer webServer;

    private String globalBrooklynPropertiesFile = Os.mergePaths(Os.home(), ".brooklyn", "brooklyn.properties");
    private String localBrooklynPropertiesFile;
    
  //--------------------------------------------------------------------------------- 
    
    public static OCampLauncher2 newInstance(){
    	return new OCampLauncher2();
    }
    
    public ManagementContext getManagementContext() {
        return managementContext;
    }

    public List<Application> getApplications() {
        if (!started) throw new IllegalStateException("Cannot retrieve application until started");
        return ImmutableList.copyOf(apps);
    }



    /**
     * Specifies that the launcher should build and manage the Brooklyn application
     * described by the given YAML blueprint.
     * The application will not be started as part of this call (callers can
     * subsequently call {@link #start()} or {@link #getApplications()}.
     *
     * @see #application(Application)
     */
    public T application(String yaml) {
        this.yamlAppsToManage.add(yaml);
        return self();
    }

    /**
     * Adds a location to be passed in on {@link #start()}, when that calls
     * {@code application.start(locations)}.
     */
    public T location(Location location) {
        locations.add(checkNotNull(location, "location"));
        return self();
    }

    /**
     * Give the spec of an application, to be created.
     * 
     * @see #location(Location)
     */
    public T location(String spec) {
        locationSpecs.add(checkNotNull(spec, "spec"));
        return self();
    }
    
    public T locations(List<String> specs) {
        locationSpecs.addAll(checkNotNull(specs, "specs"));
        return self();
    }

    public T persistenceLocation(@Nullable String persistenceLocationSpec) {
        persistenceLocation = persistenceLocationSpec;
        return self();
    }

    /** 
     * Specifies the management context this launcher should use. 
     * If not specified a new one is created automatically.
     */
    public T managementContext(ManagementContext context) {
        if (brooklynProperties != null) throw new IllegalStateException("Cannot set brooklynProperties and managementContext");
        this.managementContext = context;
        return self();
    }

    /**
     * Specifies the brooklyn properties to be used. 
     * Must not be set if managementContext is explicitly set.
     */
    public T brooklynProperties(BrooklynProperties brooklynProperties){
        if (managementContext != null) throw new IllegalStateException("Cannot set brooklynProperties and managementContext");
        if (this.brooklynProperties!=null && brooklynProperties!=null && this.brooklynProperties!=brooklynProperties)
            LOG.warn("Brooklyn properties being reset in "+self()+"; set null first if you wish to clear it", new Throwable("Source of brooklyn properties reset"));
        this.brooklynProperties = brooklynProperties;
        return self();
    }
    
    /**
     * Specifies a property to be added to the brooklyn properties
     */
    public T brooklynProperties(String field, Object value) {
        brooklynAdditionalProperties.put(checkNotNull(field, "field"), value);
        return self();
    }
    public <C> T brooklynProperties(ConfigKey<C> key, C value) {
        return brooklynProperties(key.getName(), value);
    }

    public T ignorePersistenceErrors(boolean ignorePersistenceErrors) {
        this.ignorePersistenceErrors = ignorePersistenceErrors;
        return self();
    }

    public T ignoreCatalogErrors(boolean ignoreCatalogErrors) {
        this.ignoreCatalogErrors = ignoreCatalogErrors;
        return self();
    }

    public T ignoreAppErrors(boolean ignoreAppErrors) {
        this.ignoreAppErrors = ignoreAppErrors;
        return self();
    }

    @Beta
    public T catalogInitialization(CatalogInitialization catInit) {
        if (this.catalogInitialization!=null)
            throw new IllegalStateException("Initial catalog customization already set.");
        this.catalogInitialization = catInit;
        return self();
    }

    public T persistMode(PersistMode persistMode) {
        this.persistMode = persistMode;
        return self();
    }

    public T highAvailabilityMode(HighAvailabilityMode highAvailabilityMode) {
        this.highAvailabilityMode = highAvailabilityMode;
        return self();
    }

    public T persistenceDir(@Nullable String persistenceDir) {
        this.persistenceDir = persistenceDir;
        return self();
    }

    public T persistenceDir(@Nullable File persistenceDir) {
        if (persistenceDir==null) return persistenceDir((String)null);
        return persistenceDir(persistenceDir.getAbsolutePath());
    }

    public T persistPeriod(Duration persistPeriod) {
        this.persistPeriod = persistPeriod;
        return self();
    }

    public T haHeartbeatTimeout(Duration val) {
        this.haHeartbeatTimeoutOverride = val;
        return self();
    }

    public T startBrooklynNode(boolean val) {
        this.startBrooklynNode = val;
        return self();
    }

    /**
     * Controls both the frequency of heartbeats, and the frequency of checking the health of other nodes.
     */
    public T haHeartbeatPeriod(Duration val) {
        this.haHeartbeatPeriodOverride = val;
        return self();
    }

    /**
     * @param destinationDir Directory for state to be copied to
     */
    public void copyPersistedState(String destinationDir) {
        copyPersistedState(destinationDir, null, null);
    }

    /**
     * @param destinationDir Directory for state to be copied to
     * @param destinationLocation Optional location if target for copied state is a blob store.
     */
    public void copyPersistedState(String destinationDir, @Nullable String destinationLocation) {
        copyPersistedState(destinationDir, destinationLocation, null);
    }

    /**
     * @param destinationDir Directory for state to be copied to
     * @param destinationLocationSpec Optional location if target for copied state is a blob store.
     * @param transformer Optional transformations to apply to retrieved state before it is copied.
     */
    public void copyPersistedState(String destinationDir, @Nullable String destinationLocationSpec, @Nullable CompoundTransformer transformer) {
        initManagementContext();
        try {
            highAvailabilityMode = HighAvailabilityMode.HOT_STANDBY;
            initPersistence();
        } catch (Exception e) {
            handleSubsystemStartupError(ignorePersistenceErrors, "persistence", e);
        }
        
        try {
            BrooklynMementoRawData memento = managementContext.getRebindManager().retrieveMementoRawData();
            if (transformer != null) memento = transformer.transform(memento);
            
            ManagementPlaneSyncRecord planeState = managementContext.getHighAvailabilityManager().loadManagementPlaneSyncRecord(true);
            
            LOG.info("Persisting state to "+destinationDir+(destinationLocationSpec!=null ? " @ "+destinationLocationSpec : ""));
            PersistenceObjectStore destinationObjectStore = BrooklynPersistenceUtils.newPersistenceObjectStore(
                managementContext, destinationLocationSpec, destinationDir);
            BrooklynPersistenceUtils.writeMemento(managementContext, memento, destinationObjectStore);
            BrooklynPersistenceUtils.writeManagerMemento(managementContext, planeState, destinationObjectStore);

        } catch (Exception e) {
            Exceptions.propagateIfFatal(e);
            LOG.debug("Error copying persisted state (rethrowing): " + e, e);
            throw new FatalRuntimeException("Error copying persisted state: " +
                Exceptions.collapseText(e), e);
        }
    }



    /**
     * Starts the web server (with web console) and Brooklyn applications, as per the specifications configured. 
     * @return An object containing details of the web server and the management context.
     */
    public T start() {
        if (started) throw new IllegalStateException("Cannot start() or launch() multiple times");
        started = true;

        initManagementContext();

        CatalogInitialization catInit = ((ManagementContextInternal)managementContext).getCatalogInitialization();

        markCatalogStartingUp(catInit);
        startingUp();
        initCamp();
        handlePersistence();
        populateCatalog(catInit);
        markCatalogStarted(catInit);
        addLocations();
        markStartupComplete();
        initApps();
        initBrooklynNode();

        persist();
        return self();
    }

    protected void persist() {
        if (persistMode != PersistMode.DISABLED) {
            // Make sure the new apps are persisted in case process exits immediately.
            managementContext.getRebindManager().forcePersistNow(false, null);
        }
    }

    protected void initBrooklynNode() {
        if (startBrooklynNode) {
            try {
                startBrooklynNode();
            } catch (Exception e) {
                handleSubsystemStartupError(ignoreAppErrors, "brooklyn node / self entity", e);
            }
        }
    }

    protected void initApps() {
        // TODO create apps only after becoming master, analogously to catalog initialization
        try {
            createApps();
            startApps();
        } catch (Exception e) {
            handleSubsystemStartupError(ignoreAppErrors, "brooklyn autostart apps", e);
        }
    }

    protected void markStartupComplete() {
        // Already rebinded successfully, so previous apps are now available.
        // Allow the startup to be visible in console for newly created apps.
        ((LocalManagementContext)managementContext).noteStartupComplete();
    }

    protected void addLocations() {
        // Create the locations. Must happen after persistence is started in case the
        // management context's catalog is loaded from persisted state. (Location
        // resolution uses the catalog's classpath to scan for resolvers.)
        locations.addAll(managementContext.getLocationRegistry().getListOfLocationsManaged(locationSpecs));
    }

//    protected void startingUp() {
//    }

    private void markCatalogStarted(CatalogInitialization catInit) {
        catInit.setStartingUp(false);
    }

    protected void populateCatalog(CatalogInitialization catInit) {
        try {
            // run cat init now if it hasn't yet been run; 
            // will also run if there was an ignored error in catalog above, allowing it to fail startup here if requested
            if (catInit!=null && !catInit.hasRunOfficialInitialization()) {
                if (persistMode==PersistMode.DISABLED) {
                    LOG.debug("Loading catalog as part of launch sequence (it was not loaded as part of any rebind sequence)");
                    catInit.populateCatalog(ManagementNodeState.MASTER, true, true, null);
                } else {
                    // should have loaded during rebind
                    ManagementNodeState state = managementContext.getHighAvailabilityManager().getNodeState();
                    LOG.warn("Loading catalog for "+state+" as part of launch sequence (it was not loaded as part of the rebind sequence)");
                    catInit.populateCatalog(state, true, true, null);
                }
            }
        } catch (Exception e) {
            handleSubsystemStartupError(ignoreCatalogErrors, "initial catalog", e);
        }
    }

    protected void handlePersistence() {
        try {
            initPersistence();
            startPersistence();
        } catch (Exception e) {
            handleSubsystemStartupError(ignorePersistenceErrors, "persistence", e);
        }
    }

    protected void initCamp() {
        // Add a CAMP platform
        campPlatform =	new oCampPlatformLauncher()
                //.useManagementContext(managementContext)
                .launch()
                .getCampPlatform();
        // TODO start CAMP rest _server_ in the below (at /camp) ?
    }

    protected void markCatalogStartingUp(CatalogInitialization catInit) {
        // Inform catalog initialization that it is starting up
        catInit.setStartingUp(true);
    }

    protected void initManagementContext() {
        // Create the management context
        brooklynPropertiesBuilder = new BrooklynPropertiesFactoryHelper(
        		globalBrooklynPropertiesFile,
        		localBrooklynPropertiesFile,
        		getBrooklynProperties())
        		.createPropertiesBuilder();
        
    	if (managementContext == null) {
            managementContext = new BaseEntityManager(
                    brooklynPropertiesBuilder,
                    brooklynAdditionalProperties);

            brooklynProperties = ((ManagementContextInternal)managementContext).getBrooklynProperties();
            
        } else if (brooklynProperties == null) {
            brooklynProperties = ((ManagementContextInternal)managementContext).getBrooklynProperties();
            brooklynProperties.addFromMap(brooklynAdditionalProperties);
        }
        
        if (catalogInitialization!=null) {
            ((ManagementContextInternal)managementContext).setCatalogInitialization(catalogInitialization);
        }
        
    }

    protected void handleSubsystemStartupError(boolean ignoreSuchErrors, String system, Exception e) {
        Exceptions.propagateIfFatal(e);
        if (ignoreSuchErrors) {
            LOG.error("Subsystem for "+system+" had startup error (continuing with startup): "+e, e);
            if (managementContext!=null)
                ((ManagementContextInternal)managementContext).errors().add(e);
        } else {
            throw Exceptions.propagate(e);
        }
    }

    protected void initPersistence() {
        // Prepare the rebind directory, and initialise the RebindManager as required
        final PersistenceObjectStore objectStore;
        if (persistMode == PersistMode.DISABLED) {
            LOG.info("Persistence disabled");
            objectStore = null;
            
        } else {
            try {
                if (persistenceLocation == null) {
                    persistenceLocation = brooklynProperties.getConfig(BrooklynServerConfig.PERSISTENCE_LOCATION_SPEC);
                }
                persistenceDir = BrooklynServerPaths.newMainPersistencePathResolver(brooklynProperties).location(persistenceLocation).dir(persistenceDir).resolve();
                objectStore = BrooklynPersistenceUtils.newPersistenceObjectStore(managementContext, persistenceLocation, persistenceDir, 
                    persistMode, highAvailabilityMode);
                    
                RebindManager rebindManager = managementContext.getRebindManager();
                
                BrooklynMementoPersisterToObjectStore persister = new BrooklynMementoPersisterToObjectStore(
                    objectStore,
                    ((ManagementContextInternal)managementContext).getBrooklynProperties(),
                    managementContext.getCatalogClassLoader());
                PersistenceExceptionHandler persistenceExceptionHandler = PersistenceExceptionHandlerImpl.builder().build();
                ((RebindManagerImpl) rebindManager).setPeriodicPersistPeriod(persistPeriod);
                rebindManager.setPersister(persister, persistenceExceptionHandler);
            } catch (FatalConfigurationRuntimeException e) {
                throw e;
            } catch (Exception e) {
                Exceptions.propagateIfFatal(e);
                LOG.debug("Error initializing persistence subsystem (rethrowing): "+e, e);
                throw new FatalRuntimeException("Error initializing persistence subsystem: "+
                    Exceptions.collapseText(e), e);
            }
        }
        
        // Initialise the HA manager as required
        if (highAvailabilityMode == HighAvailabilityMode.DISABLED) {
            LOG.info("High availability disabled");
        } else {
            if (objectStore==null)
                throw new FatalConfigurationRuntimeException("Cannot run in HA mode when no persistence configured.");

            HighAvailabilityManager haManager = managementContext.getHighAvailabilityManager();
            ManagementPlaneSyncRecordPersister persister =
                new ManagementPlaneSyncRecordPersisterToObjectStore(managementContext,
                    objectStore,
                    managementContext.getCatalogClassLoader());
            ((HighAvailabilityManagerImpl)haManager).setHeartbeatTimeout(haHeartbeatTimeoutOverride);
            ((HighAvailabilityManagerImpl)haManager).setPollPeriod(haHeartbeatPeriodOverride);
            haManager.setPersister(persister);
        }
    }
    
    protected void startPersistence() {
        // Now start the HA Manager and the Rebind manager, as required
        if (highAvailabilityMode == HighAvailabilityMode.DISABLED) {
            HighAvailabilityManager haManager = managementContext.getHighAvailabilityManager();
            haManager.disabled();

            if (persistMode != PersistMode.DISABLED) {
                startPersistenceWithoutHA();
            }
            
        } else {
            // Let the HA manager decide when objectstore.prepare and rebindmgr.rebind need to be called 
            // (based on whether other nodes in plane are already running).
            
            HighAvailabilityMode startMode=null;
            switch (highAvailabilityMode) {
                case AUTO:
                case MASTER:
                case STANDBY:
                case HOT_STANDBY:
                case HOT_BACKUP:
                    startMode = highAvailabilityMode;
                    break;
                case DISABLED:
                    throw new IllegalStateException("Unexpected code-branch for high availability mode "+highAvailabilityMode);
            }
            if (startMode==null)
                throw new IllegalStateException("Unexpected high availability mode "+highAvailabilityMode);
            
            LOG.debug("Management node (with HA) starting");
            HighAvailabilityManager haManager = managementContext.getHighAvailabilityManager();
            // prepare after HA mode is known, to prevent backups happening in standby mode
            haManager.start(startMode);
        }
    }

    private void startPersistenceWithoutHA() {
        RebindManager rebindManager = managementContext.getRebindManager();
        if (Strings.isNonBlank(persistenceLocation))
            LOG.info("Management node (no HA) rebinding to entities at "+persistenceLocation+" in "+persistenceDir);
        else
            LOG.info("Management node (no HA) rebinding to entities on file system in "+persistenceDir);

        ClassLoader classLoader = managementContext.getCatalogClassLoader();
        try {
            rebindManager.rebind(classLoader, null, ManagementNodeState.MASTER);
        } catch (Exception e) {
            Exceptions.propagateIfFatal(e);
            LOG.debug("Error rebinding to persisted state (rethrowing): "+e, e);
            throw new FatalRuntimeException("Error rebinding to persisted state: "+
                Exceptions.collapseText(e), e);
        }
        rebindManager.startPersistence();
    }

    @SuppressWarnings("deprecation")
    protected void createApps() {
        for (org.apache.brooklyn.core.entity.factory.ApplicationBuilder appBuilder : appBuildersToManage) {
            StartableApplication app = appBuilder.manage(managementContext);
            apps.add(app);
        }
        for (Application app : appsToManage) {
            Entities.startManagement(app, managementContext);
            apps.add(app);
        }
        for (String blueprint : yamlAppsToManage) {
            Application app = EntityManagementUtils.createUnstarted(managementContext, blueprint);
            // Note: BrooklynAssemblyTemplateInstantiator automatically puts applications under management.
            apps.add(app);
        }
    }

    protected void startBrooklynNode() {
        final String classpath = System.getenv("INITIAL_CLASSPATH");
        if (Strings.isBlank(classpath)) {
            LOG.warn("Cannot find INITIAL_CLASSPATH environment variable, skipping BrooklynNode entity creation");
            return;
        }

        EntitySpec<LocalBrooklynNode> brooklynNodeSpec = EntitySpec.create(LocalBrooklynNode.class)
            .configure(SoftwareProcess.ENTITY_STARTED, true)
            .configure(BrooklynNode.CLASSPATH, Splitter.on(":").splitToList(classpath))
            .displayName("Brooklyn Console");

        brooklynNodeSpec = customizeBrooklynNodeSpec(brooklynNodeSpec);

        if (brooklynNodeSpec != null) {
            EntityManagementUtils.createStarting(managementContext,
                    EntitySpec.create(BasicApplication.class)
                        .displayName("Brooklyn")
                        .child(brooklynNodeSpec));
        }
    }

    /**
     * Configure the node so it can connect to Brooklyn's REST API. Return null to skip registering the node
     */
//    protected EntitySpec<LocalBrooklynNode> customizeBrooklynNodeSpec(EntitySpec<LocalBrooklynNode> brooklynNodeSpec) {
//        LOG.error("Skipping BrooklynNode registration. Configure a loopback REST endpoint configured for the node.");
//        return null;
//    }

    protected void startApps() {
    	if ((stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.ALL) ||
              (stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.ALL_IF_NOT_PERSISTED && getPersistMode()==PersistMode.DISABLED)) {
              BrooklynShutdownHooks.invokeStopAppsOnShutdown(getManagementContext());
          }
  
          for (Application app : getApplications()) {
              if (app instanceof Startable) {
  
                  if ((stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.THESE) || 
                      (stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.THESE_IF_NOT_PERSISTED && getPersistMode()==PersistMode.DISABLED)) {
                      BrooklynShutdownHooks.invokeStopOnShutdown(app);
                  }
              }
          }
    	List<Throwable> appExceptions = Lists.newArrayList();
        for (Application app : apps) {
            if (app instanceof oCampStartable) {

                try {
                    LOG.info("Starting brooklyn application {} in location{} {}", new Object[] { app, locations.size()!=1?"s":"", locations });
                    ((oCampStartable)app).startup();
                } catch (Exception e) {
                    LOG.error("Error starting "+app+": "+Exceptions.collapseText(e), Exceptions.getFirstInteresting(e));
                    appExceptions.add(Exceptions.collapse(e));

                    if (Thread.currentThread().isInterrupted()) {
                        LOG.error("Interrupted while starting applications; aborting");
                        break;
                    }
                }
            }
        }
        if (!appExceptions.isEmpty()) {
            Throwable t = Exceptions.create(appExceptions);
            throw new FatalRuntimeException("Error starting applications: "+Exceptions.collapseText(t), t);
        }
    }

    public boolean isStarted() {
        return started;
    }

    public PersistMode getPersistMode() {
        return persistMode;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public CampPlatform getCampPlatform() {
        return campPlatform;
    }

    @SuppressWarnings("unchecked")
    private T self() {
        return (T) this;
    }

    public void setBrooklynPropertiesBuilder(BrooklynProperties.Factory.Builder brooklynPropertiesBuilder) {
        this.brooklynPropertiesBuilder = brooklynPropertiesBuilder;
    }

    public BrooklynProperties getBrooklynProperties() {
        return brooklynProperties;
    }
    

    public OCampServerDetails getServerDetails() {
        if (!isStarted()) throw new IllegalStateException("Cannot retrieve server details until started");
        return new OCampServerDetails(webServer, getManagementContext());
    }
    
    /** 
     * Specifies whether the launcher will start the Brooklyn web console 
     * (and any additional webapps specified); default true.
     */
    public OCampLauncher2<T> webconsole(boolean startWebApps) {
        this.startWebApps = startWebApps;
        return this;
    }

    public OCampLauncher2<T> installSecurityFilter(Boolean val) {
        this.skipSecurityFilter = val == null ? null : !val;
        return this;
    }

    /** 
     * As {@link #webconsolePort(PortRange)} taking a single port
     */ 
    public OCampLauncher2<T> webconsolePort(int port) {
        return webconsolePort(PortRanges.fromInteger(port));
    }

    /**
     * As {@link #webconsolePort(PortRange)} taking a string range
     */
    public OCampLauncher2<T> webconsolePort(String port) {
        if (port==null) return webconsolePort((PortRange)null);
        return webconsolePort(PortRanges.fromString(port));
    }

    /**
     * Specifies the port where the web console (and any additional webapps specified) will listen;
     * default (null) means "8081+" being the first available >= 8081 (or "8443+" for https).
     */ 
    public OCampLauncher2<T> webconsolePort(PortRange port) {
        this.port = port;
        return this;
    }

    /**
     * Specifies whether the webconsole should use https.
     */ 
    public OCampLauncher2<T> webconsoleHttps(Boolean useHttps) {
        this.useHttps = useHttps;
        return this;
    }

    /**
     * Specifies the NIC where the web console (and any additional webapps specified) will be bound;
     * default 0.0.0.0, unless no security is specified (e.g. users) in which case it is localhost.
     */ 
    public OCampLauncher2<T> bindAddress(InetAddress bindAddress) {
        this.bindAddress = bindAddress;
        return this;
    }

    /**
     * Specifies the address that the management context's REST API will be available on. Defaults
     * to {@link #bindAddress} if it is not 0.0.0.0.
     * @see #bindAddress(java.net.InetAddress)
     */
    public OCampLauncher2<T> publicAddress(InetAddress publicAddress) {
        this.publicAddress = publicAddress;
        return this;
    }

    /**
     * Specifies additional flags to be passed to {@link BrooklynWebServer}.
     */ 
    public OCampLauncher2<T> webServerFlags(Map<String,?> webServerFlags) {
        this.webconsoleFlags  = webServerFlags;
        return this;
    }

    /** 
     * Specifies an additional webapp to host on the webconsole port.
     * @param contextPath The context path (e.g. "/hello", or equivalently just "hello") where the webapp will be hosted.
     *      "/" will override the brooklyn console webapp.
     * @param warUrl The URL from which the WAR should be loaded, supporting classpath:// protocol in addition to file:// and http(s)://.
     */
    public OCampLauncher2<T> webapp(String contextPath, String warUrl) {
        webApps.add(new WebAppContextProvider(contextPath, warUrl));
        return this;
    }

    /**
     * @see #webapp(String, String)
     */
    public OCampLauncher2<T> webapp(WebAppContextProvider contextProvider) {
        webApps.add(contextProvider);
        return this;
    }

    public OCampLauncher2<T> ignoreWebErrors(boolean ignoreWebErrors) {
        this.ignoreWebErrors = ignoreWebErrors;
        return this;
    }

    public OCampLauncher2<T> stopWhichAppsOnShutdown(StopWhichAppsOnShutdown stopWhich) {
        this.stopWhichAppsOnShutdown = stopWhich;
        return this;
    }

    public OCampLauncher2<T> customizeManagement(Function<ManagementContext,Void> customizeManagement) {
        this.customizeManagement = customizeManagement;
        return this;
    }

    public OCampLauncher2<T> shutdownOnExit(boolean val) {
        LOG.warn("Call to deprecated `shutdownOnExit`", new Throwable("source of deprecated call"));
        stopWhichAppsOnShutdown = StopWhichAppsOnShutdown.THESE_IF_NOT_PERSISTED;
        return this;
    }

    /**
     * A listener to call when the user requests a shutdown (i.e. through the REST API)
     */
    public OCampLauncher2<T> shutdownHandler(ShutdownHandler shutdownHandler) {
        this.shutdownHandler = shutdownHandler;
        return this;
    }

//    @Override
//    protected void initManagementContext() {
//        setBrooklynPropertiesBuilder(
//                new BrooklynPropertiesFactoryHelper(
//                        globalBrooklynPropertiesFile,
//                        localBrooklynPropertiesFile,
//                        getBrooklynProperties())
//                .createPropertiesBuilder());
//
//        boolean isManagementContextSet = getManagementContext() != null;
//
//        super.initManagementContext();
//
//        if (!isManagementContextSet) {
//            // We created the management context, so we are responsible for terminating it
//            BrooklynShutdownHooks.invokeTerminateOnShutdown(getManagementContext());
//        }
//
//        if (customizeManagement!=null) {
//            customizeManagement.apply(getManagementContext());
//        }
//    }
//
    //@Override
    protected void startingUp() {
        //super.startingUp();

        // Start webapps as soon as mgmt context available -- can use them to detect progress of other processes
        if (startWebApps) {
            try {
                startWebApps();
            } catch (Exception e) {
                handleSubsystemStartupError(ignoreWebErrors, "core web apps", e);
            }
        }
    }

    protected void startWebApps() {
        ManagementContext managementContext = getManagementContext();
        BrooklynProperties brooklynProperties = (BrooklynProperties) managementContext.getConfig();

        // No security options in properties and no command line options overriding.
        if (Boolean.TRUE.equals(skipSecurityFilter) && bindAddress==null) {
            LOG.info("Starting Brooklyn web-console on loopback because security is explicitly disabled and no bind address specified");
            bindAddress = Networking.LOOPBACK;
        } else if (BrooklynWebConfig.hasNoSecurityOptions(managementContext.getConfig())) {
            LOG.info("No security provider options specified. Define a security provider or users to prevent a random password being created and logged.");
            
            if (bindAddress==null) {
                LOG.info("Starting Brooklyn web-console with passwordless access on localhost and protected access from any other interfaces (no bind address specified)");
            } else {
                if (Arrays.equals(new byte[] { 127, 0, 0, 1 }, bindAddress.getAddress())) { 
                    LOG.info("Starting Brooklyn web-console with passwordless access on localhost");
                } else if (Arrays.equals(new byte[] { 0, 0, 0, 0 }, bindAddress.getAddress())) { 
                    LOG.info("Starting Brooklyn web-console with passwordless access on localhost and random password (logged) required from any other interfaces");
                } else { 
                    LOG.info("Starting Brooklyn web-console with passwordless access on localhost (if permitted) and random password (logged) required from any other interfaces");
                }
            }
            brooklynProperties.put(
                    BrooklynWebConfig.SECURITY_PROVIDER_INSTANCE,
                    new BrooklynUserWithRandomPasswordSecurityProvider(managementContext));
        } else {
            LOG.debug("Starting Brooklyn using security properties: "+brooklynProperties.submap(ConfigPredicates.nameStartsWith(BrooklynWebConfig.BASE_NAME_SECURITY)).asMapWithStringKeys());
        }
        if (bindAddress == null) bindAddress = Networking.LOOPBACK;//Networking.ANY_NIC;

        LOG.debug("Starting Brooklyn web-console with bindAddress "+bindAddress+" and properties "+brooklynProperties);
        try {
            webServer = new OCampWebServer(webconsoleFlags, managementContext);
            webServer.setBindAddress(bindAddress);
            webServer.setPublicAddress(publicAddress);
            if (port!=null) webServer.setPort(port);
            if (useHttps!=null) webServer.setHttpsEnabled(useHttps);
            webServer.setShutdownHandler(shutdownHandler);
            webServer.putAttributes(brooklynProperties);
            if (skipSecurityFilter != Boolean.TRUE) {
                webServer.setSecurityFilter(BrooklynPropertiesSecurityFilter.class);
            }
            for (WebAppContextProvider webapp : webApps) {
                webServer.addWar(webapp);
            }
            webServer.start();

        } catch (Exception e) {
            LOG.warn("Failed to start Brooklyn web-console (rethrowing): " + Exceptions.collapseText(e));
            throw new FatalRuntimeException("Failed to start Brooklyn web-console: " + Exceptions.collapseText(e), e);
        }
    }


    protected EntitySpec<LocalBrooklynNode> customizeBrooklynNodeSpec(EntitySpec<LocalBrooklynNode> brooklynNodeSpec) {
        return brooklynNodeSpec
                .configure(SoftwareProcess.RUN_DIR, System.getenv("ROOT"))
                .configure(SoftwareProcess.INSTALL_DIR, System.getenv("BROOKLYN_HOME"))
                .configure(BrooklynNode.ENABLED_HTTP_PROTOCOLS, ImmutableList.of(webServer.getHttpsEnabled() ? "https" : "http"))
                .configure(webServer.getHttpsEnabled() ? BrooklynNode.HTTPS_PORT : BrooklynNode.HTTP_PORT, PortRanges.fromInteger(webServer.getActualPort()))
                .configure(BrooklynNode.WEB_CONSOLE_BIND_ADDRESS, bindAddress)
                .configure(BrooklynNode.WEB_CONSOLE_PUBLIC_ADDRESS, publicAddress)
                .configure(BrooklynNode.NO_WEB_CONSOLE_AUTHENTICATION, Boolean.TRUE.equals(skipSecurityFilter));
    }

//    protected void startApps() {
//        if ((stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.ALL) ||
//            (stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.ALL_IF_NOT_PERSISTED && getPersistMode()==PersistMode.DISABLED)) {
//            BrooklynShutdownHooks.invokeStopAppsOnShutdown(getManagementContext());
//        }
//
//        for (Application app : getApplications()) {
//            if (app instanceof Startable) {
//
//                if ((stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.THESE) || 
//                    (stopWhichAppsOnShutdown==StopWhichAppsOnShutdown.THESE_IF_NOT_PERSISTED && getPersistMode()==PersistMode.DISABLED)) {
//                    BrooklynShutdownHooks.invokeStopOnShutdown(app);
//                }
//            }
//        }
//        super.startApps();
//    }


    /**
     * Terminates this launch, but does <em>not</em> stop the applications (i.e. external processes
     * are left running, etc). However, by terminating the management console the brooklyn applications
     * become unusable.
     */
    public void terminate() {
        if (!isStarted()) return; // no-op

        if (webServer != null) {
            try {
                webServer.stop();
            } catch (Exception e) {
                LOG.warn("Error stopping web-server; continuing with termination", e);
            }
        }

        ManagementContext managementContext = getManagementContext();

        // TODO Do we want to do this as part of managementContext.terminate, so after other threads are terminated etc?
        // Otherwise the app can change between this persist and the terminate.
        if (getPersistMode() != PersistMode.DISABLED) {
            try {
                Stopwatch stopwatch = Stopwatch.createStarted();
                if (managementContext.getHighAvailabilityManager().getPersister() != null) {
                    managementContext.getHighAvailabilityManager().getPersister().waitForWritesCompleted(Duration.TEN_SECONDS);
                }
                managementContext.getRebindManager().waitForPendingComplete(Duration.TEN_SECONDS, true);
                LOG.info("Finished waiting for persist; took "+Time.makeTimeStringRounded(stopwatch));
            } catch (RuntimeInterruptedException e) {
                Thread.currentThread().interrupt(); // keep going with shutdown
                LOG.warn("Persistence interrupted during shutdown: "+e, e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // keep going with shutdown
                LOG.warn("Persistence interrupted during shutdown: "+e, e);
            } catch (TimeoutException e) {
                LOG.warn("Timeout after 10 seconds waiting for persistence to write all data; continuing");
            }
        }

        if (managementContext instanceof ManagementContextInternal) {
            ((ManagementContextInternal)managementContext).terminate();
        }

        for (Location loc : getLocations()) {
            if (loc instanceof Closeable) {
                Streams.closeQuietly((Closeable)loc);
            }
        }
    }

    public OCampLauncher2<T> globalBrooklynPropertiesFile(String file) {
        globalBrooklynPropertiesFile = file;
        return this;
    }

    public OCampLauncher2<T> localBrooklynPropertiesFile(String file) {
        localBrooklynPropertiesFile = file;
        return this;
    }

    //------------------------------------------------------------------------------------------
    
    
    
    

    public static void main(String [] args){
    	OCampLauncher2 launcher = (OCampLauncher2) (OCampLauncher2.newInstance())
    			 
    			 //.application(new WebClusterDatabaseExample().appDisplayName("Web-cluster example"))
    			 //.location("localhost"))
    			 .start();
 //   	BrooklynLauncher launcher = BrooklynLauncher.newInstance()
//   			 .managementContext(new BaseEntityManager())
//   			 //.application(new WebClusterDatabaseExample().appDisplayName("Web-cluster example"))
//   			 .location("localhost")
 // 			 .start();
    }
    
    
    
}
