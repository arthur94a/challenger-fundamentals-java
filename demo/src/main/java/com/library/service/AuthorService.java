package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.models.Author;

public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public void add(Author author) {
        authors.add(author);
    }

    public List<Author> getAll() {
        return authors;
    }
}
