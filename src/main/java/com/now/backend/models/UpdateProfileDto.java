package com.now.backend.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@AllArgsConstructor
@Validated
public class UpdateProfileDto {
    private String password;
    private int universityYear;
    private String shortBio;
    private String certificates;
    private String profileImage;
}
