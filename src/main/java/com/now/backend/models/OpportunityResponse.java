package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityResponse {
    private OpportunityDto opportunityDto;
    private List<OpportunityApplicationWithUserDto> applications;
    private OpportunityApplicationDto myApplication;
    private UserDto organization;
}
