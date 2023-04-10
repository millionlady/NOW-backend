package com.now.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Opportunity {
    private int id;
    private String title;
    private String description;
    private String image;


}
