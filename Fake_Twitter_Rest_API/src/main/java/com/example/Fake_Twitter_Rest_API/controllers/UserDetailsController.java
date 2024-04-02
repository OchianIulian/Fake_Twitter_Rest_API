package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.RegistrationService;
import com.example.Fake_Twitter_Rest_API.services.UserActionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserDetailsController {

    private RegistrationService registrationService;
    private UserActionsService userActionsService;


    @GetMapping("/user-info")
    public String getUserInfo(){
        return userActionsService.getUserInfo();
    }

    @GetMapping("/user-info/{username}")
    public String getUserDetailsByUsername(@PathVariable String username){
        return userActionsService.getUserDetailsByUsername(username);
    }

    @PutMapping("/follow/{userFollowed}")
    public String followUser(@PathVariable String userFollowed){
        return "follow function";
    }

    @PutMapping("/unfollow/{userFollowed}")
    public String unfollowUser(@PathVariable String userFollowed){
        return "unfollow function";
    }

    @DeleteMapping("/del-personal-acc")
    public String deleteAccount(String username){
        return registrationService.deletePersonalAccount();
    }

}
