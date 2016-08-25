package kr.ac.hanyang.policy;

import java.util.ArrayList;
import java.util.List;

import org.apache.brooklyn.api.sensor.Sensor;
import org.apache.brooklyn.core.sensor.BasicSensor;

public class SensorSet {
	private String name;
	private List<Sensor> sensors;
	
	public static class Builder{
		private String name;
		private List<Sensor> sensors;
		
		public Builder(String name){
			this.name = name;
			sensors = new ArrayList<Sensor>();
		}
		
		public Builder addSensor(Sensor BasicSensor){
			this.sensors.add(BasicSensor);
			return this;
		}
		
		public SensorSet build(){
			return new SensorSet(this);
		}
	}
	
	private SensorSet(Builder builder){
		this.name = builder.name;
		this.sensors = builder.sensors;
	}
	
	public void addSensor(Sensor BasicSensor){
		this.sensors.add(BasicSensor);
	}
	
	public String getName(){ return name;}
	
	public boolean contains(Sensor sensor){
		return sensors.contains(sensor);
	}
		
	public boolean isEmpty(){
		return sensors.size() == 0;
	}
	
	
	public String toString(){
		String toReturn = "";
		for (Sensor Sensor: sensors){
			toReturn += Sensor.toString()+"\n";
		}
		return this.name+"\n"+toReturn;		
	}
	
}
