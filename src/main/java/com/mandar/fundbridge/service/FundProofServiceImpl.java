package com.mandar.fundbridge.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mandar.fundbridge.model.FundProof;
import com.mandar.fundbridge.repository.DonationRepository;
import com.mandar.fundbridge.repository.FundProofRepository;

public class FundProofServiceImpl implements FundProofService{
	
	private final FundProofRepository fundProofRepository;

	@Autowired
	public FundProofServiceImpl(FundProofRepository fundProofRepository) {
		this.fundProofRepository = fundProofRepository;
	}

	@Override
	public FundProof saveFundProof(FundProof fundProof) {
		// TODO Auto-generated method stub
		return fundProofRepository.save(fundProof);
	}

}
