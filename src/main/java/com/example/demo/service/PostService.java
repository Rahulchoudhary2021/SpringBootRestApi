package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Post;
import com.example.demo.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
