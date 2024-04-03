package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;
}
