package com.now.backend.service;

import com.now.backend.model.Onboarding;
import org.springframework.stereotype.Service;


@Service
public class OnboardingService {
    public static Onboarding onboardingForm(Onboarding onboarding) {
        onboarding.setId(1);
        onboarding.setUniversityYear(3);
        onboarding.setOrganization("SSST");
        onboarding.setShortBio("Highly skilled in software development.");
        onboarding.setCertificates("none");
        onboarding.setLinkedinUrl("https://ba.linkedin.com/in/adela-joldi%C4%87-a3655122a?original_referer=https%3A%2F%2Fwww.google.com%2F");
        onboarding.setGpa(3.8);
        onboarding.setUploadImage("https://img.freepik.com/free-vector/cartoon-graphic-design-landing-page_52683-70881.jpg?w=1060&t=st=1680367901~exp=1680368501~hmac=f52ac161f50201811f589776791e02c575033cf22f3ab5af0947436921bd0d47");
        return onboarding;
    }

}
