package com.example.Fake_Twitter_Rest_API.models.requests;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor(force = true)
public class MentionRequest {
    private final Long postId;
    private final String username;
}
