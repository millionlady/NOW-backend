package com.now.backend.data;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.entities.Onboarding;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class OnboardingTest {
    private static int id1 = 1;
    private static int universityYear1 = 2;
    private static String organization1 = "SSST";
    private static String shortBio1 = "NoneUnitTest";
    private static String certificates1 = "NoneUnitTest";
    private static String linkedinUrl1 = "NoneUnitTest";
    private static double gpa1 = 3.2;
    private static String uploadImage1 = "https://none-unit-test";



    public static Onboarding onboarding() {
        Onboarding onboarding = new Onboarding();
        onboarding.setUniversityYear(universityYear1);
        onboarding.setOrganization(organization1);
        onboarding.setShortBio(shortBio1);
        onboarding.setCertificates(certificates1);
        onboarding.setLinkedinUrl(linkedinUrl1);
        onboarding.setGpa(gpa1);
        onboarding.setUploadImage(uploadImage1);

        return onboarding;
    }

    public static OnboardingDto onboardingDto1() {
        return new OnboardingDto(
                id1,
                universityYear1,
                organization1,
                shortBio1,
                certificates1,
                linkedinUrl1,
                gpa1,
                uploadImage1
        );
    }
    public static OnboardingDto onboardingDto3() {
        return new OnboardingDto(
                3,
                3,
                "TestOrg",
                "TestBio",
                "TestCer",
                "TestUrl",
                2.2,
                "https://unit-test-image"
        );
    }

}

