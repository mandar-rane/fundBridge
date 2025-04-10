package com.mandar.fundbridge.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fundraisers")
public class Fundraiser {	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private Double goalAmount;

    private Double collectedAmount = 0.0;

    private String status; // "PENDING", "APPROVED", "REJECTED", "COMPLETED"

    private LocalDateTime createdAt = LocalDateTime.now();

    private String category;
    
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @OneToMany(mappedBy = "fundraiser", cascade = CascadeType.ALL)
    private List<Donation> donations;
    
    @OneToMany(mappedBy = "fundraiser", cascade = CascadeType.ALL)
    private List<FundProof> proofs;
    
    
}
