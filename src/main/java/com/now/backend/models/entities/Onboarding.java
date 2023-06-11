package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "onboarding")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Onboarding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "university_year")
    private Integer universityYear;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "short_bio")
    private String shortBio;

    @Column(name = "certificates")
    private String certificates;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "profile_img")
    private String profileImage;

}

