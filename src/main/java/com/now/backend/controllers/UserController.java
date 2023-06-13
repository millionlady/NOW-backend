package com.now.backend.controllers;

import com.now.backend.models.ProfileDto;
import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ProfileDto getProfile(){
         Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
         Long id = Long.parseLong(auth.getPrincipal().toString());
        return this.userService.getProfile(id);
    }

    @GetMapping("/profile/{id}")
    public ProfileDto getProfileById(@PathVariable Long id){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long authId = Long.parseLong(auth.getPrincipal().toString());
        UserDto user = userService.getById(authId);

        if(user.isOrganization()){
            return this.userService.getProfile(id);

        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User cant get other profiles");
    }

    @PutMapping("/profile")
    public UserDto updateProfile(@RequestBody UpdateProfileDto updateProfileDto){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());

        return this.userService.updateProfile(Long.valueOf(id), updateProfileDto);
    }

    @DeleteMapping("/profile")
    public void deleteProfile(){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.parseLong(auth.getPrincipal().toString());

        this.userService.deleteProfile(id);
    }
}
