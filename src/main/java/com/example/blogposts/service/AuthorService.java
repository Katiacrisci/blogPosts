package com.example.blogposts.service;

import com.example.blogposts.exceptions.NotFoundException;
import com.example.blogposts.models.Author;
import com.example.blogposts.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private static final String AVATAR_TEMPLATE = "https://ui-avatars.com/api/?name=%s+%s";

    public Author save(Author author) {
        author.setAvatar(String.format(AVATAR_TEMPLATE, author.getName(), author.getSurname()));
        return authorRepository.save(author);
    }

    public Author updateById(Long id, Author author) {
        if (author.getId() == null) {
            System.err.printf("Cannot update %s as it's not been saved yet\n", author);
            return author;
        }

        if (!Objects.equals(id, author.getId())) {
            System.err.printf("Mismatching identifiers for update operation: %d different from %d\n", id, author.getId());
            return author;
        }

        authorRepository.save(author);

        return author;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
