package com.now.backend.services;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.repositories.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrgOpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OrgOpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public OpportunityDto createOpportunity(OpportunityDto opportunity) {
        Opportunity newOpportunity = new Opportunity();
        newOpportunity.setTitle(opportunity.getTitle());
        newOpportunity.setDescription(opportunity.getDescription());
        newOpportunity.setImage(opportunity.getImage());
        newOpportunity = opportunityRepository.save(newOpportunity);
        opportunity.setId(newOpportunity.getId());
        return opportunity;
    }
    public List<OpportunityDto> getOpportunity() {
        List<OpportunityDto> opportunityList = new ArrayList<>();
        List<Opportunity> opportunities = opportunityRepository.findAll();
        for (Opportunity opportunity : opportunities) {
            opportunityList.add(new OpportunityDto(opportunity.getId(),opportunity.getTitle(), opportunity.getDescription(), opportunity.getImage()));
        }

        return opportunityList;
    }

    public OpportunityDto getOpportunityId(long id) {
        opportunityRepository.getById(id);
        return new OpportunityDto(id, "App Developer", "Design and develop the student volunteering app to make it user-friendly and easy to navigate.", "https://buildfire.com/wp-content/uploads/2017/10/become-mobile-app-developer.jpg");
    }
}
