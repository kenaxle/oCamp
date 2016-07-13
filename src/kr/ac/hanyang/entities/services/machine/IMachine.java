package kr.ac.hanyang.entities.services.machine;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;

@Catalog(name="Machine Entity", description="Represents a machine, providing metrics about it (e.g. obtained from ssh)")
@ImplementedBy(Machine.class)

public interface IMachine {
	public static final String[] CAPABILITIES = {"ExecuteOn"};
	//need to add the characteristics also

}
