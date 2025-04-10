package com.mandar.fundbridge.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandar.fundbridge.model.Donation;
import com.mandar.fundbridge.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

	private final DonationRepository donationRepository;

	@Autowired
	public DonationServiceImpl(DonationRepository donationRepository) {
		this.donationRepository = donationRepository;
	}

	@Override
	public Donation getDonation(Long id) {
		// TODO Auto-generated method stub
		return donationRepository.findById(id).orElseThrow(() -> new RuntimeException("Donation not found"));
	}

	@Override
	public List<Donation> getAllDonations() {
		// TODO Auto-generated method stub
		return donationRepository.findAll();
	}

	@Override
	public List<Donation> getAllDonationsByDateRange(LocalDateTime from, LocalDateTime to) {
		// TODO Auto-generated method stub
		return donationRepository.findAllDonationByDateRange(from, to);
	}

	@Override
	public Donation createDonation(Donation donation) {
		// TODO Auto-generated method stub
		return donationRepository.save(donation);
	}

}
