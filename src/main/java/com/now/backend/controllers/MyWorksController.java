package com.now.backend.controllers;

import com.now.backend.models.MyWorksDto;
import com.now.backend.services.MyWorksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping(value = "/my-works")
@RestController
public class MyWorksController {
    private final MyWorksService myWorksService;

    public MyWorksController(MyWorksService myWorksService) {
        this.myWorksService = myWorksService;
    }

    @GetMapping
    public List<MyWorksDto> getMyWorks() {

        return myWorksService.getMyWorks();
    }
}
