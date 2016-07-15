package kr.ac.hanyang.entities.artifacts;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import kr.ac.hanyang.entities.IArtifact;

@Catalog(name="War Artifact Entity", description="Represents a War file Artifact, providing metrics about it (e.g. obtained from ssh)")
@ImplementedBy(War.class)

public interface IWar extends IArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn","DeploysOn"};
	
}
