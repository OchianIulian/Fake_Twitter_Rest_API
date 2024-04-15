package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.services.LikeService;
import com.example.Fake_Twitter_Rest_API.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LikeControllerTest {

    @Mock
    private LikeService likeService;

    @InjectMocks
    private LikeController likeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void likePost() {

        // When
        when(likeService.likePost(1L)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Post liked successfully"));
        ResponseEntity<String> responseEntity = likeController.likePost(1L);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Post liked successfully", responseEntity.getBody());
        verify(likeService, times(1)).likePost(1L);
    }

    @Test
    void removeLikeFromPost() {
    }

    @Test
    void getLikesNumber() {
    }
}