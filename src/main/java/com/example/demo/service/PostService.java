package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post get(Long postId) {
        return postRepository.get(postId);
    }

}
