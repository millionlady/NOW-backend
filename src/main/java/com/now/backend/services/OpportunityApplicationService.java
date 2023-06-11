package com.now.backend.services;

import com.now.backend.models.OpportunityApplicationDto;
import com.now.backend.models.entities.OpportunityApplication;
import com.now.backend.repositories.OpportunityApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpportunityApplicationService {

    private final OpportunityApplicationRepository opportunityApplicationRepository;

    public OpportunityApplicationService(OpportunityApplicationRepository opportunityApplicationRepository) {
        this.opportunityApplicationRepository = opportunityApplicationRepository;
    }

    public OpportunityApplicationDto createApplication(OpportunityApplicationDto opportunityApplicationDto) {
        OpportunityApplication application = new OpportunityApplication();

        application.setOpportunityId(opportunityApplicationDto.getOpportunityId());

        application.setUserId(opportunityApplicationDto.getUserId());

        application.setAdditionalInfo(opportunityApplicationDto.getAdditionalInfo());

        opportunityApplicationRepository.save(application);

        return toDto(application);
    }

    private static OpportunityApplicationDto toDto(OpportunityApplication opportunityApplication){
        return new OpportunityApplicationDto(opportunityApplication.getId(),opportunityApplication.getUserId(), opportunityApplication.getOpportunityId(), opportunityApplication.getAdditionalInfo());
    }

    private static OpportunityApplication toEntity(OpportunityApplicationDto opportunityApplicationDto){
        return new OpportunityApplication(opportunityApplicationDto.getId(),opportunityApplicationDto.getUserId(), opportunityApplicationDto.getOpportunityId(), opportunityApplicationDto.getAdditionalInfo());
    }

    private OpportunityApplication getEntity(long id){
        Optional<OpportunityApplication> opportunityApplicationOptional = opportunityApplicationRepository.findById(id);
        if(opportunityApplicationOptional.isPresent()){
            return opportunityApplicationOptional.get();
        }
        throw new RuntimeException("Opportunity Application with id:" + id + " does not exist!");
    }
}
