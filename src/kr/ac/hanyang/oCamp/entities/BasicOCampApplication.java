package kr.ac.hanyang.oCamp.entities;

import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.entity.stock.BasicApplication;

@ImplementedBy(BasicOCampApplicationImpl.class)
public interface BasicOCampApplication extends BasicApplication{

}
