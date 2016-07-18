package kr.ac.hanyang.entities.services;

import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import kr.ac.hanyang.entities.IArtifact;

public interface IBasicOCampArtifact extends IArtifact{
	
	public static final String[] REQUIREMENTS = {"DependsOn"};
	
	@SetFromFlag("content")
	public static final ConfigKey<String> CONTENT = new BasicConfigKey<String>(
			String.class, "content","The content of this artifact");
	
	
}