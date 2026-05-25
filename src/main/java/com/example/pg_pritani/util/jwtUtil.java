package com.example.pg_pritani.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtUtil {
     private final String SECRET = "cee4d198c3d748980f7ffb3454ee374cb6f9bde1ff125202caf4399f505bdbbe";
     private final long EXPIRATION = 86400000;

     private Key getKey() {
          return Keys.hmacShaKeyFor(SECRET.getBytes());
     }

     public String generateToken(String username, String role) {
          return Jwts.builder()
                    .subject(username)
                    .claim("role", role)
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .signWith(getKey())
                    .compact();
     }

     public String extractUsername(String token) {
          return getClaims(token).getSubject();
     }

     public String extractRole(String token) {
          return getClaims(token).get("role", String.class);
     }

     public boolean isValid(String token) {
          try {
               getClaims(token);
               return true;
          } catch (JwtException e) {
               return false;
          }
     }

     private Claims getClaims(String token) {
          return Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
     }
}
