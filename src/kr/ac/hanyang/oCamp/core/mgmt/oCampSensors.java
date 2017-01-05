package kr.ac.hanyang.oCamp.core.mgmt;

import java.util.Map;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.location.MachineProvisioningLocation;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.BrooklynConfigKeys;
import org.apache.brooklyn.core.entity.lifecycle.Lifecycle;
import org.apache.brooklyn.core.entity.lifecycle.Lifecycle.Transition;
import org.apache.brooklyn.entity.database.mysql.MySqlNode;
import org.apache.brooklyn.entity.group.DynamicCluster;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;

public class oCampSensors extends BrooklynConfigKeys {
	public static final ConfigKey<EntitySpec<?>> MEMBER = DynamicCluster.MEMBER_SPEC;//ConfigKeys.newConfigKey(EntitySpec.class, "member", "the member of a dynamic cluster");
	
	
	public static final Sensor<Boolean> SERVICE_UP = Attributes.SERVICE_UP;
	public static final Sensor<Lifecycle> SERVICE_STATE = Attributes.SERVICE_STATE;
	public static final Sensor<Lifecycle> ACTUAL_SERVICE_STATE = Attributes.SERVICE_STATE_ACTUAL;
	public static final Sensor<Transition> EXPECTED_SERVICE_STATE = Attributes.SERVICE_STATE_EXPECTED;
	public static final Sensor<Boolean> SERVICE_ISRUNNING = SoftwareProcess.SERVICE_PROCESS_IS_RUNNING;
	
	public static final Sensor<MachineProvisioningLocation> LOCATION = SoftwareProcess.PROVISIONING_LOCATION;
	
	public static final Sensor<String> DOWNLOAD_URL = Attributes.DOWNLOAD_URL;
	public static final Sensor<Map<String,String>> DOWNLOAD_ADDON_URLS = Attributes.DOWNLOAD_ADDON_URLS;
	
	public static final Sensor<String> INSTALL_DIR = SoftwareProcess.INSTALL_DIR;
	public static final Sensor<String> EXPANDED_INSTALL_DIR = SoftwareProcess.EXPANDED_INSTALL_DIR;
	public static final Sensor<String> RUN_DIR = SoftwareProcess.RUN_DIR;
    //Sensor datastore.url=Sensor: datastore.url (java.lang.String);
    
	public static final Sensor<String> HOSTNAME = SoftwareProcess.HOSTNAME;  
	public static final Sensor<String> ADDRESS = SoftwareProcess.ADDRESS;
	public static final Sensor<String> SUBNET_HOSTNAME = SoftwareProcess.SUBNET_HOSTNAME; 
	public static final Sensor<String> SUBNET_ADDRESS = SoftwareProcess.SUBNET_ADDRESS;
	public static final Sensor<String> PID_FILE = SoftwareProcess.PID_FILE;
	
	public static final Sensor<String> MYSQL_PASSWORD = MySqlNode.PASSWORD;
	public static final Sensor<Integer> MYSQL_PORT = MySqlNode.MYSQL_PORT;
	public static final Sensor<String> MYSQL_SOCKET_UID = MySqlNode.SOCKET_UID;
	public static final Sensor<String> MYSQL_TEMPLATE_URL = MySqlNode.TEMPLATE_CONFIGURATION_URL;
	public static final Sensor<Double> MYSQL_QUERIES_PERSEC = MySqlNode.QUERIES_PER_SECOND_FROM_MYSQL;


}
