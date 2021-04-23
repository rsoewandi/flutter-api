package com.flutter.api.request;

import io.swagger.annotations.ApiModelProperty;

public class AddMstaffRequest {
	@ApiModelProperty(name = "ID Staff" ,example = "staff001")
	private String staffid;
	@ApiModelProperty(name = "Password" ,example = "p@ssw0rd")
	private String password;
	@ApiModelProperty(name = "Staff Name" ,example = "Fachri Aulawy")
	private String staffname;

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
}