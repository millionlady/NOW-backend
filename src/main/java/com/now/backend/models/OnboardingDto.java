package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@Validated
public class OnboardingDto {
    private int id;
    private int universityYear;
    @NotNull
    private String organization;
    @NotNull
    private String shortBio;
    @NotNull
    private String certificates;
    @NotNull
    private String linkedinUrl;
    private double gpa;
    @NotNull
    private String uploadImage;
}
