package kr.ac.hanyang.entities.services.software;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcess;


@Catalog(name="oCamp SoftwareProcess Entity", description="Represents a software process")
@ImplementedBy(SoftwareProcess.class)

public interface ISoftwareProcess extends VanillaSoftwareProcess {
	public static final String[] CAPABILITIES = {"ExecuteOn"};
	//need to add the characteristics also

}
