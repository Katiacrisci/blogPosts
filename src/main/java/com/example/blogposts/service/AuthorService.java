package com.example.blogposts.service;

import com.example.blogposts.models.Author;
import com.example.blogposts.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private static final String AVATAR_TEMPLATE = "https://ui-avatars.com/api/?name=%s+%s";

    private Author save(Author author) {
        author.setAvatar(String.format(AVATAR_TEMPLATE, author.getName(), author.getSurname()));
        return this.authorRepository.save(author);
    }
}
