package com.idea.graphqls.api.mapper;

import com.idea.graphqls.api.entity.Author;
import com.idea.graphqls.api.input.AuthorPageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface AuthorMapper {
    String CACHE_NAME = "Author";

    @CachePut(cacheNames = CACHE_NAME, key = "#p0.id")
    int insert(Author author);

    @CacheEvict(cacheNames = CACHE_NAME, key = "#p0")
    int delete(@Param("id") long id);

    @CachePut(cacheNames = CACHE_NAME, key = "#p0.id")
    int update(Author author);

    @Cacheable(value = CACHE_NAME, key = "#p0")
    Author get(@Param("id") long id);

    List<Long> list();

    int count(AuthorPageQuery query);

    List<Long> page(AuthorPageQuery query);
}
