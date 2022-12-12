package com.example.demo.domain.repository;

import com.example.demo.domain.Post;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    private static final Map<Long, Post> posts = new HashMap<>();

    public Post save(Post post) {
        long asLong = posts.keySet().stream().mapToLong(l -> l)
                .max()
                .stream().findAny().orElse(0L);
        post.setPostId(++asLong);
        posts.put(asLong, post);
        return post;
    }

    public Post get(Long postId) {
        return Optional.ofNullable(posts.get(postId)).orElseThrow(RuntimeException::new);
    }
}
