package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id; 

@Entity
public class Depot {
	
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getDepot_name() {
		return depot_name;
	}
	public void setDepot_name(String depot_name) {
		this.depot_name = depot_name;
	}
	public String getDepot_district() {
		return district;
	}
	public void setDepot_district(String depot_district) {
		this.district = depot_district;
	}
	public String getDepot_city() {
		return city;
	}
	public void setDepot_city(String depot_city) {
		this.city = depot_city;
	}
	public String getDepot_state() {
		return state;
	}
	public void setDepot_state(String depot_state) {
		this.state = depot_state;
	}
	@Id 
	String depot_id;
	String depot_name;
	String district;
	String city;
	String state;
}
