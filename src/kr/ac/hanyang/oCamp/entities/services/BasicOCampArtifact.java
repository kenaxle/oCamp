package kr.ac.hanyang.oCamp.entities.services;

import org.apache.brooklyn.api.entity.Entity;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.BasicConfigKey;
import org.apache.brooklyn.util.core.flags.SetFromFlag;


public interface BasicOCampArtifact extends Entity{
	
	public static final String[] REQUIREMENTS = {"DependsOn"};
	
	@SetFromFlag("content")
	public static final ConfigKey<String> CONTENT = new BasicConfigKey<String>(
			String.class, "content","The content of this artifact");
	
	public <T> T getContent();
	
	public String[] getRequirements();
	
}