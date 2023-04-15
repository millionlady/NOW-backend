package com.now.backend.controllers;


import com.now.backend.models.OpportunityDetailsDto;
import com.now.backend.services.OpportunityDetailsService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/opportunity-details")
@RestController
public class OpportunityDetailsController {
    private final OpportunityDetailsService opportunityDetailsService;
    OpportunityDetailsController(OpportunityDetailsService opportunityDetailsService){
        this.opportunityDetailsService = opportunityDetailsService;
    }
    @GetMapping("/{id}")
    public OpportunityDetailsDto getOpportunityDetails(@PathVariable long id){
         return opportunityDetailsService.getOpportunityDetails(id);
    }
    @PutMapping("/{id}")
    public OpportunityDetailsDto editOpportunityDetails(@PathVariable long id, @RequestBody OpportunityDetailsDto opportunityDetailsDto){
        return opportunityDetailsService.editOpportunityDetails(id, opportunityDetailsDto);
    }
    @DeleteMapping("/{id}")
    public void deleteOpportunityDetails(@PathVariable long id){
        opportunityDetailsService.deleteOpportunityDetails(id);
    }
}
















