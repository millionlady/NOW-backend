package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.models.entities.Onboarding;
import com.now.backend.repositories.OnboardingRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
        // Save the new Onboarding object to the database
        onboardingRepository.save(onboarding);

        // Set the id of the DTO to the id of the saved Onboarding object
        onboardingDto.setId(onboarding.getId());

        // Return the DTO with the new id
        return onboardingDto;
    }

    public OnboardingMetadataDto getMetadata() {
        List<Integer> universityYearList = new ArrayList<Integer>();
        List<String> organizationList = new ArrayList<String>();
        OnboardingMetadataDto metadata = new OnboardingMetadataDto(universityYearList, organizationList);

        universityYearList.add(1);
        universityYearList.add(2);
        universityYearList.add(3);
        universityYearList.add(4);

        organizationList.add("SSST");
        organizationList.add("MOP");
        organizationList.add("IUS");
        organizationList.add("IBU");

        metadata.setUniversityYears(universityYearList);
        metadata.setOrganizations(organizationList);

        return metadata;
    }
}
