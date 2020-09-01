package com.idea.graphqls.api.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery {
    int size = 10;
    int index = 0;
    int total = -1;

    public String getLimit() {
        return (index * size) + "," + size;
    }
}
