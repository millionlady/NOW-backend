package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LandingDto {
    private long id;
    private String orgName;
    private String title;
    private String description;

}
