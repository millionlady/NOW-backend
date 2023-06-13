package com.now.backend.services;

import com.now.backend.data.OnboardingTest;
import com.now.backend.models.OnboardingDto;
import com.now.backend.models.OnboardingMetadataDto;
import com.now.backend.models.entities.Onboarding;
import com.now.backend.repositories.OnboardingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@RunWith(SpringRunner.class)
public class OnboardingServiceUnitTest {
    @MockBean
    private OnboardingRepository onboardingRepository;

    @TestConfiguration
    static class OnboardingServiceTestConfiguration {

        @Bean
        @Primary
        public OnboardingService onboardingService(OnboardingRepository onboardingRepository) {
            return new OnboardingService(onboardingRepository);
        }
    }

    @Autowired
    private OnboardingService onboardingService;

    @Test
    public void givenOnboarding_whenGetMetadata_thenListShouldBeFound() {
        // arrange
        Mockito.when(onboardingRepository.findDistinctUniversityYears())
                .thenReturn(List.of(2));
        Mockito.when(onboardingRepository.findDistinctOrganizations())
                .thenReturn(List.of("SSST"));

        // act
        OnboardingMetadataDto returnedList = onboardingService.getMetadata();

        // assert
        assertThat(returnedList.getUniversityYears()).isNotEmpty();
        assertThat(returnedList.getOrganizations()).isNotEmpty();
    }

    @Test
    public void givenOnboarding_whenGetMetadata_thenListShouldBeEmpty() {
        // act
        OnboardingMetadataDto returnedList = onboardingService.getMetadata();

        // assert
        assertThat(returnedList.getUniversityYears()).isEmpty();
        assertThat(returnedList.getOrganizations()).isEmpty();
    }

    @Test
    public void givenOnboarding_whenCreateOnboarding_thenOnboardingIsReturned() {
        // arrange
        OnboardingDto inputOnboardingDto = OnboardingTest.onboardingDto1();
        inputOnboardingDto.setId(0); // reset id
        Onboarding outputOnboarding = OnboardingTest.onboarding();

        Mockito.when(onboardingRepository.save(any(Onboarding.class))).thenReturn(outputOnboarding);

        // act
        OnboardingDto resultOnboarding = onboardingService.createOnboarding(inputOnboardingDto);

        // assert
        assertThat(resultOnboarding).isNotNull();
        assertThat(resultOnboarding.getUniversityYear()).isEqualTo(inputOnboardingDto.getUniversityYear());
        assertThat(resultOnboarding.getShortBio()).isEqualTo(inputOnboardingDto.getShortBio());
        assertThat(resultOnboarding.getCertificates()).isEqualTo(inputOnboardingDto.getCertificates());
        assertThat(resultOnboarding.getLinkedinUrl()).isEqualTo(inputOnboardingDto.getLinkedinUrl());
        assertThat(resultOnboarding.getGpa()).isEqualTo(inputOnboardingDto.getGpa());
        assertThat(resultOnboarding.getId()).isNotEqualTo(0);
    }

    @Test
    public void givenOnboarding_whenCreateOnboarding_thenRepositoryCalled() {
        // arrange
        OnboardingDto onboardingDto = OnboardingTest.onboardingDto3();

        Mockito.when(onboardingRepository.save(any(Onboarding.class)))
                .thenReturn(OnboardingTest.onboarding());

        // act
        onboardingService.createOnboarding(onboardingDto);

        // assert
        verify(onboardingRepository, times(1)).save(any(Onboarding.class));
    }
}
