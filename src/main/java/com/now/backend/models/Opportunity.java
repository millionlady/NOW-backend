package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Opportunity {
    private Integer id;
    private String title;
    private String description;
    private String image;
}
