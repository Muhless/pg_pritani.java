package com.example.pg_pritani.auth;

import com.example.pg_pritani.util.JwtUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse register(RegisterRequest request) {
        LoginRequest.User user = new LoginRequest.User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole()!= null ? request.getRole() : "USER");
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
                return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request){
        LoginRequest.User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("user not found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("invalid password");
        }
        String token;
        token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token);
    }

    @Repository
    public static interface UserRepository extends JpaRepository<LoginRequest.User,Long> {
         Optional<LoginRequest.User> findByUsername(String username);
    }
}