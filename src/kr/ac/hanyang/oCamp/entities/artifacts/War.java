package kr.ac.hanyang.oCamp.entities.artifacts;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampArtifact;

@Catalog(name="War Artifact Entity", description="Represents a War file Artifact, providing metrics about it (e.g. obtained from ssh)")
@ImplementedBy(WarImpl.class)

public interface War extends BasicOCampArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn","DeploysOn"};
	
}
