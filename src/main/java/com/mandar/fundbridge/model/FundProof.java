package com.mandar.fundbridge.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fund_proofs")
public class FundProof {
	
	private Long id;
	
	private String fileUrl;
	
	private String documentType;
	
	private LocalDateTime uploadedAt = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "fundraiser_id")
	private Fundraiser fundraiser;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public Fundraiser getFundraiser() {
		return fundraiser;
	}

	public void setFundraiser(Fundraiser fundraiser) {
		this.fundraiser = fundraiser;
	}

}
