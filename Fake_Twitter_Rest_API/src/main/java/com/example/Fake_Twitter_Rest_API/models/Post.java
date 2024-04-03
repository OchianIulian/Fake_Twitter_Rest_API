package com.example.Fake_Twitter_Rest_API.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String message;
    private Long timestamp;
    //private List<Reply> replies = new ArrayList<>();

    public Post(User user, Long timestamp) {
        this.user = user;
        this.timestamp = timestamp;
    }

    public Post(User user, String message, Long timestamp) {
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
    }
}
