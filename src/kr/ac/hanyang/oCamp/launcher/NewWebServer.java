package kr.ac.hanyang.oCamp.launcher;



import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.rest.util.BrooklynRestResourceUtils;
import org.apache.brooklyn.rest.util.ManagementContextProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.rest.RestApiSetup;


public class NewWebServer {
	private static final Logger log = LoggerFactory.getLogger(NewWebServer.class);
	
	private ManagementContext managementContext;
	private Server webServer;
	BrooklynRestResourceUtils resourceUtils;
	
	public NewWebServer(ManagementContext managementContext){
		this.managementContext = managementContext;
	}
	
	public NewWebServer init(){
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

		webServer = new Server(8082);
		webServer.setHandler(context);
		
		RestApiSetup.installRest(context, new ManagementContextProvider(managementContext));

	    return this;
	}
	
	

	public Server start() {
	    try {
	    	webServer.start();
	    	webServer.join();
	    	return webServer;
	    }catch(Exception e){
	    	log.error(e.getMessage());
	    	return null;
	    } finally {
	    	//webServer.destroy();
	    }
	}

    
}
