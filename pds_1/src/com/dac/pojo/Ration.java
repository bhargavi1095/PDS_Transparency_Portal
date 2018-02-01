package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ration {
	@Id
	String ration_id;
	String first_name;
	String last_name;
	String mobile_no;
	String category;
	String depot_id;
	public String getRation_id() {
		return ration_id;
	}
	public void setRation_id(String ration_id) {
		this.ration_id = ration_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	String address;
	String district; 
	String city;
	String state;
	String pincode;
}
