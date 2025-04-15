
package com.mandar.fundbridge.controller;

import java.awt.CardLayout;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandar.fundbridge.config.auth.TokenProvider;
import com.mandar.fundbridge.dto.JwtDto;
import com.mandar.fundbridge.dto.SignInDto;
import com.mandar.fundbridge.dto.SignUpDto;
import com.mandar.fundbridge.dto.WorkerSignInDto;
import com.mandar.fundbridge.dto.WorkerSignUpDto;
import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.model.Worker;
import com.mandar.fundbridge.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthService service;

	@Autowired
	private TokenProvider tokenService;

	@PostMapping("/employee/signup")
	public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
		System.out.println("TRYING SIGN UP");
		try {
			service.signUp(data);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SignUp Failed: " + e.getMessage());
		}
	}

	@PostMapping("/employee/signin")
	public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
		System.out.println("TRYING SIGN IN");
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),
				data.password());

		Authentication authUser = authenticationManager.authenticate(usernamePassword);
		
		String accessToken = tokenService.generateAccessToken((Employee) authUser.getPrincipal());

		return ResponseEntity.ok(new JwtDto(accessToken));
	}
	
	@PostMapping("/worker/signup")
	public ResponseEntity<?> workerSignUp(@RequestBody @Valid WorkerSignUpDto data) {
		System.out.println("TRYING SIGN UP");
		try {
			service.signUp(data);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SignUp Failed: " + e.getMessage());
		}
	}

	@PostMapping("/worker/signin")
	public ResponseEntity<JwtDto> workerSignIn(@RequestBody @Valid WorkerSignInDto data) {
		System.out.println("TRYING SIGN IN");
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.mobile(),
				data.password());

		Authentication authUser = authenticationManager.authenticate(usernamePassword);
		
		String accessToken = tokenService.generateAccessToken((Worker) authUser.getPrincipal());

		return ResponseEntity.ok(new JwtDto(accessToken));
	}
	

}
