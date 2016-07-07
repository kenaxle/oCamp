package kr.ac.hanyang.entities.services.machine;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;

import kr.ac.hanyang.entities.IService;

@Catalog(name="Machine Entity", description="Represents a machine, providing metrics about it (e.g. obtained from ssh)")
@ImplementedBy(Machine.class)
public interface IMachine extends IService{
	public static final String[] Capabilities = {"ExecuteOn"};
	//need to add the characteristics also
}
