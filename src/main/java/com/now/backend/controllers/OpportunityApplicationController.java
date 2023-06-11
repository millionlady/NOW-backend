package com.now.backend.controllers;

import com.now.backend.models.OpportunityApplicationDto;
import com.now.backend.models.OpportunityDto;
import com.now.backend.services.OpportunityApplicationService;
import com.now.backend.services.OpportunityService;
import com.now.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/opportunity-application")
@RestController
public class OpportunityApplicationController {
    private final OpportunityApplicationService opportunityApplicationService;
    private final OpportunityService opportunityService;

    OpportunityApplicationController(OpportunityApplicationService opportunityApplicationService, OpportunityService opportunityService){
        this.opportunityApplicationService = opportunityApplicationService;
        this.opportunityService = opportunityService;
    }
    @PostMapping
    public OpportunityApplicationDto createApplication(@RequestBody OpportunityApplicationDto applicationDto){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());
        applicationDto.setUserId(id);
        return opportunityApplicationService.createApplication(applicationDto);
    }
    @PostMapping("/accept/{id}")
    public OpportunityApplicationDto acceptApplication(@PathVariable Long id){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long orgId = Long.parseLong(auth.getPrincipal().toString());

        OpportunityDto opportunity = opportunityService.getOpportunityId(id);
        if(opportunity.getOrganizationId().equals(orgId)){
            return opportunityApplicationService.setStatus(id, "Accepted");
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Org not one that created");

    }
    @PostMapping("/reject/{id}")
    public OpportunityApplicationDto rejectApplication(@PathVariable Long id){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long orgId = Long.parseLong(auth.getPrincipal().toString());
        OpportunityDto opportunity = opportunityService.getOpportunityId(id);
        if(opportunity.getOrganizationId().equals(orgId)) {
            return opportunityApplicationService.setStatus(id, "Rejected");
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Org not one that created");
    }
}