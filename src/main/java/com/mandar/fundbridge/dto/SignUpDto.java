package com.mandar.fundbridge.dto;

import com.mandar.fundbridge.enums.Roles;
import com.mandar.fundbridge.model.Employee;

public record SignUpDto(
		Long employeeId,
	    String email,
	    String password,
	    Roles role) {
	}
