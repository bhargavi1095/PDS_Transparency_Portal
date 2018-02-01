package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aadhaar {
	public String getAadhaar_id() {
		return aadhaar_id;
	}
	public void setAadhaar_id(String aadhaar_id) {
		this.aadhaar_id = aadhaar_id;
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
	@Id
	String aadhaar_id;
	String first_name;
	String last_name;
	String mobile_no;
	String address;
	String district; 
	String city; 
	String state;
	String pincode;

}
