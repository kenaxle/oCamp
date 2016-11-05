package kr.ac.hanyang.oCamp.entities.policies;

import org.apache.brooklyn.api.entity.ImplementedBy;

@ImplementedBy(QoSImpl.class)
public interface QoS extends PolicyManager{

//	public static final String DEFAULT = 
//			PolicyManager.DEFAULT
//			   + "- id: SCALE_UP\n"
//			   + "  actions:\n"
//			   + "  - property: REQUEST_PER_SECOND_PER_NODE\n"
//			   + "    transitions:\n"
//			   + "    - type: Initial\n"
//			   + "      value: ANYTHING\n"
//			   + "    - type: Decrease\n"
//			   + "      value: ANYTHING\n"
//			   + "- id: SCALE_DOWN\n"
//			   + "  actions:\n"
//			   + "  - property: REQUEST_PER_SECOND_PER_NODE\n"
//			   + "    transitions:\n"
//			   + "    - type: Initial\n"
//			   + "      value: ANYTHING\n"
//			   + "    - type: Increase\n"
//			   + "      value: ANYTHING\n";

	
	public static final String DEFAULT = "type: kr.ac.hanyang.oCamp.entities.policies.QoS\n"
			   + "actiongroups:\n"
			   + "- id: SCALE_UP\n"
			   + "  actions:\n"
			   + "  - property: REQUEST_PER_SECOND\n"
			   + "    transitions:\n"
			   + "    - type: Initial\n"
			   + "      value: ANYTHING\n"
			   + "    - type: Decrease\n"
			   + "      value: ANYTHING\n"
//			   + "  - property: PROVISIONING_LOCATION\n"
//			   + "    transitions:\n"
//			   + "    - type: Initial\n"
//			   + "      value: null\n"
//			   + "    - type: Set\n"
//			   + "      value: ANYTHING\n"
			   + "- id: SCALE_DOWN\n"
			   + "  actions:\n"
			   + "  - property: REQUEST_PER_SECOND\n"
			   + "    transitions:\n"
			   + "    - type: Initial\n"
			   + "      value: ANYTHING\n"
			   + "    - type: Increase\n"
			   + "      value: ANYTHING\n";
//			   + "  - property: PROVISIONING_LOCATION\n"
//			   + "    transitions:\n"
//			   + "    - type: Initial\n"
//			   + "      value: ANYTHING\n"
//			   + "    - type: Set\n"
//			   + "      value: null\n";

	
	

}
