package kr.ac.hanyang.oCamp.core.mgmt;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.config.MapConfigKey;
import org.apache.brooklyn.core.entity.Attributes;
import org.apache.brooklyn.core.entity.BrooklynConfigKeys;
import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.core.sensor.AttributeSensorAndConfigKey;
import org.apache.brooklyn.core.sensor.BasicAttributeSensorAndConfigKey;
import org.apache.brooklyn.core.sensor.BasicAttributeSensorAndConfigKey.StringAttributeSensorAndConfigKey;
import org.apache.brooklyn.core.sensor.PortAttributeSensorAndConfigKey;
import org.apache.brooklyn.entity.database.mysql.MySqlNode;
import org.apache.brooklyn.entity.group.DynamicCluster;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.entity.software.base.SoftwareProcessDriverLifecycleEffectorTasks;
import org.apache.brooklyn.entity.software.base.SoftwareProcess.ChildStartableMode;
import org.apache.brooklyn.util.collections.MutableMap;
import org.apache.brooklyn.util.core.flags.SetFromFlag;
import org.apache.brooklyn.util.time.Duration;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

import kr.ac.hanyang.oCamp.entities.requirements.DeployOn;
import kr.ac.hanyang.oCamp.entities.services.BasicOCampService;

public class oCampConfigKeys extends BrooklynConfigKeys {
	public static final ConfigKey<EntitySpec<?>> MEMBER = DynamicCluster.MEMBER_SPEC;//ConfigKeys.newConfigKey(EntitySpec.class, "member", "the member of a dynamic cluster");
	public static final BasicAttributeSensorAndConfigKey<Map<String,String>> DOWNLOAD__ADDON_URLS = Attributes.DOWNLOAD_ADDON_URLS;
	public static final PortAttributeSensorAndConfigKey HTTP_PORT = Attributes.HTTP_PORT;
	public static final PortAttributeSensorAndConfigKey HTTPS_PORT = Attributes.HTTPS_PORT;
	public static final PortAttributeSensorAndConfigKey SSH_PORT =  Attributes.SSH_PORT;
	public static final PortAttributeSensorAndConfigKey SMTP_PORT = Attributes.SMTP_PORT;
	public static final PortAttributeSensorAndConfigKey DNS_PORT = Attributes.DNS_PORT;
	public static final PortAttributeSensorAndConfigKey AMQP_PORT = Attributes.AMQP_PORT;
	public static final PortAttributeSensorAndConfigKey MYSQL_PORT = MySqlNode.MYSQL_PORT;
	public static final StringAttributeSensorAndConfigKey MYSQL_PASSWORD = MySqlNode.PASSWORD;
	
	public static final ConfigKey<String> TARGET  = DeployOn.TARGET;
	
	public static final ConfigKey<String> VERSION = SoftwareProcess.SUGGESTED_VERSION;
	
	public static final ConfigKey<Object> LOCATIONS = BasicOCampService.LOCATIONS;
	
	public static final ConfigKey<Collection<Integer>> REQUIRED_OPEN_LOGIN_PORTS = SoftwareProcess.REQUIRED_OPEN_LOGIN_PORTS;

	public static final ConfigKey<String> INBOUND_PORTS_CONFIG_REGEX = SoftwareProcess.INBOUND_PORTS_CONFIG_REGEX;

	public static final ConfigKey<Boolean> INBOUND_PORTS_AUTO_INFER = SoftwareProcess.INBOUND_PORTS_AUTO_INFER;


	public static final ConfigKey<Duration> START_TIMEOUT = BrooklynConfigKeys.START_TIMEOUT;

    @SetFromFlag("startLatch")
    public static final ConfigKey<Boolean> START_LATCH = BrooklynConfigKeys.START_LATCH;

    @SetFromFlag("setupLatch")
    public static final ConfigKey<Boolean> SETUP_LATCH = BrooklynConfigKeys.SETUP_LATCH;

    @SetFromFlag("installResourcesLatch")
    public static final ConfigKey<Boolean> INSTALL_RESOURCES_LATCH = BrooklynConfigKeys.INSTALL_RESOURCES_LATCH;

    @SetFromFlag("installLatch")
    public static final ConfigKey<Boolean> INSTALL_LATCH = BrooklynConfigKeys.INSTALL_LATCH;

    @SetFromFlag("runtimeResourcesLatch")
    public static final ConfigKey<Boolean> RUNTIME_RESOURCES_LATCH = BrooklynConfigKeys.RUNTIME_RESOURCES_LATCH;

    @SetFromFlag("customizeLatch")
    public static final ConfigKey<Boolean> CUSTOMIZE_LATCH = BrooklynConfigKeys.CUSTOMIZE_LATCH;

    @SetFromFlag("launchLatch")
    public static final ConfigKey<Boolean> LAUNCH_LATCH = BrooklynConfigKeys.LAUNCH_LATCH;

    @SetFromFlag("skipStart")
    public static final ConfigKey<Boolean> ENTITY_STARTED = BrooklynConfigKeys.SKIP_ENTITY_START;

    @SetFromFlag("skipStartIfRunning")
    public static final ConfigKey<Boolean> SKIP_ENTITY_START_IF_RUNNING = BrooklynConfigKeys.SKIP_ENTITY_START_IF_RUNNING;

