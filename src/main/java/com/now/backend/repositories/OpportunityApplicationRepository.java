package com.now.backend.repositories;

import com.now.backend.models.entities.OpportunityApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityApplicationRepository extends JpaRepository<OpportunityApplication, Long> { }
