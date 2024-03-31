package com.example.Fake_Twitter_Rest_API.models;

import java.time.LocalDateTime;

public class Follow {
    private User user;
    private User followingUser;
    private LocalDateTime localDateTime;

    public Follow(User user, User followingUser) {
        this.user = user;
        this.followingUser = followingUser;
        this.localDateTime = LocalDateTime.now();
    }
}
