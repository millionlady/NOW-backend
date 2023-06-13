package com.now.backend.services;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.repositories.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public OpportunityDto createOpportunity(OpportunityDto opportunity) {
        Opportunity newOpportunity = new Opportunity();

        if(opportunity.getId() != null){
            Optional<Opportunity> opportunityOptional = opportunityRepository.findById(opportunity.getId());
            if(opportunityOptional.isPresent()){
                newOpportunity = opportunityOptional.get();
            }
        } else {
            opportunity.setCreatedAt(new Date());
        }

        newOpportunity.setOrganizationId(opportunity.getOrganizationId());
        newOpportunity.setTitle(opportunity.getTitle());
        newOpportunity.setDescription(opportunity.getDescription());
        newOpportunity.setRequirements(opportunity.getRequirements());
        newOpportunity.setImage(opportunity.getCoverImage());
        newOpportunity.setCreatedAt(opportunity.getCreatedAt());
        newOpportunity = opportunityRepository.save(newOpportunity);

        opportunity.setId(newOpportunity.getId());
        
        return opportunity;
    }

    public List<OpportunityDto> getOpportunity() {
        List<OpportunityDto> opportunityList = new ArrayList<>();
        List<Opportunity> opportunities = opportunityRepository.findAll();
        for (Opportunity opportunity : opportunities) {
            opportunityList.add(toDto(opportunity));
        }
        return opportunityList;
    }

    public List<OpportunityDto> getOpportunityByOrgId(Long orgId) {
        List<OpportunityDto> opportunityList = new ArrayList<>();
        List<Opportunity> opportunities = opportunityRepository.findAllByOrganizationId(orgId);
        for (Opportunity opportunity : opportunities) {
            opportunityList.add(toDto(opportunity));
        }
        return opportunityList;
    }

    public OpportunityDto getOpportunityId(long id) {
        Opportunity opportunity = getEntity(id);
        return toDto(opportunity);
    }

    private static OpportunityDto toDto(Opportunity opportunity){
        return new OpportunityDto(opportunity.getId(), opportunity.getOrganizationId(), opportunity.getTitle(), opportunity.getDescription(),opportunity.getRequirements(), opportunity.getImage(), opportunity.getCreatedAt());
    }

    private static Opportunity toEntity(OpportunityDto opportunityDto){
        return new Opportunity(opportunityDto.getId(), opportunityDto.getOrganizationId(), opportunityDto.getTitle(), opportunityDto.getDescription(),opportunityDto.getRequirements(), opportunityDto.getCoverImage(), opportunityDto.getCreatedAt());
    }

    private Opportunity getEntity(long id){
        Optional<Opportunity> opportunityOptional = opportunityRepository.findById(id);
        if(opportunityOptional.isPresent()){
            return opportunityOptional.get();
        }
        throw new RuntimeException("Opportunity with id:" + id + " does not exist!");
    }
}
