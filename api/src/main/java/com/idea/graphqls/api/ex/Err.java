package com.idea.graphqls.api.ex;

public class Err extends RuntimeException {
    public Err(String message) {
        super(message);
    }
}
