package kr.ac.hanyang.oCamp.entities.artifacts;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

@Catalog(name="Script Artifact Entity", description="Represents a Script Artifact")
@ImplementedBy(ScriptImpl.class)

public interface Script extends BasicOCampArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn","ExecuteOn"};
	
}
