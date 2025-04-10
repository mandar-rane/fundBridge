package com.mandar.fundbridge.config.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mandar.fundbridge.model.Employee;
import com.mandar.fundbridge.repository.EmployeeRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	TokenProvider tokenService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = this.recoverToken(request);
		System.out.println("RECOVERed TOKEN: " + token);

		if (token != null) {
			String login = tokenService.validateToken(token);
			Employee employee = employeeRepository.findByEmail(login);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(employee, null,
					employee.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			return null;
		}
		return authHeader.replace("Bearer ", "");
	}

}
