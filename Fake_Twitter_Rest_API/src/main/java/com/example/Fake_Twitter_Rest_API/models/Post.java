package com.example.Fake_Twitter_Rest_API.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private String id;
    private User user;
    private String message;
    private Long timestamp;
    private List<Reply> replies;

    public Post(String id, User user, Long timestamp) {
        this.id = id;
        this.user = user;
        this.timestamp = timestamp;
    }

    public Post(String id, User user, String message, Long timestamp) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
    }
}
