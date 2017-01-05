package kr.ac.hanyang.oCamp.core.mgmt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.brooklyn.api.effector.Effector;
import org.apache.brooklyn.api.effector.ParameterType;
import org.apache.brooklyn.api.entity.EntityType;
import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.objs.BrooklynTypeSnapshot;
import org.apache.brooklyn.util.guava.Maybe;

import com.google.api.client.repackaged.com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class OCampEntityTypeSnapshot extends BrooklynTypeSnapshot implements OCampEntityType{
private static final long serialVersionUID = 4670930188951106009L;
    
    private final Map<String, Sensor<?>> sensors;
    private final Set<Effector<?>> effectors;
    private final Set<Sensor<?>> sensorsSet;

    public OCampEntityTypeSnapshot(String name, Map<String, ConfigKey<?>> configKeys, Map<String, Sensor<?>> sensors, Collection<Effector<?>> effectors) {
        super(name, configKeys);
        this.sensors = ImmutableMap.copyOf(sensors);
        this.effectors = ImmutableSet.copyOf(effectors);
        this.sensorsSet = ImmutableSet.copyOf(this.sensors.values());
    }
    
    public OCampEntityTypeSnapshot(EntityType entity) {
        super(entity.getName(), entity.getConfigKeys().stream().collect(Collectors.toMap(ConfigKey<?>::getName, p -> p)));
        this.sensors = ImmutableMap.copyOf(entity.getSensors().stream().collect(Collectors.toMap(Sensor<?>::getName, p -> p)));
        this.effectors = ImmutableSet.copyOf(entity.getEffectors());
        this.sensorsSet = ImmutableSet.copyOf(entity.getSensors());
    }

    @Override
    public Set<Sensor<?>> getSensors() {
        return sensorsSet;
    }
    
    @Override
    public Set<Effector<?>> getEffectors() {
        return effectors;
    }

    @Override
    public Maybe<Effector<?>> getEffectorByName(String name) {
        for (Effector<?> contender : effectors) {
            if (name.equals(contender.getName()))
                return Maybe.<Effector<?>>of(contender);
        }
        return Maybe.<Effector<?>>absent("No effector matching '"+name+"'");        
    }
    
    @Override
    public Effector<?> getEffector(String name, Class<?>... parameterTypes) {
        // TODO Could index for more efficient lookup (e.g. by name in a MultiMap, or using name+parameterTypes as a key)
        // TODO Looks for exact match; could go for what would be valid to call (i.e. if parameterType is sub-class of ParameterType.getParameterClass then ok)
        // TODO Could take into account ParameterType.getDefaultValue() for what can be omitted
        
        effectorLoop : for (Effector<?> contender : effectors) {
            if (name.equals(contender.getName())) {
                List<ParameterType<?>> contenderParameters = contender.getParameters();
                if (parameterTypes.length == contenderParameters.size()) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] != contenderParameters.get(i).getParameterClass()) {
                            continue effectorLoop;
                        }
                    }
                    return contender;
                }
            }
        }
        throw new NoSuchElementException("No matching effector "+name+"("+Joiner.on(", ").join(parameterTypes)+") on entity "+getName());
    }

    @Override
    public Sensor<?> getSensor(String name) {
        return sensors.get(name);
    }

    @Override
    public boolean hasSensor(String name) {
        return sensors.containsKey(name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), sensors, effectors);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OCampEntityTypeSnapshot)) return false;
        OCampEntityTypeSnapshot o = (OCampEntityTypeSnapshot) obj;
        return super.getName().equals(o.getName());
        //return super.equals(obj) && Objects.equal(sensors, o.sensors) && Objects.equal(effectors, o.effectors);
    }
    
    @Override
    protected ToStringHelper toStringHelper() {
        return super.toStringHelper()
                .add("sensors", sensors)
                .add("effectors", effectors);
    }

	@Override
	public int compareTo(Object obj) {
		if(obj == null) throw new NullPointerException();
		if (obj.getClass() != getClass()) throw new ClassCastException();
		OCampEntityTypeSnapshot entity = (OCampEntityTypeSnapshot) obj;
		return this.getName().compareTo(entity.getName());
	}
}
