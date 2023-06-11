package com.now.backend.repositories;

import com.now.backend.models.entities.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    List<Opportunity> findOpportunityById(Long id);
}
