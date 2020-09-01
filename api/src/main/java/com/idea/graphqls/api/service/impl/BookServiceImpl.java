package com.idea.graphqls.api.service.impl;

import com.idea.graphqls.api.entity.Author;
import com.idea.graphqls.api.entity.Book;
import com.idea.graphqls.api.ex.Err;
import com.idea.graphqls.api.input.BookPageQuery;
import com.idea.graphqls.api.mapper.AuthorMapper;
import com.idea.graphqls.api.mapper.BookMapper;
import com.idea.graphqls.api.model.Page;
import com.idea.graphqls.api.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.downgoon.snowflake.Snowflake;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final Snowflake snowflake;

    @Override
    public Book insert(Book input) {
        validateAuthor(input.getAuthorId());
        Book book = new Book();
        book.setId(snowflake.nextId());
        book.setName(input.getName());
        book.setAuthorId(input.getAuthorId());
        book.setCreated(new Date());
        bookMapper.insert(book);
        return book;
    }

    @Override
    public void delete(Book book) {
        bookMapper.delete(book.getId());
    }

    @Override
    public Book update(long id, Book input) {
        validateAuthor(input.getAuthorId());
        Book book = bookMapper.get(id);
        book.setAuthorId(input.getAuthorId());
        book.setName(input.getName());
        bookMapper.update(book);
        return book;
    }

    @Override
    public Book get(long id) {
        return bookMapper.get(id);
    }

    @Override
    public List<Book> list() {
        return bookMapper.list().stream().map(bookMapper::get).collect(Collectors.toList());
    }

    @Override
    public Page<Book> page(BookPageQuery query) {
        return Page.query(query, bookMapper::count, bookMapper::page, bookMapper::get);
    }

    private void validateAuthor(long authorId) {
        Author author = authorMapper.get(authorId);
        if (author == null) {
            throw new Err(String.format("author: %d 不存在", authorId));
        }
    }
}
