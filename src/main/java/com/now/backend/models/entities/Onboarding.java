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

    @Column(name = "university_year")
    private Integer universityYear;

    @Column(name = "organization")
    private String organization;

    @Column(name = "short_bio")
    private String shortBio;

    @Column(name = "certificates")
    private String certificates;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "upload_image")
    private String uploadImage;

    @Entity
    @Table(name = "users")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "full_name", nullable = false)
        private String fullName;

        @Column(name = "phoneNumber", nullable = false)
        private String phoneNumber;

        @Column(name = "email", unique = true, nullable = false)
        private String email;
        private String password;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "onboarding_id", referencedColumnName = "id")
        private Onboarding onboarding;
    }
}

