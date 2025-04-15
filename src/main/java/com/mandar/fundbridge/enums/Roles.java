
package com.mandar.fundbridge.enums;

import com.mandar.fundbridge.model.Worker;

public enum Roles {
	
	ADMIN("adminEmployee"),
	USER("userEmployee"),
	WORKER("worker");
	
	private String role;
	
	Roles(String role){
		this.role = role;
	}
	
	public String getValue() {
		return role;
	}

}
