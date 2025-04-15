package com.mandar.fundbridge.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mandar.fundbridge.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee implements UserDetails{
	@Id
	private Long id;

	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Roles role; //EMPLOYEE, ADMIN
	
	private String password;
		
	public Employee() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Roles getRole() {
		return role;
	}

	public List<Donation> getDonations() {
		return donations;
	}
	

	public Employee(Long employeeId, String  email,  String password, Roles role) {
		super();
		this.id = employeeId;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	@OneToMany(mappedBy = "donor")
	private List<Donation> donations;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(this.role == Roles.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}	
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
}
