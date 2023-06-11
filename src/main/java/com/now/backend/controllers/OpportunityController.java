package com.now.backend.controllers;

import com.now.backend.models.OpportunityDto;
import com.now.backend.services.OpportunityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/opportunities")
@RestController
public class OpportunityController {

    private final OpportunityService orgOpportunityService;

    public OpportunityController(OpportunityService orgOpportunityService) {
        this.orgOpportunityService = orgOpportunityService;
    }

    @GetMapping(value = "/")
    public List<OpportunityDto> getOpportunity() {
        return orgOpportunityService.getOpportunity();
    }

    @GetMapping(value = "/{id}")
    public OpportunityDto getOpportunityId(@PathVariable int id) {
        return orgOpportunityService.getOpportunityId(id);
    }

    @PostMapping
    public OpportunityDto postOpportunity(@RequestBody OpportunityDto opportunity) {
        return orgOpportunityService.createOpportunity(opportunity);
    }
}
