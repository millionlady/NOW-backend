package com.now.backend.controllers;

import com.now.backend.models.LandingDto;
import com.now.backend.services.LandingServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/landing-page")
@RestController

public class LandingController {
    private final LandingServices landingServices;
    LandingController(LandingServices landingServices) {
        this.landingServices = landingServices;
    }
    @GetMapping("/three-recent-opportunities")
    public List<LandingDto> getLanding() {
        return landingServices.getLandingList();
    }

}
