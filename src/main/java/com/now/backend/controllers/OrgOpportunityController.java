package com.now.backend.controllers;

import com.now.backend.models.OpportunityDto;
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
    public List<OpportunityDto> getOpportunity() {
        return orgOpportunityService.getOpportunity();
    }
    @GetMapping(value = "/{id}")
    public OpportunityDto getOpportunityId(@PathVariable long id) {
        return orgOpportunityService.getOpportunityId(id);
    }
    @PostMapping
    public OpportunityDto postOpportunity(@RequestBody OpportunityDto opportunity) {
        return orgOpportunityService.createOpportunity(opportunity);
    }
}
