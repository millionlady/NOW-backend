package com.now.backend.controllers;

import com.now.backend.models.AuthResponse;
import com.now.backend.models.LoginDto;
import com.now.backend.models.RegisterDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.services.AuthService;
import com.now.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtTokenUtil;

    AuthController(AuthService authService, JwtUtil jwtTokenUtil){
        this.authService = authService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto loginDto) {
        User user = this.authService.login(loginDto);
        final String jwt = jwtTokenUtil.generateToken(loginDto.getEmail());
        return ResponseEntity.ok(new AuthResponse(jwt, user));
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterDto registerDto) {
        return this.authService.register(registerDto);
    }
}
