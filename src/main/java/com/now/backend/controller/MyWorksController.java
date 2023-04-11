package com.now.backend.controller;

import com.now.backend.model.MyWorks;
import com.now.backend.service.MyWorksService;
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
    @GetMapping(value = "/works")
    public List<MyWorks> getMyWorks() {
        return myWorksService.getMyWorks();
    }
}
