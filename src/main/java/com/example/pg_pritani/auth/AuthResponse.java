package com.example.pg_pritani.auth;

public class AuthResponse {
     public String token;

     public AuthResponse(String token) {
          this.token = token;
     }

     public String getToken() {
          return token;
     }
}
