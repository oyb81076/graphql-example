package com.idea.graphqls.api.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class BookClassify implements Serializable {
    public static String NAME = "书本分类";
    long id;
    @Size(max = 255)
    @NotNull
    String name;
}
