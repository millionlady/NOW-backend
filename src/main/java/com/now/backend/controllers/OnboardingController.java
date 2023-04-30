package com.now.backend.controllers;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.services.OnboardingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/onboarding")
@RestController

public class OnboardingController {
    private final OnboardingService onboardingService;

    public OnboardingController(OnboardingService onboardingService){
        this.onboardingService = onboardingService;
    }

    @GetMapping
    public OnboardingMetadataDto getMetadata(){
        return this.onboardingService.getMetadata();
    }

    @PostMapping
    @Validated
    public OnboardingDto postOnboarding(@RequestBody OnboardingDto onboardingDto) {
        return OnboardingService.onboardingForm(onboardingDto);
    }
}
