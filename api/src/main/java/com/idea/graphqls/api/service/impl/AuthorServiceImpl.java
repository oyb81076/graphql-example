package com.idea.graphqls.api.service.impl;

import com.idea.graphqls.api.entity.Author;
import com.idea.graphqls.api.input.AuthorPageQuery;
import com.idea.graphqls.api.mapper.AuthorMapper;
import com.idea.graphqls.api.model.Page;
import com.idea.graphqls.api.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.downgoon.snowflake.Snowflake;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final Snowflake snowflake;
    private final AuthorMapper authorMapper;

    @Override
    public Author insert(Author author) {
        author.setId(snowflake.nextId());
        author.setCreated(new Date());
        authorMapper.insert(author);
        return author;
    }

    @Override
    public void delete(Author author) {
        authorMapper.delete(author.getId());
    }

    @Override
    public Author update(long id, Author input) {
        Author author = authorMapper.get(id);
        author.setName(input.getName());
        author.setType(input.getType());
        authorMapper.update(author);
        return author;
    }

    @Override
    public Author get(long id) {
        return authorMapper.get(id);
    }

    @Override
    public List<Author> list() {
        return authorMapper.list().stream().map(authorMapper::get).collect(Collectors.toList());
    }

    @Override
    public Page<Author> page(AuthorPageQuery query) {
        return Page.query(query, authorMapper::count, authorMapper::page, authorMapper::get);
    }
}
