package com.now.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "opportunity_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpportunityApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "opportunity_id")
    private Long opportunityId;

    @Column(name = "additional_info")
    private String additionalInfo;
}
