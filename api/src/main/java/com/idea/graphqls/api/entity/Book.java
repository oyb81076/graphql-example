package com.idea.graphqls.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
    public final static String NAME = "书本";
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    long id;
    @NotNull
    @Size(max = 255)
    String name;
    @Min(0)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    long authorId;
    @Min(0)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    long classifyId;
    Date created;
}
