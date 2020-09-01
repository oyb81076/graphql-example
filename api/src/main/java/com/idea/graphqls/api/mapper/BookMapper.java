package com.idea.graphqls.api.mapper;

import com.idea.graphqls.api.entity.Book;
import com.idea.graphqls.api.input.BookPageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface BookMapper {
    String CACHE_NAME = "Book";

    @CachePut(cacheNames = CACHE_NAME, key = "#p0.id")
    int insert(Book book);

    @CacheEvict(cacheNames = CACHE_NAME, key = "#p0")
    int delete(@Param("id") long id);

    @CachePut(cacheNames = CACHE_NAME, key = "#p0.id")
    int update(Book book);

    @Cacheable(value = CACHE_NAME, key = "#p0")
    Book get(@Param("id") long id);

    List<Long> list();

    int count(BookPageQuery query);

    boolean existsClassify(@Param("classifyId") long classifyId);

    List<Long> page(BookPageQuery query);
}
