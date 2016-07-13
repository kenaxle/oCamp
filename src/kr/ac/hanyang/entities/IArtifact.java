package kr.ac.hanyang.entities;

public interface IArtifact {
	
	public <T> T getContent();
	
	public String[] getRequirements();
	
}