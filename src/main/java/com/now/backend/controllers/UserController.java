package com.now.backend.controllers;


import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.services.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public UserDto getProfile(){
        return this.userService.getProfile();
    }

    @PutMapping("/profile")
    public UserDto updateProfile(@RequestBody UpdateProfileDto updateProfileDto){
        return this.userService.updateProfile(updateProfileDto);
    }

    @DeleteMapping("/profile")
    public UserDto deleteProfile(){
        return this.userService.deleteProfile();
    }

}
