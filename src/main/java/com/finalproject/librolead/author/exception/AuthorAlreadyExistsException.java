package com.finalproject.librolead.author.exception;

import javax.persistence.EntityExistsException;

import static java.lang.String.format;

public class AuthorAlreadyExistsException extends EntityExistsException {

    public AuthorAlreadyExistsException(String name) {
        super(format("Author with name %s already exists", name));
    }
}
