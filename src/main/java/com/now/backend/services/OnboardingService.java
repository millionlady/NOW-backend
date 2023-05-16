package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.models.entities.Onboarding;
import com.now.backend.repositories.OnboardingRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnboardingService {
    private final OnboardingRepository onboardingRepository;
    public OnboardingService(OnboardingRepository onboardingRepository) {
        this.onboardingRepository = onboardingRepository;
    }

    public OnboardingDto createOnboarding(OnboardingDto onboardingDto) {
        Onboarding entity = toEntity(onboardingDto);
        Onboarding onboarding = onboardingRepository.save(entity);

        onboardingDto.setId(entity.getId());

        return toDto(onboarding);
    }



    public OnboardingMetadataDto getMetadata() {
        List<Integer> universityYearList = onboardingRepository.findDistinctUniversityYears();
        List<String> organizationList = onboardingRepository.findDistinctOrganizations();
        return new OnboardingMetadataDto(universityYearList, organizationList);
    }

    private static OnboardingDto toDto(Onboarding onboarding) {
        if (onboarding == null) {
            return null; // Or throw an exception, depending on your requirements
        }

        return new OnboardingDto(onboarding.getId(),
                onboarding.getUniversityYear(),
                onboarding.getOrganization(),
                onboarding.getShortBio(),
                onboarding.getCertificates(),
                onboarding.getLinkedinUrl(),
                onboarding.getGpa(),
                onboarding.getUploadImage());
    }
    @NotNull
    private static Onboarding toEntity(OnboardingDto onboardingDto) {
        Onboarding onboarding = new Onboarding();
        onboarding.setUniversityYear(onboardingDto.getUniversityYear());
        onboarding.setOrganization(onboardingDto.getOrganization());
        onboarding.setShortBio(onboardingDto.getShortBio());
        onboarding.setCertificates(onboardingDto.getCertificates());
        onboarding.setLinkedinUrl(onboardingDto.getLinkedinUrl());
        onboarding.setGpa(onboardingDto.getGpa());
        onboarding.setUploadImage(onboardingDto.getUploadImage());
        return onboarding;
    }
}
