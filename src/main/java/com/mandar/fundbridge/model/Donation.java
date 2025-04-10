package com.mandar.fundbridge.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donation")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	private LocalDateTime donatedAt = LocalDateTime.now();
	
	private boolean isAnonymous;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee donor;
	
	@ManyToOne
	@JoinColumn(name=  "fundraiser_id")
	private Fundraiser fundraiser;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDonatedAt() {
		return donatedAt;
	}

	public void setDonatedAt(LocalDateTime donatedAt) {
		this.donatedAt = donatedAt;
	}

	public boolean isAnonymous() {
		return isAnonymous;
	}

	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public Employee getDonor() {
		return donor;
	}

	public void setDonor(Employee donor) {
		this.donor = donor;
	}

	public Fundraiser getFundraiser() {
		return fundraiser;
	}

	public void setFundraiser(Fundraiser fundraiser) {
		this.fundraiser = fundraiser;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", amount=" + amount + ", isAnonymous=" + isAnonymous + ", donor=" + donor + "]";
	}
 	
}
