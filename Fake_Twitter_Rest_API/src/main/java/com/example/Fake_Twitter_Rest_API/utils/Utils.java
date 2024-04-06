package com.example.Fake_Twitter_Rest_API.utils;

import com.example.Fake_Twitter_Rest_API.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;
        return user;
    }
}
