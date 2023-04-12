package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterDto {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
}