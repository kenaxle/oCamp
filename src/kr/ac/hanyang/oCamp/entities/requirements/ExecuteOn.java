package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;

@Catalog(name="ExecuteOn relationship", description="Represents the relationship ExecuteOn")
@ImplementedBy(ExecuteOnImpl.class)
public interface ExecuteOn {
	public <T> T getContent();
}
