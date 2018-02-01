package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrator {

	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_first_name() {
		return admin_first_name;
	}
	public void setAdmin_first_name(String admin_first_name) {
		this.admin_first_name = admin_first_name;
	}
	public String getAdmin_last_name() {
		return admin_last_name;
	}
	public void setAdmin_last_name(String admin_last_name) {
		this.admin_last_name = admin_last_name;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	@Id
	String admin_id;
	String admin_first_name;
	String admin_last_name;
	String admin_phone;
	String admin_email;
	String admin_password;
	
	
}
