package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PDS_USERS {

@Id
String pds_id;
String aadhaar_id;
String ration_id;
String mobile_no;
String category;
String user_status;
String depot_id;
String manager_id;
public String getPds_id() {
	return pds_id;
}
public void setPds_id(String pds_id) {
	this.pds_id = pds_id;
}
public String getAadhaar_id() {
	return aadhaar_id;
}
public void setAadhaar_id(String aadhaar_id) {
	this.aadhaar_id = aadhaar_id;
}
public String getRation_id() {
	return ration_id;
}
public void setRation_id(String ration_id) {
	this.ration_id = ration_id;
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
public String getUser_status() {
	return user_status;
}
public void setUser_status(String user_status) {
	this.user_status = user_status;
}
public String getDepot_id() {
	return depot_id;
}
public void setDepot_id(String depot_id) {
	this.depot_id = depot_id;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
}
