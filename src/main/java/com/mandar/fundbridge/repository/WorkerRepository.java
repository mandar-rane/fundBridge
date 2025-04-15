package com.mandar.fundbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	Worker findByMobile(String mobile);
}
