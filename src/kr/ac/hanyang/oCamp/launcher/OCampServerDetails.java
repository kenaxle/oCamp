package kr.ac.hanyang.oCamp.launcher;

import org.apache.brooklyn.api.mgmt.ManagementContext;

public class OCampServerDetails {//extends BrooklynServerDetails{

	protected OCampWebServer webServer;
	protected ManagementContext mgmtContext;
	
    public OCampServerDetails(OCampWebServer webServer, ManagementContext mgmtContext) {
    	//super(webServer, mgmtContext);
    	this.webServer = webServer;
        this.mgmtContext = mgmtContext;
    }

    public OCampWebServer getWebServer() {
        return webServer;
    }
    
    public String getWebServerUrl() {
        if (webServer==null) return null;
        return webServer.getRootUrl();
    }
    
    public ManagementContext getManagementContext() {
        return mgmtContext;
    }

}
