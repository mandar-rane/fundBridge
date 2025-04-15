package com.mandar.fundbridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mandar.fundbridge.dto.SignUpDto;
import com.mandar.fundbridge.dto.WorkerSignUpDto;
import com.mandar.fundbridge.enums.Roles;
import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.model.Worker;
import com.mandar.fundbridge.repository.EmployeeRepository;
import com.mandar.fundbridge.repository.WorkerRepository;

@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	WorkerRepository workerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String email = username;
		return repository.findByEmail(email);
	}
	
	
	public UserDetails signUp(SignUpDto data) throws Exception {
		if(repository.findByEmail(data.email()) != null) {
			throw new Exception("User by this email already exists");
		}
		
		if(repository.findById(data.employeeId()) != null) {
			throw new Exception("User by this employee id already exists");
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
			
		Employee newEmployee = new Employee(data.employeeId() ,data.email(), encryptedPassword, data.role());
		return repository.save(newEmployee);	
	}
	
	
	
	public UserDetails workerSignUp(WorkerSignUpDto data) throws Exception{
		if(workerRepository.findByMobile(data.mobile()) != null) {
			throw new Exception("User by this mobile number already exists");
		}
		
		if(workerRepository.findById(data.workerId()) != null) {
			throw new Exception("User by this employee id already exists");
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		
		Worker newWorker = new Worker(data.workerId(), data.mobile(), encryptedPassword, data.role());
		
		return workerRepository.save(newWorker);
	}
	
}
