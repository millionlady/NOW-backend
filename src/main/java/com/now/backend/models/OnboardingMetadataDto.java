package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OnboardingMetadataDto {
    private List<Integer> universityYears;
    private List<String> organizations;
}
