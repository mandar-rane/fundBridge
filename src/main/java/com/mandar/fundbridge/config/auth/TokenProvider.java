package com.mandar.fundbridge.config.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mandar.fundbridge.model.Employee;

@Service
public class TokenProvider {
	@Value("${jwt.secret}")
	private String JWT_SECRET;

	public String generateAccessToken(Employee employee) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
			return JWT.create().withSubject(employee.getUsername()).withClaim("email", employee.getUsername())
					.withExpiresAt(genAccessExpirationDate()).sign(algorithm);
		} catch (JWTCreationException exception) {
			// TODO: handle exception
			throw new JWTCreationException("Error while generating token", exception);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
			return JWT.require(algorithm).build().verify(token).getSubject();

		} catch (JWTVerificationException exception) {
			throw new JWTVerificationException("Error while validating token", exception);
		}
	}

	private Instant genAccessExpirationDate() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
