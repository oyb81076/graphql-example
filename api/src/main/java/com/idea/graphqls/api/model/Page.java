package com.idea.graphqls.api.model;

import com.idea.graphqls.api.input.PageQuery;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class Page<T> {
    int total;
    List<T> rows;
    static Page<?> EMPTY = new Page<>(0, Collections.emptyList());

    private Page(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    @SuppressWarnings("unchecked")
    public static <R, Q extends PageQuery> Page<R> query(
            Q query,
            Function<Q, Integer> counter,
            Function<Q, List<R>> pager
    ) {
        int total = query.getTotal();
        if (total < 0) {
            total = counter.apply(query);
        }
        if (total == 0) {
            return (Page<R>) EMPTY;
        }
        List<R> rows = pager.apply(query);
        return new Page<>(total, rows);
    }

    public static <R, Q extends PageQuery> Page<R> query(
            Q query,
            Function<Q, Integer> counter,
            Function<Q, List<Long>> pager,
            Function<Long, R> getById
    ) {
        return query(query, counter, (q) -> pager.apply(q).stream().map(getById).collect(Collectors.toList()));
    }
}
