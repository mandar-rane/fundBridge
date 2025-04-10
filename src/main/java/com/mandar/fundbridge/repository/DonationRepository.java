package com.mandar.fundbridge.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mandar.fundbridge.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{
	
	@Query("SELECT d FROM Donation d WHERE d.donatedAt >= :from AND d.donatedAt <= :to")
    List<Donation> findAllDonationByDateRange(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
