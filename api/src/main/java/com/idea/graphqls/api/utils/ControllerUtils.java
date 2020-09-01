package com.idea.graphqls.api.utils;

import com.idea.graphqls.api.ex.Err;

import java.util.function.Consumer;
import java.util.function.Function;

public class ControllerUtils {
    public static <T, K> T deleteIfExists(String label, K id, Function<K, T> getter, Consumer<T> delete) {
        T entity = getter.apply(id);
        if (entity == null) {
            throw new Err(label + "(" + id + ") 不存在");
        }
        delete.accept(entity);
        return entity;
    }
}
