package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentListDto {
    private Long id;
    private String student;
    private String joinedOn;
    private String email;
    private String rate;
    private Integer completed;
    private Integer points;
}
