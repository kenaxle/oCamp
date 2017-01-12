package kr.ac.hanyang.oCamp.entities.services.base;

import org.apache.brooklyn.api.catalog.Catalog;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.entity.software.base.VanillaSoftwareProcess;

import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;
import kr.ac.hanyang.oCamp.entities.services.web.tomcat.Tomcat7Impl;
@Catalog(name="Tomcat Entity", description="Represents a server")
@ImplementedBy(EmptyMachineImpl.class)
public interface EmptyMachine extends VanillaSoftwareProcess, BasicOCampService {

}
