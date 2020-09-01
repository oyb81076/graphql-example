package com.idea.graphqls.api.service;

import com.idea.graphqls.api.entity.Book;
import com.idea.graphqls.api.input.BookPageQuery;
import com.idea.graphqls.api.model.Page;

import java.util.List;

public interface BookService {
    Book insert(Book input);

    void delete(Book book);

    Book update(long id, Book input);

    Book get(long id);

    List<Book> list();

    Page<Book> page(BookPageQuery query);
}
