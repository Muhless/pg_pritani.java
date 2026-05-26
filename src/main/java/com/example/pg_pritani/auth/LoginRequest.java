package com.example.pg_pritani.auth;

import jakarta.persistence.*;

public class LoginRequest {
    public String username;
    public String password;

    public String getUsername(){return username;}
    public String  getPassword(){return password;}

    @Entity
    @Table(name = "user")
    public static class User {

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;

         @Column(unique = true, nullable = true)
         private String username;

         @Column(nullable = false)
         private String password;

         @Column(nullable = false)
         private String role;

         public User() {
         }

         public Long getId() {
              return id;
         }

         public String getUsername() {
              return username;
         }

         public String getPassword() {
              return password;
         }

         public String getRole() {
              return role;
         }

         public void setUsername(String username) {
              this.username = username;
         }

         public void setPassword(String password) {
              this.password = password;
         }

         public void setRole(String role) {
              this.role = role;
         }

    }
}
