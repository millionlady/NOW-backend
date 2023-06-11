package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MyApplicationDto {
    private OpportunityApplicationDto application;
    private OpportunityDto opportunity;
    private String organizationName;
}
