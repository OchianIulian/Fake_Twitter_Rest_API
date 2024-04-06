package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Follow;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This clas is responsible for following requests logic
 */
@Service
@AllArgsConstructor
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    /**
     * Follow a user and save this action into it's table
     * @param follower
     * @param following
     */
    public void followUser(User follower, User following){
        followRepository.save(new Follow(follower, following));
    }

    /**
     * Unfollow user and remove the corespondent line from table
     * @param follower
     * @param following
     */
    public void unfollowUser(User follower, User following){
        Optional<Follow> follow = followRepository.findFollow(follower, following);

        follow.ifPresent(value -> followRepository.delete(value));
    }




}
