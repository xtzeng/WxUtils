package com.xt.weixin.common.vo;


public class WaiterPositionVO {

	/** */
	private static final long serialVersionUID = 1L;

	private String departmentId;
	
	private String status;
	
	private String loginEmployeeId;
	
	private String rowBusinessDate;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginEmployeeId() {
		return loginEmployeeId;
	}

	public void setLoginEmployeeId(String loginEmployeeId) {
		this.loginEmployeeId = loginEmployeeId;
	}

	public String getRowBusinessDate() {
		return rowBusinessDate;
	}

	public void setRowBusinessDate(String rowBusinessDate) {
		this.rowBusinessDate = rowBusinessDate;
	}
	
}
