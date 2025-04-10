package com.mandar.fundbridge.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.mandar.fundbridge.model.Donation;

public interface DonationService{
	
	Donation getDonation(Long id);
	
	List<Donation> getAllDonations();
	
	List<Donation> getAllDonationsByDateRange(LocalDateTime from, LocalDateTime to);
	
	Donation createDonation(Donation donation);
}
