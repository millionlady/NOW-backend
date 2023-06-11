package com.now.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OpportunityDto {
    private Long id;
    private String title;
    private String description;
    private String requirements;
    private Date startDate;
    private Date endDate;
    private String coverImage;
}
