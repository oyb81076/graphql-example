package com.idea.graphqls.api.service.impl;

import com.idea.graphqls.api.entity.Book;
import com.idea.graphqls.api.entity.BookClassify;
import com.idea.graphqls.api.ex.Err;
import com.idea.graphqls.api.mapper.BookClassifyMapper;
import com.idea.graphqls.api.mapper.BookMapper;
import com.idea.graphqls.api.service.BookClassifyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.downgoon.snowflake.Snowflake;

import java.util.List;

@Service
@AllArgsConstructor
public class BookClassifyServiceImpl implements BookClassifyService {
    private final BookClassifyMapper bookClassifyMapper;
    private final BookMapper bookMapper;
    private final Snowflake snowflake;

    @Override
    public BookClassify insert(String name) {
        BookClassify classify = new BookClassify();
        classify.setId(snowflake.nextId());
        classify.setName(name);
        bookClassifyMapper.insert(classify);
        return classify;
    }

    @Override
    public void delete(BookClassify classify) {
        if (bookMapper.existsClassify(classify.getId())) {
            throw new Err(BookClassify.NAME + " " + classify.getId() + " 被" + Book.NAME + ", 无法删除");
        }
        bookClassifyMapper.delete(classify.getId());
    }

    @Override
    public BookClassify update(long id, String name) {
        BookClassify bookClassify = new BookClassify();
        bookClassify.setId(id);
        bookClassify.setName(name);
        bookClassifyMapper.update(bookClassify);
        return bookClassify;
    }

    @Override
    public BookClassify get(long id) {
        return bookClassifyMapper.get(id);
    }

    @Override
    public List<BookClassify> list() {
        return bookClassifyMapper.list();
    }
}
