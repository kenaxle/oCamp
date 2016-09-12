package kr.ac.hanyang.oCamp.entities.requirements;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.api.entity.ImplementedBy;

@Catalog(name="DependsOn relationship", description="Represents the relationship DependsOn")
@ImplementedBy(DependsOnImpl.class)
public interface DependsOn extends Entity{
	
}
