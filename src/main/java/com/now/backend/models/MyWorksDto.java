package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class MyWorksDto {
    private String opportunity;
    private String organization;
    private String dateCreated;
    private int pts;
    private String status;
}
