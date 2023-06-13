package com.now.backend.controllers;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.repositories.OnboardingRepository;
import com.now.backend.services.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/onboarding")
@RestController

public class OnboardingController {
    private final OnboardingService onboardingService;

    @Autowired
    public OnboardingController(OnboardingService onboardingService, OnboardingRepository onboardingRepository) {
        this.onboardingService = onboardingService;
    }

    @GetMapping
    public OnboardingMetadataDto getMetadata(){
        return this.onboardingService.getMetadata();
    }

    @PostMapping
    @Validated
    public OnboardingDto postOnboarding(@RequestBody OnboardingDto onboardingDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());
        onboardingDto.setUserId(id);

        return onboardingService.createOnboarding(onboardingDto);
    }
}
