package com.now.backend.services;
import com.now.backend.models.LandingDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/landing-page")
@RestController

public class LandingServices {

    public List<LandingDto> getLandingList() {
        List<LandingDto> result = new ArrayList<>();
        LandingDto x = new LandingDto(27L, "SSST University", "Designer", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        LandingDto y = new LandingDto(47L, "SSST University", "Developer", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        LandingDto z = new LandingDto(16L, "SSST University", "QA", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");

        result.add(x);
        result.add(y);
        result.add(z);

        return result;
    }


}
