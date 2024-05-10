package com.tpisoftware.core.common.response;

public record Status(String code, String message) {
    public Status(String code) {
        this(code, null);
    }
}
