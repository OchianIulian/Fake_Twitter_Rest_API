package com.example.Fake_Twitter_Rest_API.models.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Model for Login input
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private final String username;
    private final String password;
}
