package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.services.FollowService;
import com.example.Fake_Twitter_Rest_API.services.PostService;
import com.example.Fake_Twitter_Rest_API.services.UserActionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FollowControllerTest {

    @Mock
    private UserActionsService followService;

    @InjectMocks
    private FollowController followController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getFollowersByEmail() {
        String email = "user@gmail.com";
        // When
        when(followService.followByEmail(email)).thenReturn(ResponseEntity.status(HttpStatus.OK).body("Follow approved"));
        ResponseEntity<String> responseEntity = followService.followByEmail(email);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Post created successfully", responseEntity.getBody());
        verify(followService, times(1)).followByEmail(email);
    }

    @Test
    void getFollowingByEmail() {
    }
}