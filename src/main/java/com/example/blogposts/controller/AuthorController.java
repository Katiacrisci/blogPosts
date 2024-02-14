package com.example.blogposts.controller;

import com.example.blogposts.models.Author;
import com.example.blogposts.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Author saveAuthor(@RequestBody Author body) throws Exception {
        System.out.println(body);
        return authorService.save(body);
    }

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/{authorId}")
    public Author getById(@PathVariable long authorId) throws Exception {
        return authorService.getById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author findAndUpdate(@PathVariable long authorId, @RequestBody Author body) throws Exception {
        return authorService.updateById(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable long authorId) {
        authorService.delete(authorId);
    }
}
