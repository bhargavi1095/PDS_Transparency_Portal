package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Allotment {


public String getAllocation_id() {
		return allocation_id;
	}
	public void setAllocation_id(String allocation_id) {
		this.allocation_id = allocation_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getWheat_stock() {
		return wheat_stock;
	}
	public void setWheat_stock(String wheat_stock) {
		this.wheat_stock = wheat_stock;
	}
	public String getRice_stock() {
		return rice_stock;
	}
	public void setRice_stock(String rice_stock) {
		this.rice_stock = rice_stock;
	}
	public String getOil_stock() {
		return oil_stock;
	}
	public void setOil_stock(String oil_stock) {
		this.oil_stock = oil_stock;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
@Id
String allocation_id;
String admin_id;
String depot_id;
String wheat_stock;
String rice_stock;
String oil_stock;
String Timestamp;

}
