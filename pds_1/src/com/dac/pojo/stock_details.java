package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class stock_details {

	@Id
	String stock_id;
	String depot_id;
	String timestamp;
	String oil_stock;
	String rice_stock;
	String wheat_stock;
	String admin_id;
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getOil_stock() {
		return oil_stock;
	}
	public void setOil_stock(String oil_stock) {
		this.oil_stock = oil_stock;
	}
	public String getRice_stock() {
		return rice_stock;
	}
	public void setRice_stock(String rice_stock) {
		this.rice_stock = rice_stock;
	}
	public String getWheat_stock() {
		return wheat_stock;
	}
	public void setWheat_stock(String wheat_stock) {
		this.wheat_stock = wheat_stock;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
}
