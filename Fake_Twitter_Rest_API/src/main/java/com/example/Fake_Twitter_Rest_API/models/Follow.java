package com.example.Fake_Twitter_Rest_API.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "following_user_id")
    private User followingUser;

    private LocalDateTime localDateTime;

    public Follow(User user, User followingUser) {
        this.user = user;
        this.followingUser = followingUser;
        this.localDateTime = LocalDateTime.now();
    }
}
