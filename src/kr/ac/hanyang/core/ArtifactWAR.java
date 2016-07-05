package kr.ac.hanyang.core;

import org.apache.brooklyn.entity.webapp.JavaWebAppDriver;
import org.apache.brooklyn.entity.webapp.JavaWebAppSoftwareProcessImpl;

public class ArtifactWAR extends JavaWebAppSoftwareProcessImpl {
	public ArtifactWAR(){
		super();
	}
	
	public void init(){
		super.init();
	}

	@Override
	public Class<?> getDriverInterface() {
		return JavaWebAppDriver.class;
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return super.configure(flags);
//		
//	}
	
	public String toString(){
		return this.getConfigMap().toString();
	}
	
}
