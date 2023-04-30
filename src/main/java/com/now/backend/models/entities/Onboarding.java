package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Entity
@Table(name = "onboarding")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Onboarding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "universityYear")
    private int universityYear;

    @Column(name = "organization")
    @NotNull
    private String organization;

    @Column(name = "shortBio")
    @NotNull
    private String shortBio;

    @Column(name = "certificates")
    @NotNull
    private String certificates;

    @Column(name = "linkedinUrl")
    @NotNull
    private String linkedinUrl;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "uploadImage")
    @NotNull
    private String uploadImage;
}
