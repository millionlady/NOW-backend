package com.now.backend.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class LoginDto {
    private String email;
    private String password;
}
