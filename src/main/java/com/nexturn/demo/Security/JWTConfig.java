package com.nexturn.demo.Security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class JWTConfig {
	
	    @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiration}")
	    private long expiration;

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + expiration))
	                .signWith(SignatureAlgorithm.HS256, secret)
	                .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	    }
	}



