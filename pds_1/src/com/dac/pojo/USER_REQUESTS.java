package com.dac.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class USER_REQUESTS {
	@Id
	String request_id;
	String aadhaar_id;
	String pds_id;
	String ration_id;
	String category;
	String Timestamp;
	String verify_request;
	String allocated;
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getAadhaar_id() {
		return aadhaar_id;
	}
	public void setAadhaar_id(String aadhaar_id) {
		this.aadhaar_id = aadhaar_id;
	}
	public String getPds_id() {
		return pds_id;
	}
	public void setPds_id(String pds_id) {
		this.pds_id = pds_id;
	}
	public String getRation_id() {
		return ration_id;
	}
	public void setRation_id(String ration_id) {
		this.ration_id = ration_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getVerify_request() {
		return verify_request;
	}
	public void setVerify_request(String verify_request) {
		this.verify_request = verify_request;
	}
	public String getAllocated() {
		return allocated;
	}
	public void setAllocated(String allocated) {
		this.allocated = allocated;
	} 
}
