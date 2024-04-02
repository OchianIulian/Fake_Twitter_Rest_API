package com.example.Fake_Twitter_Rest_API.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Like {
    private String id;
    private User user;
    private Post post;
}
