package com.now.backend.services;

import com.now.backend.models.OpportunityDetailsDto;
import org.springframework.stereotype.Service;

@Service
public class OpportunityDetailsService {
    public OpportunityDetailsDto getOpportunityDetails(long id) {
        return new OpportunityDetailsDto(id, "john.doe@john.com", "Designer");
    }
    public OpportunityDetailsDto editOpportunityDetails( long id, OpportunityDetailsDto opportunityDetailsDto) {
        System.out.println("Edit chosen opportunity " + id);
        opportunityDetailsDto.setId(27L);
        opportunityDetailsDto.setTitle("Developer");
        opportunityDetailsDto.setEmail("john.doe@john.com");
        return opportunityDetailsDto;
    }
    public void deleteOpportunityDetails(long id) {
        System.out.println("Deleted " + id);
    }
}
