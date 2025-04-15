package com.mandar.fundbridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mandar.fundbridge.model.Fundraiser;

public interface FundraiserRepository extends JpaRepository<Fundraiser, Long>{

	@Query("SELECT f from Fundraiser f WHERE f.worker = ?1 AND f.status = ?2")
	List<Fundraiser> getAllFundraisersByStatusByWorkerId(@Param("workerId") Long workerId, @Param("status") String status);
	
}

