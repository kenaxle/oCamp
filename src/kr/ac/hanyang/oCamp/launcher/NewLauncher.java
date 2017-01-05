package kr.ac.hanyang.oCamp.launcher;

import java.io.File;
import java.util.ArrayList;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.api.mgmt.ha.ManagementNodeState;
import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.camp.spi.pdp.Artifact;
import org.apache.brooklyn.camp.spi.pdp.ArtifactRequirement;
import org.apache.brooklyn.camp.spi.pdp.Service;
import org.apache.brooklyn.core.catalog.internal.BasicBrooklynCatalog;
import org.apache.brooklyn.core.catalog.internal.CatalogInitialization;
import org.apache.brooklyn.core.catalog.internal.CatalogUtils;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.mgmt.internal.ManagementContextInternal;
import org.apache.brooklyn.core.mgmt.persist.PersistMode;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.camp.pdp.ActionGroup;
import kr.ac.hanyang.oCamp.camp.pdp.Policy;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatformLauncher;
import kr.ac.hanyang.oCamp.core.catalog.OCampServiceCatalog;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;
import kr.ac.hanyang.oCamp.core.mgmt.oCampReservedKeys;

public class NewLauncher {
	private static final Logger LOG = LoggerFactory.getLogger(BrooklynLauncher.class);
	
	/** Creates a configurable (fluent API) launcher for use starting the web console and Brooklyn applications. */
    public static NewLauncher newInstance() {
    	return new NewLauncher();
    }
    
    /** 
     * Specifies the management context this launcher should use. 
     * If not specified a new one is created automatically.
     */
    public NewLauncher managementContext(ManagementContext context) {
        //if (brooklynProperties != null) throw new IllegalStateException("Cannot set brooklynProperties and managementContext");
        this.managementContext = context;
        return this;
    }
    
    private boolean started;
    //private boolean startWebApps = true;
    //private PortRange port = null;
   // private Boolean useHttps = null;
    //private InetAddress bindAddress = null;
    //private InetAddress publicAddress = null;
    //private List<WebAppContextProvider> webApps = new LinkedList<>();
    //private Map<String, ?> webconsoleFlags = Maps.newLinkedHashMap();
    //private Boolean skipSecurityFilter = null;
    
    //private boolean ignoreWebErrors = false;
    
    //private StopWhichAppsOnShutdown stopWhichAppsOnShutdown = StopWhichAppsOnShutdown.THESE_IF_NOT_PERSISTED;
    //private ShutdownHandler shutdownHandler;
    
    //private Function<ManagementContext,Void> customizeManagement = null;
    
    

    //private String globalBrooklynPropertiesFile = Os.mergePaths(Os.home(), ".brooklyn", "brooklyn.properties");
    //private String localBrooklynPropertiesFile;
    
    
    private volatile NewWebServer webServer;
    private CampPlatform campPlatform;
    private ManagementContext managementContext;
    
     
    public CampPlatform getCampPlatform() {
        return campPlatform;
    }
    
    
    protected void initCamp() {
        // Add a CAMP platform
        campPlatform = new oCampPlatformLauncher()
                .useManagementContext(managementContext)
                .launch()
                .getCampPlatform();
        // TODO start CAMP rest _server_ in the below (at /camp) ?
    }
    
    protected void startingUp() {

    }
    
    
    protected void startWebApps() {
        webServer = new NewWebServer(managementContext).init();
        webServer.start();
    }
    
    protected void startServerNode() {
    	
    }
  
    
    /**
     * Starts the web server (with web console) and Brooklyn applications, as per the specifications configured. 
     * @return An object containing details of the web server and the management context.
     */
    public NewLauncher start() {
        if (started) throw new IllegalStateException("Cannot start() or launch() multiple times");
        started = true;

        //initManagementContext();

       //ServiceCatalogInitializer catInit =  (ServiceCatalogInitializer) ((ManagementContextInternal)managementContext).getCatalogInitialization();

        //markCatalogStartingUp(catInit);
        startingUp();
        initCamp();
        
        //handlePersistence();
       // populateCatalog(catInit);
       // markCatalogStarted(catInit);
       // addLocations();
        //markStartupComplete();
       // initApps();
        //initBrooklynNode();

       // persist();
        startWebApps();
        return this;
    }
    
    public static void main(String [] args){
    	NewLauncher launcher = NewLauncher.newInstance()
    			.managementContext(new BaseEntityManager())
    			//.webapp("/home", "http://search.maven.org/remotecontent?filepath=io/brooklyn/example/brooklyn-example-hello-world-sql-webapp/0.6.0-M2/brooklyn-example-hello-world-sql-webapp-0.6.0-M2.war")
    			.start();
    }
    
}
