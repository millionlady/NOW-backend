package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OnboardingService {
    public static OnboardingDto onboardingForm(OnboardingDto onboardingDto) {
        
       /* onboardingDto.setId(1);
        onboardingDto.setUniversityYear(3);
        onboardingDto.setOrganization("SSST");
        onboardingDto.setShortBio("Highly skilled in software development.");
        onboardingDto.setCertificates("none");
        onboardingDto.setLinkedinUrl("https://ba.linkedin.com/in/adela-joldi%C4%87-a3655122a?original_referer=https%3A%2F%2Fwww.google.com%2F");
        onboardingDto.setGpa(3.8);
        onboardingDto.setUploadImage("https://img.freepik.com/free-vector/cartoon-graphic-design-landing-page_52683-70881.jpg?w=1060&t=st=1680367901~exp=1680368501~hmac=f52ac161f50201811f589776791e02c575033cf22f3ab5af0947436921bd0d47");
*/
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
