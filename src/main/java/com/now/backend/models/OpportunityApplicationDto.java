package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OpportunityApplicationDto {
    private Long id;
    private Long userId;
    private Long opportunityId;
    private String additionalInfo;
}
