package com.idea.graphqls.api.input;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookPageQuery extends PageQuery {
    String name;
    Long authorId;
    Long classifyId;
}