    @SetFromFlag("skipInstall")
    public static final ConfigKey<Boolean> SKIP_INSTALLATION = BrooklynConfigKeys.SKIP_ENTITY_INSTALLATION;

    @SetFromFlag("preInstallCommand")
    public static final ConfigKey<String> PRE_INSTALL_COMMAND = BrooklynConfigKeys.PRE_INSTALL_COMMAND;

    @SetFromFlag("postInstallCommand")
    public static final ConfigKey<String> POST_INSTALL_COMMAND = BrooklynConfigKeys.POST_INSTALL_COMMAND;

    @SetFromFlag("preCustomizeCommand")
    public static final ConfigKey<String> PRE_CUSTOMIZE_COMMAND = BrooklynConfigKeys.PRE_CUSTOMIZE_COMMAND;

    @SetFromFlag("postCustomizeCommand")
    public static final ConfigKey<String> POST_CUSTOMIZE_COMMAND = BrooklynConfigKeys.POST_CUSTOMIZE_COMMAND;

    @SetFromFlag("preLaunchCommand")
    public static final ConfigKey<String> PRE_LAUNCH_COMMAND = BrooklynConfigKeys.PRE_LAUNCH_COMMAND;

    @SetFromFlag("postLaunchCommand")
    public static final ConfigKey<String> POST_LAUNCH_COMMAND = BrooklynConfigKeys.POST_LAUNCH_COMMAND;

    @SetFromFlag("env")
    public static final MapConfigKey<Object> SHELL_ENVIRONMENT = BrooklynConfigKeys.SHELL_ENVIRONMENT;

    @SetFromFlag("version")
    public static final ConfigKey<String> SUGGESTED_VERSION = BrooklynConfigKeys.SUGGESTED_VERSION;

    @SetFromFlag("downloadUrl")
    public static final AttributeSensorAndConfigKey<String,String> DOWNLOAD_URL = Attributes.DOWNLOAD_URL;

    @SetFromFlag("downloadAddonUrls")
    public static final AttributeSensorAndConfigKey<Map<String,String>,Map<String,String>> DOWNLOAD_ADDON_URLS = Attributes.DOWNLOAD_ADDON_URLS;

    @SetFromFlag("archiveNameFormat")
    public static final ConfigKey<String> ARCHIVE_DIRECTORY_NAME_FORMAT = SoftwareProcess.ARCHIVE_DIRECTORY_NAME_FORMAT;

    @SetFromFlag("installLabel")
    public static final ConfigKey<String> INSTALL_UNIQUE_LABEL = BrooklynConfigKeys.INSTALL_UNIQUE_LABEL;

    @SetFromFlag("expandedInstallDir")
    public static final AttributeSensorAndConfigKey<String,String> EXPANDED_INSTALL_DIR = BrooklynConfigKeys.EXPANDED_INSTALL_DIR;

    @SetFromFlag("installDir")
    public static final AttributeSensorAndConfigKey<String,String> INSTALL_DIR = BrooklynConfigKeys.INSTALL_DIR;

    @SetFromFlag("runDir")
    public static final AttributeSensorAndConfigKey<String,String> RUN_DIR = BrooklynConfigKeys.RUN_DIR;

    public static final ConfigKey<Boolean> OPEN_IPTABLES = SoftwareProcess.OPEN_IPTABLES;

    public static final ConfigKey<Boolean> STOP_IPTABLES = SoftwareProcess.STOP_IPTABLES;

    public static final ConfigKey<Boolean> DONT_REQUIRE_TTY_FOR_SUDO = SoftwareProcess.DONT_REQUIRE_TTY_FOR_SUDO;

    public static final ConfigKey<Map<String, String>> PRE_INSTALL_FILES = SoftwareProcess.PRE_INSTALL_FILES;

    public static final ConfigKey<Map<String, String>> PRE_INSTALL_TEMPLATES = SoftwareProcess.PRE_INSTALL_TEMPLATES;
    
    public static final ConfigKey<Map<String, String>> INSTALL_FILES = SoftwareProcess.INSTALL_FILES;

    public static final ConfigKey<Map<String, String>> INSTALL_TEMPLATES = SoftwareProcess.INSTALL_TEMPLATES;

    public static final ConfigKey<Map<String, String>> RUNTIME_FILES = SoftwareProcess.RUNTIME_FILES;

    public static final ConfigKey<Map<String, String>> RUNTIME_TEMPLATES = SoftwareProcess.RUNTIME_TEMPLATES;

    public static final MapConfigKey<Object> PROVISIONING_PROPERTIES = SoftwareProcess.PROVISIONING_PROPERTIES;

    public static final ConfigKey<Duration> MAXIMUM_REBIND_SENSOR_CONNECT_DELAY = SoftwareProcess.MAXIMUM_REBIND_SENSOR_CONNECT_DELAY;

    public static final ConfigKey<SoftwareProcessDriverLifecycleEffectorTasks> LIFECYCLE_EFFECTOR_TASKS = SoftwareProcess.LIFECYCLE_EFFECTOR_TASKS;

    public static final ConfigKey<Boolean> RETRIEVE_USAGE_METRICS = SoftwareProcess.RETRIEVE_USAGE_METRICS;

    public static final ConfigKey<ChildStartableMode> CHILDREN_STARTABLE_MODE = SoftwareProcess.CHILDREN_STARTABLE_MODE;
	
	
}
