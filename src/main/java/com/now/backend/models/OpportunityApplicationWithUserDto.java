package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor()
public class OpportunityApplicationWithUserDto {
    private OpportunityApplicationDto application;
    private UserDto user;
    private OnboardingDto onboarding;

}
