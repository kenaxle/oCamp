package kr.ac.hanyang.oCamp.camp.spi;

import org.apache.brooklyn.camp.spi.PlatformTransaction;

public abstract class oCampAbstractPlatformTransaction extends PlatformTransaction{

	@Override
	public abstract void commit();
	
	public PlatformTransaction add(PolicyManagerTemplate pmct) {
        additions.add(pmct);
        return this;
    }
	
}
