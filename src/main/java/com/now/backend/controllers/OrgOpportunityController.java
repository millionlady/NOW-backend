package com.now.backend.controllers;

import com.now.backend.models.Opportunity;
import com.now.backend.services.OrgOpportunityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/orgOpportunity")
@RestController
public class OrgOpportunityController {

    private final OrgOpportunityService orgOpportunityService;

    public OrgOpportunityController(OrgOpportunityService orgOpportunityService) {
        this.orgOpportunityService = orgOpportunityService;
    }

    @GetMapping(value = "/opportunity")
    public List<Opportunity> getOpportunity() {
        return orgOpportunityService.getOpportunity();
    }
    @GetMapping(value = "/{id}")
    public Opportunity getOpportunityId(@PathVariable int id) {
        return orgOpportunityService.getOpportunityId(id);
    }
    @PostMapping
    public Opportunity postOpportunity(@RequestBody Opportunity opportunity) {
        return orgOpportunityService.createOpportunity(opportunity);
    }
}
