package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.models.entities.Onboarding;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.OnboardingRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public OnboardingDto getOnboardingByUserId(Long userId) {
        Onboarding onboarding = getEntityByUserId(userId);
        return toDto(onboarding);
    }


    public OnboardingMetadataDto getMetadata() {
        List<Integer> universityYearList = onboardingRepository.findDistinctUniversityYears();
        List<String> organizationList = onboardingRepository.findDistinctOrganizations();
        return new OnboardingMetadataDto(universityYearList, organizationList);
    }

    private static OnboardingDto toDto(Onboarding onboarding) {
        return new OnboardingDto(onboarding.getId(),
                onboarding.getUserId(),
                onboarding.getUniversityYear(),
                onboarding.getUniversityName(),
                onboarding.getShortBio(),
                onboarding.getCertificates(),
                onboarding.getLinkedinUrl(),
                onboarding.getGpa(),
                onboarding.getProfileImage());
    }

    @NotNull
    private static Onboarding toEntity(OnboardingDto onboardingDto) {
        Onboarding onboarding = new Onboarding();
        onboarding.setUserId(onboardingDto.getUserId());
        onboarding.setUniversityYear(onboardingDto.getUniversityYear());
        onboarding.setUniversityName(onboardingDto.getUniversityName());
        onboarding.setShortBio(onboardingDto.getShortBio());
        onboarding.setCertificates(onboardingDto.getCertificates());
        onboarding.setLinkedinUrl(onboardingDto.getLinkedinUrl());
        onboarding.setGpa(onboardingDto.getGpa());
        onboarding.setProfileImage(onboardingDto.getProfileImage());
        return onboarding;
    }


    private Onboarding getEntityByUserId(long id){
        Optional<Onboarding> onboarding = onboardingRepository.findOneByUserId(id);
        if(onboarding.isPresent()){
            return onboarding.get();
        }
        throw new RuntimeException("Onboarding with id:" + id + " does not exist!");
    }
}
