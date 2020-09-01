package com.idea.graphqls.api.entity;

import com.idea.graphqls.api.enums.AuthorType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class Author implements Serializable {
    public static String NAME = "作者";
    long id;
    @NotNull
    @Size(min = 3, max = 15)
    String name;
    @NotNull
    AuthorType type;
    Date created;
}
