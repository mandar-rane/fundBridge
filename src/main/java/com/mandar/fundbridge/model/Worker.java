package com.mandar.fundbridge.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mandar.fundbridge.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "workers")
public class Worker implements UserDetails{
    @Id
    private Long workerId;

    public Worker(Long workerId, String mobile, String password, Roles role) {
		super();
		this.workerId = workerId;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}

	@Column(unique = true)
    private String mobile;
    
    private String password;
    


	private Roles role;
    
    private String name;
    

	private String jobTitle; // e.g. "Janitor", "Security"

    

    private String employeeId;

    private boolean isVerified = false;

    private String aadhaarNumber;
    
    
    
    
    @OneToMany(mappedBy = "worker")
    private List<Fundraiser> fundraisers;
    
    public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

    public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Fundraiser> getFundraisers() {
		return fundraisers;
	}

	public void setFundraisers(List<Fundraiser> fundraisers) {
		this.fundraisers = fundraisers;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("ROLE_WORKER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return mobile;
	}
}
