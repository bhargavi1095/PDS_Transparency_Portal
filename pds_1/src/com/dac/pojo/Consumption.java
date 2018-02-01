package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Consumption {

	@Id
	String consumption_id;
	String depot_id;
	String wheat_consumption;
	String rice_consumption;
	String oil_consumption;
	String Timestamp;
	public String getConsumption_id() {
		return consumption_id;
	}
	public void setConsumption_id(String consumption_id) {
		this.consumption_id = consumption_id;
	}
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getWheat_consumption() {
		return wheat_consumption;
	}
	public void setWheat_consumption(String wheat_consumption) {
		this.wheat_consumption = wheat_consumption;
	}
	public String getRice_consumption() {
		return rice_consumption;
	}
	public void setRice_consumption(String rice_consumption) {
		this.rice_consumption = rice_consumption;
	}
	public String getOil_consumption() {
		return oil_consumption;
	}
	public void setOil_consumption(String oil_consumption) {
		this.oil_consumption = oil_consumption;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	
}
