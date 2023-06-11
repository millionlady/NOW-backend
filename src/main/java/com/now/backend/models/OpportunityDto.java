package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityDto {
    private Long id;
    private Long organizationId;
    private String title;
    private String description;
    private String coverImage;
}
