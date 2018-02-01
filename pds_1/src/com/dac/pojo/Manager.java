package com.dac.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {

	@Id
	String manager_id;
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_first_name() {
		return manager_first_name;
	}
	public void setManager_first_name(String manager_first_name) {
		this.manager_first_name = manager_first_name;
	}
	public String getManager_last_name() {
		return manager_last_name;
	}
	public void setManager_last_name(String manager_last_name) {
		this.manager_last_name = manager_last_name;
	}
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	public String getManager_password() {
		return manager_password;
	}
	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}
	public String getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(String depot_id) {
		this.depot_id = depot_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	String manager_first_name;
	String manager_last_name;
	String manager_phone;
	String manager_email;
	String manager_password;
	String depot_id;
	String admin_id;
	
}
