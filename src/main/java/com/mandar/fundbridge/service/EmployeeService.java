package com.mandar.fundbridge.service;

import java.util.List;

import com.mandar.fundbridge.model.Donation;
import com.mandar.fundbridge.model.Employee;

public interface EmployeeService {
	Employee getEmployee(Long id);
	List<Employee> getAllEmployees();
}
