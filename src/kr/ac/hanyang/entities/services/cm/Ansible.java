package kr.ac.hanyang.entities.services.cm;

import org.apache.brooklyn.entity.cm.ansible.AnsibleEntityImpl;

public class Ansible extends AnsibleEntityImpl {
	
	public Ansible(){
		super();
	}
	
	public void init(){
		super.init();
	}
	
	public String ansibleCommand(String module, String args){
		return super.ansibleCommand(module, args);
	}
	
}
