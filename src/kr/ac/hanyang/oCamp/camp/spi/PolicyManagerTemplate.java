/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kr.ac.hanyang.oCamp.camp.spi;

import org.apache.brooklyn.camp.spi.AbstractResource;
import org.apache.brooklyn.camp.spi.ApplicationComponent;
import org.apache.brooklyn.camp.spi.ApplicationComponentTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate;
import org.apache.brooklyn.camp.spi.PlatformComponent;
import org.apache.brooklyn.camp.spi.PlatformComponentTemplate;
import org.apache.brooklyn.camp.spi.AssemblyTemplate.Builder;
import org.apache.brooklyn.camp.spi.collection.BasicResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup;
import org.apache.brooklyn.camp.spi.collection.ResourceLookup.EmptyResourceLookup;
import org.apache.brooklyn.camp.spi.instantiate.AssemblyTemplateInstantiator;

import com.google.common.base.Preconditions;


/** Holds the metadata (name, description, etc) for a PCT
 * as well as fields pointing to behaviour (eg creation of PlatformComponent).
 * <p>
 * See {@link AbstractResource} for more general information.
 */
public class PolicyManagerTemplate extends AssemblyTemplate {
	public static final String CAMP_TYPE = "PolicyManagerTemplate";
    static { assert CAMP_TYPE.equals(PolicyManagerTemplate.class.getSimpleName()); }
    
    Class<? extends AssemblyTemplateInstantiator> instantiator;
    ResourceLookup<ApplicationComponentTemplate> applicationComponentTemplates;
    ResourceLookup<PlatformComponentTemplate> platformComponentTemplates;
    ResourceLookup<PolicyManagerTemplate> policyManagerTemplates;
    
    // TODO
//    "parameterDefinitionUri": URI,
//    "pdpUri" : URI ?
                    
    /** Use {@link #builder()} to create */
    protected PolicyManagerTemplate() {}

    public Class<? extends AssemblyTemplateInstantiator> getInstantiator() {
        return instantiator;
    }
    public ResourceLookup<ApplicationComponentTemplate> getApplicationComponentTemplates() {
        return applicationComponentTemplates != null ? applicationComponentTemplates : new EmptyResourceLookup<ApplicationComponentTemplate>();
    }
    public ResourceLookup<PlatformComponentTemplate> getPlatformComponentTemplates() {
        return platformComponentTemplates != null ? platformComponentTemplates : new EmptyResourceLookup<PlatformComponentTemplate>();
    }
    public ResourceLookup<PolicyManagerTemplate> getPolicyManagerTemplates() {
        return policyManagerTemplates != null ? policyManagerTemplates : new EmptyResourceLookup<PolicyManagerTemplate>();
    }
    
    private void setInstantiator(Class<? extends AssemblyTemplateInstantiator> instantiator) {
        this.instantiator = instantiator;
    }
    private void setApplicationComponentTemplates(ResourceLookup<ApplicationComponentTemplate> applicationComponentTemplates) {
        this.applicationComponentTemplates = applicationComponentTemplates;
    }
    private void setPlatformComponentTemplates(ResourceLookup<PlatformComponentTemplate> platformComponentTemplates) {
        this.platformComponentTemplates = platformComponentTemplates;
    }
    private void setPolicyManagerTemplates(ResourceLookup<PolicyManagerTemplate> policyManagerTemplates) {
        this.policyManagerTemplates = policyManagerTemplates;
    }
    
    // builder
    public static Builder<? extends PolicyManagerTemplate> templateBuilder() {
        return new PolicyManagerTemplate().new Builder<PolicyManagerTemplate>(CAMP_TYPE);
    }
    
    public class Builder<T extends PolicyManagerTemplate> extends AbstractResource.Builder<T,Builder<T>> {
        
        protected Builder(String type) { super(type); }
        
        public Builder<T> instantiator(Class<? extends AssemblyTemplateInstantiator> x) { PolicyManagerTemplate.this.setInstantiator(x); return thisBuilder(); }
        public Builder<T> applicationComponentTemplates(ResourceLookup<ApplicationComponentTemplate> x) { PolicyManagerTemplate.this.setApplicationComponentTemplates(x); return thisBuilder(); }
        public Builder<T> platformComponentTemplates(ResourceLookup<PlatformComponentTemplate> x) { PolicyManagerTemplate.this.setPlatformComponentTemplates(x); return thisBuilder(); }
        public Builder<T> policyManagerTemplates(ResourceLookup<PolicyManagerTemplate> x) { PolicyManagerTemplate.this.setPolicyManagerTemplates(x); return thisBuilder(); }

        /** allows callers to see the partially formed instance when needed, for example to query instantiators;
         *  could be replaced by specific methods as and when that is preferred */
        @SuppressWarnings("unchecked")
        public T peek() { return (T) PolicyManagerTemplate.this; }
        
        public synchronized Builder<T> add(ApplicationComponentTemplate x) {
            if (PolicyManagerTemplate.this.applicationComponentTemplates==null) {
            	PolicyManagerTemplate.this.applicationComponentTemplates = new BasicResourceLookup<ApplicationComponentTemplate>();
            }
            if (!(PolicyManagerTemplate.this.applicationComponentTemplates instanceof BasicResourceLookup)) {
                throw new IllegalStateException("Cannot add to resource lookup "+PolicyManagerTemplate.this.applicationComponentTemplates);
            }
            ((BasicResourceLookup<ApplicationComponentTemplate>)PolicyManagerTemplate.this.applicationComponentTemplates).add(x);
            return thisBuilder();
        }
        
        public synchronized Builder<T> add(PlatformComponentTemplate x) {
            if (PolicyManagerTemplate.this.platformComponentTemplates==null) {
            	PolicyManagerTemplate.this.platformComponentTemplates = new BasicResourceLookup<PlatformComponentTemplate>();
            }
            if (!(PolicyManagerTemplate.this.platformComponentTemplates instanceof BasicResourceLookup)) {
                throw new IllegalStateException("Cannot add to resource lookup "+PolicyManagerTemplate.this.platformComponentTemplates);
            }
            ((BasicResourceLookup<PlatformComponentTemplate>)PolicyManagerTemplate.this.platformComponentTemplates).add(x);
            return thisBuilder();
        }
        
        public synchronized Builder<T> add(PolicyManagerTemplate x) {
            if (PolicyManagerTemplate.this.policyManagerTemplates==null) {
            	PolicyManagerTemplate.this.policyManagerTemplates = new BasicResourceLookup<PolicyManagerTemplate>();
            }
            if (!(PolicyManagerTemplate.this.policyManagerTemplates instanceof BasicResourceLookup)) {
                throw new IllegalStateException("Cannot add to resource lookup "+PolicyManagerTemplate.this.policyManagerTemplates);
            }
            ((BasicResourceLookup<PolicyManagerTemplate>)PolicyManagerTemplate.this.policyManagerTemplates).add(x);
            return thisBuilder();
        }
        
        @Override
        public synchronized T build() {
            Preconditions.checkNotNull(PolicyManagerTemplate.this.instantiator);
            return super.build();
        }
    }

}
