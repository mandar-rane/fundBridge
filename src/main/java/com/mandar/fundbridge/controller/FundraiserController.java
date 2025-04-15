package com.mandar.fundbridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mandar.fundbridge.model.Fundraiser;
import com.mandar.fundbridge.service.EmployeeService;
import com.mandar.fundbridge.service.FundraiserService;


@RestController
@RequestMapping("/api/fundraiser")
public class FundraiserController {
	
	private final FundraiserService fundraiserService;
	
	public FundraiserController(FundraiserService fundraiserService) {
		this.fundraiserService = fundraiserService;
	}
	
	
	@GetMapping("/get")
	public Fundraiser getFundraiserById(@RequestParam("id") Long id) {
		return fundraiserService.getFundraiserById(id);
	}
	
	@PostMapping("/createFundraiser")
	public Fundraiser createFundraiser(@RequestBody Fundraiser fundraiser) {
		return fundraiserService.createFundraiser(fundraiser);
	}
	
	@GetMapping("/getByWidAndStatus")
	public List<Fundraiser> getFundraiserByWorkerIdandStatus(@RequestParam("id") Long id, @RequestParam String status) {
		return fundraiserService.getAllFundraisersByStatusByWorkerId(id, status);
	}
	
	
	
	
	

}
