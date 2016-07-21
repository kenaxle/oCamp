package kr.ac.hanyang.entities.artifacts;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import kr.ac.hanyang.entities.IArtifact;

@Catalog(name="Machine Artifact Entity", description="Represents a machine Artifact, providing metrics about it (e.g. obtained from ssh)")
@ImplementedBy(Software.class)

public interface ISoftware extends IArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn","ExecuteOn"};
	
}
