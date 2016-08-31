package kr.ac.hanyang.oCamp.entities;

public interface IArtifact {
	
	public <T> T getContent();
	
	public String[] getRequirements();
	
}