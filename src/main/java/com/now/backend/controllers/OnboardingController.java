package com.now.backend.controllers;

import com.now.backend.models.Onboarding;
import com.now.backend.models.OnboardingMetadata;
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
    public OnboardingMetadata getMetadata(){
        return this.onboardingService.getMetadata();
    }

    @PostMapping
    @Validated
    public Onboarding postOnboarding(@RequestBody Onboarding onboarding) {
        return OnboardingService.onboardingForm(onboarding);
    }
}
