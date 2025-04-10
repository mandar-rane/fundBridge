package com.mandar.fundbridge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandar.fundbridge.model.Donation;
import com.mandar.fundbridge.service.DonationService;

@RestController
@RequestMapping("/api/donations")
public class DonationController {
	
	private final DonationService donationService;
	
	public DonationController(DonationService donationService) {
		this.donationService = donationService;
	}
	
	@GetMapping("/getAllDonations")
	public List<Donation> getAllDonations(){
		return donationService.getAllDonations();
	}
	
	@PostMapping("/createDonation")
	public Donation createDonation(@RequestBody Donation donation) {		
		System.out.println(donation.toString());
		return donationService.createDonation(donation);
	}
}
