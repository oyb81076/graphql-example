package com.idea.graphqls.api.input;

import com.idea.graphqls.api.enums.AuthorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorPageQuery extends PageQuery {
    String name;
    AuthorType type;
}
