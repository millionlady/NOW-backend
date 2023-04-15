package com.now.backend.services;

import com.now.backend.models.LoginDto;
import com.now.backend.models.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private String email;
    private String password;

    public String login(LoginDto loginDto) {

        if(this.email.equals(loginDto.getEmail()) && this.password.equals(loginDto.getPassword()) ){
            return "Login success";
        } else {
            return "Login failed, invalid credentials";
        }
    }

    public String register(RegisterDto registerDto) {
        this.email = registerDto.getEmail();
        this.password = registerDto.getPassword();

        return "Register success";
    }
}
