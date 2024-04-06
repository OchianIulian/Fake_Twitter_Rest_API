package com.example.Fake_Twitter_Rest_API.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a model for Post entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String message;
    private String timestamp;//date and time when post was published
    //private List<Reply> replies = new ArrayList<>();


    public Post(String message) {
        this.message = message;
        timestamp = LocalDateTime.now().toString();
    }
}
