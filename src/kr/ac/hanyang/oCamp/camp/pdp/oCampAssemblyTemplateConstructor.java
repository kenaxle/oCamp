package kr.ac.hanyang.oCamp.camp.pdp;

import java.util.Map;

import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate.Builder;
import org.apache.brooklyn.camp.spi.instantiate.AssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.pdp.AssemblyTemplateConstructor;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatformComponentTemplate;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform;
import kr.ac.hanyang.oCamp.camp.platform.oCampPlatform.oCampPlatformTransaction;

public class oCampAssemblyTemplateConstructor extends AssemblyTemplateConstructor {
	
	private final oCampPlatform campPlatform;
	private final Builder<? extends AssemblyTemplate> builder;
    protected oCampPlatformTransaction transaction;
    
	public oCampAssemblyTemplateConstructor(CampPlatform campPlatform) {
		super(campPlatform);
		this.campPlatform = (oCampPlatform)campPlatform;
		this.builder = AssemblyTemplate.builder();
        this.transaction = this.campPlatform.transaction();
	}
    
    /** records all the templates to the underlying platform */
    public AssemblyTemplate commit() {
        checkState();
        AssemblyTemplate at = builder.build();
        transaction.add(at).commit();
        transaction = null;
        return at;
    }

    public void name(String name) {
        checkState();
        builder.name(name);
    }

    public void description(String description) {
        checkState();
        builder.description(description);
    }


    public void sourceCode(String sourceCode) {
        checkState();
        builder.sourceCode(sourceCode);
    }

    public void addCustomAttributes(Map<String, Object> attrs) {
        for (Map.Entry<String, Object> attr : attrs.entrySet())
            builder.customAttribute(attr.getKey(), attr.getValue());
    }

    public void instantiator(Class<? extends AssemblyTemplateInstantiator> instantiator) {
        checkState();
        builder.instantiator(instantiator);
    }
    
    public Class<? extends AssemblyTemplateInstantiator> getInstantiator() {
        checkState();
        return builder.peek().getInstantiator();
    }
    
    public void add(ApplicationComponentTemplate act) {
        checkState();
        builder.add(act);
        transaction.add(act);
    }

    public void add(PlatformComponentTemplate pct) {
        checkState();
        builder.add(pct);
        transaction.add(pct);
    }

    public void addRequirement(PlatformComponentTemplate rct, String id){
    	checkState();
    	oCampPlatformComponentTemplate platTemp = (oCampPlatformComponentTemplate) transaction.getPlatformComponentTemplate(id);
    	platTemp.add(rct);
    }
    
    protected void checkState() {
        if (transaction == null)
            throw new IllegalStateException("transaction already committed");
    }
	
	public oCampPlatform getPlatform(){
		return campPlatform;
	}


}

//need this class only to expose the platform