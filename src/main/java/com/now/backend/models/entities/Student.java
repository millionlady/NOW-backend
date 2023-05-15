package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studentList")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student")
    private String student;
    @Column(name = "joinedOn")
    private String joinedOn;
    @Column(name = "email")
    private String email;
    @Column(name = "rate")
    private String rate;
    @Column(name = "completed")
    private Integer completed;
    @Column(name = "points")
    private Integer points;
}
