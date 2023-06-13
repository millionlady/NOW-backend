package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityDto {
    private Long id;
    private Long organizationId;
    private String title;
    private String description;
    private String requirements;
    private String coverImage;
    private Date createdAt;
}
