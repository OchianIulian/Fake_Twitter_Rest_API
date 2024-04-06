package com.example.Fake_Twitter_Rest_API.models.requests;

import lombok.*;

/**
 * This is a model for post request body
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class PostRequest {
    public final String message;

}