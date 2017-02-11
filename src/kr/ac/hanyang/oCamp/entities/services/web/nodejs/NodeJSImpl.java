package kr.ac.hanyang.oCamp.entities.services.web.nodejs;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.webapp.nodejs.NodeJsWebAppServiceImpl;

import kr.ac.hanyang.oCamp.entities.requirements.IService;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class NodeJSImpl extends NodeJsWebAppServiceImpl implements NodeJS, IService, Startable{


}
