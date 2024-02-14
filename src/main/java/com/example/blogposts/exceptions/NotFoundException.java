package com.example.blogposts.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Object notFound) {
        super(notFound.toString());
    }
}
