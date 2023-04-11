package com.now.backend.controller;

import com.now.backend.model.Onboarding;
import com.now.backend.service.OnboardingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/onboarding")
@RestController

public class OnboardingController {
    private final OnboardingService onboardingService;

    public OnboardingController(OnboardingService onboardingService){
        this.onboardingService = onboardingService;
    }

    @PostMapping
    public Onboarding postOnboarding(@Validated @RequestBody Onboarding onboarding) {
        return OnboardingService.onboardingForm(onboarding);
    }
}
