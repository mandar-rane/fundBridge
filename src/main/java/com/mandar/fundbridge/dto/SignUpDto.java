package com.mandar.fundbridge.dto;

import com.mandar.fundbridge.enums.EmployeeRole;
import com.mandar.fundbridge.model.Employee;

public record SignUpDto(
		Long employeeId,
	    String email,
	    String password,
	    EmployeeRole role) {
	}
