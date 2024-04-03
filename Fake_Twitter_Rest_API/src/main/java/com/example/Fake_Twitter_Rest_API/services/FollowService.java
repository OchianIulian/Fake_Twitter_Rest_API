package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Follow;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This clas is responsible for following requests logic
 */
@Service
@AllArgsConstructor
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    public void followUser(User follower, User following){
        followRepository.save(new Follow(follower, following));
    }


}
