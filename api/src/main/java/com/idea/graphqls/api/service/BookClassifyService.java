package com.idea.graphqls.api.service;

import com.idea.graphqls.api.entity.BookClassify;

import java.util.List;

public interface BookClassifyService {
    BookClassify insert(String name);

    void delete(BookClassify classify);

    BookClassify update(long id, String name);

    BookClassify get(long id);

    List<BookClassify> list();
}
