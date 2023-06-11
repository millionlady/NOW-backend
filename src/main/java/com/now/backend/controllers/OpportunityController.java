package com.now.backend.controllers;

import com.now.backend.models.OpportunityDto;
import com.now.backend.services.OpportunityService;
import com.now.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(value = "/opportunities")
@RestController
public class OpportunityController {

    private final OpportunityService orgOpportunityService;
    private final UserService userService;

    public OpportunityController(OpportunityService orgOpportunityService, UserService userService) {
        this.orgOpportunityService = orgOpportunityService;
        this.userService = userService;
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
    public ResponseEntity<OpportunityDto> postOpportunity(@RequestBody OpportunityDto opportunity) {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());

        if(userService.isOrganization(id)){
            opportunity.setOrganizationId(id);
            return ResponseEntity.ok(orgOpportunityService.createOpportunity(opportunity));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User cant create opportunity");
    }
}
