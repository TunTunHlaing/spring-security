package com.demo.security.first_demo.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import io.jsonwebtoken.*;


@Component
public class JwtUtils {
    private static final String SECRET_KEY = "EEpREZYpHHzF/T67ETJSnCRkV10tlukq3w0nqHdQTHSn1VajLMWNWQcmW/wgB1BQ+h+jtxCRLAXB61zVQYWh4A=="; // Change to a secure key
    private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 30 minutes

    private final SecretKey key = getKey(SECRET_KEY);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private SecretKey getKey(String key) {
        return new SecretKeySpec(Base64.getDecoder().decode(key), "HmacSHA512");
    }
}

