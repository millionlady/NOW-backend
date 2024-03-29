package com.now.backend.controllers;

import com.now.backend.models.*;
import com.now.backend.services.OpportunityApplicationService;
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

    private final OpportunityService opportunityService;
    private final UserService userService;
    private final OpportunityApplicationService opportunityApplicationService;

    public OpportunityController(OpportunityService opportunityService, UserService userService,  OpportunityApplicationService opportunityApplicationService) {
        this.opportunityService = opportunityService;
        this.userService = userService;
        this.opportunityApplicationService = opportunityApplicationService;
    }

    @GetMapping(value = "/")
    public List<OpportunityDto> getOpportunity() {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long authId = Long.parseLong(auth.getPrincipal().toString());

        UserDto user = this.userService.getById(authId);

        if(user.isOrganization()){
            return opportunityService.getOpportunityByOrgId(authId);
        }

        return opportunityService.getOpportunity();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity< OpportunityResponse > getOpportunityId(@PathVariable Long id) {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long authId = Long.parseLong(auth.getPrincipal().toString());

        OpportunityDto opportunity = opportunityService.getOpportunityId(id);
        UserDto org = userService.getById(opportunity.getOrganizationId());

        if(opportunity.getOrganizationId().equals(authId)){
            List<OpportunityApplicationWithUserDto> applications = opportunityApplicationService.getAllApplications(id);
            return ResponseEntity.ok(new OpportunityResponse(opportunity, applications, null, org));
        }


        if(!userService.isOrganization(authId)){
            OpportunityApplicationDto myApplication = opportunityApplicationService.getMyApplication(authId, id);
            return ResponseEntity.ok(new OpportunityResponse(opportunity, null, myApplication, org));
        }

        return ResponseEntity.ok(new OpportunityResponse(opportunity, null, null, org));
    }

    @PostMapping
    public ResponseEntity<OpportunityDto> postOpportunity(@RequestBody OpportunityDto opportunity) {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());

        if(userService.isOrganization(id)){
            opportunity.setOrganizationId(id);
            return ResponseEntity.ok(opportunityService.createOpportunity(opportunity));
        }


        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User cant create opportunity");
    }
}
