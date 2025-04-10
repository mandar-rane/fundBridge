package com.mandar.fundbridge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/get")
	public Employee getEmployee(@RequestParam("id") Long employeeId) {
		System.out.println("GET EMP HIT");
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Success";
	}
	
}
