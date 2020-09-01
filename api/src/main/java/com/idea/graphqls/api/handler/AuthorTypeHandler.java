package com.idea.graphqls.api.handler;

import com.idea.graphqls.api.enums.AuthorType;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class AuthorTypeHandler extends EnumOrdinalTypeHandler<AuthorType> {
    public AuthorTypeHandler() {
        super(AuthorType.class);
    }
}
