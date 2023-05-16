package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my-works")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opportunity")

    private String opportunity;
    @Column(name = "organization")

    private String organization;
    @Column(name = "dateCreated")

    private String dateCreated;
    @Column(name = "pts")

    private int pts;
    @Column(name = "status")

    private String status;
}
