package com.mandar.fundbridge.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    private Long workerId;

    private String name;

    private String jobTitle; // e.g. "Janitor", "Security"

    private String mobile;

    private String employeeId;

    private boolean isVerified = false;

    private String aadhaarNumber;
    
    @OneToMany(mappedBy = "worker")
    private List<Fundraiser> fundraisers;
}
