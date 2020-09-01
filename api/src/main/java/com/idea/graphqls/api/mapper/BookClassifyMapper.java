package com.idea.graphqls.api.mapper;

import com.idea.graphqls.api.entity.BookClassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;

@Mapper
public interface BookClassifyMapper {
    String CACHE_NAME = "BookClassify";

    @Caching(
            put = @CachePut(cacheNames = CACHE_NAME, key = "#p0.id"),
            evict = @CacheEvict(cacheNames = CACHE_NAME, key = "''")
    )
    int insert(BookClassify classify);

    @Caching(evict = {
            @CacheEvict(cacheNames = CACHE_NAME, key = "''"),
            @CacheEvict(cacheNames = CACHE_NAME, key = "#p0")
    })
    int delete(@Param("id") long id);

    @Caching(
            put = @CachePut(cacheNames = CACHE_NAME, key = "#p0.id"),
            evict = @CacheEvict(cacheNames = CACHE_NAME, key = "''")
    )
    int update(BookClassify book);

    @Cacheable(value = CACHE_NAME, key = "#p0")
    BookClassify get(@Param("id") long id);

    @Cacheable(value = CACHE_NAME, key = "''")
    List<BookClassify> list();
}
