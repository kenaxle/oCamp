package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;

@Catalog(name="DeployOn relationship", description="Represents the relationship DeployOn")
@ImplementedBy(DeployOnImpl.class)
public interface DeployOn extends Entity{
	public <T> T getContentUrl();
	public String getTarget();
}
