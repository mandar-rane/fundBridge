package com.mandar.fundbridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandar.fundbridge.model.Fundraiser;
import com.mandar.fundbridge.repository.FundraiserRepository;

@Service
public class FundraiserServiceImpl implements FundraiserService{
	
	private final FundraiserRepository fundraiserRepository;
	
	@Autowired
	public FundraiserServiceImpl(FundraiserRepository fundraiserRepository) {
		this.fundraiserRepository = fundraiserRepository;
	}
	
	
	@Override
	public Fundraiser createFundraiser(Fundraiser fundraiser) {
		// TODO Auto-generated method stub
		return fundraiserRepository.save(fundraiser);
	}

	@Override
	public Fundraiser getFundraiserById(Long fundraiserId) {
		// TODO Auto-generated method stub
		return fundraiserRepository.findById(fundraiserId).orElseThrow();
	}

	
	@Override
	public List<Fundraiser> getAllFundraisersByWorkerId(Long workerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fundraiser> getAllFundraisersByStatusByWorkerId(Long workerId, String status) {
		// TODO Auto-generated method stub
		return fundraiserRepository.getAllFundraisersByStatusByWorkerId(workerId, status);
	}

}
