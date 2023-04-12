package com.now.backend.controllers;


import com.now.backend.models.LoginDto;
import com.now.backend.models.RegisterDto;
import com.now.backend.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return this.authService.login(loginDto);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto) {
        return this.authService.register(registerDto);
    }


}
