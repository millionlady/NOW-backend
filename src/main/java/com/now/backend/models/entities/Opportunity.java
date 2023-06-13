package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "opportunities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "organization_id")
    private Long organizationId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "image")
    private String image;
    @Column(name = "created_at")
    private Date createdAt;
}
