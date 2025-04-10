
package com.mandar.fundbridge.enums;

public enum EmployeeRole {
	
	ADMIN("adminEmployee"),
	USER("userEmployee");
	
	private String role;
	
	EmployeeRole(String role){
		this.role = role;
	}
	
	public String getValue() {
		return role;
	}

}
