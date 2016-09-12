package kr.ac.hanyang.oCamp.entities.artifacts;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

@Catalog(name="Software Artifact Entity", description="Represents a Software Artifact")
@ImplementedBy(SoftwareImpl.class)

public interface Software extends BasicOCampArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn","ExecuteOn"};
	
}
