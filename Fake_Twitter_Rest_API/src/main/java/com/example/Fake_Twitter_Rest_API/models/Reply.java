package com.example.Fake_Twitter_Rest_API.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Post parent;
    private Boolean isPublic;

    public Reply(Post parent, Boolean isPublic) {
        this.parent = parent;
        this.isPublic = isPublic;
    }
}
