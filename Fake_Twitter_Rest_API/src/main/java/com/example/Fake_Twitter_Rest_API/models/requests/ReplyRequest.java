package com.example.Fake_Twitter_Rest_API.models.requests;

import lombok.*;

/**
 * This is a model for a reply request model
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class ReplyRequest {
    public final String message;
    public final Boolean is_public;
}
