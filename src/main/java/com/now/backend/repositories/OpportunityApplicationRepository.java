package com.now.backend.repositories;

import com.now.backend.models.entities.OpportunityApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpportunityApplicationRepository extends JpaRepository<OpportunityApplication, Long> {

    List<OpportunityApplication> findAllByOpportunityId(Long opportunityId);
    List<OpportunityApplication> findAllByUserId(Long userId);
    OpportunityApplication findByUserIdAndOpportunityId(Long userId, Long opportunityId);


}
