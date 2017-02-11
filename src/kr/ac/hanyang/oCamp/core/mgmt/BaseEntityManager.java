package kr.ac.hanyang.oCamp.core.mgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.Application;
import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynComponentTemplateResolver;
import org.apache.brooklyn.core.internal.BrooklynProperties.Factory.Builder;
import org.apache.brooklyn.core.mgmt.classloading.JavaBrooklynClassLoadingContext;
import org.apache.brooklyn.core.mgmt.internal.LocalEntityManager;
import org.apache.brooklyn.core.mgmt.internal.LocalManagementContext;
import org.apache.brooklyn.core.objs.proxy.InternalEntityFactory;
import org.apache.brooklyn.launcher.BrooklynLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.core.catalog.OCampServiceCatalog;

public class BaseEntityManager extends LocalManagementContext{// implements PolicyManager {

	private static final Logger log = LoggerFactory.getLogger(BaseEntityManager.class);
	
	
	private LocalOCampEntityManager entityManager;
	private oCampPlatform parentPlatform;
	private OCampServiceCatalog catalog;
	
	
	public BaseEntityManager() {
		super();
		this.catalog = new OCampServiceCatalog();
//		for (String path: oCampReservedKeys.PATHS)
//			populateServiceCatalog(path);
	}
	
	public synchronized Collection<Application> getPolicyManagers() {
        return ((LocalOCampEntityManager)getEntityManager()).getPolicyManagers();
    }

	
	public BaseEntityManager(Builder brooklynPropertiesBuilder, Map<String, Object> brooklynAdditionalProperties) {
		super(brooklynPropertiesBuilder, brooklynAdditionalProperties);
		this.catalog = new OCampServiceCatalog();
//		for (String path: oCampReservedKeys.PATHS)
//			populateServiceCatalog(path);
	}

	public void setParentPlatform(oCampPlatform platform){
		this.parentPlatform = platform;
	}
	
	public oCampPlatform getParentPlatform(){
		return parentPlatform;
	}
	
	@Override
	public InternalEntityFactory getEntityFactory() {
		return getEntityManager().getEntityFactory();
    }

	@Override
	public synchronized LocalEntityManager getEntityManager() {
        if (!isRunning()) throw new IllegalStateException("Management context no longer running");

        if (this.entityManager == null) {
            this.entityManager = new LocalOCampEntityManager(this);
        }
        return this.entityManager;
    }
	
	public OCampServiceCatalog getServiceCatalog(){
		return this.catalog;
	}
	
	private void populateServiceCatalog(String path) {
		File folder = new File(oCampReservedKeys.CLASSPATH+path);
    	File[] listOfFiles = folder.listFiles();
    	ArrayList<File> services = new ArrayList<File>();
    	
    	
    	for (int i = 0; i < listOfFiles.length; i++) {
    		populateRec(listOfFiles[i], services);   
    	}
    	ArrayList<String> serviceUris = sanitize(services);
    	
    	BrooklynClassLoadingContext loader = JavaBrooklynClassLoadingContext.create(this);
		
    	for(String serviceUri: serviceUris){
			BrooklynComponentTemplateResolver instance = BrooklynComponentTemplateResolver.Factory.newInstance(loader, serviceUri);
			if (instance != null){         
				
				EntitySpec spec = instance.resolveSpec(null);
				
				spec.displayName(serviceUri);
				catalog.addItem(spec);
			}
		}
		
    	

    }
	
	private void populateRec(File file, ArrayList<File> services){
	      if (file.isFile() && !file.isHidden()) {
	    	  services.add(file);
	    	  return;
	        //System.out.println("File " + listOfFiles[i].getName());
	      } else if (file.isDirectory()) {
	    	for(File subfile: file.listFiles()){
	    		populateRec(subfile, services);
	    	}
	        //System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    
  }
  
  private ArrayList<String> sanitize(ArrayList<File> services){
  	ArrayList<String> toReturn = new ArrayList<String>();
		for(File file: services){
			String path = file.getPath();
			String uri = path.substring(path.indexOf(oCampReservedKeys.PREFIX), path.length()-6).replace('\\'/*'/'*/, '.');
			if (! uri.contains("Impl") && ! toOmit(uri)){
				toReturn.add(uri);
			}

		}
		return toReturn;
  }
  
  private boolean toOmit(String uri){
	  for (String cname: oCampReservedKeys.OMIT){
		  if (uri.contains(cname)) return true;
	  }
	  return false;
  }
  
 
}
