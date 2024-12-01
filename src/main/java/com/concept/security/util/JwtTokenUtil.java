package com.concept.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "mysecretkey";  // You should keep this key secure, e.g., in environment variables

    private static final long EXPIRATION_TIME = 86400000L;  // 24 hours in milliseconds

    // Generate JWT Token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();  // Extract the username from authentication

        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Token expiration time
                .sign(Algorithm.HMAC512(SECRET_KEY));  // Signing the token with the secret key
    }

    // Validate JWT Token (to be used in the filter)
    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC512(SECRET_KEY))
                .build()
                .verify(token);  // Verifies the token
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract username from JWT token
    public String getUsernameFromToken(String token) {
        return JWT.require(Algorithm.HMAC512(SECRET_KEY))
                .build()
                .verify(token)
                .getSubject();  // Extracts the username from the token
    }
}
