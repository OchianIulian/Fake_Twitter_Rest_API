package com.example.Fake_Twitter_Rest_API.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Follow {
    @Id
    private Long id;
    private User user;
    private User followingUser;
    private LocalDateTime localDateTime;

    public Follow(User user, User followingUser) {
        this.user = user;
        this.followingUser = followingUser;
        this.localDateTime = LocalDateTime.now();
    }
}
