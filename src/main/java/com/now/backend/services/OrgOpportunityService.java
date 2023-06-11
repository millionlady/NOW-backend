package com.now.backend.services;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.repositories.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrgOpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OrgOpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public OpportunityDto createOpportunity(OpportunityDto opportunityDto) {
        Opportunity entity = toEntity(opportunityDto);
        Opportunity opportunity = opportunityRepository.save(entity);

        return toDto(opportunity);
    }
    public List<OpportunityDto> getOpportunity() {
        List<Opportunity> opportunities = opportunityRepository.findAll();
        List<OpportunityDto> result = new ArrayList<>();
        for (Opportunity opportunity : opportunities) {
            OpportunityDto dto = toDto(opportunity);
            result.add(dto);
        }
        return result;
    }
//    public List<OpportunityDto> getOpportunity() {
//        List<OpportunityDto> opportunityList = new ArrayList<>();
//        List<Opportunity> opportunities = opportunityRepository.findAll();
//        for (Opportunity opportunity : opportunities) {
//            opportunityList.add(new OpportunityDto(opportunity.getId(),opportunity.getTitle(), opportunity.getDescription(), opportunity.getImage()));
//        }
//
//        return opportunityList;
//    }


//    public OpportunityDto getOpportunityId(long id) {
//        opportunityRepository.getById(id);
//        return new OpportunityDto();
//    }

    public OpportunityDto getOpportunityId(long id) {
        return toDto(getEntity(id));
    }

    private Opportunity getEntity(long id) {
        Optional<Opportunity> opportunityOptional = opportunityRepository.findById(id);
        if (opportunityOptional.isPresent()) {
            return opportunityOptional.get();
        }

        throw new RuntimeException("Opportunity with id:" + id + " does not exist!");
    }

    private static OpportunityDto toDto(Opportunity opportunity) {
        OpportunityDto dto = new OpportunityDto();
        dto.setId(opportunity.getId());
        dto.setTitle(opportunity.getTitle());
        dto.setDescription(opportunity.getDescription());
        dto.setRequirements(opportunity.getRequirements());
        dto.setStartDate(opportunity.getStartDate());
        dto.setEndDate(opportunity.getEndDate());
        dto.setCoverImage(opportunity.getImage());
        return dto;
    }

    private static Opportunity toEntity(OpportunityDto opportunityDto) {
        Opportunity opportunity = new Opportunity();
        opportunity.setTitle(opportunityDto.getTitle());
        opportunity.setDescription(opportunityDto.getDescription());
        opportunity.setRequirements(opportunityDto.getRequirements());
        opportunity.setStartDate(opportunityDto.getStartDate());
        opportunity.setEndDate(opportunityDto.getEndDate());
        opportunity.setImage(opportunityDto.getCoverImage());
        return opportunity;
    }
}
