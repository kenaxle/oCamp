package kr.ac.hanyang.oCamp.core.mgmt;

public interface oCampReservedKeys {
	
	public static final String MEMBER = "member";
	public static final String[] PATHS = {"/kr/ac/hanyang/oCamp/entities/services","/kr/ac/hanyang/oCamp/entities/artifacts","/kr/ac/hanyang/oCamp/entities/requirements"};
	public static final String CLASSPATH = "C:/Users/kenax/git/oCamp/target/classes";//"/Users/kena/git/oCamp/target/classes";
	public static final String PREFIX = "kr\\ac\\hanyang\\"; //"kr/ac/hanyang/";
	public static final String[] OMIT = {"BasicOCampArtifact","BasicOCampService","ISoftwareProcess","SoftwareProcess","Ansible","IConnectable","IDeployable","IEntity","IExecutable","IService"};
	
}
