package kr.ac.hanyang.platform;

import org.apache.brooklyn.camp.CampPlatform;
import org.apache.brooklyn.camp.brooklyn.spi.creation.BrooklynAssemblyTemplateInstantiator;
import org.apache.brooklyn.camp.spi.Assembly;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;

public class oCampAssemblyTemplateInstantiator extends BrooklynAssemblyTemplateInstantiator {

	@Override
	public Assembly instantiate(AssemblyTemplate template, CampPlatform platform) {
		return super.instantiate(template, platform);
	}

}
