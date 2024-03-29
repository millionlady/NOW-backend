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
    private Integer id;
    private Long userId;
    private Integer universityYear;
    @NotNull
    private String universityName;
    @NotNull
    private String shortBio;
    @NotNull
    private String certificates;
    @NotNull
    private String linkedinUrl;
    private Double gpa;
    @NotNull
    private String profileImage;
}
