package com.mandar.fundbridge.dto;

import com.mandar.fundbridge.enums.Roles;

public record WorkerSignUpDto(
		Long workerId,
	    String mobile,
	    String password,
	    Roles role) {
	}
