package com.mandar.fundbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mandar.fundbridge.model.Fundraiser;



public interface FundraiserService {

	public Fundraiser createFundraiser(Fundraiser fundraiser);
	
	public Fundraiser getFundraiserById(Long fundraiserId);
	
	public List<Fundraiser> getAllFundraisersByWorkerId(Long workerId);
	
	public List<Fundraiser> getAllFundraisersByStatusByWorkerId(Long workerId, String status);
	
}
