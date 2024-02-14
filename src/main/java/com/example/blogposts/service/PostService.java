package com.example.blogposts.service;

import com.example.blogposts.exceptions.NotFoundException;
import com.example.blogposts.models.Post;
import com.example.blogposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    private static final String COVER_TEMPLATE = "https://picsum.photos/%d/%d";
    private static final Random random = new Random();

    public Post save(Post post) {
        post.setCover(COVER_TEMPLATE.formatted(random.nextInt(300, 500), random.nextInt(300, 500)));
        return this.postRepository.save(post);
    }

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public Post getById(Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
