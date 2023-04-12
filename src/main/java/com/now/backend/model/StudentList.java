package com.now.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentList {
    private Integer id;
    private String student;
    private String joinedOn;
    private String email;
    private String rate;
    private Integer completed;
    private Integer points;
}
