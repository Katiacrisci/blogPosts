package com.example.blogposts.service;

import com.example.blogposts.exceptions.NotFoundException;
import com.example.blogposts.models.Author;
import com.example.blogposts.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private static final String AVATAR_TEMPLATE = "https://ui-avatars.com/api/?name=%s+%s";

    private Author save(Author author) {
        author.setAvatar(String.format(AVATAR_TEMPLATE, author.getName(), author.getSurname()));
        return this.authorRepository.save(author);
    }

    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    public Author getById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
