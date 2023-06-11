package com.now.backend.controllers;

import com.now.backend.models.OpportunityApplicationDto;
import com.now.backend.services.OpportunityApplicationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/opportunity-application")
@RestController
public class OpportunityApplicationController {
    private final OpportunityApplicationService opportunityApplicationService;
    OpportunityApplicationController(OpportunityApplicationService opportunityApplicationService){
        this.opportunityApplicationService = opportunityApplicationService;
    }
    @PostMapping
    public OpportunityApplicationDto createApplication(@RequestBody OpportunityApplicationDto applicationDto){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());
        applicationDto.setUserId(id);
        return opportunityApplicationService.createApplication(applicationDto);
    }
}