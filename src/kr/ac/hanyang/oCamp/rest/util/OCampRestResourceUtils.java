package kr.ac.hanyang.oCamp.rest.util;

import org.apache.brooklyn.api.mgmt.ManagementContext;
import org.apache.brooklyn.rest.util.BrooklynRestResourceUtils;

import kr.ac.hanyang.oCamp.core.catalog.OCampServiceCatalog;
import kr.ac.hanyang.oCamp.core.mgmt.BaseEntityManager;

public class OCampRestResourceUtils extends BrooklynRestResourceUtils {

	 private final ManagementContext mgmt;
	
	public OCampRestResourceUtils(ManagementContext mgmt) {
		super(mgmt);
		this.mgmt = mgmt;
	}
	
	 public OCampServiceCatalog getServiceCatalog() {
	        return ((BaseEntityManager)mgmt).getServiceCatalog();
	    }

}
