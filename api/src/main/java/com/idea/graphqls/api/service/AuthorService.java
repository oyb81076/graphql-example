package com.idea.graphqls.api.service;

import com.idea.graphqls.api.entity.Author;
import com.idea.graphqls.api.input.AuthorPageQuery;
import com.idea.graphqls.api.model.Page;

import java.util.List;


public interface AuthorService {
    Author insert(Author author);

    void delete(Author author);

    Author update(long id, Author author);

    Author get(long id);

    List<Author> list();

    Page<Author> page(AuthorPageQuery query);
}
