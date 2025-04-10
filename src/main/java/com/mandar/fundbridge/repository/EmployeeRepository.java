package com.mandar.fundbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandar.fundbridge.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByEmail(String email);
}
