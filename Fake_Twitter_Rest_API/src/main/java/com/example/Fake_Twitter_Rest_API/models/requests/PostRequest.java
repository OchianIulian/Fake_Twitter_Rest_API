package com.example.Fake_Twitter_Rest_API.models.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PostRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}