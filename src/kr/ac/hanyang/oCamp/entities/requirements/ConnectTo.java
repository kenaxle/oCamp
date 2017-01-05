package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;

@Catalog(name="ConnectTo relationship", description="Represents the relationship ConnectsTo")
@ImplementedBy(ConnectToImpl.class)
public interface ConnectTo extends Entity{
	public <T> T getScript();
}
