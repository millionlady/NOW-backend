package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.models.entities.Onboarding;
import com.now.backend.repositories.OnboardingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnboardingService {
    private final OnboardingRepository onboardingRepository;
    public OnboardingService(OnboardingRepository onboardingRepository) {
        this.onboardingRepository = onboardingRepository;
    }

    public OnboardingDto createOnboarding(OnboardingDto onboardingDto) {
        Onboarding onboarding = new Onboarding();
        onboarding.setUniversityYear(onboardingDto.getUniversityYear());
        onboarding.setOrganization(onboardingDto.getOrganization());
        onboarding.setShortBio(onboardingDto.getShortBio());
        onboarding.setCertificates(onboardingDto.getCertificates());
        onboarding.setLinkedinUrl(onboardingDto.getLinkedinUrl());
        onboarding.setGpa(onboardingDto.getGpa());
        onboarding.setUploadImage(onboardingDto.getUploadImage());

        onboardingRepository.save(onboarding);
        onboardingDto.setId(onboarding.getId());

        return onboardingDto;
    }

    public OnboardingMetadataDto getMetadata() {
        List<Integer> universityYearList = onboardingRepository.findDistinctUniversityYears();
        List<String> organizationList = onboardingRepository.findDistinctOrganizations();
        return new OnboardingMetadataDto(universityYearList, organizationList);
    }
}
