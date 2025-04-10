package com.mandar.fundbridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
